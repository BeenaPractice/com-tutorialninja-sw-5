package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customerlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage  extends Utility {
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement mouseHoverDesktop;

    @CacheLookup
    @FindBy(linkText = "Show AllDesktops")
    WebElement clickDesktop;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectSortZToA;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectSortAToZ;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement selectProduct;

    @CacheLookup
    @FindBy(name = "quantity")
    WebElement enterQty;

    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCartClick;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement hpText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successText;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement shoppingcartText;

    @CacheLookup
    @FindBy(xpath = "(//a[text()='HP LP3065'])[2]")
    WebElement hpProductText;
    @CacheLookup
    @FindBy(xpath = "//td[normalize-space()='Product 21']")
    WebElement product21Text;

    @CacheLookup
    @FindBy(xpath = "(//td[@class='text-right'][normalize-space()='£74.73'])[4]")
    WebElement totalcostText;

    @CacheLookup
    @FindBy(xpath = "//small[normalize-space()='Delivery Date:2023-11-30']")
    WebElement deliveryDateText;

    public void selectSortByAToZ() {
        Reporter.log("Select sort by A to Z" + selectSortAToZ.toString());
        selectByVisibleTextFromDropDown(selectSortAToZ, "Name (A - Z)");
        CustomListeners.test.log(Status.PASS, "Select sort by A to Z");
    }

    public void mouseHoverAndClickDesktops() {
        Reporter.log("Mouse hover and click on desktop" + mouseHoverDesktop.toString());
        mouseHoverToElementAndClick(mouseHoverDesktop);
        CustomListeners.test.log(Status.PASS, "Mouse hover and click on desktop");
    }

    public void clickOnShowAllDeskTops() {
        Reporter.log("Click on show all desktop" + clickDesktop.toString());
        clickOnElement(clickDesktop);
        CustomListeners.test.log(Status.PASS, "Click on show all desktop");
    }

    public void selectSortByZToA() {
        Reporter.log("Select sort by Z to A" + selectSortZToA.toString());
        selectByVisibleTextFromDropDown(selectSortZToA, "Name (Z - A)");
        CustomListeners.test.log(Status.PASS, "Select sort by Z to A");
    }

    public void selectProduct() {
        Reporter.log("Select product" + selectProduct.toString());
        clickOnElement(selectProduct);
        CustomListeners.test.log(Status.PASS, "Select product");
    }

    public void addToCart() {
        Reporter.log("Add to cart" + addToCartClick.toString());
        clickOnElement(addToCartClick);
        CustomListeners.test.log(Status.PASS, "Add to cart");
    }

    public String getHPText() {
        Reporter.log("Get text HP" + hpText.toString());
        CustomListeners.test.log(Status.PASS, "Get text HP");
        return getTextFromElement(hpText);
    }

    public String getSuccessMessageText() {
        Reporter.log("Get text Success Message" + successText.toString());
        CustomListeners.test.log(Status.PASS, "Get text Success Message");
        return getTextFromElement(successText);
    }

    public String getShoppingcartText() {
        Reporter.log("Get text Shopping cart" + shoppingcartText.toString());
        CustomListeners.test.log(Status.PASS, "Get text Shopping cart");
        return getTextFromElement(shoppingcartText);
    }

    public String getHPProdcutText() {
        Reporter.log("Get text HPP Product" + hpProductText.toString());
        CustomListeners.test.log(Status.PASS, "Get text HPP Product");
        return getTextFromElement(hpProductText);
    }

    public String getProdcut21Text() {
        Reporter.log("Get text Product 21" + product21Text.toString());
        CustomListeners.test.log(Status.PASS, "Get text Product 21");
        return getTextFromElement(product21Text);
    }

    public String getTotalCostText() {
        Reporter.log("Get text Total cost" + totalcostText.toString());
        CustomListeners.test.log(Status.PASS, "Get text Total cost");
        return getTextFromElement(totalcostText);
    }

    public String getdeliveryDateText() {
        Reporter.log("Get text delivery date" + deliveryDateText.toString());
        CustomListeners.test.log(Status.PASS, "Get text delivery date");
        return getTextFromElement(deliveryDateText);
    }

    public void verifyProductArrangeInDescendingOrder() {
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
    }

    public void selectDeliveryDate() {
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

   }