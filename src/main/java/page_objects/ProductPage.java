package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {
    private SelenideElement shoppingCartBtn = $(byXpath("//a[@class='shopping_cart_link']"));
    private ElementsCollection productsCollection = $$(byXpath("//div[@class='inventory_item']"));
    private SelenideElement blockOfProducts = $(byXpath("//div[@class='inventory_list']"));

    public void clickShoppingCartBtn(){ shoppingCartBtn.click(); }

    public void addProductsToCart(Integer quantityOfProduct){

        for (int i = 0; i <  quantityOfProduct; i++){
            productsCollection.get(i).$(byXpath("descendant::button")).click();
        }
    }

    public void addProductToCartByName(String nameProduct){
        for (int i = 0; i <  productsCollection.size(); i++){

            String name = productsCollection.get(i).$(byXpath("descendant::div[@class='inventory_item_name']")).text();

            if(nameProduct.equals(name)){
                productsCollection.get(i).$(byXpath("descendant::button")).click();
            }
        }
    }

    public void waitProductPage(){
        blockOfProducts.shouldBe(Condition.visible);
    }

}
