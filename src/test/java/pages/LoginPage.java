package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement userNameField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@name='login-button']")
    private WebElement loginButton;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement burgerMenu;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logOut;

//    public static final By USERNAME_FIELD = By.xpath("//input[@id='user-name']");
//    public static final By PASSWORD_FIELD = By.xpath("//input[@name='password']");
//    public static final By LOGIN_BUTTON = By.xpath("//input[@name='login-button']");
//    public static final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");
//    public static final By BURGER_MENU = By.xpath("//button[@id='react-burger-menu-btn']");
//    public static final By LOGOUT = By.xpath("//a[contains(text(),'Logout')]");



public LoginPage(WebDriver driver){
    super(driver);
    PageFactory.initElements(driver,this);
}

    public void openSite(String url){
        driver.get(url);
}
    public void LogIn(String userName, String password){
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
}

    public String getErrorMassage(){
        return errorMessage.getText();
}
    public String getErrorMessageIfNameIsEmpty(){
        userNameField.sendKeys("");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();
        return errorMessage.getText();
}
    public String getErrorMessageIfPasswordIsEmpty(){
        userNameField.sendKeys("standard_user");
        passwordField.sendKeys("");
        loginButton.click();
        return errorMessage.getText();
    }
    public void logout(){
    burgerMenu.click();
    logOut.click();
    }


}
