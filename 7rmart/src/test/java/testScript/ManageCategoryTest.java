package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class ManageCategoryTest extends Base {
	public LogoutPage logoutpage;
	public ManageCategoryPage managecategorypage;
	@Test(retryAnalyzer=retry.Retry.class,description = "Verify the user is able to add new category")
	public void verifyTheUserISAbleToAddNewCategory() throws Exception
	{
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		//String manageCateCategory = ExcelUtilities.readStringData(1, 0, "ManageCategory");
		FakerUtility fakerutility = new FakerUtility();
		String manageCateCategory = fakerutility.creatARandomFirstName();
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		
		//ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		//managecategorypage.clickManageCategoryMoreInfo();
		managecategorypage = logoutpage.clickManageCategoryMoreInfo();
		managecategorypage.clickManageCategoryNew().enterManageCatCategory(manageCateCategory).selectManageCategoryGroups()
		.chooseFileManageCat().selectOnTop().showOnLeft().clickManageCatSave();
		//managecategorypage.enterManageCatCategory("Test Category"+manageCateCategory);
		//managecategorypage.selectManageCategoryGroups();
		//managecategorypage.chooseFileManageCat();
		//managecategorypage.selectOnTop();
		//managecategorypage.showOnLeft();
		//managecategorypage.clickManageCatSave();
		boolean manageCatAlertDisplayed = managecategorypage.isManageCategoryAlertDisplayed();
		Assert.assertTrue(manageCatAlertDisplayed);
	}

}
