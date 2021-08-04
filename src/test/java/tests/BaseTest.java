package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public static final String NAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected LogIn login;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected WebDriverWait wait;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverviewPage checkoutOverviewPage;

@BeforeTest
public void setUP (){
    System.setProperty("webdriver.chrome.driver","D:\\testing\\SauceDemo\\src\\test\\resources\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().deleteAllCookies();
    wait = new WebDriverWait(driver,5);
    loginPage = new LoginPage(driver);
    productsPage = new ProductsPage(driver);
    cartPage = new CartPage(driver);
    checkoutPage = new CheckoutPage(driver);
    checkoutOverviewPage =new CheckoutOverviewPage(driver);
}
@AfterTest
    public void exit(){
    driver.close();
}
}
