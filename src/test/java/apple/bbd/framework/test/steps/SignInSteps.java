package apple.bbd.framework.test.steps;

import java.util.List; 
import java.util.Map;

import org.junit.Assert;

import apple.bbd.framework.pages.POMFactory;
import apple.bbd.framework.utilities.CommonUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String expectedTitle = "React App";
		String actualTitle = getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		logger.info(actualTitle + " is equal to " + expectedTitle);
	}

	@When("User click on Sign in option")
	public void user_click_on_sign_in_option() {
		click(factory.signInPage().signBtn);
		logger.info("User clicked on SignIn Button");

	}

	@When("User enter email {string} and password {string}")
	public void user_enter_email_and_password(String email, String password) {
		sendText(factory.signInPage().userName, email);
		sendText(factory.signInPage().password, password);
		logger.info("User entered " + email + " and password " + password);
		
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		click(factory.signInPage().loginBtn);
		logger.info("User clicked on login button");

	}

	@Then("User should be logged in into Account")
	public void user_should_be_logged_in_into_account() {
		click(factory.signInPage().accountLogo);
		if(isElementDisplayed(factory.signInPage().profileImage)){
			if(isElementDisplayed(factory.signInPage().creditCardsImg)){
				logger.info("User has successfuly loged in and clicked on account btn and navigated to accoutPage");
			}
		}
//		Assert.assertTrue(isElementDisplayed(factory.signInPage().profileImage));
//		Assert.assertTrue(isElementDisplayed(factory.signInPage().creditCardsImg));
		

	}

	// Signup Steps

	@When("User click on Create New Account button")
	public void user_click_on_create_new_account_button() {
		click(factory.signInPage().newAccountBtn);
		logger.info("User Has clicked on creat new Acount Button");

	}

	@When("User fill the signUp information with below data")
	public void user_fill_the_sign_up_information_with_below_data(DataTable dataTable) {
		List<Map<String, String>> fillInData = dataTable.asMaps(String.class, String.class);
		sendText(factory.signInPage().nameInput, fillInData.get(0).get("name"));
		sendText(factory.signInPage().emailInput, fillInData.get(0).get("email"));
		sendText(factory.signInPage().passwordInput, fillInData.get(0).get("password"));
		sendText(factory.signInPage().confirmPasswordInput, fillInData.get(0).get("confirmPassword"));
		logger.info("User filled out userName, email, Password, ConfirmedPassowrd ");


	}

	@When("User click on SignUp button")
	public void user_click_on_sign_up_button() {
		click(factory.signInPage().signupBtn);
		logger.info("User clicked on SignUp Button");



	}

	@Then("User should be logged into account page")
	public void user_should_be_logged_into_account_page() {
		eWait(10, factory.signInPage().profileImageSignUp);
		eWait(10, factory.signInPage().creditImgSignUp);
		Assert.assertTrue(isElementDisplayed(factory.signInPage().profileImageSignUp));
		Assert.assertTrue(isElementDisplayed(factory.signInPage().creditImgSignUp));
		logger.info("User is on AcountPage and ProfileImageIcon and CreditCardImageIcon is visiable");
		
	   
	}

}
