package RecorderController;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.JavascriptExecutor;
import java.io.File;

public class RecorderController {
    private String m_APIKey;

    public RecorderController(WebDriver driver, String APIKey) {
        m_Driver = driver;

        m_APIKey = APIKey;
    }

    public static void AttachExtension(ChromeOptions opt) {
        opt.addExtensions(new File("C:/Dev/testflip_insights_extension/TestInsightChromeExtension/src.crx"));
    }

    public static void AttachExtension(FirefoxProfile opt) {
        opt.addExtension(new File("C:/Dev/TestFlipRecorderJavaInterface/artifacts/TestFlip_Recorder/TestFlip_Recorder.zip"));
    }

    public void StartRecorder() {
        JavascriptExecutor js = (JavascriptExecutor) m_Driver;
        js.executeScript("var event = new CustomEvent('Event');" +
                "        event.initEvent('start_record');" +
                "        document.dispatchEvent(event);");
    }

    public void StopRecorder() {
        JavascriptExecutor js = (JavascriptExecutor) m_Driver;
        js.executeScript("var event = new CustomEvent('Event');" +
                "        event.initEvent('stop_record');" +
                "        document.dispatchEvent(event);");
    }

    public void NewRecordingSession() {
        JavascriptExecutor js = (JavascriptExecutor) m_Driver;

        js.executeScript("var event = new CustomEvent('Event');" +
                "        event.initEvent('new_session');" +
                "        document.dispatchEvent(event);");
    }

    public void UploadSession(String name, Integer releaseID) {
        JavascriptExecutor js = (JavascriptExecutor) m_Driver;
        js.executeScript("var event = new CustomEvent('Event', {detail: {name: '"+ name + "', apiKey: '" + m_APIKey + "', source:'" + name + "', sourceLocation:'" + "Automation" + "', releaseID: " + releaseID + "}});" +
                "        event.initEvent('upload_session');" +
                "        document.dispatchEvent(event);");
    }

    private WebDriver m_Driver;
}
