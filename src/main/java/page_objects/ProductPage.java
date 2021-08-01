package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.ConfProperties;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {
    private SelenideElement markerProductPage = $(byXpath("//span[@class='title']"));
    private SelenideElement shoppingCartBtn = $(byXpath("//a[@class='shopping_cart_link']"));
    private ElementsCollection productsCollection = $$(byXpath("//div[@class='inventory_item']"));

    public void clickShoppingCartBtn(){ shoppingCartBtn.click(); }

    public void addProductsToCart(Integer quantityOfProduct){

        for (int i = 0; i <  quantityOfProduct; i++){
            productsCollection.get(i).$(byXpath("//button")).click();
        }

    }
    public boolean isProductPage(){
        markerProductPage.shouldBe(Condition.visible);
        return markerProductPage.text().equals(ConfProperties.getProperty("product_page_marker"));
    }
}
