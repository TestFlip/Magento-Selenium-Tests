package Pages.CustomerAuthentication;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerRegistrationPage extends BasePage {
    String customerRegistrationUrl = "http://local.magento/index.php/customer/account/create/";

    String firstNameFieldId = "firstname";

    String firstNameErrorLabelId = "firstname-error";

    String lastNameFieldId = "lastname";

    String lastNameErrorLabelId = "lastname-error";

    String subscribeId = "is_subscribed";

    String emailId = "email_address";

    String emailErrorId = "email_address-error";

    String passwordId = "password";

    String passwordErrorId = "password-error";

    String passwordConfirmationId = "password-confirmation";

    String passwordConfirmationErrorId = "password-confirmation-error";

    String createAccountClassName = "submit";

    public CustomerRegistrationPage(WebDriver driver)
    {
        super(driver);
    }

    public void goToURL()
    {
        m_Driver.get(customerRegistrationUrl);
    }

    public void enterFirstName(String firstname)
    {
        m_Driver.findElement(By.id(firstNameFieldId)).sendKeys(firstname);
    }

    public void assertFirstNameError()
    {
        Assert.assertTrue(m_Driver.findElement(By.id(firstNameErrorLabelId)).isDisplayed());
    }

    public void enterLastName(String lastname)
    {
        m_Driver.findElement(By.id(lastNameFieldId)).sendKeys(lastname);
    }

    public void assertLastNameError()
    {
        Assert.assertTrue(m_Driver.findElement(By.id(lastNameErrorLabelId)).isDisplayed());
    }

    public void signUpNewsLetter(Boolean signup)
    {
        m_Driver.findElement(By.id(subscribeId)).click();
    }

    public void enterEmail(String email)
    {
        m_Driver.findElement(By.id(emailId)).sendKeys(email);
    }

    public void assertEmailError()
    {
        Assert.assertTrue(m_Driver.findElement(By.id(emailErrorId)).isDisplayed());
    }

    public void enterPassword(String password)
    {
        m_Driver.findElement(By.id(passwordId)).sendKeys(password);
    }

    public void assertPasswordError()
    {
        Assert.assertTrue(m_Driver.findElement(By.id(emailErrorId)).isDisplayed());
    }

    public void enterConfirmPassword(String password)
    {
        m_Driver.findElement(By.id(passwordConfirmationId)).sendKeys(password);
    }

    public void assertPasswordConfirmationError()
    {
        Assert.assertTrue(m_Driver.findElement(By.id(passwordConfirmationErrorId)).isDisplayed());
    }

    public void submitCreateAccount()
    {
        m_Driver.findElement(By.className(createAccountClassName)).click();
    }
}
