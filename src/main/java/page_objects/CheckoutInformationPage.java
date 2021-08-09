package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import value_objects.Customer;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutInformationPage {
    private SelenideElement firstNameField = $(byXpath("//input[@data-test='firstName']"));
    private SelenideElement lastNameField = $(byXpath("//input[@data-test='lastName']"));
    private SelenideElement postalCodeField = $(byXpath("//input[@data-test='postalCode']"));
    private SelenideElement continueBtn = $(byXpath("//input[@data-test='continue']"));
    private SelenideElement cancelBtn = $(byXpath("//button[@data-test='cancel']"));

    public void waitCheckoutInformationPage(){
        cancelBtn.shouldBe(Condition.visible);
    }

    public void setFirstNameField(String text) { firstNameField.sendKeys(text); }

    public String getFirstNameField() { return firstNameField.getValue(); }

    public void setLastNameField(String text) { lastNameField.sendKeys(text); }

    public String getLastNameField() { return lastNameField.getValue(); }

    public void setPostalCodeField(String text) { postalCodeField.sendKeys(text); }

    public String getPostalCodeField() { return postalCodeField.getValue(); }

    public void clickContinueBtn() { continueBtn.click(); }

    public void clickCancelBtn() { cancelBtn.click(); }

    public void enterCustomerDate(Customer customer) {
        setFirstNameField(customer.getFirstName());
        setLastNameField(customer.getLastName());
        setPostalCodeField(customer.getPostalCode().toString());
    }
}
