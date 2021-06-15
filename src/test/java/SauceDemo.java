import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemo extends BaseTest{
    @Test
    public void lonIn (){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        driver.findElement(By.cssSelector("[type='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        boolean idDisplayed = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).isDisplayed();
        Assert.assertTrue(idDisplayed,"You didn't authorize");
    }
    @Test
    public void addItemToCart (){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        driver.findElement(By.cssSelector("[type='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        boolean idDisplayed = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).isDisplayed();
        Assert.assertTrue(idDisplayed,"You didn't authorize");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        boolean isAddedItem = driver.findElement(By.xpath("//div[contains(text(),'Sauce')]")).isDisplayed();
        Assert.assertTrue(isAddedItem,"Item didn't add");
    }
    @Test
    public void checkValueCart(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        driver.findElement(By.cssSelector("[type='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        boolean idDisplayed = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).isDisplayed();
        Assert.assertTrue(idDisplayed,"You didn't authorize");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        WebElement element = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        String itemValue = element.getText();
        Assert.assertEquals(itemValue,"2", "Items didn't add to cart");
    }
    @Test
    public void checkItemNameAndCost(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[type='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        boolean idDisplayed = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).isDisplayed();
        Assert.assertTrue(idDisplayed,"You didn't authorize");
        String addedItem = driver.findElement(By.xpath("//div[contains(text(),'Backpack')]")).getText();
        String addedItemCost = driver.findElement(By.xpath("//div[contains(text(),'29.99')]")).getText();
        System.out.println(addedItemCost);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        String itemName = driver.findElement(By.className("inventory_item_name")).getText();
        String itemCost = driver.findElement(By.className("inventory_item_price")).getText();
        Assert.assertEquals(itemCost,addedItemCost,"Item cost doesn't match");
        Assert.assertEquals(itemName,addedItem,"Item name doesn't match");

    }
}
