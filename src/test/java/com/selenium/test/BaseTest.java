package com.selenium.test;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\Desktop\\Selenium Jar and Drivers\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\carlo\\Desktop\\Selenium Jar and Drivers\\geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\carlo\\Desktop\\Selenium Jar and Drivers\\msedgedriver.exe");
        this.driver = new FirefoxDriver();
    }


    @AfterTest
    public void quitDriver(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.driver.quit();
    }

}
