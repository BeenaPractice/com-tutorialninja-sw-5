package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customerlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class MyAccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement MyAccountTab;

    @CacheLookup
    @FindBy(xpath = "//div[@id ='top-links']//li[@class='hidden-xs hidden-sm hidden-md']/ul/li")
    WebElement MyAccountOptions;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Register Account']")
    WebElement RegisterAccountText;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement ReturningCustomerText;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu dropdown-menu-right']//li")
    List<WebElement> TopMenu;
    @CacheLookup
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement MyAccount1;

    public void clickOnMyAccountTab() {
        mouseHoverToElementAndClick(MyAccountTab);
        Reporter.log("Click on my account tab" + MyAccountTab.toString());
        CustomListeners.test.log(Status.PASS, "Click on my account tab");
    }

    public void clickOnMyAccount1() {
        mouseHoverToElementAndClick(MyAccount1);
    }

    public String getRegisterAccountText() {
        Reporter.log("Get Text Register account" + RegisterAccountText.toString());
        CustomListeners.test.log(Status.PASS, "Get Text Register account");
        return getTextFromElement(RegisterAccountText);

    }

    public String getReturningCustomerText() {
        Reporter.log("Get Text Return customer" + ReturningCustomerText.toString());
        CustomListeners.test.log(Status.PASS, "Get Text Return customer");
        return getTextFromElement(ReturningCustomerText);
    }

    /*
     * 1.1 create method with name "selectMyAccountOptions" it has one parameter name
     * "option" of type string
     * 1.2 This method should click on the options whatever name is passed as parameter.
     * (Hint: Handle List of Element and Select options)
     */
    public void selectMyAccountOptions(String option) {
        try {
            List<WebElement> list = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu dropdown-menu-right']//li"));
            for (WebElement listOfElement : list) {
                if (listOfElement.getText().equals(option)) {
                    listOfElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> list = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu dropdown-menu-right']//li"));
        }
        CustomListeners.test.log(Status.PASS, "Select my account options");
        Reporter.log("Select my account options" + TopMenu.toString());
    }

}
