package Pages.CustomerAuthentication;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerLoginPage extends BasePage {
    String customerLoginUrl = "http://local.magento/index.php/customer/account/login";

    String emailId = "email";

    String passwordId = "pass";

    String loginButtonId = "send2";

    String forgotPassButtonClass = "action remind";

    String emailErrorId = "email-error";

    String emptyEmailErrorId = "email-error";

    String passErrorId = "pass-error";

    String loginErrorXpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div";

    String loggedInWelcomeXpath = "/html/body/div[1]/header/div[1]/div/ul/li[1]/span";

    public CustomerLoginPage(WebDriver driver)
    {
        super(driver);
    }

    public void goToURL()
    {
        m_Driver.get(customerLoginUrl);
    }

    public void enterEmail(String email)
    {
        m_Driver.findElement(By.id(emailId)).sendKeys(email);
    }

    public void enterPassword(String password)
    {
        m_Driver.findElement(By.id(passwordId)).sendKeys(password);
    }

    public void submitLogin()
    {
        m_Driver.findElement(By.id(loginButtonId)).click();
    }

    public void ClickForgotPassword()
    {
        m_Driver.findElement(By.className(forgotPassButtonClass)).click();
    }

    public void assertInvalidEmail()
    {
        Assert.assertTrue(m_Driver.findElement(By.id(emailErrorId)).isDisplayed());
    }

    public void assertEmptyEmail()
    {
        Assert.assertTrue(m_Driver.findElement(By.id(emailErrorId)).isDisplayed());
    }

    public void assertEmptyPassword()
    {
        Assert.assertTrue(m_Driver.findElement(By.id(passErrorId)).isDisplayed());
    }

    public void assertInvalidLogin()
    {
        Assert.assertTrue(m_Driver.findElement(By.xpath(loginErrorXpath)).isDisplayed());
    }

    public void assertLoggedIn()
    {
        Assert.assertTrue(m_Driver.getCurrentUrl().equals("http://local.magento/index.php/customer/account/"));
    }
}
