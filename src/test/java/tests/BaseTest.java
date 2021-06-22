package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public static final String NAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected LogIn login;
    protected ProductsPage productsPage;
    protected CartPage cartPage;

@BeforeTest
public void setUP (){
    System.setProperty("webdriver.chrome.driver","D:\\testing\\SauceDemo\\src\\test\\resources\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().deleteAllCookies();
    loginPage = new LoginPage(driver);
    productsPage = new ProductsPage(driver);
    cartPage = new CartPage(driver);
}
@AfterTest
    public void exit(){
    driver.close();
}
}
