package page_elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import utils.ConfProperties;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class TitleElement {
    private SelenideElement markerPages = $(byXpath("//span[@class='title']"));

    public boolean isShoppingCartPage(){
        markerPages.shouldBe(Condition.visible);
        return markerPages.text().equals(ConfProperties.getProperty("shopping_cart_page_marker"));
    }
    public boolean isProductPage(){
        markerPages.shouldBe(Condition.visible);
        return markerPages.text().equals(ConfProperties.getProperty("product_page_marker"));
    }

    public boolean isCheckoutInformationPage(){
        markerPages.shouldBe(Condition.visible);
        return markerPages.text().equals(ConfProperties.getProperty("checkout_information_page_marker"));
    }

    public boolean isOverviewPage(){
        markerPages.shouldBe(Condition.visible);
        return markerPages.text().equals(ConfProperties.getProperty("overview_page_marker"));
    }

    public boolean isCompletePage(){
        markerPages.shouldBe(Condition.visible);
        return markerPages.text().equals(ConfProperties.getProperty("complete_page_marker"));
    }

}
