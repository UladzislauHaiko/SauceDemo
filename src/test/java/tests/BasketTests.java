package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BasketTests extends BaseTest {
    @Test
    public void removeItemFromBasketTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        productsPage.clickAddToCartButton("Sauce Labs Fleece Jacket");
        productsPage.openBasket();
        int initialCount = basketPage.countNumberOfItemsInBasket();
        basketPage.removeItemByName("Sauce Labs Backpack");
        Assert.assertEquals(basketPage.countNumberOfItemsInBasket(), initialCount - 1);
    }

    @Test
    public void proceedToCheckoutPage() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        productsPage.openBasket();
        basketPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isFirstNameDisplayed());
    }
}
