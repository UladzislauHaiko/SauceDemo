package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTests extends BaseTest {
    @Test(groups = {"Smoke"})
    public void positiveLoginTest() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
    }

    @Test(groups = {"Regression"}, dataProvider = "negativeLoginTestData")
    public void negativeLoginTest(String email, String password, String expectedErrorMessage) {
        loginPage.login(email, password);
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
    }

    @DataProvider
    public Object[][] negativeLoginTestData() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "qwerty", "Epic sadface: Username and password do not match any user in this service"},
        };
    }
}
