package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected SingleProductPage singleProductPage;
    protected BasketPage basketPage;
    protected CheckoutPage checkoutPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.singleProductPage = new SingleProductPage(driver);
        this.basketPage = new BasketPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}