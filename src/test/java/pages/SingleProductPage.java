package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingleProductPage extends BasePage {
    @FindBy(id = "back-to-products")
    private WebElement backButton;
    @FindBy(className = "inventory_details_name")
    private WebElement itemName;
    @FindBy(className = "inventory_details_desc")
    private WebElement itemDescription;
    @FindBy(className = "inventory_details_price")
    private WebElement itemPrice;
    @FindBy(id = "add-to-cart")
    private WebElement addToCartButton;

    public SingleProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addItemToBasket() {
        addToCartButton.click();
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemDescription() {
        return itemDescription.getText();
    }

    public void returnToAllProductsPage() {
        backButton.click();
    }
}
