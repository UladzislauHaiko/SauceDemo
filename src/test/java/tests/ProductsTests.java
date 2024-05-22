package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTest {
    @Test
    public void addProductToCartTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        productsPage.openBasket();
        Assert.assertTrue(basketPage.isAddedToBasket("Sauce Labs Backpack"));
    }
}
