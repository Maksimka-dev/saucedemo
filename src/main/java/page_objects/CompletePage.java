package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CompletePage {
    private SelenideElement backHomeBtn = $(byXpath("//button[@data-test='back-to-products']"));

    @Step("Complete page is loaded")
    public void waitCompleteElement(){
        backHomeBtn.shouldBe(Condition.visible);
    }

    @Step("Click 'Back Home' button")
    public void clickBackHomeBtn(){ backHomeBtn.click(); }
}
