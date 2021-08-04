package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;
import pages.BasePage;
import pages.LoginPage;
import tests.Base.Retry;

public class LogIn extends BaseTest {

    @DataProvider(name = "Login Data")
    public Object[][] getData() {
        return new Object[][]{
            {"", PASSWORD, "Epic sadface: Username is required"},
            {NAME, "", "Epic sadface: Password is required"},
            {NAME, "flsjsk;d", "Epic sadface: Username and password do not match any user in this service"},
            {"locked_out_user", PASSWORD, "Epic sadface: Sorry, this user has been locked out."},
        };
    }

    @Test(dataProvider = "Login Data")
    public void loginDataShouldBeRequired(String name, String password, String errorMessage){
        loginPage.openSite("https://www.saucedemo.com/");
        loginPage.LogIn(name,password);
        String error = loginPage.getErrorMassage();
        Assert.assertEquals(error,errorMessage,"Error message isn't correct");
    }

    @Test(retryAnalyzer = Retry.class, description = "Successful log in")
    public void enterValidValue(){
        loginPage.openSite("https://www.saucedemo.com/");
        loginPage.LogIn(NAME,PASSWORD);
        WebElement isLogged = driver.findElement(By.id("shopping_cart_container"));
        Assert.assertTrue(isLogged.isDisplayed(),"You didn't log in");
    }
    @Test
    public void logout(){
        loginPage.openSite("https://www.saucedemo.com")
                .LogIn(NAME,PASSWORD)
                .logout();
        boolean isLoginButtonIsDisplayed = driver.findElement(By.xpath("//input[@name='login-button']")).isDisplayed();
        Assert.assertTrue(isLoginButtonIsDisplayed,"You didn't Logout");
    }
}
