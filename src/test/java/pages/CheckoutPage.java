package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage{

    @FindBy(id = "first-name")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement zipCodeField;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;


    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public CheckoutOverviewPage fillShippingInfo(String firstName, String lastName, String zipCode){
       firstNameField.sendKeys(firstName);
       lastNameField.sendKeys(lastName);
       zipCodeField.sendKeys(zipCode);
       continueButton.click();
    return new CheckoutOverviewPage(driver);
    }
}
