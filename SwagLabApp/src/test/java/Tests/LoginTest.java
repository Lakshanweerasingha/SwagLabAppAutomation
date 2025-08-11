package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends BaseTest {
	
	  @Test(priority = 1)
	    public void testInvalidLogin() {
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("test user", "test password");

	        String error = loginPage.getErrorMessage();
	        Assert.assertTrue(error.contains("Username and password do not match any user in this service"),
	                "error message: " + error);
	    }

    @Test(priority = 2)
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

    }

  
}
