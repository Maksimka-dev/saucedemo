package org.example.steps;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import page_objects.*;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuyProductStepsDef {

    private LoginPage logIn = new LoginPage();
    private ProductPage productPage = new ProductPage();
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    private CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
    private OverviewPage overviewPage = new OverviewPage();

    @Допустим("^открыта страница \"([^\"]*)\"$")
    public void pageOpen(String pageUrl) {
        open(pageUrl);
        String currentPageUrl = getWebDriver().getCurrentUrl();
        assertEquals(pageUrl, currentPageUrl, "Значения ссылок не сопадают");
    }

    @Когда("^в поле имя пользователя введено значение \"([^\"]*)\"$")
    public void enterUsername(String name) {
        logIn.setUserName(name);
        assertEquals(name, logIn.getUserName(), "введенное имя не совпадает с ожидаемым");
    }

    @Когда("^в поле пароль введено значение \"([^\"]*)\"$")
    public void enterPassword(String password) {
        logIn.setPassword(password);
        assertEquals(password, logIn.getPassword(), "введенный пароль не совпадает с ожидаемым");
    }

    @Когда("^переходим на следующую страницу кнопокй \"([^\"]*)\"$")
    public void pressInput(String valueInput) {
        $(byXpath("//*[contains(@value,'" + valueInput + "')]")).click();
    }

    @Когда("^нажата кнопка \"([^\"]*)\"$")
    public void pressBtn(String textBtn) {
        $(byXpath("//*[contains(text(),'" + textBtn + "')]")).click();
    }

    @Когда("^нажата ссылка \"([^\"]*)\"$")
    public void pressLink(String nameLink) {
        productPage.clickShoppingCartBtn();
    }

    @Тогда("^открылась страница \"([^\"]*)\"$")
    public void openedPage(String pageUrl) {
        String currentPageUrl = getWebDriver().getCurrentUrl();
        assertEquals(pageUrl, currentPageUrl, "Значения ссылок не сопадают");
    }

    @Когда("^у товара \"([^\"]*)\" выполнено нажатие на кнопку ADD TO CART")
    public void addProductToCartByName(String nameProduct) {
        productPage.addProductToCartByName(nameProduct);
    }

    @Когда("^товар \"([^\"]*)\" показан в корзине")
    public void checkProductIntoCart(String nameProduct) {
        assertTrue(shoppingCartPage.isProductByName(nameProduct));
    }

    @Когда("^в поле имя введено значение \"([^\"]*)\"$")
    public void enterFirstName(String firstName) {
        checkoutInformationPage.setFirstNameField(firstName);
        String name = checkoutInformationPage.getFirstNameField();
        assertEquals(firstName, name, "введенное имя не совпадает с ожидаемым");
    }

    @Когда("^в поле фамилия введено значение \"([^\"]*)\"$")
    public void enterLastName(String lastName) {
        checkoutInformationPage.setLastNameField(lastName);
        String name = checkoutInformationPage.getLastNameField();
        assertEquals(lastName, name, "введенная фамилия не совпадает с ожидаемой");
    }

    @Когда("^в поле почтовый индекс введено значение \"([^\"]*)\"$")
    public void enterPostalCode(String postalCode) {
        checkoutInformationPage.setPostalCodeField(postalCode);
        String code = checkoutInformationPage.getPostalCodeField();
        assertEquals(postalCode, code, "введенный почтовый индекс не совпадает с ожидаемым");
    }

    @Когда("^товар \"([^\"]*)\" показан в таблице")
    public void checkProductIntoTable(String nameProduct) {
        assertTrue(overviewPage.isProductIntoCartCollection(nameProduct));
    }
}
