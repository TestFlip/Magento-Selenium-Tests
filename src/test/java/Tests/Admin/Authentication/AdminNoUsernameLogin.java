package Tests.Admin.Authentication;

import Pages.Admin.AdminPage;
import RecorderController.RecorderController;
import Tests.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AdminNoUsernameLogin  extends TestBase {

    private AdminPage adminPage;

    @BeforeTest
    public void setUp()
    {
        initDriver();

        adminPage = new AdminPage(driver);
        adminPage.goToURL();

        startRecorder();
    }

    @Test(groups = "admin")
    public void loginNoUsername() throws Exception
    {
        adminPage.enterUsername("");

        adminPage.enterPassword("nopassword");

        adminPage.submitLogin();

        adminPage.assertNoUsernameError();
    }


    @AfterTest
    public void tearDown()
    {
        stopRecording();

        closerDriver();
    }
}
