package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTests extends BaseTest {
    @Test
    public void positiveLoginTest() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
    }
}
