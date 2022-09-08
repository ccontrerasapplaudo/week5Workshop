package com.selenium.saucedemoinventory;

import com.selenium.common.AbstractComponent;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryItemComponent extends AbstractComponent {

    @FindBy(css = "div.inventory_item:nth-child(4)")
    WebElement itemContainer;
    @FindBy(css = "div.inventory_item:nth-child(4) div.inventory_item_name")
    WebElement itemTitle;

    @FindBy(css = "div.inventory_item:nth-child(4) div.inventory_item_price")
    WebElement itemPrice;

    WebDriver webDriver;

    public InventoryItemComponent(final WebDriver driver){
        super(driver);
        this.webDriver = driver;
    }

    public String getItemTitle(){
        String title = new String();
        try {
            title=itemTitle.getText();
            System.out.println("ITEM TITLE:"+title);
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("ITEM TITLE: ERROR");
            title="TITLE ERROR";
        }
        return title;
    }

    public String getItemPrice(){
        String price = new String();
        try {
            price=itemPrice.getText();
            System.out.println("ITEM PRICE:"+price);
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("ITEM PRICE: ERROR");
            price="PRICE ERROR";
        }
        return price;
    }


    @Override
    public boolean isDisplayed() {
        boolean returnValue;

        try {
            returnValue = wait.until((d) -> this.itemContainer.isDisplayed());
        } catch (TimeoutException ex) {
            System.out.println("Item container not found");
            returnValue = false;
        }

        return  returnValue;
    }
}
