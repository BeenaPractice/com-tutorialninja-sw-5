package com.tutorialninja.testsuite;

import com.tutorialninja.customerlisteners.CustomListeners;
import com.tutorialninja.pages.*;
import com.tutorialninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)

public class LapTopsAndNoteBooksTest extends BaseTest {
    HomePage homePage ;
    LaptopsAndNoteBooksPage laptopsAndNotebooksPage ;
    ShoppingCartPage shoppingCartpage ;
    MyAccountRegisterPage myAccountRegisterPage;
    CheckOutPage checkoutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        laptopsAndNotebooksPage = new LaptopsAndNoteBooksPage();
        shoppingCartpage = new ShoppingCartPage();
        myAccountRegisterPage = new MyAccountRegisterPage();
        checkoutPage = new CheckOutPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverAndClickLaptopsAndNotebooks();
        //1.2 Click on “Show All Laptops & Notebooks”
        laptopsAndNotebooksPage.clickOnShowAllLaptopAndNoteBooks();
        laptopsAndNotebooksPage.originalProductPrice();
        //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.sortByPriceHightoLow();
        laptopsAndNotebooksPage.afterSortByPrice();
        //1.4 Verify the Product price will arrange in High to Low order.
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        // Select currency as £ Pound Sterling
        shoppingCartpage.clickOnCurrencyTab();
        shoppingCartpage.clickOnPoundSterling();
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverAndClickLaptopsAndNotebooks();
        //2.2 Click on “Show All Laptops & Notebooks”
        laptopsAndNotebooksPage.clickOnShowAllLaptopAndNoteBooks();
        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.sortByPriceHightoLow();
        //2.4 Select Product “MacBook”
        laptopsAndNotebooksPage.clickOnMacbook();
        //2.5 Verify the text “MacBook”
        Assert.assertEquals(laptopsAndNotebooksPage.getMacbooktext(), "MacBook", "Macbook product not found");
        //2.6 Click on ‘Add To Cart’ button
        waitUntilVisibilityOfElementLocated(By.xpath("//button[@id='button-cart']"), 5);
        laptopsAndNotebooksPage.addToCart();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertEquals(laptopsAndNotebooksPage.getSuccesstext(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Not correct text");
        // 2.8 Click on link “shopping cart” display into success message
        laptopsAndNotebooksPage.clickShoppingCart();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertEquals(laptopsAndNotebooksPage.getShoppingCartText(), "Shopping Cart  (0.00kg)", "Shopping cart message not found");
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(laptopsAndNotebooksPage.getMacbookNameText(), "MacBook", "Product name not matched");
        //2.11 Change Quantity "2"
        laptopsAndNotebooksPage.clearQty();
        laptopsAndNotebooksPage.changeQty();
        //2.12 Click on “Update”Tab
        laptopsAndNotebooksPage.clickUpdateTab();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertEquals(laptopsAndNotebooksPage.getModifiedSuccessText(), "Success: You have modified your shopping cart!\n" +
                "×", "Cart not modified");
        //2.14 Verify the Total £737.45
        Assert.assertEquals(laptopsAndNotebooksPage.getTotaltext(), "£737.45", "Total cost do not match");
        //2.15 Click on “Checkout” button
        laptopsAndNotebooksPage.clickCheckout();
        //2.16 Verify the text “Checkout”
        Assert.assertEquals(laptopsAndNotebooksPage.getCheckoutText(), "Checkout", "text not found");
        //2.17 Verify the Text “New Customer”
        Thread.sleep(2000);
        //waitUntilVisibilityOfElementLocated(By.xpath("//h1[contains(text(),'Checkout')]"), 5);
        Assert.assertEquals(laptopsAndNotebooksPage.getNewCustomerText(), "New Customer", "Text not found");
        //2.18 Click on “Guest Checkout” radio button
        laptopsAndNotebooksPage.clickOnGuestCheckoutButton();
        //2.19 Click on “Continue” tab
        laptopsAndNotebooksPage.clickOnContinueButton();
        //2.20 Fill the mandatory fields
        checkoutPage.enterFirstname();
        checkoutPage.enterLastName();
        checkoutPage.enterEmail();
        checkoutPage.enterTelephone();
        checkoutPage.enterAddress();
        checkoutPage.enterCity();
        checkoutPage.enterPostcode();
        checkoutPage.enterCountry();
        checkoutPage.enterState();
        //2.21 Click on “Continue” Button
        checkoutPage.clickContinueButtonguest();
        //2.22 Add Comments About your order into text area
        checkoutPage.enterCommentInTextAea();
        //2.23 Check the Terms & Conditions check box
        checkoutPage.checkTermsAndCondtionCheckBox();
        //2.24 Click on “Continue” button
        checkoutPage.clickContinueButtonpayment();
        //2.25 Verify the message “Warning: Payment method required
        Assert.assertEquals(checkoutPage.GetWarningMessageText(), "Warning: Payment method required!\n" + "×", "message not found");
    }

}