package Tests;

import Pages.ProductPage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductPageTest extends BaseTest {

    @Test
    public void testAddToCartAndOpenCart() {
        ProductPage productPage = new ProductPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        productPage.scrollToAddToCartAndTap();

        boolean removeButtonVisible = wait.until(ExpectedConditions
                .visibilityOfElementLocated(AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"REMOVE\")"))
        ).isDisplayed();
        Assert.assertTrue(removeButtonVisible, "REMOVE button should be visible after adding to cart");

        productPage.tapCartIcon();

        boolean cartPageVisible = wait.until(ExpectedConditions
                .visibilityOfElementLocated(AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"YOUR CART\")"))
        ).isDisplayed();
        Assert.assertTrue(cartPageVisible, "Cart page is not visible after tapping cart icon.");
    }
}
