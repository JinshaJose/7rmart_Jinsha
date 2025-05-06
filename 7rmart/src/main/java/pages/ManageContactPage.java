package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
	WebDriver driver;
	//@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'])[2]")WebElement manageContactMoreInfo;
	@FindBy(xpath="//i[@class='fas fa-edit']")WebElement manageContactAction;
	@FindBy(xpath="//input[@id='phone']")WebElement manageContactPhone;
	@FindBy(xpath="//input[@id='email']")WebElement manageContactEmail;
	@FindBy(xpath="(//textarea[@id='content'])[1]")WebElement manageContactAddress;
	@FindBy(xpath="(//textarea[@id='content'])[2]")WebElement manageContactDeliveryTime;
	@FindBy(xpath="//input[@id='del_limit']")WebElement manageContactDeliveryChargeLimit;
	@FindBy(xpath="//button[@name='Update']")WebElement manageContactUpdate;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement manageContactAlert;
	public ManageContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*public void clickManageContactMoreInfo()
	{
		manageContactMoreInfo.click();
	}*/
	public ManageContactPage clickManageContactAction()
	{
		manageContactAction.click();
		return this;	
	}
	public ManageContactPage enterManageContactPhone(String valuemanageContactPhone)
	{
		
		manageContactPhone.clear();
		manageContactPhone.sendKeys(valuemanageContactPhone);
		return this;
	}
	public ManageContactPage enterManageConatctEmail(String valuemanageContactEmail )
	{
		manageContactEmail.clear();
		manageContactEmail.sendKeys(valuemanageContactEmail);
		return this;	
	}
	public ManageContactPage enterManageConatctAddress(String valuemanageContactAddress )
	{
		manageContactAddress.clear();
		manageContactAddress.sendKeys(valuemanageContactAddress);
		return this;
	}
	public ManageContactPage enterManageContactDeliveryTime(String valuemanageContactDeliveryTime )
	{
		manageContactDeliveryTime.clear();
		manageContactDeliveryTime.sendKeys(valuemanageContactDeliveryTime);
		return this;
	}
	public ManageContactPage enterManageContactDeliveryCharge(String valuemanageContactDeliveryChargeLimit)
	{
		PageUtility pu = new PageUtility();
		pu.javascriptScrollBottom(driver);
		manageContactDeliveryChargeLimit.clear();
		manageContactDeliveryChargeLimit.sendKeys(valuemanageContactDeliveryChargeLimit);
		return this;
	}
	public ManageContactPage clickManageContactUpdate()
	{
		PageUtility pu = new PageUtility();
		pu.javascriptScrollBottom(driver);
		manageContactUpdate.click();
		return this;
	}
	public boolean isManageContactAlertDisplayed()
	{
		return manageContactAlert.isDisplayed();
	}
}
