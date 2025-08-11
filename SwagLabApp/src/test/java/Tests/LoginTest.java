package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import io.appium.java_client.AppiumBy;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test user", "test password");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match any user in this service"),
                "Error message: " + error);
    }

    @Test(priority = 2)
    public void testUIElementsVisibilityAndEnablement() {
        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("test-Username")).isDisplayed(), "Username field should be displayed");
        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("test-Username")).isEnabled(), "Username field should be enabled");

        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("test-Password")).isDisplayed(), "Password field should be displayed");
        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("test-Password")).isEnabled(), "Password field should be enabled");

        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).isEnabled(), "Login button should be enabled");
    }

    @Test(priority = 3)
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        By productsTitle = AppiumBy.xpath("//android.widget.TextView[@text='PRODUCTS']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isProductsVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle)).isDisplayed();

        Assert.assertTrue(isProductsVisible, "PRODUCTS page title should be visible after successful login");
    }

}
