package com.selenium.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoPage{

    private WebDriver driver;

    private FormComponent formComponent;

    public SauceDemoPage(final WebDriver driver){
        this.driver = driver;
        this.formComponent = PageFactory.initElements(driver, FormComponent.class);
    }

    public void goTo(){
        this.driver.get("https://www.saucedemo.com/");
    }

    public FormComponent getFormComponent() {
        return formComponent;
    }
}
