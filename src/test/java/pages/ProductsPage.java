package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage{

    @FindBy(id = "shopping_cart_container")
    private WebElement cart;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement select;

    @FindBy(xpath = "//a[@id='reset_sidebar_link']")
    private WebElement reset;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement menu;

    String addToCartButton = "//*[contains(text(), '%s')]//ancestor::*[@class='inventory_item']//child::button";
    String deleteFromCartButton = "//*[contains(text(), '%s')]//ancestor::*[@class='inventory_item']//child::button";


    public ProductsPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void addItemToCart (String itemName){
        driver.findElement(By.xpath(String.format(addToCartButton,itemName))).click();
    }
    public void deleteItemFromCart(String itemName){
        driver.findElement(By.xpath(String.format(deleteFromCartButton,itemName))).click();
    }
    public String getTextRemoveOrAddItemToCart(String itemName){
        return driver.findElement(By.xpath(String.format(deleteFromCartButton,itemName))).getText();
    }
    public String qualityItemOnCart(){
       return cart.getText();
    }
    public CartPage openCartPage(){
        cart.click();
    return new CartPage(driver);
    }
    public void setSelect (String value){
        WebElement selectElem = select;
        Select select = new Select(selectElem);
        select.selectByValue(value);
    }
    public void resetAppState(){
        menu.click();
        reset.click();
    }
}
