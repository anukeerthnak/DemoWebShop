package demowebshop.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePage {

	public AddressPage(WebDriver driver) {
		super(driver);
		
	}

	@FindAll({@FindBy(css = "[class='button-1 add-address-button']"),@FindBy(xpath = "//input[@value='Add new']")})
	private WebElement addNewButton;
	
	@FindAll({@FindBy(id = "Address_FirstName"),@FindBy(name = "Address.FirstName")})
	private WebElement firstNameTextField;

	@FindAll({@FindBy(id = "Address_LastName"),@FindBy(name = "Address.LastName")})
	private WebElement lastNameTextField;
	
	@FindAll({@FindBy(id = "Address_Email"),@FindBy(name = "Address.Email")})
	private WebElement emailTextField;
	
	@FindAll({@FindBy(id = "Address_CountryId"),@FindBy(name = "Address.CountryId")})
	private WebElement countryDropDown;
	
	@FindAll({@FindBy(id = "Address_City"),@FindBy(name = "Address.City")})
	private WebElement cityTextField;
	
	@FindAll({@FindBy(id = "Address_Address1"),@FindBy(name = "Address.Address1")})
	private WebElement address1TextField;
	
	@FindAll({@FindBy(id = "Address_ZipPostalCode"),@FindBy(name = "Address.ZipPostalCode")})
	private WebElement zipPostalCodeTextField;
	
	@FindAll({@FindBy(id = "Address_PhoneNumber"),@FindBy(name="Address.PhoneNumber")})
	private WebElement phoneNumberTextField;
	
	@FindAll({@FindBy(xpath = "//input[@value='Save']"),@FindBy(css = "[class='button-1 save-address-button']")})
	private WebElement saveButton;
	
	public WebElement getAddNewButton() {
		return addNewButton;
	}
	
	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getCountryDropDown() {
		return countryDropDown;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public WebElement getAddress1TextField() {
		return address1TextField;
	}

	public WebElement getZipPostalCodeTextField() {
		return zipPostalCodeTextField;
	}

	public WebElement getPhoneNumberTextField() {
		return phoneNumberTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	
	
}
