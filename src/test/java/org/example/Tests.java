package org.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page_objects.LoginPage;
import page_objects.ProductPage;

import static com.codeborne.selenide.Selenide.open;

public class Tests {

    private LoginPage logIn;
    private ProductPage productPage;

    @BeforeEach
    public void setup(){
        Configuration.baseUrl = "https://www.saucedemo.com/";
        open(Configuration.baseUrl);
        logIn = new LoginPage();
        productPage = new ProductPage();
    }

    @Test
    public void loginTest(){
        logIn.login();
        Assertions.assertTrue(productPage.isProductPage());
    }
}
