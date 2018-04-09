package Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver m_Driver;

    public BasePage(WebDriver driver)
    {
        m_Driver = driver;
    }
}
