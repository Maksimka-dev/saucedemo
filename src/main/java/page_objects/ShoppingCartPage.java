package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingCartPage {
    private ElementsCollection productsIntoCartCollection = $$(byXpath("//div[@class='cart_item']"));
    private SelenideElement continueShoppingBtn = $(byXpath("//button[@id='continue-shopping']"));
    private SelenideElement checkoutBtn = $(byXpath("//button[@id='checkout']"));

    public void clickContinueShoppingBtn(){ continueShoppingBtn.click(); }

    public void clickCheckoutBtn(){ checkoutBtn.click(); }

    public void waitShoppingCartPage(){
        continueShoppingBtn.shouldBe(Condition.visible);
    }

    public void deleteAllProducts(){
        for (int i = productsIntoCartCollection.size() - 1; i >= 0; i--){
            productsIntoCartCollection.get(i).$(byXpath("descendant::button")).click();
        }
    }

    public boolean isProductByName(String productName){
        boolean result = false;

        for(int i = 0; i < productsIntoCartCollection.size(); i++){
            String name = productsIntoCartCollection.get(i)
                    .$(byXpath("descendant::div[@class='inventory_item_name']")).text();
            if(productName.equals(name)){
                result = true;
            }
        }
        return result;
    }

    public Double getFullPrice(){
        Double result = 0.0;

        for(int i = 0; i < productsIntoCartCollection.size(); i++){
            Double currentProductPrice = 0.0;
            currentProductPrice = Double.parseDouble(productsIntoCartCollection.get(i)
                    .$(byXpath("descendant::div[@class='inventory_item_price']"))
                    .text().replace("$",""));
            result += currentProductPrice;
        }
        return result;
    }

    public boolean isClearListProducts(){
        return productsIntoCartCollection.size() == 0;
    }

}
