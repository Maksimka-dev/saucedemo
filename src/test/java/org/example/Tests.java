package org.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import page_elements.BurgerMenu;
import page_elements.TitleElement;
import page_objects.*;
import utils.ConfProperties;
import utils.Log;
import value_objects.Customer;

import static com.codeborne.selenide.Selenide.open;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests {

    private LoginPage logIn;
    private ProductPage productPage;
    private TitleElement titleElement;
    private ShoppingCartPage shoppingCartPage;
    private CheckoutInformationPage checkoutInformationPage;
    private OverviewPage overviewPage;
    private CompletePage completePage;
    private BurgerMenu burgerMenu;

    @BeforeEach
    public void setup(){
        Configuration.baseUrl = "https://www.saucedemo.com/";
        open(Configuration.baseUrl);
        logIn = new LoginPage();
        productPage = new ProductPage();
        titleElement = new TitleElement();
        shoppingCartPage = new ShoppingCartPage();
        checkoutInformationPage = new CheckoutInformationPage();
        overviewPage = new OverviewPage();
        completePage = new CompletePage();
        burgerMenu = new BurgerMenu();
    }

    @AfterEach
    public void logout(){
        burgerMenu.clickBurgerBtn();
        burgerMenu.clickLogoutBtn();
    }

    @Test
    @Order(2)
    public void loginTest(){
        logIn.login();
        Assertions.assertTrue(titleElement.isProductPage());
        Log.info("Вход выполнен");
    }

    @Test
    @Order(1)
    public void buyTest(){
        Customer customer = new Customer(ConfProperties.getProperty("customer_first_name"),
                ConfProperties.getProperty("customer_last_name"),
                Integer.parseInt(ConfProperties.getProperty("customer_postal_code")));

        logIn.login();

        productPage.waitProductPage();
        Log.info("Вход выполнен");
        Log.info("Страница товаров загружена");
        productPage.addProductsToCart(2);
        productPage.clickShoppingCartBtn();
        shoppingCartPage.waitShoppingCartPage();
        Log.info("Страница корзины товаров загружена");

        shoppingCartPage.clickCheckoutBtn();
        checkoutInformationPage.waitCheckoutInformationPage();
        Log.info("Страница валидации клиента загружена");

        checkoutInformationPage.enterCustomerDate(customer);

        checkoutInformationPage.clickContinueBtn();
        overviewPage.waitOverviewPage();
        Log.info("Страница подтверждения заказа загружена");

        overviewPage.clickFinishBtn();
        completePage.waitCompleteElement();
        Log.info("Страница завершения заказа загружена");

        completePage.clickBackHomeBtn();
        Assertions.assertTrue(titleElement.isProductPage());
        Log.info("Покупка завершена");
    }

    @Test
    @Order(5)
    public void deleteProductsCartTest(){
        logIn.login();

        productPage.waitProductPage();
        Log.info("Вход выполнен");
        Log.info("Страница товаров загружена");
        productPage.addProductsToCart(2);
        productPage.clickShoppingCartBtn();
        shoppingCartPage.waitShoppingCartPage();
        Log.info("Страница корзины товаров загружена");
        shoppingCartPage.deleteAllProducts();

        Assertions.assertTrue(shoppingCartPage.isClearListProducts());
        Log.info("Корзина пуста");
    }

    @Test
    @Order(4)
    public void cancelBuyTest(){
        Customer customer = new Customer(ConfProperties.getProperty("customer_first_name"),
                ConfProperties.getProperty("customer_last_name"),
                Integer.parseInt(ConfProperties.getProperty("customer_postal_code")));

        logIn.login();

        productPage.waitProductPage();
        Log.info("Вход выполнен");
        Log.info("Страница товаров загружена");
        productPage.addProductsToCart(4);
        productPage.clickShoppingCartBtn();
        shoppingCartPage.waitShoppingCartPage();
        Log.info("Страница корзины товаров загружена");

        shoppingCartPage.clickCheckoutBtn();
        checkoutInformationPage.waitCheckoutInformationPage();
        Log.info("Страница валидации клиента загружена");

        checkoutInformationPage.enterCustomerDate(customer);

        checkoutInformationPage.clickContinueBtn();
        overviewPage.waitOverviewPage();
        Log.info("Страница подтверждения заказа загружена");

        overviewPage.clickCancelBtn();

        Assertions.assertTrue(titleElement.isProductPage());
        Log.info("Отмена покупки прошла успешно");
    }

    @Test
    @Order(3)
    public void priceCompareTest(){
        Double price = 0.0;
        Double itemPrice = 0.0;
        Customer customer = new Customer(ConfProperties.getProperty("customer_first_name"),
                ConfProperties.getProperty("customer_last_name"),
                Integer.parseInt(ConfProperties.getProperty("customer_postal_code")));

        logIn.login();

        productPage.waitProductPage();
        Log.info("Вход выполнен");
        Log.info("Страница товаров загружена");
        productPage.addProductsToCart(3);
        productPage.clickShoppingCartBtn();
        shoppingCartPage.waitShoppingCartPage();
        Log.info("Страница корзины товаров загружена");

        price = shoppingCartPage.getFullPrice();

        shoppingCartPage.clickCheckoutBtn();
        checkoutInformationPage.waitCheckoutInformationPage();
        Log.info("Страница валидации клиента загружена");

        checkoutInformationPage.enterCustomerDate(customer);

        checkoutInformationPage.clickContinueBtn();
        overviewPage.waitOverviewPage();
        Log.info("Страница подтверждения заказа загружена");

        itemPrice = overviewPage.getItemTotalPrice();

        Assertions.assertEquals(price, itemPrice);
        Log.info("Подсчет общей суммы заказа корректен");
    }
}
