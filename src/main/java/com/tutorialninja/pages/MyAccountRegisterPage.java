package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customerlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class MyAccountRegisterPage extends Utility {
    @CacheLookup
    @FindBy(name = "firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(name = "lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(name = "email")
    WebElement email;

    @CacheLookup
    @FindBy(name = "telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(xpath = "(//input[@type='radio'])[2]")
    WebElement subscribeRadioButton;

    @CacheLookup
    @FindBy(name = "agree")
    WebElement privacyPolicyCheckBox;

    @CacheLookup
    @FindBy(xpath = "//input[@type='submit']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountHasBeenCreatedText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement clickContinueButton;


    @CacheLookup
    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continue1;
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccountLink;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;

    public void enterFirstName() {
        Reporter.log("Enter first name" + firstName.toString());
        sendTextToElement(firstName, "Jay");
        CustomListeners.test.log(Status.PASS, "Enter first name");
    }

    public void enterLastName() {
        Reporter.log("Enter last name" + lastName.toString());
        sendTextToElement(lastName, "Raj");
        CustomListeners.test.log(Status.PASS, "Enter last name");
    }

    public void enterEmail() {
        Reporter.log("Enter email" + email.toString());
        sendTextToElement(email, "ewq01@gmail.com");
        CustomListeners.test.log(Status.PASS, "Enter email");
    }

    public void enterTelephone() {
        Reporter.log("Enter Telephone" + telephone.toString());
        sendTextToElement(telephone, "12345678");
        CustomListeners.test.log(Status.PASS, "Enter Telephone");
    }

    public void enterPassword() {
        Reporter.log("Enter password" + password.toString());
        sendTextToElement(password, "qwe@1456");
        CustomListeners.test.log(Status.PASS, "Enter password");
    }

    public void enterConfirmPassword() {
        Reporter.log("Enter confirm password" + confirmPassword.toString());
        sendTextToElement(confirmPassword, "qwe@1456");
        CustomListeners.test.log(Status.PASS, "Enter confirm password");
    }

    public void selectSubscribeYesRadioButton() {
        Reporter.log("Click on radio button for subscribe" + subscribeRadioButton.toString());
        clickOnElement(subscribeRadioButton);
        CustomListeners.test.log(Status.PASS, "Click on radio button for subscribe");
    }

    public void clickPrivacyPolicyCheckbox() {
        Reporter.log("Click on privacy check box" + privacyPolicyCheckBox.toString());
        clickOnElement(privacyPolicyCheckBox);
        CustomListeners.test.log(Status.PASS, "Click on privacy check box");
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on continue button" + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }

    public String getAccountHasBeenCreatedText() {
        Reporter.log("Get text account is created" + accountHasBeenCreatedText.toString());
        CustomListeners.test.log(Status.PASS, "Get text account is created");
        return getTextFromElement(accountHasBeenCreatedText);
    }

    public void clickOnContinueButtonAgain() {
        Reporter.log("Click on continue button" + clickContinueButton.toString());
        clickOnElement(clickContinueButton);
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }

    public void clickOnContinueButton3() {
        Reporter.log("Click on continue button" + continue1.toString());
        clickOnElement(continue1);
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }

    public void clickOnMyAccountLink() {
        Reporter.log("Click on My Account link" + myAccountLink.toString());
        clickOnElement(myAccountLink);
        CustomListeners.test.log(Status.PASS, "Click on My Account link");
    }

    public String getAccountLogoutText() {
        Reporter.log("Get text account logout" + accountLogoutText.toString());
        CustomListeners.test.log(Status.PASS, "Get text account logout");
        return getTextFromElement(accountLogoutText);
    }


}
