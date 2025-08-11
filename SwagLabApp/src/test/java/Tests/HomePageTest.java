package Tests;

import Pages.HomePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void testGetAllTitlesAndSelectOnesie() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page did not load.");

        List<WebElement> titles = homePage.getProductTitles();
        Assert.assertTrue(titles.size() > 0, "No product titles found on home page.");

        System.out.println("Products visible on screen:");
        for (WebElement title : titles) {
            String text = title.getText();
            System.out.println(" - " + text);
            Assert.assertFalse(text.isEmpty(), "Product title should not be empty");
            Assert.assertTrue(title.isDisplayed(), "Product title should be visible");
        }
    }

    @Test(priority = 2)
    public void testTapAllHomePageActions() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page did not load.");

        homePage.tapToggleIcon();

        homePage.tapFirstAddButton();//android.widget.TextView[@text="-"]
        Assert.assertTrue(driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='-']")).size() > 0,
                "Remove button should appear after adding product");

        homePage.tapSecondAddButton();

        homePage.tapFirstRemoveButton();

        homePage.tapFilterButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"))).isDisplayed(),
                "Filter modal should be visible after tapping filter button");

        homePage.tapSortPriceLowToHigh();

        homePage.tapToggleIcon();
    }

    @Test(priority = 3)
    public void selectTheItems() {
        HomePage homePage = new HomePage(driver);

        homePage.scrollToProductAndSelect("Sauce Labs Onesie");

        String productTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sauce Labs Onesie']")).getText();
        Assert.assertEquals(productTitle, "Sauce Labs Onesie", "Wrong product opened after scroll.");
    }
}
