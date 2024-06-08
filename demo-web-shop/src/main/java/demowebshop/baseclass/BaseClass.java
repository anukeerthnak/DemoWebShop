package demowebshop.baseclass;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.Status;

import demowebshop.fileutility.ReadProperties;
import demowebshop.genericutility.WebDriverUtility;
import demowebshop.listenerimplementation.ListenerClass;
import demowebshop.objectrepository.HomePage;
import demowebshop.objectrepository.LoginPage;
import demowebshop.objectrepository.WelcomePage;

/**
 * @author ANU
 */
public class BaseClass extends ListenerClass{
	
	
	    public WebDriver driver;
		public static WebDriver sdriver;
		
		ReadProperties read=new ReadProperties();
		WebDriverUtility webDriverUtility =new WebDriverUtility();
		
		@BeforeClass
		public void openBrowser() 
		{
			String browser = System.getProperty("browser");
			if (browser.contains("Chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(browser.contains("Edge"))
			{
				driver = new EdgeDriver();
			}
			sdriver=driver;
			driver.manage().window().maximize();
			String url=read.fetchProperty("url");
			webDriverUtility.getWebpage(driver, url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		}
		
		@BeforeMethod
		public void login()
		{
			
			WelcomePage welcomePage= new WelcomePage(driver);
			HomePage homePage=new HomePage(driver);
			webDriverUtility.clickElement(welcomePage.getLoginLink());
			
			Assert.assertEquals(webDriverUtility.fetchCurrentUrl(driver).contains("login"), true);
			String un=read.fetchProperty("username");
			String pwd=read.fetchProperty("password");
			LoginPage loginPage=new LoginPage(driver);
			webDriverUtility.sendText(loginPage.getEmailIdTextField(), un);
			
			webDriverUtility.sendText(loginPage.getPasswordTextField(), pwd);
			
			webDriverUtility.clickElement(loginPage.getLoginButton());
			
			Assert.assertEquals(webDriverUtility.isWebElementPresent(homePage.getLogoutLink()),true);

			
//			wp.getLoginButton().click();		
//			String un=read.fetchProperty("username");
//			String pwd=read.fetchProperty("password");
//			LoginPage lp=new LoginPage(driver);
//			lp.getEmailIdTextField().sendKeys(un);
//			lp.getPasswordTextField().sendKeys(pwd);
//			lp.getLoginButton1().click();
			
		}
		
		@AfterClass
		public void closeBrowser()
		{
			webDriverUtility.closeBrowser(driver);
			
			//driver.quit();
			
		}
		
		@AfterMethod
		public void logout()
		{
			WelcomePage welcomePage= new WelcomePage(driver);
			HomePage homePage=new HomePage(driver);
			webDriverUtility.mouseClickElement(driver,homePage.getLogoutLink());
			
			Assert.assertEquals(webDriverUtility.isWebElementPresent(welcomePage.getLoginLink()),true);

			
			//webDriverUtility.clickElement(loginPage.getLogoutButton());
			//lp1.getLogoutButton();
			
		}

	}


