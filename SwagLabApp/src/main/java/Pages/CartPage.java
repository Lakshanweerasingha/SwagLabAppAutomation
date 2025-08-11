package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void tapCheckout() {
        String uiScrollToElement = "new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().description(\"test-CHECKOUT\"))";
        driver.findElement(AppiumBy.androidUIAutomator(uiScrollToElement));

        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("test-CHECKOUT")));
        checkoutBtn.click();
    }


    public void tapContinue() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("test-CONTINUE")));
        continueBtn.click();
    }

    public boolean isErrorMessageDisplayed() {
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("test-Error message")));
        return errorMsg.isDisplayed();
    }

    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        WebElement firstNameField = driver.findElement(AppiumBy.accessibilityId("test-First Name"));
        WebElement lastNameField = driver.findElement(AppiumBy.accessibilityId("test-Last Name"));
        WebElement postalCodeField = driver.findElement(AppiumBy.accessibilityId("test-Zip/Postal Code"));

        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
    }

    public void scrollToFinishAndTap() {
        String uiScroll = "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"FINISH\"))";
        WebElement finishBtn = driver.findElement(AppiumBy.androidUIAutomator(uiScroll));
        finishBtn.click();
    }

    public void tapBackHome() {
        WebElement backHomeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("test-BACK HOME")));
        backHomeBtn.click();
    }
}
