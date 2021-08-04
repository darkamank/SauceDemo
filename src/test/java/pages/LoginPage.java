package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public static final By USERNAME_FIELD = By.xpath("//input[@id='user-name']");
    public static final By PASSWORD_FIELD = By.xpath("//input[@name='password']");
    public static final By LOGIN_BUTTON = By.xpath("//input[@name='login-button']");
    public static final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");
    public static final By BURGER_MENU = By.xpath("//button[@id='react-burger-menu-btn']");
    public static final By LOGOUT = By.xpath("//a[contains(text(),'Logout')]");



public LoginPage(WebDriver driver){
    super(driver);
}

    public void openSite(String url){
        driver.get(url);
}
    public void LogIn(String userName, String password){
        driver.findElement(USERNAME_FIELD).sendKeys(userName);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
}

    public String getErrorMassage(){
        return driver.findElement(ERROR_MESSAGE).getText();
}
    public String getErrorMessageIfNameIsEmpty(){
        driver.findElement(USERNAME_FIELD).sendKeys("");
        driver.findElement(PASSWORD_FIELD).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
        return driver.findElement(ERROR_MESSAGE).getText();
}
    public String getErrorMessageIfPasswordIsEmpty(){
        driver.findElement(USERNAME_FIELD).sendKeys("standard_user");
        driver.findElement(PASSWORD_FIELD).sendKeys("");
        driver.findElement(LOGIN_BUTTON).click();
        return driver.findElement(ERROR_MESSAGE).getText();
    }
    public void logout(){
    driver.findElement(BURGER_MENU).click();
    driver.findElement(LOGOUT).click();
    }


}
