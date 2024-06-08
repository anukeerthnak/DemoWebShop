package demowebshop.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindAll({@FindBy(partialLinkText = "Log out"),@FindBy(className ="ico-logout")})
	private WebElement logoutLink;
	
	
	@FindAll({@FindBy(xpath = "//span[text()='Shopping cart']"),@FindBy(xpath = "//span[@class='cart-label' and text()='Shopping cart']")})
	private WebElement shoppingCartLink;
	

	@FindAll({@FindBy(xpath = "(//a[contains(text(),'Books')])[3]"),@FindBy(xpath = "(//div[@class = 'listbox'])[1]/ul/li[1]/a")})
	private WebElement booksCategoryLink;
	
	

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}
	
	public WebElement getBooksCategoryLink() {
		return booksCategoryLink;
	}


}
