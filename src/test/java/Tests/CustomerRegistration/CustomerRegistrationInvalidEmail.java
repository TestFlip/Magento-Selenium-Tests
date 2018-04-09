package Tests.CustomerRegistration;

import Pages.CustomerAuthentication.CustomerRegistrationPage;
import RecorderController.RecorderController;
import Tests.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CustomerRegistrationInvalidEmail extends TestBase {

    private CustomerRegistrationPage customerRegistrationPage;

    @BeforeTest
    public void setUp()
    {
        initDriver();

        customerRegistrationPage = new CustomerRegistrationPage(driver);
        customerRegistrationPage.goToURL();

        startRecorder();
    }

    @Test(groups = "CustomerRegistration")
    public void customerRegistrationInvalidEmail() throws Exception
    {
        customerRegistrationPage.enterEmail("asdasd");

        customerRegistrationPage.submitCreateAccount();

        customerRegistrationPage.assertEmailError();
    }

    @AfterTest
    public void tearDown()
    {
        stopRecording();

        closerDriver();
    }

}
