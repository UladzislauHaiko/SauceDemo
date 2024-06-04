package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.DriverFactory;
import utils.InvokedListener;
import utils.TestListener;

@Listeners({TestListener.class, InvokedListener.class})
public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected SingleProductPage singleProductPage;
    protected BasketPage basketPage;
    protected CheckoutPage checkoutPage;

    @BeforeClass(alwaysRun = true)
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browserName, ITestContext testContext) throws Exception {
        driver = DriverFactory.getDriver(browserName);
        testContext.setAttribute("driver", driver);
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.singleProductPage = new SingleProductPage(driver);
        this.basketPage = new BasketPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }

    @BeforeMethod(alwaysRun = true)
    public void openMainURL() {
        driver.get("https://www.saucedemo.com/");
    }
}