package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtilities;


public class LoginTest extends Base{
	@Test(groups= {"regression"},retryAnalyzer=retry.Retry.class,description = "Verify the user is able to login using valid credentials")
	public void verifyTheUserIsAbleTologinUsingValidCredentials() throws Exception
	{
		
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean isDasboardLoaded = loginpage.isHomepageLoaded();
		Assert.assertTrue(isDasboardLoaded,Constants.LOGINWITHCORRECTCREDENTIALS);
	}
	@Test(retryAnalyzer=retry.Retry.class,description = "Verify the user is able to login using invalid username and valid password" )
	public void verifyTheUserIsAbleTologinUsingInvalidUsernameAndValidPassword() throws Exception
	{
		String username = ExcelUtilities.readStringData(2, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean alertmessage = loginpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage,Constants.LOGINWITHINVALIDUSERNAMEANDVALIDPASSWORD);
	}
	@Test(retryAnalyzer=retry.Retry.class,description = "Verify the user is able to login using valid username and invalid password" )
	public void verifyTheUserIsAbleTologinUsingValidUsernameAndInvalidPassword() throws Exception
	{
		String username = ExcelUtilities.readStringData(3, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean alertmessage = loginpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage,Constants.LOGINWITHVALIDUSERNAMEANDINVALIDPASSWORD);
	}
	@Test(retryAnalyzer=retry.Retry.class,description = "Verify the user is able to login using invalid username and invalid password" )
	public void verifyTheUserIsAbleTologinUsingInvalidUsernameAndInvalidPassword() throws Exception
	{
		String username = ExcelUtilities.readStringData(4, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean alertmessage = loginpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage,Constants.LOGINWITHINVALIDUSERNAMEANDINVALIDPASSWORD);
	}
	
}
