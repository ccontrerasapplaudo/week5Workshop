package com.selenium.saucedemoinventory;

import com.selenium.saucedemo.FormComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoInventoryPage{
    private WebDriver driver;

    private InventoryItemComponent inventoryItemComponent;

    public SauceDemoInventoryPage(final WebDriver driver){
        this.driver = driver;
        this.inventoryItemComponent = PageFactory.initElements(driver, InventoryItemComponent.class);
    }

    public void navigateBack(){
        driver.navigate().back();
    }

    public InventoryItemComponent getInventoryItemComponent() {
        return inventoryItemComponent;
    }
}
