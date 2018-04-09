package Tests;

import RecorderController.RecorderController;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {
    /********** Replace with your own details ***********/
    private final String API_KEY = "T4_-ooXpbpmkUY1ykPBZeuS-w";
    private final Integer releaseID = 4;

    private String testName;

    protected ChromeDriver driver;

    protected RecorderController rc;

    public void initDriver()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        RecorderController.AttachExtension(options);

        driver = new ChromeDriver(options);

        rc = new RecorderController(driver, API_KEY);
    }

    public void startRecorder()
    {
        rc.StartRecorder();
    }

    @BeforeMethod
    public void handleTestMethodName(Method method)
    {
        testName = method.getName();
    }

    public void stopRecording()
    {
        rc.StopRecorder();
        rc.UploadSession(testName, releaseID);

        try {
            if (waitForAlert()) {
                driver.switchTo().alert().accept();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void closerDriver()
    {
        driver.close();
    }

    private Boolean waitForAlert() throws InterruptedException {
        int i=0;
        while(i++<10)
        {
            try
            {
                Alert alert = driver.switchTo().alert();
                return true;
            }
            catch(NoAlertPresentException e)
            {
                Thread.sleep(1000);
                continue;
            }
        }

        return false;
    }
}
