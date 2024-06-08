package demowebshop.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	public void getWebpage(WebDriver driver,String url)
	{
		driver.get(url);
	}
	
	public String getCurrentTitle(WebDriver driver)
	{
		return driver.getTitle();
	}

	public String fetchCurrentUrl(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	
	public void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}
	public void clickElement(WebElement element)
	{
		element.click();
	}
	
	public void sendText(WebElement element,String text)
	{
		element.sendKeys(text);
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public String getTextFromAlert(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		return alert.getText();
	}
	public void sendTextToAlert(WebDriver driver,String text)
	{
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(text);
	}
	
	public void selectDropdownByIndex(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public void selectDropdownByValue(WebElement element,String Value)
	{
		Select sel=new Select(element);
		sel.selectByValue(Value);
	}
	
	public void selectDropdownByVisibleText(WebElement element,String Text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(Text);
	}
	
	public void deSelectDropdownByIndex(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.deselectByIndex(index);
	}
	
	public void deSelectDropdownByValue(WebElement element,String Value)
	{
		Select sel=new Select(element);
		sel.deselectByValue(Value);
	}
	
	public void deSelectDropdownByVisibleText(WebElement element,String Text)
	{
		Select sel=new Select(element);
		sel.deselectByVisibleText(Text);
	}
	
	public void deSelectAllFromDropdown(WebElement element)
	{
		Select sel=new Select(element);
		sel.deselectAll();
	}
	
	public String getFirstSelectedOptionFromDropdown(WebElement element)
	{
		Select sel=new Select(element);
		return sel.getFirstSelectedOption().getText();
	}
	
	public List<WebElement> getAllSelectedOptionsFromDropdown(WebElement element)
	{
		Select sel=new Select(element);
		return sel.getAllSelectedOptions();
	}
	
	public List<WebElement> getAllOptionsFromDropdown(WebElement element)
	{
		Select sel=new Select(element);
		return sel.getOptions();
	}
	
	public void moveMouseToElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element);
		action.perform();
	}
	
	public void mouseClick(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.click();
		action.perform();
	}
	
	public void mouseClickElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.click(element);
		action.perform();
	}
	
	public void mouseContextClick(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.contextClick();
		action.perform();
	}
	
	public void mouseContextClickElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element);
		action.perform();
	}
	
	public void mouseDoubleClick(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.doubleClick();
		action.perform();
	}
	
	public void mouseDoubleClickElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element);
		action.perform();
	}
	
	public void mouseClickAndHold(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.clickAndHold();
		action.perform();
	}
	
	public void mouseClickAndHoldElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.clickAndHold(element);
		action.perform();
	}
	
	public void mouseRelease(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.release();
		action.perform();
	}
	
	public void mouseReleaseElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.release(element);
		action.perform();
		
	}
	
	public void mouseScrollToElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.scrollToElement(element);
		action.perform();	
	}
	
	public void mouseDragAndDropElement(WebDriver driver,WebElement draggable,WebElement droppable)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(draggable, droppable);
		action.perform();	
	}
	
	public void switchFrameByIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchFrameByNameOrId(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchFrameByElement(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchFrameToMainPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public void switchFrameToParent(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	public boolean isWebElementPresent(WebElement element)
	{
		return element.isDisplayed();
	}
	
	public void clearWebElementText(WebElement element)
	{
		element.clear();
	}
	
	public void takeScreenshotOfWebElement(WebElement element,String screenshotName)
	{
		File path=new File("./Screenshots/"+screenshotName+".png");
		File img=element.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(img,path);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void takeScreenshotOfWebPage(WebDriver driver,String screenshotName)
	{
		File path=new File("./Screenshots/"+screenshotName+".png");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File img=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(img,path);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
