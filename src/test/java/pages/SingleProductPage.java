package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingleProductPage extends BasePage {
    private static final By BACK_BUTTON = By.id("back-to-products");
    private static final By ITEM_NAME = By.className("inventory_details_name");
    private static final By ITEM_DESCRIPTION = By.className("inventory_details_desc");
    private static final By ITEM_PRICE = By.className("inventory_details_price");
    private static final By ADD_TO_CART_BUTTON = By.id("add-to-cart");

    public SingleProductPage(WebDriver driver) {
        super(driver);
    }

    public void addItemToBasket() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }

    public String getItemName() {
        return driver.findElement(ITEM_NAME).getText();
    }

    public String getItemDescription() {
        return driver.findElement(ITEM_DESCRIPTION).getText();
    }

    public void returnToAllProductsPage() {
        driver.findElement(BACK_BUTTON).click();
    }
}
