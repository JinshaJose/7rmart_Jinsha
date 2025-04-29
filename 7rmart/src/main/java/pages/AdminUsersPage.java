package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminUsersMoreInfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement adminUserNewButton;
	@FindBy(xpath="//input[@id='username']")WebElement adminUserUsername;
	@FindBy(xpath="//input[@id='password']")WebElement adminUserPassword;
	@FindBy(xpath="//select[@id='user_type']")WebElement userType;
	@FindBy(xpath="//button[@name='Create']")WebElement adminUserSaveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement adminUserAlert;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickAdminUserMoreInfo()
	{
		adminUsersMoreInfo.click();
	}
	public void clickAdminUserNew()
	{
		adminUserNewButton.click();
	}
	public void enterAdminUserUsername(String valueAdminUserUsername)
	{
		adminUserUsername.sendKeys(valueAdminUserUsername);
	}
	public void enterAdminUserPassword(String valueAdminUserPassword)
	{
		adminUserPassword.sendKeys(valueAdminUserPassword);
	}
	public void selectAdminUserUsertype()
	{
		//Select s= new Select(userType);
		//s.selectByIndex(1);
		PageUtility pu = new PageUtility();
		pu.selectByIndexMethod(userType, 1);//method name in page utility
		
	}
	public void clickAdminUserSave()
	{
		adminUserSaveButton.click();
	}
	public boolean isAdminUserAlertDisplayed()
	{
		return adminUserAlert.isDisplayed();
	}

}
