package com.selenium.saucedemo;

import com.google.common.util.concurrent.Uninterruptibles;
import com.selenium.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class FormComponent extends AbstractComponent{

    @FindBy (className = "login-box")
    private WebElement formContainer;
    @FindBy (id = "login-button")
    private WebElement formLoginButton;

    @FindBy (id = "user-name")
    private WebElement userNameInput;

    @FindBy (id = "password")
    private WebElement passwordInput;

    public FormComponent(final WebDriver driver){
        super(driver);
    }

    public void formFilling(String username, String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void formSubmit(){
        formLoginButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.formContainer.isDisplayed());
    }
}
