package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {

    @Test
    public void fillInformationToOrder() {
        loginPage.openSite("https://www.saucedemo.com/");
        loginPage.LogIn(NAME, PASSWORD);
        productsPage.addItemToCart("Sauce Labs Bike Light");
        productsPage.openCartPage();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));
        cartPage.findAddedItem("Sauce Labs Bike Light");
        cartPage.clickContinueShoppingButton();
        checkoutPage.fillShippingInfo("Anton", "Sidorik", "24505392");
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-step-two.html"));
        boolean isNextPageOpened = driver.findElement(By.id("finish")).isDisplayed();
        Assert.assertTrue(isNextPageOpened, "Next page didn't open");
    }
}
