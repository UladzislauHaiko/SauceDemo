import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckItem extends BaseTest {
    @Test
    public void checkItemInBasket() {
        driver.navigate().to("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.cssSelector(".header_container"));
        String shirtText = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getText();
        String shirtPrice = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']/following::div[@class='inventory_item_price']")).getText();
        driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.cssSelector("[class='shopping_cart_link']")).click();
        WebElement shirtInBasket = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        WebElement priceInBasket = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
        Assert.assertEquals(shirtText, shirtInBasket.getText());
        Assert.assertEquals(shirtPrice, priceInBasket.getText());
    }
}