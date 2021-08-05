package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class OverviewPage {
    private SelenideElement totalPriceText = $(byXpath("//div[@class='summary_subtotal_label']"));
    private SelenideElement cancelBtn = $(byXpath("//button[@data-test='cancel']"));
    private SelenideElement finishBtn = $(byXpath("//button[@data-test='finish']"));

    public void waitOverviewPage(){
        finishBtn.shouldBe(Condition.visible);
    }

    public void clickCancelBtn() { cancelBtn.click(); }

    public void clickFinishBtn() { finishBtn.click(); }

    public Double getItemTotalPrice(){
        Double result = 0.0;
        String itemTotalPrice = totalPriceText.text();
        Pattern pattern = Pattern.compile("[0-9]*\\.[0-9]+");
        Matcher matcher = pattern.matcher(itemTotalPrice);
        while (matcher.find()){
            result = Double.parseDouble(itemTotalPrice.substring(matcher.start(),matcher.end()));
        }
        return result;
    }
}
