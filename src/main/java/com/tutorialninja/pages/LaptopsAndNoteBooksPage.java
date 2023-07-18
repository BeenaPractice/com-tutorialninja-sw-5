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

public class LaptopsAndNoteBooksPage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Show AllLaptops & Notebooks")
    WebElement clickOnShowAllLaptopsandNoteBooks;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByPrice;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macbookClick;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement macbookText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successText;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement cartButton;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement macbooknameText;

    @CacheLookup
    @FindBy(xpath = "//tbody/tr[1]/td[4]/div[1]/input[1]")
    WebElement clearQty;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement changeQty;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement updatetab;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement modifiedSuccessText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkoutLink;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement checkoutText;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement newCustomerText;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckoutButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueLink;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> priceList;

    //1.2 Click on “Show AllLaptops & Notebooks”
    public void clickOnShowAllLaptopAndNoteBooks() {
        Reporter.log("Click on show all laptop and notebooks" + clickOnShowAllLaptopsandNoteBooks.toString());
        clickOnElement(clickOnShowAllLaptopsandNoteBooks);
        CustomListeners.test.log(Status.PASS, "Click on show all laptop and notebooks");
    }

    // Get all the products price and stored into array list
    public void originalProductPrice() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        Reporter.log("Original product list" + priceList.toString());
        CustomListeners.test.log(Status.PASS, "Original product list");
    }

    //1.3 Select Sort By "Price (High > Low)"

    public void sortByPriceHightoLow() {
        Reporter.log("Product Sort by High low price" + sortByPrice.toString());
        selectByVisibleTextFromDropDown(sortByPrice, "Price (High > Low)");
        CustomListeners.test.log(Status.PASS, "Product Sort by High low price");
    }

    // After filter Price (High > Low) Get all the products price and stored into array list
    public void afterSortByPrice() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        Reporter.log("After sort by price" + priceList.toString());
        CustomListeners.test.log(Status.PASS, "After sort by price");
    }
    public void clickOnMacbook() {
        Reporter.log("Click on Macbook" + macbookClick.toString());
        clickOnElement(macbookClick);
        CustomListeners.test.log(Status.PASS, "Click on Macbook");
    }
    public String getMacbooktext() {
        Reporter.log("Get Text MacBook" + macbookText.toString());
        CustomListeners.test.log(Status.PASS, "Get Text MacBook");
        return getTextFromElement(macbookText);
    }
    public void addToCart() {
        Reporter.log("Click on add to cart" + cartButton.toString());
        clickOnElement(cartButton);
        CustomListeners.test.log(Status.PASS, "Click on add to cart");
    }
    public String getSuccesstext() {
        Reporter.log("Get Text Success" + successText.toString());
        CustomListeners.test.log(Status.PASS, "Get Text Success");
        return getTextFromElement(successText);

    }
    public void clickShoppingCart(){
        Reporter.log("Click on shopping cart" + shoppingCartLink.toString());
        clickOnElement(shoppingCartLink);
        CustomListeners.test.log(Status.PASS, "Click on shopping cart");
    }
    public String getShoppingCartText() {
        Reporter.log("Get text shopping cart" + shoppingCartText.toString());
        CustomListeners.test.log(Status.PASS, "Get text shopping cart");
        return getTextFromElement(shoppingCartText);
    }
    public String getMacbookNameText() {
        Reporter.log("Get Text MacBook" + macbooknameText.toString());
        CustomListeners.test.log(Status.PASS, "Get Text MacBook");
        return getTextFromElement(macbooknameText);
    }
    public void clearQty(){
        clearQty.clear();
    }
    public void changeQty(){
        Reporter.log("Change the Qty" + changeQty.toString());
        sendTextToElement(changeQty,"2");
        CustomListeners.test.log(Status.PASS, "Change the Qty");
    }
    public void clickUpdateTab(){
        Reporter.log("Click on update tab" + updatetab.toString());
        clickOnElement(updatetab);
        CustomListeners.test.log(Status.PASS, "Click on update tab");
    }
    public String getModifiedSuccessText(){
        Reporter.log("Get Text modified success" + modifiedSuccessText.toString());
        CustomListeners.test.log(Status.PASS, "Get Text modified success");
        return getTextFromElement(modifiedSuccessText);
    }
    public String getTotaltext(){
        Reporter.log("Get Text Total amount" + totalText.toString());
        CustomListeners.test.log(Status.PASS, "Get Text Total amount");
        return getTextFromElement(totalText);
    }
    public void clickCheckout(){
        Reporter.log("Click on checkout" + checkoutLink.toString());
        clickOnElement(checkoutLink);
        CustomListeners.test.log(Status.PASS, "Click on checkout");
    }
    public String getCheckoutText(){
        Reporter.log("Get Text Check Out" + checkoutText.toString());
        CustomListeners.test.log(Status.PASS, "Get Text Check Out");
        return getTextFromElement(checkoutText);
    }
    public String getNewCustomerText(){
        Reporter.log("Get Text New customer" + newCustomerText.toString());
        CustomListeners.test.log(Status.PASS, "Get Text New customer");
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckoutButton(){
        Reporter.log("Click on guest checkout button" + guestCheckoutButton.toString());
        clickOnElement(guestCheckoutButton);
        CustomListeners.test.log(Status.PASS, "Click on guest checkout button");
    }

    public void clickOnContinueButton(){
        Reporter.log("Click on Continue button" + continueLink.toString());
        clickOnElement(continueLink);
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }
}

