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
import java.sql.Timestamp;

public class CustomerRegistrationNoFields extends TestBase {

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
    public void customerRegistrationNewUser() throws Exception
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        customerRegistrationPage.submitCreateAccount();

        customerRegistrationPage.assertEmailError();
        customerRegistrationPage.assertFirstNameError();
        customerRegistrationPage.assertLastNameError();
        customerRegistrationPage.assertPasswordConfirmationError();
        customerRegistrationPage.assertPasswordError();
    }

    @AfterTest
    public void tearDown()
    {
        stopRecording();

        closerDriver();
    }

}
