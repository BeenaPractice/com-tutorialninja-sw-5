package com.tutorialninja.testsuite;

import com.tutorialninja.customerlisteners.CustomListeners;
import com.tutorialninja.pages.MyAccountPage;
import com.tutorialninja.pages.MyAccountRegisterPage;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)

public class AccountRegisterPageTest extends BaseTest {
    MyAccountPage myAccountPage;
    MyAccountRegisterPage accountRegisterPage ;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        myAccountPage = new MyAccountPage();
        accountRegisterPage = new MyAccountRegisterPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        //1.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        // 1.2 Call the method “selectMyAccountOptions” method and pass the parameter Register
        myAccountPage.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”
        Assert.assertEquals(myAccountPage.getRegisterAccountText(), "Register Account", "Register Account not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter Register
        myAccountPage.selectMyAccountOptions("Register");
        //3.3 Enter First Name
        accountRegisterPage.enterFirstName();
        //3.4 Enter Last Name
        accountRegisterPage.enterLastName();
        //3.5 Enter Email
        accountRegisterPage.enterEmail();
        //3.6 Enter Telephone
        accountRegisterPage.enterTelephone();
        //3.7 Enter Password
        accountRegisterPage.enterPassword();
        //3.8 Enter Password Confirm
        accountRegisterPage.enterConfirmPassword();
        //3.9 Select Subscribe Yes radio button
        accountRegisterPage.selectSubscribeYesRadioButton();
        //3.10 Click on Privacy Policy check box
        accountRegisterPage.clickPrivacyPolicyCheckbox();
        //3.11 Click on Continue button
        accountRegisterPage.clickOnContinueButton();
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(accountRegisterPage.getAccountHasBeenCreatedText(), "Your Account Has Been Created!", "Cannot create account");
        // 3.13 Click on Continue button
        accountRegisterPage.clickOnContinueButtonAgain();
        //3.14 Clickr on My Account Link.
        accountRegisterPage.clickOnMyAccountLink();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter "Logout"
        myAccountPage.selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals(accountRegisterPage.getAccountLogoutText(), "Account Logout", "Cannot logout");
        //3.17 Click on Continue button
        accountRegisterPage.clickOnContinueButton3();
    }
}

