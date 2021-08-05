package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import utils.ConfProperties;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement userName = $(byXpath("//input[@data-test='username']"));
    private SelenideElement password = $(byXpath("//input[@data-test='password']"));
    private SelenideElement loginBtn = $(byXpath("//input[@data-test='login-button']"));

    private void setUserName(String text) { userName.sendKeys(text); }

    private void setPassword(String text) { password.sendKeys(text); }

    private void clickLoginBtn() { loginBtn.click(); }

    public void login(){
        loginBtn.shouldBe(Condition.visible);
        setUserName(ConfProperties.getProperty("username"));
        setPassword(ConfProperties.getProperty("password"));
        clickLoginBtn();
    }
}
