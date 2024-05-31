package tests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BasketTests extends BaseTest {
    @Test(retryAnalyzer = Retry.class)
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
        productsPage.clickAddToCartButton("Sauce Labs Onesie");
        productsPage.openBasket();
        basketPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isFirstNameDisplayed());
    }
}
