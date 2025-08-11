package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public ProductPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void scrollToAddToCartAndTap() {
        String uiScroll = "new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().text(\"ADD TO CART\"))";

        driver.findElement(AppiumBy.androidUIAutomator(uiScroll));

        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"ADD TO CART\")")));
        addToCartBtn.click();
    }

    public void tapCartIcon() {
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")));
        cartIcon.click();
    }
}