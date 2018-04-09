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

public class CustomerRegistrationNewUser extends TestBase {

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

        customerRegistrationPage.enterEmail("testemail" + timestamp.getTime() + "@google.com");
        customerRegistrationPage.enterFirstName("james");
        customerRegistrationPage.enterLastName("walker");
        customerRegistrationPage.enterPassword("testPassword01!");
        customerRegistrationPage.enterConfirmPassword("testPassword01!");

        customerRegistrationPage.submitCreateAccount();
    }

    @AfterTest
    public void tearDown()
    {
        stopRecording();

        closerDriver();
    }

}
