package apple.bbd.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import apple.bbd.framework.base.BaseSetUp;

public class AcountPage extends BaseSetUp{
	
	public AcountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(id = "accountLink")
	public WebElement accountLink;
	
	@FindBy(xpath = "//input[@id='nameInput']")
	public WebElement nameInputUpdate;
	
	@FindBy(id = "phoneNumberInput")
	public WebElement phoneNumberInputUpdate;
	
	@FindBy(id = "personalUpdateBtn")
	public WebElement personalUpdateBtn;
	
	@FindBy(css = "h1.account__information-username")
	public WebElement infoUsernameUpdate;
	
	@FindBy(id = "previousPasswordInput")
	public WebElement previousPasswordInput;
	
	@FindBy(id = "newPasswordInput")
	public WebElement newPasswordInput;
	
	@FindBy(id = "confirmPasswordInput")
	public WebElement confirmPasswordInput;
	
	@FindBy(id = "credentialsSubmitBtn")
	public WebElement changePasswordBtn;
	
	@FindBy(xpath = "//div[text()='Password Updated Successfully']")
	public WebElement passwordChangedPop;
	
	
	@FindBy(xpath = "//p[text()='Add a payment method']")
	public WebElement paymentLinkclick;
	
	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberInput;
	
	@FindBy(id = "nameOnCardInput")
	public WebElement nameOnCardInput;
	
	@FindBy(id = "expirationMonthInput")
	public WebElement expirationMonthInput;
	
	@FindBy(id = "expirationYearInput")
	public WebElement expirationYearInput;
	
	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeInput;
	
	@FindBy(id = "paymentSubmitBtn")
	public WebElement paymentSubmitBtn;
	
	@FindBy(xpath = "//button[text()='Edit']")
	public WebElement cardEditBtn;
	
	@FindBy(xpath = "//div[text()='Payment Method added sucessfully']")
	public WebElement PaymentMethodAddedSuccessfully;
	@FindBy(xpath = "//div[text()='Payment Method updated Successfully']")
	public WebElement PaymentMethodupdatedSuccessfully;
	
	@FindBy(css = "p.account__payment-sub-title")
	public WebElement clickOnMasterCard;
	
	@FindBy(xpath = "//button[text()='remove']")
	public WebElement removeBtn;
	
	//Address
	
	@FindBy(css = "svg.account__address-new-icon")
	public WebElement addAddressClick;
	
	@FindBy(id = "countryDropdown")
	public WebElement countryDropdown;
	
	@FindBy(id = "fullNameInput")
	public WebElement addressfullNameInput;
	
	@FindBy(xpath =   "/html/body/div/div[3]/div[2]/div/div/form/div[3]/input")
	public WebElement phoneNumberInputAddress;
	
	@FindBy(id = "streetInput")
	public WebElement streetInput;
	
	@FindBy(id = "apartmentInput")
	public WebElement apartmentInput;
	
	@FindBy(id = "cityInput")
	public WebElement cityInput;
	
	@FindBy(xpath = "//select[@name='state']")
	public WebElement stateDropDown;
	
	@FindBy(id = "zipCodeInput")
	public WebElement zipCodeInput;
	
	@FindBy(id = "addressBtn")
	public WebElement addressBtn;
	
	@FindBy(xpath = "//div[text()='Address Added Successfully']")
	public WebElement AddressAddedSuccessfully;
	
	//update address
	
	@FindBy(css = "button.account__address-btn")
	public WebElement editAddressBtn;
	
	@FindBy( id = "addressBtn")
	public WebElement UpdateAddressBtn;
	
	@FindBy(xpath = "//div[text()='Address Updated Successfully']")
	public WebElement AddressUpdatedSuccessfully;
	
	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement RemoveAddress;
	
	@FindBy(css = "div.account__address-single")
	public WebElement addressBar;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
