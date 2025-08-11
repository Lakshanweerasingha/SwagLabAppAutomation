package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By cartButton = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");
    private final By productTitles = AppiumBy.xpath("//android.widget.TextView[@content-desc='test-Item title']");

    public boolean isPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartButton)).isDisplayed();
    }

    public List<WebElement> getProductTitles() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTitles));
    }

    public void scrollToProductAndSelect(String productName) {
        String uiScrollToElement  = String.format(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"%s\"))",
                productName
        );
        driver.findElement(AppiumBy.androidUIAutomator(uiScrollToElement));
        driver.findElement(AppiumBy.androidUIAutomator(String.format("new UiSelector().text(\"%s\")", productName))).click();
    }
}
