package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTest extends BaseTest {

    @Test
    public void AddProductToCart(){
        loginPage.openSite("https://www.saucedemo.com/");
        loginPage.LogIn(NAME,PASSWORD);
        productsPage.addItemToCart("Sauce Labs Backpack");
        productsPage.addItemToCart("Sauce Labs Onesie");
        String getTextIsAdd = productsPage.getTextRemoveOrAddItemToCart("Sauce Labs Backpack");
        Assert.assertEquals(getTextIsAdd,"REMOVE","Didn't click the 'Add to Cart' button");
        String getTextIsAdd2 = productsPage.getTextRemoveOrAddItemToCart("Sauce Labs Onesie");
        Assert.assertEquals(getTextIsAdd2,"REMOVE","Didn't click the 'Add to Cart' button");
    }
    @Test
    public void checkIfAddedItemsDisplayedInCart(){
        loginPage.openSite("https://www.saucedemo.com/");
        loginPage.LogIn(NAME,PASSWORD);
        productsPage.addItemToCart("Sauce Labs Backpack");
        productsPage.addItemToCart("Sauce Labs Onesie");
        String qualityItems = productsPage.qualityItemOnCart();
        Assert.assertEquals(qualityItems,"2","Quality Items Displayed incorrectly");
        productsPage.openCartPage();
        cartPage.findAddedItem("Sauce Labs Backpack");
        cartPage.findAddedItem("Sauce Labs Onesie");
    }
    @Test
    public void selectProductSort(){
        loginPage.openSite("https://www.saucedemo.com/");
        loginPage.LogIn(NAME,PASSWORD);
        productsPage.setSelect("za");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        String firstItem = elements.get(0).getText();
        Assert.assertEquals(firstItem,"Test.allTheThings() T-Shirt (Red)","Sorting didn't work");
    }
    @Test
    public void checkIfResetWork(){
        loginPage.openSite("https://www.saucedemo.com/");
        loginPage.LogIn(NAME,PASSWORD);
        productsPage.addItemToCart("Sauce Labs Backpack");
        String qualityItems1 = productsPage.qualityItemOnCart();
        Assert.assertEquals(qualityItems1,"1","Quality Items Displayed incorrectly");
        productsPage.resetAppState();
        String qualityItems0 = productsPage.qualityItemOnCart();
        Assert.assertEquals(qualityItems0,"","Reset doesn't work");
    }
}
