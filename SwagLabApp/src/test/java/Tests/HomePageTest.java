package Tests;

import Pages.HomePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends BaseTest {

    @Test
    public void testGetAllTitlesAndSelectOnesie() {
     
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page did not load.");

        List<WebElement> titles = homePage.getProductTitles();
        System.out.println("Products visible on screen:");
        for (WebElement title : titles) {
            System.out.println(" - " + title.getText());
        }

        homePage.scrollToProductAndSelect("Sauce Labs Onesie");

        String productTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Sauce Labs Onesie\"]")).getText();
        Assert.assertEquals(productTitle, "Sauce Labs Onesie", "Wrong product opened after scroll.");
    }
}
