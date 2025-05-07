package pages;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class SubCategoryPage {
	WebDriver driver;
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")WebElement subCategoryMoreInfo;
	@FindBy(xpath="//a[@onclick=\"click_button(1)\"]")WebElement subCategoryNew;
	@FindBy(xpath="//select[@id=\"cat_id\"]")WebElement category;
	@FindBy(xpath="//input[@id='subcategory']")WebElement subCategory;
	@FindBy(xpath = "//input[@name='main_img' and @type='file']")WebElement subCategoryChooseFile;
	@FindBy(xpath="//button[@name='create']")WebElement subCategorySave;
	@FindBy(xpath="//i[@class='icon fas fa-check']")WebElement subCategoryAlert;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement subCategoryUpdateAlert;
	@FindBy(xpath="(//i[@class='fas fa-edit'])[2]")WebElement subCategoryAction;
	@FindBy(xpath="//button[@name='update']")WebElement subCategoryUpdate;
	@FindBy(xpath="//div[@id='imagePreview']")WebElement imgpreview;
	@FindBy(xpath="//span[@class='fas fa-trash-alt']")WebElement deleteImg;
	public SubCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*public void clickSubCategoryMoreInfo()
	{
		subCategoryMoreInfo.click();
	}*/
	public SubCategoryPage clickSubCategoryNew()
	{
		subCategoryNew.click();
		return this;
	}
	public SubCategoryPage selectCategory()
	{
		PageUtility pu = new PageUtility();
		pu.selectByIndexMethod(category, 1);
		return this;
	}
	public SubCategoryPage updateCategory()
	{
		PageUtility pu = new PageUtility();
		pu.selectByIndexMethod(category, 2);
		return this;
	}
	public SubCategoryPage enterSubCategorySub(String valuesubCategory)
	{
		subCategory.clear();
		subCategory.sendKeys(valuesubCategory);
		return this;
	}
	public SubCategoryPage clickChooseFile() throws AWTException
	{
		//subCategoryChooseFile.click();
		PageUtility pu = new PageUtility();
		pu.javaScriptExecutorClickMethod(subCategoryChooseFile, driver);

		FileUploadUtility fileuploadutilities =new FileUploadUtility();
		fileuploadutilities.fileUploadUsingRobotClass(subCategoryChooseFile,Constants.IMG);
		return this;
	}
	public SubCategoryPage updateChooseFile() throws AWTException
	{
		//subCategoryChooseFile.click();
		PageUtility pu = new PageUtility();
		pu.javaScriptExecutorClickMethod(subCategoryChooseFile, driver);

		FileUploadUtility fileuploadutilities =new FileUploadUtility();
		fileuploadutilities.fileUploadUsingRobotClass(subCategoryChooseFile,Constants.IMG1);
		return this;
	}
	public SubCategoryPage clickSubCategorySave()
	{
		WaitUtility wu = new WaitUtility();
		wu.waitForElementIsVisible(driver, imgpreview);
		PageUtility pu = new PageUtility();
		pu.javaScriptExecutorClickMethod(subCategorySave, driver);
		//subCategorySave.click();
		return null;
	}
	public boolean isAlertDisplayed()
	{
		return subCategoryAlert.isDisplayed();
		
	}
	public SubCategoryPage clicksubCategoryAction()
	{
		subCategoryAction.click();
		return this;
	}
	public SubCategoryPage clickSubCategoryUpdate()
	{
		
		PageUtility pu = new PageUtility();
		pu.javascriptScrollBottom(driver);
		WaitUtility wu = new WaitUtility();
		wu.waitForElementIsVisible(driver, imgpreview);
		
		pu.javaScriptExecutorClickMethod(subCategoryUpdate, driver);
		//subCategoryUpdate.click();
		return this;
	}
	public boolean isUpdateAlertDisplayed()
	{
		return subCategoryUpdateAlert.isDisplayed();
		
	}
	
}
