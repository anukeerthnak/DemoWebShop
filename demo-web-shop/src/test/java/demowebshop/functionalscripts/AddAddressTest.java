package demowebshop.functionalscripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import demowebshop.baseclass.BaseClass;
import demowebshop.genericutility.WebDriverUtility;
import demowebshop.objectrepository.AddressPage;
import demowebshop.objectrepository.MyAccountPage;

/**
 * @author ANU
 */

@Listeners(demowebshop.listenerimplementation.ListenerClass.class)
public class AddAddressTest extends BaseClass {
		
		@Test(retryAnalyzer = demowebshop.listenerimplementation.RetryListener.class)
		public void addAddressTest()
		{
			WebDriverUtility webDriverUtility =new WebDriverUtility();
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			AddressPage addressPage= new AddressPage(driver);
			
			webDriverUtility.clickElement(myAccountPage.getMyAccount());
			test.log(Status.INFO,"My Account link has been clicked");
			Assert.assertEquals(webDriverUtility.fetchCurrentUrl(driver).contains("info"), true);
			
			
			webDriverUtility.clickElement(myAccountPage.getAddresses());
			test.log(Status.INFO,"Addresses link has been clicked");
			Assert.assertEquals(webDriverUtility.fetchCurrentUrl(driver).contains("addresses"), true);
			
			
			webDriverUtility.clickElement(addressPage.getAddNewButton());
			test.log(Status.INFO,"Add Address button has been clicked"); 
			Assert.assertEquals(webDriverUtility.fetchCurrentUrl(driver).contains("addressadd"), true);
			
			
			webDriverUtility.sendText(addressPage.getFirstNameTextField(), "Anu");
			webDriverUtility.sendText(addressPage.getLastNameTextField(), "Kannan");
			webDriverUtility.sendText(addressPage.getEmailTextField(), "anukeerthnakannan@gmail.com");
			webDriverUtility.selectDropdownByVisibleText(addressPage.getCountryDropDown(),"India");
            webDriverUtility.sendText(addressPage.getCityTextField(), "Chennai");
			webDriverUtility.sendText(addressPage.getAddress1TextField(), "Velachery");
			webDriverUtility.sendText(addressPage.getZipPostalCodeTextField(), "600042");
			webDriverUtility.sendText(addressPage.getPhoneNumberTextField(), "9863223262");
			test.log(Status.INFO,"Address Details has been entered"); 
			
			webDriverUtility.clickElement(addressPage.getSaveButton());
			test.log(Status.INFO,"Save Button has been clicked");
			Assert.assertEquals(webDriverUtility.fetchCurrentUrl(driver).contains("addresses"), true);
			
		}

	}

