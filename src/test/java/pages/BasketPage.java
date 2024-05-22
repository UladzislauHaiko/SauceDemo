package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {
    private static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    private static final String REMOVE_BUTTON = "//div[text()='%s']/../following-sibling::div/button";
    private static final By CHECKOUT_BUTTON = By.id("checkout");
    private static final String ITEM_NAME = "//div[text()='%s']";
    private static final By ITEM_DESCRIPTION = By.id("checkout");
    private static final By ITEM_PRICE = By.id("checkout");


    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAddedToBasket(String productName) {
        return driver.findElement(By.xpath(String.format(ITEM_NAME, productName))).isDisplayed();
    }

    public String getItemDescription() {
        return driver.findElement(ITEM_DESCRIPTION).getText();
    }

    public String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }

    public void removeItemByName(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
    }
    public void clickCheckoutButton(){
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
