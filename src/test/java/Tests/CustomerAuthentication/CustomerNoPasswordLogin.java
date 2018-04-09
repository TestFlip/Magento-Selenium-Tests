package Tests.CustomerAuthentication;

import Pages.CustomerAuthentication.CustomerLoginPage;
import RecorderController.RecorderController;
import Tests.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CustomerNoPasswordLogin extends TestBase {

    private CustomerLoginPage customerLoginPage;

    @BeforeTest
    public void setUp()
    {
        initDriver();

        customerLoginPage = new CustomerLoginPage(driver);
        customerLoginPage.goToURL();

        startRecorder();
    }

    @Test(groups = "CustomerAuthentication")
    public void customerNoPasswordLogin() throws Exception
    {
        customerLoginPage.enterEmail("wronguser@user.com");

        customerLoginPage.enterPassword("");

        customerLoginPage.submitLogin();

        customerLoginPage.assertEmptyPassword();
    }

    @AfterTest
    public void tearDown()
    {
        stopRecording();

        closerDriver();
    }
}
