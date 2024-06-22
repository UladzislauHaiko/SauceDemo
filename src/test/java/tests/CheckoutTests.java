package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {
    @Test(groups = {"Smoke"}, description = "Positive checkout test")
    @Description("Long test description with many words")
    @Issue("12345") //ссылка на баг в багтрекинг системе
    @TmsLink("85125") //ссылка на тесткейс
    @Severity(SeverityLevel.CRITICAL)
    @Link(url = "https://www.google.com/") //просто ссылка на какой-то нужный ресурс
    public void fullScenarioPositiveTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        productsPage.openBasket();
        basketPage.clickCheckoutButton();
        checkoutPage.setUser("Ulad", "Haiko", "220045");
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishButton();
        Assert.assertTrue(checkoutPage.isOrderConfirmationButtonIsDisplayed());
    }
}