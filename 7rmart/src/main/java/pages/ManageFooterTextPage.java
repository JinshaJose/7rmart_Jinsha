package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	WebDriver driver;
	//@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'])[2]")WebElement manageFooterTextMoreInfo;
	@FindBy(xpath="(//i[@class='fas fa-edit'])[1]")WebElement manageFooterTextAction;
	@FindBy(xpath="//textarea[@placeholder='Enter the Address']")WebElement manageFooterTextAddress;
	@FindBy(xpath="//input[@id='email']")WebElement manageFooterTextEmail;
	@FindBy(xpath="//input[@id='phone']")WebElement manageFooterTextPhone;
	@FindBy(xpath="//button[@name='Update']")WebElement manageFooterTextUpdate;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement manageFooterTextAlert;
	public ManageFooterTextPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*public void clickManageFooterTextMoreInfo()
	{
		manageFooterTextMoreInfo.click();
	}*/
	public ManageFooterTextPage clickManageFooterTextAction()
	{
		manageFooterTextAction.click();
		return this;
	}
	public ManageFooterTextPage enterManageFooterTextAddress(String valueAddress)
	{
		manageFooterTextAddress.clear();
		manageFooterTextAddress.sendKeys(valueAddress);
		return this;
	}
	public ManageFooterTextPage enterManageFooterTextEmail(String valueEmail)
	{
		manageFooterTextEmail.clear();
		manageFooterTextEmail.sendKeys(valueEmail);
		return this;
	}
	public ManageFooterTextPage enterManageFooterTextPhone(String valuePhone)
	{
		manageFooterTextPhone.clear();
		manageFooterTextPhone.sendKeys(valuePhone);
		return this;
		
	}
	public ManageFooterTextPage clickManageFooterTextUpdate()
	{
		manageFooterTextUpdate.click();
		return this;
	}
	public boolean isManageFooterUpdateDisplayed()
	{
		return manageFooterTextUpdate.isDisplayed();
	}
	public boolean isAlertDisplayed()
	{
		return manageFooterTextAlert.isDisplayed();
	}
}
