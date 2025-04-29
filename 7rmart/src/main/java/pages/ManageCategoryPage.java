package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	WebDriver driver;
	@FindBy(xpath="(//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-category\"])[3]")WebElement manageCatMoreInfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement manageCatNew;
	@FindBy(xpath="//input[@id='category']")WebElement manageCatCategory;
	@FindBy(xpath="//li[@id='134-selectable']")WebElement manageCatSelectGroups;
	@FindBy(xpath="//input[@id='main_img']")WebElement manageCatChooseFile;
	@FindBy(xpath="(//input[@value='no'])[1]")WebElement manageCatShowOnTop;
	@FindBy(xpath="(//input[@value='no'])[2]")WebElement manageCatShowOnLeft;
	@FindBy(xpath="//button[@name='create']")WebElement manageCateSave;
	@FindBy(xpath="//div[@id='imagePreview']")WebElement imgpreview;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement manageCatAlert;
	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickManageCategoryMoreInfo()
	{
		manageCatMoreInfo.click();
	}
	public void clickManageCategoryNew()
	{
		manageCatNew.click();
	}
	public void enterManageCatCategory(String valuemanageCateCategory)
	{
		manageCatCategory.sendKeys(valuemanageCateCategory);
	}
	public void selectManageCategoryGroups()
	{
		manageCatSelectGroups.click();
	}
	public void chooseFileManageCat() throws AWTException
	{
		//manageCatChooseFile.click();
		PageUtility pu = new PageUtility();
		pu.javaScriptExecutorClickMethod(manageCatChooseFile, driver);
		FileUploadUtility fileuploadutilities =new FileUploadUtility();
		fileuploadutilities.fileUploadUsingRobotClass(manageCatChooseFile,Constants.IMG);
		
	}
	public void selectOnTop()
	{
		
		PageUtility pu = new PageUtility();
		pu.javascriptScrollBottom(driver);
		WaitUtility wu = new WaitUtility();
		wu.waitForElementIsVisible(driver, imgpreview);
		
		manageCatShowOnTop.click();
	}
	public void showOnLeft()
	{
		manageCatShowOnLeft.click();
	}
	public void clickManageCatSave()
	{
		manageCateSave.click();
	}
	public boolean isManageCategoryAlertDisplayed()
	{
		return manageCatAlert.isDisplayed();
	}
	
	

}
