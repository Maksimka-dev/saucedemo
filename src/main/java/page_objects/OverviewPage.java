package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OverviewPage {
    private ElementsCollection cartProductsCollection = $$(byXpath("//div[@class='cart_item']"));
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

    public boolean isProductIntoCartCollection(String productName){
        boolean result = false;
        for(int i = 0; i < cartProductsCollection.size(); i++){
            String name = cartProductsCollection.get(i).$(byXpath("descendant::div[@class='inventory_item_name']"))
                    .text();
            if(name.equals(productName)){
                result = true;
            }
        }
        return result;
    }
}
