import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.BaseTest;

public class Locators extends BaseTest {
    @Test
    public void findFirstLocators(){
        driver.get("https://www.saucedemo.com/");
    driver.findElement(By.id("user-name"));
    driver.findElement(By.name("user-name"));
    driver.findElement(By.className("submit-button btn_action"));
    driver.findElement(By.tagName("Form"));
    driver.findElement(By.linkText("About"));
    driver.findElement(By.partialLinkText("App State"));
    }

    @Test
    public void findXpathLocators(){
        driver.findElement(By.xpath("//div[@class = 'inventory_list']/div[1]//button")); // find "Add to cart" button for the first item
        driver.findElement(By.xpath("//div[@class='inventory_item_name'][text()='Sauce Labs Backpack']")); // find item's name
        driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));
        driver.findElement(By.xpath("//div[contains(text(),'carry')]"));
        driver.findElement(By.xpath("//div[contains(@class,'inventory')]"));
        driver.findElement(By.xpath("//div[contains(@class,'name')]//ancestor::div"));
        driver.findElement(By.xpath("//div[@class='pricebar']//descendant::button"));
        driver.findElement(By.xpath("//footer//following-sibling::div"));
        driver.findElement(By.xpath("//footer//parent::a"));
        driver.findElement(By.xpath("//footer//preceding::div"));
        driver.findElement(By.xpath("//div[@class='inventory_item_desc' and contains(text(), 'Rib snap')]"));
    }
    @Test
    public void findCssLocators (){
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.name("user-name")).clear();
        driver.findElement(By.name("user-name")).sendKeys("performance_glitch_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[type=submit]")).click(); // [attribute=value]
        driver.findElement(By.cssSelector("div.inventory_item_desc")); // element.class
        driver.findElement(By.cssSelector(".pricebar .inventory_item_price"));
        driver.findElement(By.cssSelector("#remove-sauce-labs-bike-light"));

    }
}
