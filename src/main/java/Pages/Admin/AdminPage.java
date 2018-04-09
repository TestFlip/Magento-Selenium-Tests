package Pages.Admin;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AdminPage extends BasePage{
    String adminUrl = "http://local.magento/admin";

    String usernameId = "username";

    String passwordId = "login";

    String loginButtonClass = "action-login";

    String forgotPasswordClass = "action-forgotpassword";

    String badUsernamePassword_Xpath = "//*[@id=\"html-body\"]/section/div/div/div";

    String noUsernameErrorId = "username-error";

    String noPasswordErrorId = "login-error";


    public AdminPage(WebDriver driver)
    {
        super(driver);

    }

    public void goToURL()
    {
        m_Driver.get(adminUrl);
    }

    public void enterUsername(String username)
    {
        m_Driver.findElement(By.id(usernameId)).sendKeys(username);
    }

    public void enterPassword(String password)
    {
        m_Driver.findElement(By.id(passwordId)).sendKeys(password);
    }

    public void assertNoUsernameError()
    {
        Assert.assertTrue(m_Driver.findElement(By.id(noUsernameErrorId)).isDisplayed());
    }

    public void assertNoPasswordError()
    {
        Assert.assertTrue(m_Driver.findElement(By.id(noPasswordErrorId)).isDisplayed());
    }

    public void assertNotLoggedIn()
    {
        Assert.assertTrue(m_Driver.findElement(By.xpath(badUsernamePassword_Xpath)).isDisplayed());
    }

    public void assertLoggedIn()
    {

    }

    public void submitLogin()
    {
        m_Driver.findElement(By.className(loginButtonClass)).click();
    }

    public void forgotPassword()
    {
        m_Driver.findElement(By.className(forgotPasswordClass)).click();
    }
}
