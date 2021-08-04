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
        loginPage.openSite("https://www.saucedemo.com/");
        loginPage.LogIn(NAME,PASSWORD);
        WebElement isLogged = driver.findElement(By.id("shopping_cart_container"));
        Assert.assertTrue(isLogged.isDisplayed(),"You didn't log in");
    }

    @Test
    public void userNameShouldBeRequired(){
        loginPage.openSite("https://www.saucedemo.com/");
        loginPage.LogIn("","secret_sauce");
        String error = loginPage.getErrorMassage();
        String errorMessage = loginPage.getErrorMessageIfNameIsEmpty();
        Assert.assertEquals(error,errorMessage,"Error message isn't correct");
    }
    @Test
    public void passwordShouldBeRequired(){
        loginPage.openSite("https://www.saucedemo.com/");
        loginPage.LogIn("standard_user","");
        String error = loginPage.getErrorMassage();
        String errorMessage = loginPage.getErrorMessageIfPasswordIsEmpty();
        Assert.assertEquals(error,errorMessage,"Error message isn't correct");
    }
    @Test
    public void logout(){
        loginPage.openSite("https://www.saucedemo.com");
        loginPage.LogIn(NAME,PASSWORD);
        loginPage.logout();
        boolean isLoginButtonIsDisplayed = driver.findElement(By.xpath("//input[@name='login-button']")).isDisplayed();
        Assert.assertTrue(isLoginButtonIsDisplayed,"You didn't Logout");
    }
}
