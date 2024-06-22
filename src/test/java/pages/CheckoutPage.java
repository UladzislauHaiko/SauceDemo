package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(id = "postal-code")
    private WebElement zipCode;
    @FindBy(id = "continue-shopping")
    private WebElement cancelButton;
    @FindBy(id = "continue")
    private WebElement continueButton;
    @FindBy(id = "finish")
    private WebElement finishButton;
    @FindBy(id = "complete-header")
    private WebElement orderConfirmationButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isFirstNameDisplayed() {
        return firstName.isDisplayed();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public boolean isOrderConfirmationButtonIsDisplayed() {
        return orderConfirmationButton.isDisplayed();
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setZipCode(String zipCode) {
        this.zipCode.sendKeys(zipCode);
    }

    @Step("Fill user info: {firstName}, {lastName}, {zipCode}")
    public void setUser(String firstName, String lastName, String zipCode) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.zipCode.sendKeys(zipCode);
    }
}