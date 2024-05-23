package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SingleProductPage;

public class SingleProductTests extends BaseTest {
    @Test
    public void correctItemIsDisplayedTest() {
        loginPage.login("standard_user", "secret_sauce");
        String itemName = productsPage.getProductName("Sauce Labs Backpack");
        String itemPrice = productsPage.getProductPrice("Sauce Labs Backpack");
        String itemDescription = productsPage.getProductDescription("Sauce Labs Backpack");
        productsPage.openSingleProductPage("Sauce Labs Backpack");
        Assert.assertEquals(singleProductPage.getItemName(), itemName);
        Assert.assertEquals(singleProductPage.getItemPrice(), itemPrice);
        Assert.assertEquals(singleProductPage.getItemDescription(), itemDescription);
    }
    @Test
    public void clickBackButtonTest(){
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openSingleProductPage("Sauce Labs Backpack");
        singleProductPage.returnToAllProductsPage();
        Assert.assertTrue(productsPage.isFilterOptionsDisplayed());
    }
}
