package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {
    @Test
    public void fullScenarioPositiveTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        productsPage.openBasket();
        basketPage.clickCheckoutButton();
        checkoutPage.setUser("Ulad", "Haiko", "220045");
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishButton();
        Assert.assertEquals(driver.findElement(By.className("complete-header")).getText(),"Thank you for your order!");
    }
}
