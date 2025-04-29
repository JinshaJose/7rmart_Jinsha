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
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		public void clickAdmin()
		{
			admin.click();
		}
	
	public void clickLogout()
	{
		logout.click();
	}
	public boolean isLoginPageLoaded()
	{
		return signIn.isDisplayed();
		
	}
}
