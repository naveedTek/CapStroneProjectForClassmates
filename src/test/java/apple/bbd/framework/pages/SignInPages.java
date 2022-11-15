package apple.bbd.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import apple.bbd.framework.base.BaseSetUp;

public class SignInPages extends BaseSetUp{
	
	
	public SignInPages() {
		
		PageFactory.initElements(getDriver(), this);
		
	}
	
	//SignIn Locators
	
	@FindBy(id="signinLink")
	public WebElement signBtn;
	
	@FindBy(id= "email")
	public WebElement userName;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "loginBtn")
	public WebElement loginBtn;
	
	@FindBy(linkText = "Account")
	public WebElement accountLogo;
	
	@FindBy(id = "profileImage")
	public WebElement profileImage;
	
	@FindBy(xpath = "//img[@alt='credit cards']")
	public WebElement creditCardsImg;
	
	//SignUp Locators
	
	
	@FindBy(id = "newAccountBtn")
	public WebElement newAccountBtn;
	
	@FindBy(id = "nameInput")
	public WebElement nameInput;
	
	@FindBy(id = "emailInput")
	public WebElement emailInput;
	
	@FindBy(id = "passwordInput")
	public WebElement passwordInput;
	
	@FindBy(id = "confirmPasswordInput")
	public WebElement confirmPasswordInput;
	
	@FindBy(id = "signupBtn")
	public WebElement signupBtn;
	
	@FindBy(xpath = "//img[@alt='credit cards']")
	public WebElement creditImgSignUp;
	
	@FindBy(id = "profileImage")
	public WebElement profileImageSignUp;
	
	
	
	
	

}
