package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement manageNewsMoreInfo ;
	@FindBy(xpath="(//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-news')])[1]")WebElement manageNewsMoreInfo ;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newButton ;
	@FindBy(xpath="//textarea[@id='news']")WebElement enterNews ;
	@FindBy(xpath="//button[@name='create']")WebElement save ;
	@FindBy(xpath="//button[@data-dismiss='alert']")WebElement alertMessage ;
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*public void clickMore()
	{
		manageNewsMoreInfo.click();
	}*/
	public ManageNewsPage clickNew()
	{
		newButton.click();
		return this;
	}
	public ManageNewsPage enterNews(String nValue)
	{
		enterNews.sendKeys(nValue);
		return this;
	}
	public ManageNewsPage clickSave()
	{
		save.click();
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return alertMessage.isDisplayed();
	}

}
