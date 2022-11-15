package apple.bbd.framework.test.steps;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.Address;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import apple.bbd.framework.pages.POMFactory;
import apple.bbd.framework.utilities.CommonUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AccountSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User click on Account option")
	public void user_click_on_account_option() {
		click(factory.accountPage().accountLink);
		logger.info("User clicked on AcountOption");

	}

	@When("User update Name {string} and Phone {string}")
	public void user_update_name_name_value_and_phone_phone_value(String name, String phoneNumber) {
		clearTextUsingSendKeys(factory.accountPage().nameInputUpdate);

		sendText(factory.accountPage().nameInputUpdate, name);

		sendText(factory.accountPage().phoneNumberInputUpdate, phoneNumber);
		logger.info("User updated Name: " + name + " and phoneNUmber: " + phoneNumber);

	}

	@When("User click on Update button")
	public void user_click_on_update_button() {
		click(factory.accountPage().personalUpdateBtn);
		logger.info("User clicked on Update Button");

	}

	@Then("user profile information should be updated")
	public void user_profile_information_should_be_updated() {

		 eWait(20,factory.accountPage().infoUsernameUpdate);
		String expectedUserName = getText(factory.accountPage().infoUsernameUpdate);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().infoUsernameUpdate));
		logger.info("User has updated user name to " + expectedUserName);

	}

	@When("User enter below information")
	public void user_enter_below_information(DataTable dataTable) {

		List<Map<String, String>> passwordList = dataTable.asMaps(String.class, String.class);

		waitTillPresence(factory.accountPage().previousPasswordInput);
		sendText(factory.accountPage().previousPasswordInput, passwordList.get(0).get("previousPassword"));
		sendText(factory.accountPage().newPasswordInput, passwordList.get(0).get("newPassword"));
		sendText(factory.accountPage().confirmPasswordInput, passwordList.get(0).get("confirmPassword"));
		logger.info("User Changed the Password");
	}

	@When("User click on Change Password button")
	public void user_click_on_change_password_button() {
		click(factory.accountPage().changePasswordBtn);
		logger.info("User clicked on changePassword Button");
slowDown(3000);
	}

	@Then("a message should Be displayed {string}")
	public void a_message_should_be_displayed_password_updated_successfully(String pasword) {

		String expectedText = pasword;
		
		
		String actualText = getText(factory.accountPage().passwordChangedPop);
		Assert.assertEquals(expectedText, actualText);
			logger.info("Password Successfuly changed");
		

	}

	@When("User click on Add a payment method link")
	public void user_click_on_add_a_payment_method_link() {

		click(factory.accountPage().paymentLinkclick);
		logger.info("user clicked on AddPaymentLink");
	}

	@When("User fill Debit or credit card information")
	public void user_fill_debit_or_credit_card_information(DataTable dataTable) {
		List<Map<String, String>> creditCardInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().cardNumberInput, creditCardInfo.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOnCardInput, creditCardInfo.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationYearInput, creditCardInfo.get(0).get("expirationYear"));
		selectByVisibleText(factory.accountPage().expirationMonthInput, creditCardInfo.get(0).get("expirationMonth"));
		sendText(factory.accountPage().securityCodeInput, creditCardInfo.get(0).get("securityCode"));
		logger.info("User filled up creditCard Informations");

	}

	@When("User click on Add your card button")
	public void user_click_on_add_your_card_button() {

		click(factory.accountPage().paymentSubmitBtn);
		logger.info("user clicked on submit payment method Button");

	}

	@Then("a message should be displayed‘Payment Method added sucessfully’")
	public void a_message_should_be_displayed_payment_method_added_successfully() {
		eWait(10, factory.accountPage().PaymentMethodupdatedSuccessfully);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().PaymentMethodAddedSuccessfully));
		logger.info("Payment Method added successfully");
		
	}

	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.accountPage().clickOnMasterCard);
		click(factory.accountPage().cardEditBtn);
		logger.info("user clicked on EditCard Button");
slowDown(2000);
	}

	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		clearTextUsingSendKeys(factory.accountPage().cardNumberInput);
		clearTextUsingSendKeys(factory.accountPage().nameOnCardInput);
		clearTextUsingSendKeys(factory.accountPage().securityCodeInput);
		

		List<Map<String, String>> updateCardInfo = dataTable.asMaps(String.class, String.class);

		sendText(factory.accountPage().cardNumberInput, updateCardInfo.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOnCardInput, updateCardInfo.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationYearInput, updateCardInfo.get(0).get("expirationYear"));
		selectByVisibleText(factory.accountPage().expirationMonthInput, updateCardInfo.get(0).get("expirationMonth"));
		sendText(factory.accountPage().securityCodeInput, updateCardInfo.get(0).get("securityCode"));
		logger.info("User Updated creditCard Informations");
		slowDown(2000);

	}

	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.accountPage().paymentSubmitBtn);
		logger.info("User clicked on Update Card Button");

	}

	@Then("a message should be displayed ‘Payment Method updated Successfully’")
	public void aMessageShouldBeDisplayedPaymentMethodUpdatedSuccessfully() {
		eWait(10, factory.accountPage().PaymentMethodupdatedSuccessfully);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().PaymentMethodupdatedSuccessfully));
			logger.info("Payment card Has successfully Updated");
			
		

	}

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.accountPage().clickOnMasterCard);
		click(factory.accountPage().removeBtn);
		logger.info("user clicked on removed card btn");

	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		if (!isElementDisplayed(factory.accountPage().clickOnMasterCard)) {
			logger.info("Card removed successfully");
		}

	}

	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.accountPage().addAddressClick);
		logger.info("User clicked On Add Address link");

	}

	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> AddressInfo = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.accountPage().countryDropdown, AddressInfo.get(0).get("country"));
		sendText(factory.accountPage().addressfullNameInput, AddressInfo.get(0).get("fullName"));
		slowDown(3000);
		
		clearTextUsingSendKeys(factory.accountPage().phoneNumberInputAddress);
		sendText(factory.accountPage().phoneNumberInputAddress, AddressInfo.get(0).get("phoneNumber"));
		sendText(factory.accountPage().streetInput, AddressInfo.get(0).get("streetAddress"));
		
		sendText(factory.accountPage().apartmentInput, AddressInfo.get(0).get("apt"));
		sendText(factory.accountPage().cityInput, AddressInfo.get(0).get("city"));
		
		selectByVisibleText(factory.accountPage().stateDropDown, AddressInfo.get(0).get("state"));
		sendText(factory.accountPage().zipCodeInput, AddressInfo.get(0).get("zipCode"));
		logger.info("User filled out the Address informaition ");
	}

	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.accountPage().addressBtn);
		logger.info("user clicked on add address button");
		slowDown(3000);
	}

	@Then("a message should be displayed ‘Address Added Successfully’")
	public void aMessageShouldBeDisplayedAddressAddedSuccessfully() {
        waitTillPresence(factory.accountPage().AddressAddedSuccessfully);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().AddressAddedSuccessfully));
			logger.info("Address Added successfully Massege shown");
		}

	
	
	
	//Update Address
	
	
	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(factory.accountPage().editAddressBtn);
		logger.info("User clicked on update Address");
	    
	}
	@When("user fill new address form  with below information")
	public void userfillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String , String>> upDateAdd = dataTable.asMaps(String.class,String.class);
		selectByVisibleText(factory.accountPage().countryDropdown, upDateAdd.get(0).get("country"));
		clearTextUsingSendKeys(factory.accountPage().addressfullNameInput);
		sendText(factory.accountPage().addressfullNameInput, upDateAdd.get(0).get("fullName"));
		clearTextUsingSendKeys(factory.accountPage().phoneNumberInputAddress);
		sendText(factory.accountPage().phoneNumberInputAddress, upDateAdd.get(0).get("phoneNumber"));
		clearTextUsingSendKeys(factory.accountPage().streetInput);
		sendText(factory.accountPage().streetInput, upDateAdd.get(0).get("streetAddress"));
		clearTextUsingSendKeys(factory.accountPage().apartmentInput);
		sendText(factory.accountPage().apartmentInput, upDateAdd.get(0).get("apt"));
		clearTextUsingSendKeys(factory.accountPage().cityInput);
		sendText(factory.accountPage().cityInput, upDateAdd.get(0).get("city"));
		selectByVisibleText(factory.accountPage().stateDropDown, upDateAdd.get(0).get("state"));
		clearTextUsingSendKeys(factory.accountPage().zipCodeInput);
		sendText(factory.accountPage().zipCodeInput, upDateAdd.get(0).get("zipCode"));
		logger.info("User filled out the Address informaition ");
		
	    
	}
	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(factory.accountPage().UpdateAddressBtn);
		logger.info("user clicked on updated address button");
		
	    
	}
	@Then("a message should be displayed ‘Address Updated Successfully’")
	public void aMessageShouldBeDisplayedAddressUpdatedSuccessfully() {
		waitTillPresence(factory.accountPage().AddressUpdatedSuccessfully);
	    Assert.assertTrue(isElementDisplayed(factory.accountPage().AddressUpdatedSuccessfully));
	    	logger.info("user Updated successfully");
	    	
	    }
	
	
	//Removed Address
	
	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(factory.accountPage().RemoveAddress);
		logger.info("user clicked on removed the Address button");
		  
	}
	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		
		if(!isElementDisplayed(factory.accountPage().addressBar));

			logger.info("Address removed Successfully");
			  

	    
	}
	
	
	
	
	
	
	
	
	
	

}
