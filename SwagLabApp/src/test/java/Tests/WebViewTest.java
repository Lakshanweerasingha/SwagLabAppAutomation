package Tests;

import Pages.WebViewPage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebViewTest extends BaseTest {
    @Test
    public void testWebViewNavigation() throws InterruptedException {
        WebViewPage webViewPage = new WebViewPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        webViewPage.tapSidebarIcon();
        By sidebarPanel = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(sidebarPanel)).isDisplayed(),
                "Sidebar panel should be visible after tapping sidebar icon");

        webViewPage.tapWebViewIcon();
        By webViewHeader = AppiumBy.accessibilityId("test-WEBVIEW");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(webViewHeader)).isDisplayed(),
                "WebView header should be visible after tapping WebView icon");

        String url = "https://www.google.com";
        webViewPage.enterUrl(url);
        WebElement urlTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("test-enter a https url here...")));
        Assert.assertEquals(urlTextbox.getText(), url, "URL textbox should contain the entered URL");

        webViewPage.tapGoToSite();

        webViewPage.switchToWebViewContext();
        String currentContext = driver.getContext();
        Assert.assertTrue(currentContext.toLowerCase().contains("webview"),
                "Driver context should be switched to WEBVIEW");

        webViewPage.searchAppium();

        Thread.sleep(2000); 
    }
}
