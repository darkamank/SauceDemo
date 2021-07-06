package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test
    public void removeItemFromCart(){
        loginPage.openSite("https://www.saucedemo.com/");
        loginPage.LogIn(NAME,PASSWORD);
        productsPage.addItemToCart("Sauce Labs Bike Light");
        productsPage.openCartPage();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));
        cartPage.findAddedItem("Sauce Labs Bike Light");
        cartPage.removeItemFromCart("Sauce Labs Bike Light");
    }
    @Test
    public void clickContinueShopping(){
        loginPage.openSite("https://www.saucedemo.com/");
        loginPage.LogIn(NAME,PASSWORD);
        productsPage.addItemToCart("Sauce Labs Bike Light");
        productsPage.openCartPage();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));
        cartPage.clickContinueShoppingButton();
    }
}
