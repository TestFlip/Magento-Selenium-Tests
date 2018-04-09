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

public class AdminNoPasswordLogin extends TestBase {

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
    public void adminLoginNoPassword() throws Exception
    {
        adminPage.enterUsername("admin");

        adminPage.enterPassword("");

        adminPage.submitLogin();

        adminPage.assertNoPasswordError();
    }

    @AfterTest
    public void tearDown()
    {
        stopRecording();

        closerDriver();
    }
}
