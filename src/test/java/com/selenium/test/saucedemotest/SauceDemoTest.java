package com.selenium.test.saucedemotest;

import com.selenium.saucedemo.SauceDemoPage;
import com.selenium.saucedemoinventory.SauceDemoInventoryPage;
import com.selenium.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SauceDemoTest  extends BaseTest {

    private SauceDemoPage sauceDemoPage;
    private SauceDemoInventoryPage sauceDemoInventoryPage;
    private SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void setupPages(){
        this.sauceDemoPage = new SauceDemoPage(driver);
        this.sauceDemoInventoryPage = new SauceDemoInventoryPage(driver);
    }

    @Test(dataProvider = "getData")
    public void AutomationPracticeWorkflow(String username, String password) throws InterruptedException {
        sauceDemoPage.goTo();
        sauceDemoPage.getFormComponent().isDisplayed();
        sauceDemoPage.getFormComponent().formFilling(username,password);
        waitTime();

        sauceDemoPage.getFormComponent().formSubmit();

        sauceDemoInventoryPage.getInventoryItemComponent().isDisplayed();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html","The login process fail");
        waitTime();

        softAssert.assertEquals(sauceDemoInventoryPage.getInventoryItemComponent().getItemTitle(),"Sauce Labs Fleece Jacket","The item title is NOT ok");
        softAssert.assertEquals(sauceDemoInventoryPage.getInventoryItemComponent().getItemPrice(),"$49.99","The item price is NOT ok");
        sauceDemoInventoryPage.navigateBack();
        waitTime();

        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"standard_user","secret_sauce"},
                {"locked_out_user","secret_sauce"},
                {"problem_user","secret_sauce"},
                {"performance_glitch_user","secret_sauce"},
        };

    }

    public void waitTime() throws InterruptedException {
        synchronized (driver){
            driver.wait(2000);
        }
    }
}
