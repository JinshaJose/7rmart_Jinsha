package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void fileUploadUsingSendKeys(WebElement element,String path)
	{
		element.sendKeys(path);
	}
	public void fileUploadUsingRobotClass(WebElement element,String path) throws AWTException
	{
		StringSelection ss = new StringSelection(path);//create object, mention path in string selection class
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);//toolkit-class,3 methods inside class toolkit,copy to clipboard from ss by calling these 3 methods,
		Robot rb = new Robot();
		rb.delay(2500);
		rb.keyPress(KeyEvent.VK_CONTROL);//VK-Virtual Key//Press control
		rb.keyPress(KeyEvent.VK_V);//Paste//Press V
		rb.keyRelease(KeyEvent.VK_CONTROL);//Release
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);//Press enter key
		rb.keyRelease(KeyEvent.VK_ENTER);//release
	}
}
