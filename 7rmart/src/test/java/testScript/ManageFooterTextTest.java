package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class ManageFooterTextTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description = "Verify the user is able to update footer text")
	public void verifyTheUserIsAbleToUpdateFooterText() throws Exception
	{
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		//String manageFooterAddress = "0196 Lyndon Roads, Tierrachester, PA 93925";
		//String manageFooterEmail = "classie.hahn@yahoo.com";
		//String manageFooterPhone = "(578) 007-3217";
		FakerUtility fakerutility = new FakerUtility();
		String manageFooterAddress=fakerutility.generateAddress();
		String manageFooterEmail=fakerutility.generateEmail();
		String manageFooterPhone=fakerutility.generatePhone();
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		
		ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);
		managefootertextpage.clickManageFooterTextMoreInfo();
		managefootertextpage.clickManageFooterTextAction();
		managefootertextpage.enterManageFooterTextAddress(manageFooterAddress);
		managefootertextpage.enterManageFooterTextEmail(manageFooterEmail);
		managefootertextpage.enterManageFooterTextPhone(manageFooterPhone);
		managefootertextpage.clickManageFooterTextUpdate();
		boolean alertDisplayed = managefootertextpage.isAlertDisplayed();
		Assert.assertTrue(alertDisplayed);
		
	}
	@Test(retryAnalyzer=retry.Retry.class,description = "Verify the update button is displayed")
	public void verifyTheUpdateButtonIsDisplayed() throws Exception
	{
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		
		ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);
		managefootertextpage.clickManageFooterTextMoreInfo();
		managefootertextpage.clickManageFooterTextAction();
		boolean manageFooterDisplayed = managefootertextpage.isManageFooterUpdateDisplayed();
		Assert.assertTrue(manageFooterDisplayed);
	}

}
