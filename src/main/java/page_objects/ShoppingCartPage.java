package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import utils.ConfProperties;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingCartPage {
    private ElementsCollection productsIntoCartCollection = $$(byXpath("//div[@class='cart_item']"));
    private SelenideElement continueShoppingBtn = $(byXpath("//button[@id='continue-shopping']"));
    private SelenideElement checkoutBtn = $(byXpath("//button[@id='checkout']"));

    public void clickContinueShoppingBtn(){ continueShoppingBtn.click(); }

    public void clickCheckoutBtn(){ checkoutBtn.click(); }

    public Integer checkFullPrice(){
        Integer result = 0;

        for(int i = 0; i < productsIntoCartCollection.size(); i++){
            Integer currentProductPrice = 0;
            currentProductPrice = Integer.parseInt(productsIntoCartCollection.get(i).$(byXpath("//div[@class='inventory_item_price']"))
                    .text().replace("$",""));
            result += currentProductPrice;
        }
        return result;
    }

}
