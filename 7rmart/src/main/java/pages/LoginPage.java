package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath="//input[@name='username']")WebElement username;
	@FindBy(xpath="//input[@name='password']")WebElement password;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signIn;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String usernamevalue)
	{
		username.sendKeys(usernamevalue);	
	}
	
	public void enterPassword(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
	}
	public void clickSignIn()
	{
		signIn.click();
	}
	public boolean isHomepageLoaded()
	{
		return dashboard.isDisplayed();
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}

