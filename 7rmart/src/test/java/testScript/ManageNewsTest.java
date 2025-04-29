package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;


public class ManageNewsTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description = "Verify the user is able to add news")
	public void verifyTheUserIsAbleToAddNews() throws Exception {
		
		//String username="admin";
		//String password="admin";
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		//String news = "Test New";
		String news = ExcelUtilities.readStringData(1, 0, "ManageNews");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickMore();
		managenewspage.clickNew();
		managenewspage.enterNews(news);
		managenewspage.clickSave();
		boolean alert = managenewspage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}

}
