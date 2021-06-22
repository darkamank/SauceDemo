package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{

    String addToCartButton = "//*[contains(text(), '%s')]//ancestor::*[@class='inventory_item']//child::button";
    String deleteFromCartButton = "//*[contains(text(), '%s')]//ancestor::*[@class='inventory_item']//child::button";
    public static final By QUALITY_ITEMS = By.id("shopping_cart_container");

    public ProductsPage (WebDriver driver){
        super(driver);
    }
    public void addItemToCart (String itemName){
        driver.findElement(By.xpath(String.format(addToCartButton,itemName))).click();
    }
    public void deleteItemFromCart(String itemName){
        driver.findElement(By.xpath(String.format(deleteFromCartButton,itemName))).click();
    }
    public String getTextRemoveOrAddItemToCart(String itemName){
        return driver.findElement(By.xpath(String.format(deleteFromCartButton,itemName))).getText();
    }
    public String qualityItemOnCart(){
       return driver.findElement(QUALITY_ITEMS).getText();
    }
    public CartPage openCartPage(){
        driver.findElement(QUALITY_ITEMS).click();
    return new CartPage(driver);
    }
}
