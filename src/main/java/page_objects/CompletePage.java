package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CompletePage {
    private SelenideElement backHomeBtn = $(byXpath("//button[@data-test='back-to-products']"));

    public void waitCompleteElement(){
        backHomeBtn.shouldBe(Condition.visible);
    }

    public void clickBackHomeBtn(){ backHomeBtn.click(); }
}
