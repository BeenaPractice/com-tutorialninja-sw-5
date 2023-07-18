package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customerlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class MyAccountLoginPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddress;
    @CacheLookup
    @FindBy(name = "password")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'My Account')]")
    WebElement myAccountText;

    public void enterEmailAddress() {
        Reporter.log("Enter email" + emailAddress.toString());
        sendTextToElement(emailAddress, "qwe0@gmail.com");
        CustomListeners.test.log(Status.PASS, "Enter email");

    }

    public void enterValidPassword() {
        Reporter.log("Enter password" + enterPassword.toString());
        sendTextToElement(enterPassword, "qwe123");
        CustomListeners.test.log(Status.PASS, "Enter email");
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on login button" + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on login button");
    }

    public String getMyAccountText() {
        Reporter.log("Get Text My account" + myAccountText.toString());
        CustomListeners.test.log(Status.PASS, "Get Text My account");
        return getTextFromElement(myAccountText);
    }
}


