package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageContactPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class ManageContactTest extends Base {
	public LogoutPage logoutpage;
	public ManageContactPage managecontactpage;
	@Test(retryAnalyzer=retry.Retry.class,description = "Verify the user is able to update contact")
	public void verifyTheUserIsAbleToUpdateContact() throws Exception
	{
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		/*String manageConatctPhone = "9192939495";
		String manageContactEmail = "romona.beahan@hotmail.com";
		*/
		
		FakerUtility fakerutility = new FakerUtility();
		String manageConatctPhone = fakerutility.generatePhone();
		String manageContactEmail = fakerutility.generateEmail();
		String managecontactAddress = fakerutility.generateAddress();
		String manageContactDeliveryTime = "5 pm";
		String manageContactDeliveryCharge = "50";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		
		//ManageContactPage managecontactpage = new ManageContactPage(driver);
		//managecontactpage.clickManageContactMoreInfo();
		managecontactpage = logoutpage.clickManageContactMoreInfo();
		managecontactpage.clickManageContactAction().enterManageContactPhone(manageConatctPhone).enterManageConatctEmail(manageContactEmail)
		.enterManageConatctAddress(managecontactAddress).enterManageContactDeliveryTime(manageContactDeliveryTime).enterManageContactDeliveryCharge(manageContactDeliveryCharge)
		.clickManageContactUpdate();
		//managecontactpage.enterManageContactPhone(manageConatctPhone);
		//managecontactpage.enterManageConatctEmail(manageContactEmail);
		//managecontactpage.enterManageConatctAddress(managecontactAddress);
		//managecontactpage.enterManageContactDeliveryTime(manageContactDeliveryTime);
		//managecontactpage.enterManageContactDeliveryCharge(manageContactDeliveryCharge);
		//managecontactpage.clickManageContactUpdate();
		boolean manageContactAlertDisplayed = managecontactpage.isManageContactAlertDisplayed();
		Assert.assertTrue(manageContactAlertDisplayed);
		
	}
	

}
