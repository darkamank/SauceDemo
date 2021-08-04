package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage{

    String addToCartButton = "//*[contains(text(), '%s')]//ancestor::*[@class='inventory_item']//child::button";
    String deleteFromCartButton = "//*[contains(text(), '%s')]//ancestor::*[@class='inventory_item']//child::button";
    public static final By CART = By.id("shopping_cart_container");
    public static final By SELECT = By.xpath("//select[@class='product_sort_container']");
    public static final By RESET = By.xpath("//a[@id='reset_sidebar_link']");
    public static final By MENU = By.xpath("//button[@id='react-burger-menu-btn']");

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
       return driver.findElement(CART).getText();
    }
    public CartPage openCartPage(){
        driver.findElement(CART).click();
    return new CartPage(driver);
    }
    public void setSelect (String value){
        WebElement selectElem = driver.findElement(SELECT);
        Select select = new Select(selectElem);
        select.selectByValue(value);
    }
    public void resetAppState(){
        driver.findElement(MENU).click();
        driver.findElement(RESET).click();
    }
}
