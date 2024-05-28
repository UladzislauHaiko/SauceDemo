package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SingleProductPage;

public class SingleProductTests extends BaseTest {

    @BeforeMethod
    public void login() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(enabled = false, description = "Проверить, что открылся именно тот товар, на который нажали")
    public void correctItemIsDisplayedTest() {
        String itemName = productsPage.getProductName("Sauce Labs Backpack");
        String itemPrice = productsPage.getProductPrice("Sauce Labs Backpack");
        String itemDescription = productsPage.getProductDescription("Sauce Labs Backpack");
        productsPage.openSingleProductPage("Sauce Labs Backpack");
        Assert.assertEquals(singleProductPage.getItemName(), itemName);
        Assert.assertEquals(singleProductPage.getItemPrice(), itemPrice);
        Assert.assertEquals(singleProductPage.getItemDescription(), itemDescription);
    }

    @Test(dataProvider = "productsTestData")
    public void correctItemIsDisplayedDataProviderTest(String itemName, String price, String description) {
        productsPage.openSingleProductPage(itemName);
        Assert.assertEquals(singleProductPage.getItemName(), itemName);
        Assert.assertEquals(singleProductPage.getItemPrice(), price);
        Assert.assertEquals(singleProductPage.getItemDescription(), description);
    }

    @Test()
    public void clickBackButtonTest() {
        productsPage.openSingleProductPage("Sauce Labs Backpack");
        singleProductPage.returnToAllProductsPage();
        Assert.assertTrue(productsPage.isFilterOptionsDisplayed());
    }

    @DataProvider
    public Object[][] productsTestData() {
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."},
                {"Sauce Labs Bike Light", "$9.99", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."},
                {"Sauce Labs Bolt T-Shirt", "$15.99", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."},
        };
    }
}
