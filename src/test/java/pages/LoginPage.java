package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public static final By USERNAME_FIELD = By.xpath("//input[@id='user-name']");
    public static final By PASSWORD_FIELD = By.xpath("//input[@name='password']");
    public static final By LOGIN_BUTTON = By.xpath("//input[@name='login-button']");
    public static final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");


public LoginPage(WebDriver driver){
    super(driver);
}

public void openSite(){
    driver.get("https://www.saucedemo.com/");
}
public void LogIn(String userName, String password){
    driver.findElement(USERNAME_FIELD).sendKeys(userName);
    driver.findElement(PASSWORD_FIELD).sendKeys(password);
    driver.findElement(LOGIN_BUTTON).click();
}

public String getErrorMassage(){
    return driver.findElement(ERROR_MESSAGE).getText();
}
}
