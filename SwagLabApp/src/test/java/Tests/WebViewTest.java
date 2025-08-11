package Tests;

import Pages.WebViewPage;
import org.testng.annotations.Test;

public class WebViewTest extends BaseTest {
    @Test
    public void testWebViewNavigation() throws InterruptedException {
        WebViewPage webViewPage = new WebViewPage(driver);

        webViewPage.tapSidebarIcon();
        webViewPage.tapWebViewIcon();
        webViewPage.enterUrl("https://www.google.com");
        webViewPage.tapGoToSite();
        webViewPage.switchToWebViewContext();
        webViewPage.searchAppium();
        Thread.sleep(2000);
     
    }
}
