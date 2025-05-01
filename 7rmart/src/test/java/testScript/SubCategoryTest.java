package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtilities;

public class SubCategoryTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description = "Verify the user is able to add new subcategory")
	public void verifyTheUserIsAbleToAddNewSubCategory() throws Exception
	{
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		String subCategory = ExcelUtilities.readStringData(1, 0, "SubCategory");
		//String subCategory = "Strawberry";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.clickSubCategoryMoreInfo();
		subcategorypage.clickSubCategoryNew();
		subcategorypage.selectCategory();
		subcategorypage.enterSubCategorySub(subCategory);
		subcategorypage.clickChooseFile();
		subcategorypage.clickSubCategorySave();
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
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.clickSubCategoryMoreInfo();
		subcategorypage.clicksubCategoryAction();
		subcategorypage.updateCategory();
		subcategorypage.enterSubCategorySub(subCategory);
		//subcategorypage.deleteImg();
		subcategorypage.updateChooseFile();
		subcategorypage.clickSubCategoryUpdate();
		boolean alertDisplayed = subcategorypage.isAlertDisplayed();
		Assert.assertTrue(alertDisplayed);
	}

}
