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

    private final By homePageTitle = AppiumBy.xpath("//android.widget.TextView[@text='PRODUCTS']");
    private final By productTitles = AppiumBy.xpath("//android.widget.TextView[@content-desc='test-Item title']");
    private final By toggleIcons = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Toggle']/android.widget.ImageView");
    private final By addButtons1 = AppiumBy.xpath("(//android.widget.TextView[@text=\"+\"])[1]");
    private final By addButtons2 = AppiumBy.xpath("(//android.widget.TextView[@text=\"+\"])[2]");
    private final By removeButtons = AppiumBy.xpath("//android.widget.TextView[@text=\"-\"]");
    private final By filterButton = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Modal Selector Button']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");
    private final By sortPriceLowToHigh = AppiumBy.xpath("//android.widget.TextView[@text='Price (low to high)']");

    public boolean isPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homePageTitle)).isDisplayed();
    }

    public List<WebElement> getProductTitles() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTitles));
    }

    public void tapToggleIcon() {
        WebElement toggle = wait.until(ExpectedConditions.visibilityOfElementLocated(toggleIcons));
        toggle.click();
    }

    public void tapFirstAddButton() {
        WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(addButtons1));
        add.click();
    }
    
    public void tapSecondAddButton() {
        WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(addButtons2));
        add.click();
    }

    public void tapFirstRemoveButton() {
        WebElement remove = wait.until(ExpectedConditions.visibilityOfElementLocated(removeButtons));
        remove.click();
    }

    public void tapFilterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(filterButton)).click();
    }

    public void tapSortPriceLowToHigh() {
        wait.until(ExpectedConditions.elementToBeClickable(sortPriceLowToHigh)).click();
        
    }


    public void scrollToProductAndSelect(String productName) {
        String uiScrollToElement = String.format(
            "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"%s\"))",
            productName);
        driver.findElement(AppiumBy.androidUIAutomator(uiScrollToElement));
        driver.findElement(AppiumBy.androidUIAutomator(String.format("new UiSelector().text(\"%s\")", productName))).click();
    }
}
