package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
	WebDriver driver;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'])[2]")WebElement manageContactMoreInfo;
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
	public void clickManageContactMoreInfo()
	{
		manageContactMoreInfo.click();
	}
	public void clickManageContactAction()
	{
		manageContactAction.click();	
	}
	public void enterManageContactPhone(String valuemanageContactPhone)
	{
		
		manageContactPhone.clear();
		manageContactPhone.sendKeys(valuemanageContactPhone);
	}
	public void enterManageConatctEmail(String valuemanageContactEmail )
	{
		manageContactEmail.clear();
		manageContactEmail.sendKeys(valuemanageContactEmail);	
	}
	public void enterManageConatctAddress(String valuemanageContactAddress )
	{
		manageContactAddress.clear();
		manageContactAddress.sendKeys(valuemanageContactAddress);
	}
	public void enterManageContactDeliveryTime(String valuemanageContactDeliveryTime )
	{
		manageContactDeliveryTime.clear();
		manageContactDeliveryTime.sendKeys(valuemanageContactDeliveryTime);
	}
	public void enterManageContactDeliveryCharge(String valuemanageContactDeliveryChargeLimit)
	{
		PageUtility pu = new PageUtility();
		pu.javascriptScrollBottom(driver);
		manageContactDeliveryChargeLimit.clear();
		manageContactDeliveryChargeLimit.sendKeys(valuemanageContactDeliveryChargeLimit);
	}
	public void clickManageContactUpdate()
	{
		PageUtility pu = new PageUtility();
		pu.javascriptScrollBottom(driver);
		manageContactUpdate.click();
	}
	public boolean isManageContactAlertDisplayed()
	{
		return manageContactAlert.isDisplayed();
	}
}
