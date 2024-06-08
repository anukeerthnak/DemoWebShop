package demowebshop.functionalscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import demowebshop.fileutility.ReadExcel;
import demowebshop.fileutility.ReadProperties;

public class LoginFunctionalTest  {

	
	@DataProvider
	public Object[][] dataSupplier() {
		ReadExcel read=new ReadExcel();
		Object [][] data=read.getMultipleData("LoginTest");
		return data;
	}
	
	
	@Test(dataProvider="dataSupplier")
	public void loginTest(String userName,String password)
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		ReadProperties read=new ReadProperties();
		String url=read.fetchProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.findElement(By.partialLinkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(userName);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.quit();
	}
}
