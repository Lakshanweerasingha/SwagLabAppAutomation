package Tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
    protected static AndroidDriver driver;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setDeviceName("Android Emulator")
                    .setAppPackage("com.swaglabsmobileapp")
                    .setAppActivity("com.swaglabsmobileapp.MainActivity")
                    .setAutomationName("UiAutomator2")
                    .setNewCommandTimeout(Duration.ofSeconds(300));

            URL appiumServerURL = new URL("http://127.0.0.1:4723");
            driver = new AndroidDriver(appiumServerURL, options);
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
