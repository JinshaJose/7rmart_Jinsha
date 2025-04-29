package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectByIndexMethod(WebElement element,int index) {
		Select select =new Select(element);
		select.selectByIndex(index);
		
	}
	public void selectByVisibleTextMethod(WebElement element,String text) {
		Select select =new Select(element);
		select.selectByVisibleText(text);
		
	}
	public void selectByValueMethod(WebElement element,String value) {
		Select select =new Select(element);
		select.selectByValue(value);
		
	}
	public void javaScriptExecutorClickMethod(WebElement element, WebDriver driver)
	{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", element);
}
	public void javascriptScrollBottom(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,4000)","");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
	}
}
