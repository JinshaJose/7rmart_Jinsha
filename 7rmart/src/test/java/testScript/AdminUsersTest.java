package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	public LogoutPage logoutpage;
	public AdminUsersPage adminuserpage;
	@Test(retryAnalyzer=retry.Retry.class,description = "Verfit the user is able to add users")
	public void verifyUserIsAbleToAddUsers() throws Exception
	{
		//String username="admin";
		//String password="admin";
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		//String adminUsername = "Jinsha";
		//String adminPassword = "Test123";
		FakerUtility fakerutility = new FakerUtility();
		String adminUsername=fakerutility.creatARandomFirstName();
		String adminPassword=fakerutility.creatARandomFirstName();
		//String adminUsername = ExcelUtilities.readStringData(1, 0, "AdminUsers");
		//String adminPassword = ExcelUtilities.readStringData(1, 1, "AdminUsers");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		
		//AdminUsersPage adminuserpage = new AdminUsersPage(driver);
		//adminuserpage.clickAdminUserMoreInfo();
		adminuserpage = logoutpage.clickAdminUserMoreInfo();
		adminuserpage.clickAdminUserNew().enterAdminUserUsername(adminUsername).enterAdminUserPassword(adminPassword).selectAdminUserUsertype().clickAdminUserSave();
		//adminuserpage.enterAdminUserUsername(adminUsername);
		//adminuserpage.enterAdminUserPassword(adminPassword);
		//adminuserpage.selectAdminUserUsertype();
		//adminuserpage.clickAdminUserSave();
		boolean adminUserAlert = adminuserpage.isAdminUserAlertDisplayed();
		Assert.assertTrue(adminUserAlert);
	}

}
