package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement itemNameField;
    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private WebElement itemPriceField;
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutField;
    @FindBy(xpath = "//span[@class='title']")
    private WebElement title;
    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;


    String itemName = "//*[contains(text(),'%s')]";
    String removeItemFromCart = "//*[contains(text(),'%s')]//ancestor::*[@class='cart_item']//child::button";
    public static final String REMOVE_BUTTON = "//*[contains(text(),'%s')]//ancestor::*[@class='cart_item']//child::button";


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void openCart() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public void findAddedItem(String name) {
        boolean isItemAddedToCart = driver.findElement(By.xpath(String.format(itemName, name))).isDisplayed();
        Assert.assertTrue(isItemAddedToCart, "Item didn't display in cart");
    }

    public void removeItemFromCart(String itemName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, itemName))).click();
    }

    public CheckoutPage clickContinueShoppingButton() {
        continueShoppingButton.click();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        String nameTitle = title.getText();
        Assert.assertEquals(nameTitle, "PRODUCTS", "Product page didn't open");
        return new CheckoutPage(driver);
    }


}
