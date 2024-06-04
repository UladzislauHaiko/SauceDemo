package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private static final By FIRST_NAME = By.id("first-name");
    private static final By LAST_NAME = By.id("last-name");
    private static final By ZIP_CODE = By.id("postal-code");
    private static final By CANCEL_BUTTON = By.id("continue-shopping");
    private static final By CONTINUE_BUTTON = By.id("continue");
    private static final By FINISH_BUTTON = By.id("finish");
    private static final By ORDER_CONFIRMATION_BUTTON = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFirstNameDisplayed() {
        return this.driver.findElement(FIRST_NAME).isDisplayed();
    }

    public void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public boolean isOrderConfirmationButtonIsDisplayed() {
        return this.driver.findElement(ORDER_CONFIRMATION_BUTTON).isDisplayed();
    }

    public void setFirstName(String firstName) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(LAST_NAME).sendKeys(lastName);
    }

    public void setZipCode(String zipCode) {
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
    }

    @Step("Fill user info: {firstName}, {lastName}, {zipCode}")
    public void setUser(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
    }
}
