package demowebshop.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ComputingAndInternetProductPage extends BasePage {

	public ComputingAndInternetProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindAll({@FindBy(xpath = "//div[@class='product-grid']/div[1]/div[1]/div[2]/h2/a")})
	private WebElement computingAndInternetBookLink;
	
	@FindAll({@FindBy(id = "addtocart_13_EnteredQuantity"),@FindBy(name = "addtocart_13.EnteredQuantity")})
	private WebElement quantityTextField;
	
	@FindAll({@FindBy(id = "add-to-cart-button-13"),@FindBy(css = "[class= 'button-1 add-to-cart-button']")})
	private WebElement addToCartButton;
	
	@FindAll({@FindBy(xpath = "//a[@class='product-name' and text()='Computing and Internet']")})
	private WebElement computingAndInternetBookInCart;

	public WebElement getComputingAndInternetBookLink() {
		return computingAndInternetBookLink;
	}
	
	public WebElement getQuantityTextField() {
		return quantityTextField;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public WebElement getComputingAndInternetBookInCart() {
		return computingAndInternetBookInCart;
	}
	
	

}
