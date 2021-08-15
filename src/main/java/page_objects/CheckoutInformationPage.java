package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import value_objects.Customer;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutInformationPage {
    private SelenideElement firstNameField = $(byXpath("//input[@data-test='firstName']"));
    private SelenideElement lastNameField = $(byXpath("//input[@data-test='lastName']"));
    private SelenideElement postalCodeField = $(byXpath("//input[@data-test='postalCode']"));
    private SelenideElement continueBtn = $(byXpath("//input[@data-test='continue']"));
    private SelenideElement cancelBtn = $(byXpath("//button[@data-test='cancel']"));

    @Step("Check Information page is loaded")
    public void waitCheckoutInformationPage(){
        cancelBtn.shouldBe(Condition.visible);
    }

    private void setFirstNameField(String text) { firstNameField.sendKeys(text); }

    private void setLastNameField(String text) { lastNameField.sendKeys(text); }

    private void setPostalCodeField(String text) { postalCodeField.sendKeys(text); }

    @Step("Click 'Continue' button")
    public void clickContinueBtn() { continueBtn.click(); }

    @Step("Click 'Cancel' button")
    public void clickCancelBtn() { cancelBtn.click(); }

    @Step("Entered customer date")
    public void enterCustomerDate(Customer customer) {
        setFirstNameField(customer.getFirstName());
        setLastNameField(customer.getLastName());
        setPostalCodeField(customer.getPostalCode().toString());
    }
}
