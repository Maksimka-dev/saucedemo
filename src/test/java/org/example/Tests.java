package org.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page_elements.TitleElement;
import page_objects.*;
import utils.ConfProperties;
import value_objects.Customer;

import static com.codeborne.selenide.Selenide.open;

public class Tests {

    private LoginPage logIn;
    private ProductPage productPage;
    private TitleElement titleElement;
    private ShoppingCartPage shoppingCartPage;
    private CheckoutInformationPage checkoutInformationPage;
    private OverviewPage overviewPage;

    @BeforeEach
    public void setup(){
        Configuration.baseUrl = "https://www.saucedemo.com/";
        open(Configuration.baseUrl);
        logIn = new LoginPage();
        productPage = new ProductPage();
        titleElement = new TitleElement();
        shoppingCartPage = new ShoppingCartPage();
        checkoutInformationPage = new CheckoutInformationPage();
        overviewPage = new OverviewPage();

    }

    @Test
    public void loginTest(){
        logIn.login();
        Assertions.assertTrue(titleElement.isProductPage());
    }

    @Test
    public void priceCompareTest(){
        Double price = 0.0;
        Double itemPrice = 0.0;
        Customer customer = new Customer(ConfProperties.getProperty("customer_first_name"),
                ConfProperties.getProperty("customer_last_name"),
                Integer.parseInt(ConfProperties.getProperty("customer_postal_code")));

        logIn.login();

        productPage.waitProductPage();
        productPage.addProductsToCart(3);
        productPage.clickShoppingCartBtn();
        shoppingCartPage.waitShoppingCartPage();

        price = shoppingCartPage.getFullPrice();

        shoppingCartPage.clickCheckoutBtn();
        checkoutInformationPage.waitCheckoutInformationPage();

        checkoutInformationPage.enterCustomerDate(customer);

        checkoutInformationPage.clickContinueBtn();
        overviewPage.waitOverviewPage();

        itemPrice = overviewPage.getItemTotalPrice();

        Assertions.assertTrue(price == itemPrice);

    }
}
