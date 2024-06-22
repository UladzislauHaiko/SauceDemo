package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = "h3[data-test=error]")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    @Step
    public void setEmailValue(String email) {
        emailInput.sendKeys(email);
    }

    @Step
    public void setPasswordValue(String password) {
        passwordInput.sendKeys(password);
    }

    @Step
    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String email, String password) {
        setEmailValue(email);
        setPasswordValue(password);
        clickLoginButton();
    }
}
