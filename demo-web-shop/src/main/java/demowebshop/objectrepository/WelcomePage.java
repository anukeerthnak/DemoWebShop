package demowebshop.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage {

	public WelcomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindAll({@FindBy(partialLinkText = "Log in"),@FindBy(className ="ico-login")})
	private WebElement loginLink;

	public WebElement getLoginLink() {
		return loginLink;
	}
	
   
}
