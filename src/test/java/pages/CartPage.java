package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {

    String itemName = "//*[contains(text(),'%s')]";
    String removeItemFromCart = "//*[contains(text(),'%s')]//ancestor::*[@class='cart_item']//child::button";
    public static final By ITEM_NAME = By.xpath("//div[@class='inventory_item_name']");
    public static final By ITEM_PRICE = By.xpath("//div[@class='inventory_item_price']");
    public static final By CHECKOUT = By.xpath("//button[@id='checkout']");
    public static final By TITLE = By.xpath("//span[@class='title']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

public void openCart(){
        driver.get("https://www.saucedemo.com/cart.html");
}
public void findAddedItem(String name){
        boolean isItemAddedToCart = driver.findElement (By.xpath(String.format(itemName,name))).isDisplayed();
    Assert.assertTrue(isItemAddedToCart,"Item didn't display in cart");
}



}
