package Pages.Products;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomanTopListingPage extends BasePage {
    String addToCartXPath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[4]/div/div[1]/form/button";

    String productDetailsXPath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/strong/a";

    String pinkColorXPath = "//*[@id=\"option-label-color-93-item-57\"]";

    String yellowColorXPath = "//*[@id=\"option-label-color-93-item-60\"]";

    String whiteColorXPath = "//*[@id=\"option-label-color-93-item-59\"]";

    String smallSizeXPath = "//*[@id=\"option-label-size-142-item-168\"]";

    public WomanTopListingPage(WebDriver driver)
    {
        super(driver);
    }

    public void AddBreathEasyToCart()
    {
        m_Driver.findElement(By.xpath(addToCartXPath)).click();
    }


    public void EnterBreathEasyProductDetails()
    {
        m_Driver.findElement(By.xpath(productDetailsXPath)).click();
    }

    public void SetBreathEasyPinkColour()
    {
        m_Driver.findElement(By.xpath(pinkColorXPath)).click();
    }

    public void SetBreathEasyYellowColour()
    {
        m_Driver.findElement(By.xpath(yellowColorXPath)).click();
    }

    public void SetBreathEasyWhiteColour()
    {
        m_Driver.findElement(By.xpath(whiteColorXPath)).click();
    }

    public void DefineBreathEasySmallSize()
    {
        m_Driver.findElement(By.xpath(smallSizeXPath)).click();
    }
}

