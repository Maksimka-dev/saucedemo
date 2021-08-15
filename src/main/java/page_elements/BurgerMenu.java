package page_elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BurgerMenu {
    private SelenideElement burgerBtn = $(byXpath("//div[@class='bm-burger-button']/button"));
    private SelenideElement allItemBtn = $(byXpath("//a[@id='inventory_sidebar_link']"));
    private SelenideElement aboutBtn = $(byXpath("//a[@id='about_sidebar_link']"));
    private SelenideElement logoutBtn = $(byXpath("//a[@id='logout_sidebar_link']"));
    private SelenideElement resetAppStateBtn = $(byXpath("//a[@id='reset_sidebar_link']"));
    private SelenideElement quitBurgerMenuBtn = $(byXpath("//div[@class='bm-cross-button']/button"));

    @Step("Click 'Burger Menu' button")
    public void clickBurgerBtn() { burgerBtn.click(); }

    @Step("Click 'All Item' button into burger menu")
    public void clickAllItemBtn() { allItemBtn.click(); }

    @Step("Click 'About' button into burger menu")
    public void clickAboutBtn() { aboutBtn.click(); }

    @Step("Click 'Logout' button into burger menu")
    public void clickLogoutBtn() { logoutBtn.click(); }

    @Step("Click 'Reset App' button into burger menu")
    public void clickResetAppStateBtn() { resetAppStateBtn.click(); }

    @Step("Click 'Quit' button into burger menu")
    public void clickQuitBurgerMenuBtn() { quitBurgerMenuBtn.click(); }
}
