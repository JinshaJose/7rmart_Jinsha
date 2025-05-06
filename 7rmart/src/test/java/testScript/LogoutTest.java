package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtilities;

public class LogoutTest extends Base {
	public LogoutPage logoutpage;
	@Test(retryAnalyzer=retry.Retry.class,description = "Verify the user is able to logout")
	public void verifyTheUserIsAbleToLogout() throws Exception
	{
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		loginpage.clickSignIn();
		
		//LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickAdmin();
		logoutpage.clickLogout();
		boolean loginpageLoaded = logoutpage.isLoginPageLoaded();
		Assert.assertTrue(loginpageLoaded);
	}

}
