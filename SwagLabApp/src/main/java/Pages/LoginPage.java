package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    private final By usernameField =  AppiumBy.accessibilityId("test-Username");
    private final By passwordField =  AppiumBy.accessibilityId("test-Password");
    private final By loginBtn =  AppiumBy.accessibilityId("test-LOGIN");
    private final By errorMsg = AppiumBy.xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]");

    public void enterUsername(String username) {
        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        user.clear();
        user.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        pass.clear();
        pass.sendKeys(password);
    }

    public void tapLogin() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        button.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        tapLogin();
    }

    public String getErrorMessage() {
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
        return msg.getText();
    }
}
