package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;
	@FindBy(xpath="//a[@class=\"nav-link\" and @data-toggle=\"dropdown\"]")WebElement admin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")WebElement logout;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signIn;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminUsersMoreInfo;
	@FindBy(xpath="(//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-category\"])[3]")WebElement manageCatMoreInfo;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'])[2]")WebElement manageContactMoreInfo;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'])[2]")WebElement manageFooterTextMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement manageNewsMoreInfo ;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")WebElement subCategoryMoreInfo;
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public AdminUsersPage clickAdminUserMoreInfo()
	{
		adminUsersMoreInfo.click();
		return new AdminUsersPage(driver);
	}
	public ManageCategoryPage clickManageCategoryMoreInfo()
	{
		manageCatMoreInfo.click();
		return new ManageCategoryPage(driver);
	}
	public ManageContactPage clickManageContactMoreInfo()
	{
		manageContactMoreInfo.click();
		return new ManageContactPage(driver);
	}
	public ManageFooterTextPage clickManageFooterTextMoreInfo()
	{
		manageFooterTextMoreInfo.click();
		return new ManageFooterTextPage(driver);
	}
	public ManageNewsPage clickMore()
	{
		manageNewsMoreInfo.click();
		return new ManageNewsPage(driver);
	}
	public SubCategoryPage clickSubCategoryMoreInfo()
	{
		subCategoryMoreInfo.click();
		return new SubCategoryPage(driver);
	}
	
	public LogoutPage clickAdmin()
	{
		admin.click();
		return this;
	}
	
	public LoginPage clickLogout()
	{
		logout.click();
		return new LoginPage(driver);
	}
	public boolean isLoginPageLoaded()
	{
		return signIn.isDisplayed();
		
	}
}
