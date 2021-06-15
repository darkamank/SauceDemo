import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
WebDriver driver;

@BeforeTest
public void setUP (){
    System.setProperty("webdriver.chrome.driver","D:\\testing\\SauceDemo\\src\\test\\resources\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
@AfterTest
    public void exit(){
    driver.close();
}
}
