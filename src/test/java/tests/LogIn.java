package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;
import pages.BasePage;
import pages.LoginPage;

public class LogIn extends BaseTest {
    @Test
    public void enterValidValue(){
        loginPage.openSite();
        loginPage.LogIn(NAME,PASSWORD);
        WebElement isLogged = driver.findElement(By.id("shopping_cart_container"));
        Assert.assertTrue(isLogged.isDisplayed(),"You didn't log in");
    }
}
