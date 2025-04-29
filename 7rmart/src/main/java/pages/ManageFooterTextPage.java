package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	WebDriver driver;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'])[2]")WebElement manageFooterTextMoreInfo;
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
	public void clickManageFooterTextMoreInfo()
	{
		manageFooterTextMoreInfo.click();
	}
	public void clickManageFooterTextAction()
	{
		manageFooterTextAction.click();
	}
	public void enterManageFooterTextAddress(String valueAddress)
	{
		manageFooterTextAddress.clear();
		manageFooterTextAddress.sendKeys(valueAddress);
	}
	public void enterManageFooterTextEmail(String valueEmail)
	{
		manageFooterTextEmail.clear();
		manageFooterTextEmail.sendKeys(valueEmail);
	}
	public void enterManageFooterTextPhone(String valuePhone)
	{
		manageFooterTextPhone.clear();
		manageFooterTextPhone.sendKeys(valuePhone);
		
	}
	public void clickManageFooterTextUpdate()
	{
		manageFooterTextUpdate.click();
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
