package apple.bbd.framework.test.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.zip.UnicodePathExtraField;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import apple.bbd.framework.pages.POMFactory;
import apple.bbd.framework.utilities.CommonUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RetailHomeSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().AllOptionBtn);
		logger.info("user clicked on All Option Button");
	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> AllOptiondata = dataTable.asLists(String.class);
		List<String> elements = new ArrayList<String>();
		elements.add(getText(factory.homePage().elictronics));
		elements.add(getText(factory.homePage().computers));
		elements.add(getText(factory.homePage().homeSmart));
		elements.add(getText(factory.homePage().sports));
		elements.add(getText(factory.homePage().automative));
		String expectedText = AllOptiondata.get(0).toString();
		Assert.assertEquals(elements.toString(), expectedText);

	}

	String angel;

	@When("User on {string}")
	public String userOnElectronics(String department) {

		switch (department) {
		case "Electronics":
			Assert.assertTrue(isElementDisplayed(factory.homePage().elictronics));
			logger.info("user is on Electronics section");
			break;
		case "Computers":
			Assert.assertTrue(isElementDisplayed(factory.homePage().computers));
			logger.info("user is on Computers section");
			break;
		case "Sports":
			Assert.assertTrue(isElementDisplayed(factory.homePage().sports));
			logger.info("user is on Sports section");
			break;
		case "Automotive":
			Assert.assertTrue(isElementDisplayed(factory.homePage().automative));
			logger.info("user is on Automotive section");
			break;
		default:

		}

		return this.angel = department;

	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> department = dataTable.asLists();

		switch (this.angel) {
		case "Electronics":
			click(factory.homePage().elictronics);
			String video = getText(factory.homePage().VideoGames);
			String TVAndVideo = getText(factory.homePage().TVAndVideo);
			Assert.assertEquals(TVAndVideo, department.get(0).get(0));
			Assert.assertEquals(video, department.get(0).get(1));
			logger.info(video + " options are present in department" + TVAndVideo);
			break;
		case "Computers":
			click(factory.homePage().computers);
			String Accessories = getText(factory.homePage().Accessories);
			String Networking = getText(factory.homePage().Networking);
			Assert.assertEquals(Accessories, department.get(0).get(0));
			Assert.assertEquals(Networking, department.get(0).get(1));
			logger.info(Accessories + " options are present in department" + Networking);
			break;
		case "Sports":
			click(factory.homePage().sports);
			String AthleticClothing = getText(factory.homePage().AthleticClothing);
			String ExerciseFitness = getText(factory.homePage().ExerciseFitness);
			Assert.assertEquals(AthleticClothing, department.get(0).get(0));
			Assert.assertEquals(ExerciseFitness, department.get(0).get(1));
			logger.info(AthleticClothing + " options are present in department" + ExerciseFitness);
			break;
		case "Automotive":
			click(factory.homePage().automative);
			String AutomativePartsAccessories = getText(factory.homePage().AutomativePartsAccessories);
			String MotorCyclePowersports = getText(factory.homePage().MotorCyclePowersports);
			Assert.assertEquals(AutomativePartsAccessories, department.get(0).get(0));
			Assert.assertEquals(MotorCyclePowersports, department.get(0).get(1));
			logger.info(MotorCyclePowersports + " options are present in department" + AutomativePartsAccessories);
			break;

		}

	}
	
	
	
	@When("User change the category to {string}")
	public void user_change_the_category_to(String string) {
		selectByVisibleText(factory.homePage().allDepartmentdorpDown, string);
		logger.info("the category has been changed to Smart Home");
		slowDown(3000);
	   
	}

	@When("User search for an item {string}")
	public void user_search_for_an_item(String string) {
	    sendText(factory.homePage().searchInput, string);
	    logger.info("User searched for <<kasa outdoor smart plug>>");
	    slowDown(3000);
	}

	@When("User click on Search icon")
	public void user_click_on_search_icon() {
	    click(factory.homePage().searchBtn);
	    logger.info("User clicked on search button");
	    slowDown(3000);
	}

	@When("User click on item")
	public void user_click_on_item() {
		click(factory.homePage().addItem);
	   logger.info("User clicked on item ");
	   slowDown(3000);
	}

	@When("User select quantity {string}")
	public void user_select_quantity(String qtn1) {
		selectByVisibleText(factory.homePage().quantity, qtn1 );
		logger.info("User selected quantity of the item");
		slowDown(3000);
	    
	}

	@When("User click add to Cart button")
	public void user_click_add_to_cart_button() {
		click(factory.homePage().addToCartBtn);
		logger.info("User clicked on add to cart btn");
		slowDown(3000);
	    
	}

	@Then("the cart icon quantity should change to {string}")
	public void the_cart_icon_quantity_should_change_to(String qyt) {
		String qyn = getText(factory.homePage().cartQuantity);
		Assert.assertEquals(qyn, qyt);
		logger.info(qyt + " as asked User successfully added "+ qyn);
		slowDown(3000);
	    
	}
	
	
	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.homePage().cartBtn);
		logger.info("User clicked on Cart Option");
		slowDown(3000);
	  
		
	}
	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.homePage().proceedBtn);
		logger.info("User clicked on proceed cheackout button");
		slowDown(3000);
		
	}
	@Then("User click Add a new address link for shipping address")
	public void userClickAddANewAddressLinkForShippingAddress() {
		click(factory.homePage().addAddressBtnCart);
		logger.info("User clicked on add address link");
		slowDown(3000);
		
	}
	@Then("User fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String , String >> addAddress = dataTable.asMaps(String.class,String.class);
		selectByVisibleText(factory.accountPage().countryDropdown, addAddress.get(0).get("country"));
		sendText(factory.accountPage().addressfullNameInput, addAddress.get(0).get("fullName"));
		sendText(factory.accountPage().phoneNumberInputAddress, addAddress.get(0).get("phoneNumber"));
		sendText(factory.accountPage().streetInput, addAddress.get(0).get("streetAddress"));
		sendText(factory.accountPage().apartmentInput, addAddress.get(0).get("apt"));
		sendText(factory.accountPage().cityInput, addAddress.get(0).get("city"));
		selectByVisibleText(factory.accountPage().stateDropDown, addAddress.get(0).get("state"));
		sendText(factory.accountPage().zipCodeInput, addAddress.get(0).get("zipCode"));
		slowDown(3000);
		
	}
	
//	@And ("User click Add Your Address button")
//	public void UserclickAddYourAddressbutton() {
//		click(factory.accountPage().addressBtn);
//		logger.info("User added the address successfully");
//	}
	@Then("User click Add a credit card or Debit Card for Payment method")
	public void userClickAddACreditCardOrDebitCardForPaymentMethod() {
		click(factory.homePage().addPaymentBtnCart);
		logger.info("User clicked on Add credit btn");
		slowDown(3000);
	    
	}
	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.homePage().placeOrderBtn);
		logger.info("User clicked on places order button");
		slowDown(3000);
	   
	}
	@Then("a message should be displayed ‘Order Placed, Thanks’")
	public void aMessageShouldBeDisplayedOrderPlacedThanks() {
		String actualTest = getText(factory.homePage().thankYouMessage);
		String expectedText = "Order Placed, Thanks";
		Assert.assertEquals(actualTest, expectedText);
		logger.info( "Message Displayed as Expected "+actualTest);
		slowDown(3000);
	  
	}
	
	
	
	
	
	
	
	

}
