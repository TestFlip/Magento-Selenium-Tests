package Tests.ShoppingCart;

import Pages.CustomerAuthentication.CustomerLoginPage;
import Pages.Products.ProductHeaderNavigationPage;
import Pages.Products.WomanTopListingPage;
import Pages.ShoppingCart.ShoppingCartPage;
import RecorderController.RecorderController;
import Tests.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.sql.Timestamp;

public class OrderBreatheEasyTankByListing extends TestBase {

    private CustomerLoginPage customerLoginPage;

    private WomanTopListingPage womanTopListingPage;

    private ProductHeaderNavigationPage headerNavigationPage;

    private ShoppingCartPage shoppingCartPage;

    @BeforeTest
    public void setUp()
    {
        initDriver();

        customerLoginPage = new CustomerLoginPage(driver);
        womanTopListingPage = new WomanTopListingPage(driver);
        headerNavigationPage = new ProductHeaderNavigationPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        customerLoginPage.goToURL();

        startRecorder();
    }

    @Test(groups = "ShoppingCart")
    public void orderBreathEasyTop() throws Exception
    {
        // Valid login
        customerLoginPage.enterEmail("roni_cost@example.com");
        customerLoginPage.enterPassword("roni_cost3@example.com");
        customerLoginPage.submitLogin();
        customerLoginPage.assertLoggedIn();

        // Go to products page
        headerNavigationPage.ClickWoman_Tops();

        // Define product
        womanTopListingPage.DefineBreathEasySmallSize();
        womanTopListingPage.SetBreathEasyWhiteColour();
        womanTopListingPage.AddBreathEasyToCart();

        // Go to checkout
        shoppingCartPage.GoToCart();
        shoppingCartPage.ClickProceedCheck();
    }

    @AfterTest
    public void tearDown()
    {
        stopRecording();

        closerDriver();
    }
}
