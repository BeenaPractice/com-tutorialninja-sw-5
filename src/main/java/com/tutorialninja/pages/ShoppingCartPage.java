package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customerlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartClick;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyTabClick;


    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'£Pound Sterling')]")
    WebElement poundSterlingClick;


    //2.10 Click on link “shopping cart” display into success message
    public void shoppingCartClick() {
        Reporter.log("Click on shopping cart" + shoppingCartClick.toString());
        clickOnElement(shoppingCartClick);
        CustomListeners.test.log(Status.PASS, "Click on shopping cart");
    }

    //currency tab click
    public void clickOnCurrencyTab() {
        Reporter.log("Click on currency tab" + currencyTabClick.toString());
        clickOnElement(currencyTabClick);
        CustomListeners.test.log(Status.PASS, "Click on currency tab");
    }

    public void clickOnPoundSterling() {
        Reporter.log("Click on pound sterling" + poundSterlingClick.toString());
        clickOnElement(poundSterlingClick);
        CustomListeners.test.log(Status.PASS, "Click on pound sterling");
    }

}