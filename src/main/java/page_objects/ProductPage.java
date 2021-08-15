package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {
    private SelenideElement shoppingCartBtn = $(byXpath("//a[@class='shopping_cart_link']"));
    private ElementsCollection productsCollection = $$(byXpath("//div[@class='inventory_item']"));
    private SelenideElement blockOfProducts = $(byXpath("//div[@class='inventory_list']"));

    @Step("Click 'Shopping Cart' button")
    public void clickShoppingCartBtn(){ shoppingCartBtn.click(); }

    @Step("Added products to cart")
    public void addProductsToCart(Integer quantityOfProduct){

        for (int i = 0; i <  quantityOfProduct; i++){
            productsCollection.get(i).$(byXpath("descendant::button")).click();
        }
    }

    @Step("Product page is loaded")
    public void waitProductPage(){
        blockOfProducts.shouldBe(Condition.visible);
    }

}
