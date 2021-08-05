package page_elements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BurgerMenu {
    private SelenideElement burgerBtn = $(byXpath("//div[@class='bm-burger-button']/button"));
    private SelenideElement allItemBtn = $(byXpath("//a[@id='inventory_sidebar_link']"));
    private SelenideElement aboutBtn = $(byXpath("//a[@id='about_sidebar_link']"));
    private SelenideElement logoutBtn = $(byXpath("//a[@id='logout_sidebar_link']"));
    private SelenideElement resetAppStateBtn = $(byXpath("//a[@id='reset_sidebar_link']"));
    private SelenideElement quitBurgerMenuBtn = $(byXpath("//div[@class='bm-cross-button']/button"));

    public void clickBurgerBtn() { burgerBtn.click(); }

    public void clickAllItemBtn() { allItemBtn.click(); }

    public void clickAboutBtn() { aboutBtn.click(); }

    public void clickLogoutBtn() { logoutBtn.click(); }

    public void clickResetAppStateBtn() { resetAppStateBtn.click(); }

    public void clickQuitBurgerMenuBtn() { quitBurgerMenuBtn.click(); }
}
