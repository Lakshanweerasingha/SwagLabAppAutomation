package Tests;

import Pages.ProductPage;
import io.appium.java_client.AppiumBy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    @Test
    public void testAddToCartAndOpenCart() {
        ProductPage productPage = new ProductPage(driver);

        productPage.scrollToAddToCartAndTap();

        productPage.tapCartIcon();

        boolean cartPageVisible = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"YOUR CART\"]"))
                .isDisplayed();

        Assert.assertTrue(cartPageVisible, "Cart page is not visible after tapping cart icon.");
    }
}
