package page_objects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPage {
    private SelenideElement markerShoppingCartPage = $(byXpath("//span[@class='title']"));


}
