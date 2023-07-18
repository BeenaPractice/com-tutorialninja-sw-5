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

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement mouseHoverDesktop;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement mouseHoverLaptopsAndNotebooks;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement mouseHoverComponents;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopText;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopNotebookText;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentsText;

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> selectMenu1;

    public void mouseHoverAndClickDesktops() {
        Reporter.log("Mouse hover and click on desktop" + mouseHoverDesktop.toString());
        mouseHoverToElementAndClick(mouseHoverDesktop);
        CustomListeners.test.log(Status.PASS, "Mouse hover and click on desktop");
    }

    public void mouseHoverAndClickLaptopsAndNotebooks() {
        Reporter.log("Mouse hover and click on Laptop and Notebooks" + mouseHoverLaptopsAndNotebooks.toString());
        mouseHoverToElementAndClick(mouseHoverLaptopsAndNotebooks);
        CustomListeners.test.log(Status.PASS, "Mouse hover and click on Laptop and Notebooks");
    }

    public void mouseHoverAndClickComponents() {
        Reporter.log("Mouse hover and click on Components" + mouseHoverComponents.toString());
        mouseHoverToElementAndClick(mouseHoverComponents);
        CustomListeners.test.log(Status.PASS, "Mouse hover and click on Components");
    }

    public void selectMenu(String menu) {
        try {
            List<WebElement> list = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
            for (WebElement listOfElement : list) {
                if (listOfElement.getText().equals(menu)) {
                    listOfElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> list = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
        Reporter.log("Select from top menu" + selectMenu1.toString());
        CustomListeners.test.log(Status.PASS, "Select from top menu");
    }

    public String getDesktopText() {
        Reporter.log("Get Text Desktop" + desktopText.toString());
        CustomListeners.test.log(Status.PASS, "Get Text Desktop");
        return getTextFromElement(desktopText);
    }

    public String getLaptopsNotebooksText() {
        Reporter.log("Get Text Laptop and Notebooks" + laptopNotebookText.toString());
        CustomListeners.test.log(Status.PASS, "Get Text Laptop and Notebooks");
        return getTextFromElement(laptopNotebookText);
    }

    public String getComponents() {
        Reporter.log("Get Text Components" + componentsText.toString());
        CustomListeners.test.log(Status.PASS, "Get Text Components");
        return getTextFromElement(componentsText);
    }

}
