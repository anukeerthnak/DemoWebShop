package demowebshop.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}

	@FindAll({@FindBy(partialLinkText = "My account"),@FindBy(xpath = "//a[@class='account' and text()='My account']")})
	private WebElement myAccount;
	
	
	@FindAll({@FindBy(partialLinkText = "Addresses"),@FindBy(xpath = "//a[@class='inactive' and text()='Addresses']")})
	private WebElement addresses;
	
	
	public WebElement getMyAccount() {
		return myAccount;
	}


	public WebElement getAddresses() {
		return addresses;
	}
	

}
