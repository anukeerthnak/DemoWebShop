package demowebshop.functionalscripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import demowebshop.baseclass.BaseClass;
import demowebshop.genericutility.WebDriverUtility;
import demowebshop.objectrepository.ComputingAndInternetProductPage;
import demowebshop.objectrepository.HomePage;

/**
 * @author ANU
 */


@Listeners(demowebshop.listenerimplementation.ListenerClass.class)
public class AddProductToCartTest extends BaseClass {
	
	
	@Test(retryAnalyzer = demowebshop.listenerimplementation.RetryListener.class)
	public void addProductToCartTest()
	{
		WebDriverUtility webDriverUtility =new WebDriverUtility();
		HomePage homePage=new HomePage(driver);
		ComputingAndInternetProductPage computingAndInternetProductPage=new ComputingAndInternetProductPage(driver);	
		
     	webDriverUtility.clickElement(homePage.getBooksCategoryLink());
     	test.log(Status.INFO,"Books Category link has been clicked");
		Assert.assertEquals(webDriverUtility.fetchCurrentUrl(driver).contains("books"), true);
		
		webDriverUtility.clickElement(computingAndInternetProductPage.getComputingAndInternetBookLink());
		test.log(Status.INFO,"Computing And Internet Book link has been clicked");
		Assert.assertEquals(webDriverUtility.fetchCurrentUrl(driver).contains("computing-and-internet"), true);
		
		webDriverUtility.clearWebElementText(computingAndInternetProductPage.getQuantityTextField());
		webDriverUtility.sendText(computingAndInternetProductPage.getQuantityTextField(),"2");
		webDriverUtility.clickElement(computingAndInternetProductPage.getAddToCartButton());
		test.log(Status.INFO,"AddToCart Button has been clicked");
		
		webDriverUtility.clickElement(homePage.getShoppingCartLink());
		test.log(Status.INFO,"ShoppingCart Link has been clicked");
		Assert.assertEquals(webDriverUtility.isWebElementPresent(computingAndInternetProductPage.getComputingAndInternetBookInCart()),true);

	
	}
}