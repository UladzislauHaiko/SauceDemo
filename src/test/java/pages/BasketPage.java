package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasketPage extends BasePage {
    private static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    private static final String REMOVE_BUTTON = "//div[text()='%s']/../following-sibling::div/button";
    private static final By CHECKOUT_BUTTON = By.id("checkout");
    private static final String ITEM_NAME = "//div[text()='%s']";
    private static final String ITEM_DESCRIPTION = "//div[text()='%s']/../following-sibling::div[@class='inventory_item_desc']";
    private static final String ITEM_PRICE = "//div[text()='%s']/../following-sibling::div/div[@class='inventory_item_price']";
    private static final By NUMBER_OF_ITEMS_IN_BASKET = By.className("cart_item");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAddedToBasket(String productName) {
        return driver.findElement(By.xpath(String.format(ITEM_NAME, productName))).isDisplayed();
    }
    public int countNumberOfItemsInBasket(){
        return this.driver.findElements(NUMBER_OF_ITEMS_IN_BASKET).size();
    }

    public String getItemDescription(String productName) {
        return driver.findElement(By.xpath(String.format(ITEM_DESCRIPTION, productName))).getText();
    }

    public String getItemPrice(String productName) {
        return driver.findElement(By.xpath(String.format(ITEM_PRICE, productName))).getText();
    }

    public void removeItemByName(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
