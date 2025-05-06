package pages;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	WebDriver driver;
	//@FindBy(xpath="(//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-category\"])[3]")WebElement manageCatMoreInfo;
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
	/*public void clickManageCategoryMoreInfo()
	{
		manageCatMoreInfo.click();
	}*/
	public ManageCategoryPage clickManageCategoryNew()
	{
		manageCatNew.click();
		return this;
	}
	public ManageCategoryPage enterManageCatCategory(String valuemanageCateCategory)
	{
		manageCatCategory.sendKeys(valuemanageCateCategory);
		return this;
	}
	public ManageCategoryPage selectManageCategoryGroups()
	{
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
				fluentWait.until(ExpectedConditions.elementToBeClickable(manageCatSelectGroups));
		manageCatSelectGroups.click();
		return this;
	}
	public ManageCategoryPage chooseFileManageCat() throws AWTException
	{
		//manageCatChooseFile.click();
		/*PageUtility pu = new PageUtility();
		pu.javaScriptExecutorClickMethod(manageCatChooseFile, driver);
		FileUploadUtility fileuploadutilities =new FileUploadUtility();
		fileuploadutilities.fileUploadUsingRobotClass(manageCatChooseFile,Constants.IMG);
		return this;*/
		FileUploadUtility fileuploadutilities =new FileUploadUtility();
		fileuploadutilities.fileUploadUsingSendKeys(manageCatChooseFile, Constants.IMG);
		return this;
		
	}
	/*public ManageCategoryPage selectOnTop()
	{
		
		PageUtility pu = new PageUtility();
		pu.javascriptScrollBottom(driver);
		//WaitUtility wu = new WaitUtility();
		//wu.waitForElementToBeClickable(driver, imgpreview);
		
		manageCatShowOnTop.click();
		return this;
	}
	public ManageCategoryPage showOnLeft()
	{
		manageCatShowOnLeft.click();
		return this;
	}*/
	public ManageCategoryPage clickManageCatSave()
	{
		PageUtility pu = new PageUtility();
		pu.javaScriptExecutorClickMethod(manageCateSave, driver);
		//manageCateSave.click();
		return this;
	}
	public boolean isManageCategoryAlertDisplayed()
	{
		return manageCatAlert.isDisplayed();
	}
	
	

}
