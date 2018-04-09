package Pages.Products;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ProductHeaderNavigationPage extends BasePage {
    String homeUrl = "http://local.magento/index.php/";

    String whatsNewLinkId = "ui-id-3";

    String womanLinkId = "ui-id-4";

    String womanTopsLinkId = "ui-id-9";

    String womanBottomsLinkId = "ui-id-10";

    String menLinkId = "ui-id-5";

    String gearLinkId = "ui-id-6";

    public ProductHeaderNavigationPage(WebDriver driver)
    {
        super(driver);
    }

    public void goToURL()
    {
        m_Driver.get(homeUrl);
    }

    public void ClickWhatsNew()
    {
        m_Driver.findElement(By.id(whatsNewLinkId)).click();
    }

    public void ClickWoman()
    {
        m_Driver.findElement(By.id(womanLinkId)).click();
    }

    public void ClickWoman_Tops()
    {
        Actions action = new Actions(m_Driver);
        action.moveToElement(m_Driver.findElement(By.id(womanLinkId))).perform();

        By topLocator = By.id(womanTopsLinkId);
        while (!m_Driver.findElement(topLocator).isDisplayed())
            continue;

        m_Driver.findElement(topLocator).click();
    }

    public void ClickWoman_Bottoms()
    {
        m_Driver.findElement(By.id(womanBottomsLinkId)).click();
    }

    public void ClickMen()
    {
        m_Driver.findElement(By.id(menLinkId)).click();
    }

    public void ClickGear()
    {
        m_Driver.findElement(By.id(gearLinkId)).click();
    }
}
