package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import pages.SubCategoryPage;
import utilities.ExcelUtilities;

public class SubCategoryTest extends Base {
	public LogoutPage logoutpage;
	public SubCategoryPage subcategorypage;;
	
	@Test(retryAnalyzer=retry.Retry.class,description = "Verify the user is able to add new subcategory")
	public void verifyTheUserIsAbleToAddNewSubCategory() throws Exception
	{
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		String subCategory = ExcelUtilities.readStringData(1, 0, "SubCategory");
		//String subCategory = "Strawberry";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		
		//SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		//subcategorypage.clickSubCategoryMoreInfo();
		subcategorypage = logoutpage.clickSubCategoryMoreInfo();
		subcategorypage.clickSubCategoryNew().selectCategory().enterSubCategorySub(subCategory).clickChooseFile().clickSubCategorySave();
		//subcategorypage.selectCategory();
		//subcategorypage.enterSubCategorySub(subCategory);
		//subcategorypage.clickChooseFile();
		//subcategorypage.clickSubCategorySave();
		boolean alertDisplayed = subcategorypage.isAlertDisplayed();
		Assert.assertTrue(alertDisplayed);
		
	}
	@Test(retryAnalyzer=retry.Retry.class,description = "Verify the user is able to update subcategory")
	public void verifyTheUserIsAbleToUpdateSubCategory() throws Exception
	{
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		String subCategory = ExcelUtilities.readStringData(2, 0, "SubCategory");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		
		//SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		//subcategorypage.clickSubCategoryMoreInfo();
		subcategorypage = logoutpage.clickSubCategoryMoreInfo();
		subcategorypage.clicksubCategoryAction().updateCategory().enterSubCategorySub(subCategory).updateChooseFile().clickSubCategoryUpdate();
		//subcategorypage.updateCategory();
		//subcategorypage.enterSubCategorySub(subCategory);
		//subcategorypage.deleteImg();
		//subcategorypage.updateChooseFile();
		//subcategorypage.clickSubCategoryUpdate();
		boolean alertDisplayed = subcategorypage.isAlertDisplayed();
		Assert.assertTrue(alertDisplayed);
	}

}
