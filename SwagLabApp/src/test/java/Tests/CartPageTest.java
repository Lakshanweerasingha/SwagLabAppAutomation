package Tests;

import Pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

    @Test
    public void testCheckoutFlow() {
        CartPage cartPage = new CartPage(driver);

        cartPage.tapCheckout();

        cartPage.tapContinue();
        Assert.assertTrue(cartPage.isErrorMessageDisplayed(), "Error message should be displayed when continue tapped without data");
        cartPage.fillCheckoutForm("Test", "User", "12345");
        cartPage.tapContinue();
        cartPage.scrollToFinishAndTap();
        cartPage.tapBackHome();

    }
}
