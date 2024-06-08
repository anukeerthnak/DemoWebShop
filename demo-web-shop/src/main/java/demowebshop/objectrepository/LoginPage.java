package demowebshop.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@FindAll({@FindBy(id="Email"),@FindBy(name = "Email")})
	private WebElement emailIdTextField;
	
	@FindAll({@FindBy(id="Password"),@FindBy(name="Password")})
	private WebElement passwordTextField;
	
	@FindAll({@FindBy(css = "[class='button-1 login-button']"),@FindBy(xpath = "//input[@value='Log in']")})
	private WebElement loginButton;


	
	public WebElement getEmailIdTextField() {
		return emailIdTextField;
	}

	
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
}
