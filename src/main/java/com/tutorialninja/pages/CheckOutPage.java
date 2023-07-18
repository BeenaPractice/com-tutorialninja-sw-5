package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customerlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckOutPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    WebElement firstName;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-email']")
    WebElement email;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-telephone']")
    WebElement telephone;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement address;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement city;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    WebElement postcode;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement country;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement state;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement continueButtonguest;
    @CacheLookup
    @FindBy(name = "agree")
    WebElement termsandCondition;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continueButtonpayment;
    @CacheLookup
    @FindBy(xpath = "//div[text()='Warning: Payment method required!']")
    WebElement warningMessageText;
    @CacheLookup
    @FindBy(tagName = "textarea")
    WebElement textArea;

    public void enterFirstname() {
        Reporter.log("Enter first name" + firstName.toString());
        sendTextToElement(firstName, "Gabbar");
        CustomListeners.test.log(Status.PASS, "Enter first name");
    }

    public void enterLastName() {
        Reporter.log("Enter last name" + lastName.toString());
        sendTextToElement(lastName, "Singh");
        CustomListeners.test.log(Status.PASS, "Enter last name");
    }

    public void enterEmail() {
        Reporter.log("Enter email" + email.toString());
        sendTextToElement(email, "gabbarsingh1234@gmail.com");
        CustomListeners.test.log(Status.PASS, "Enter email");
    }

    public void enterTelephone() {
        Reporter.log("Enter Telephone" + telephone.toString());
        sendTextToElement(telephone, "123456789");
        CustomListeners.test.log(Status.PASS, "Enter Telephone");
    }

    public void enterAddress() {
        Reporter.log("Enter Address" + address.toString());
        sendTextToElement(address, "Soho street");
        CustomListeners.test.log(Status.PASS, "Enter Address");
    }

    public void enterCity() {
        Reporter.log("Enter City" + city.toString());
        sendTextToElement(city, "London");
        CustomListeners.test.log(Status.PASS, "Enter City");
    }

    public void enterPostcode() {
        Reporter.log("Enter postcode" + postcode.toString());
        sendTextToElement(postcode, "B346YH");
        CustomListeners.test.log(Status.PASS, "Enter postcode");
    }

    public void enterCountry() {
        Reporter.log("Enter Country" + country.toString());
        sendTextToElement(country, "United Kingdom");
        CustomListeners.test.log(Status.PASS, "Enter country");
    }

    public void enterState() {
        Reporter.log("Enter State" + state.toString());
        sendTextToElement(state, "Soho");
        CustomListeners.test.log(Status.PASS, "Enter State");
    }

    public void clickContinueButtonguest() {
        Reporter.log("Click on continue button" + continueButtonguest.toString());
        clickOnElement(continueButtonguest);
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }

    public void enterCommentInTextAea() {
        Reporter.log("Enter comment" + textArea.toString());
        sendTextToElement(textArea, "Thank You!");
        CustomListeners.test.log(Status.PASS, "Enter comment");
    }

    public void checkTermsAndCondtionCheckBox() {
        Reporter.log("Check terms and condition" + termsandCondition.toString());
        clickOnElement(termsandCondition);
        CustomListeners.test.log(Status.PASS, "Check terms and condition");
    }

    public void clickContinueButtonpayment() {
        Reporter.log("Click on continue button for payment" + continueButtonpayment.toString());
        clickOnElement(continueButtonpayment);
        CustomListeners.test.log(Status.PASS, "Click on continue button for payment");
    }

    public String GetWarningMessageText() {
        Reporter.log("Get Text for warning" + warningMessageText.toString());
        CustomListeners.test.log(Status.PASS, "Get Text for warning");
        return getTextFromElement(warningMessageText);
    }

    }