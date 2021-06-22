package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

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
}
