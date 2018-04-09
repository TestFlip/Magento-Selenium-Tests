package Pages.ShoppingCart;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {
    String cartURL = "http://local.magento/index.php/checkout/cart/";

    String proceedCheckoutId = "checkout";

    public ShoppingCartPage(WebDriver driver)
    {
        super(driver);
    }

    public void GoToCart()
    {
        m_Driver.get(cartURL);
    }

    public void ClickProceedCheck()
    {
        m_Driver.findElement(By.className(proceedCheckoutId)).click();

    }
}
