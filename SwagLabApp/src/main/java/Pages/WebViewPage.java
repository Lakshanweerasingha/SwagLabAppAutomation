package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebViewPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public WebViewPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void tapSidebarIcon() {
        WebElement sidebarIcon = wait.until(ExpectedConditions.elementToBeClickable(
        AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")));
        sidebarIcon.click();
    }

    public void tapWebViewIcon() {
        WebElement webViewIcon = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("test-WEBVIEW")));
        webViewIcon.click();
    }

    public void enterUrl(String url) {
        WebElement urlTextbox = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("test-enter a https url here...")));
        urlTextbox.clear();
        urlTextbox.sendKeys(url);
    }

    public void tapGoToSite() {
        WebElement goToSiteBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("test-GO TO SITE")));
        goToSiteBtn.click();
    }

    public void switchToWebViewContext() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> {
            for (String context : driver.getContextHandles()) {
                if (context.toLowerCase().contains("webview")) {
                    driver.context(context);
                    System.out.println("Now you are in web view context: " + context);
                    return true;
                }
            }
            return false;
        });
    }

    public void searchAppium() {
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.className("gLFyf")));
        searchBox.click();
        searchBox.sendKeys("Appium");
        searchBox.sendKeys(Keys.ENTER);

    }
    
}
