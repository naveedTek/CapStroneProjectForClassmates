package apple.bbd.framework.test.steps;

import org.junit.Assert;

import apple.bbd.framework.pages.POMFactory;
import apple.bbd.framework.utilities.CommonUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class OrderSteps extends CommonUtility{
	POMFactory factory = new POMFactory();
	
	
	
	
	
	
	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(factory.orderPage().orderLinkClick);
		logger.info("User clicked on Order link");
	  
	}
	@When("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		click(factory.orderPage().elementclick);
		logger.info("User click on order");
	  
	}
	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
	    click(factory.orderPage().cancelBtn);
	    logger.info("User clicked on Cancel Order");
	}
	@When("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String string) {
		selectByVisibleText(factory.orderPage().reasonInput, string);
		logger.info("User selected the reason of cancelling the order");
	    
	}
	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.orderPage().orderSubmitBtn);
		logger.info("User clicked on submit cancelling order button");
	}
	
	
	@Then("a cancelation message should be displayed ‘Your Order Has Been Cancelled’")
	public void aCancelationMessageShouldBeDisplayedYourOrderHasBeenCancelled() {
		String expectedText = "Your Order Has Been Cancelled";
		String actualText = getText(factory.orderPage().cancelationMessage);
		Assert.assertEquals(expectedText, actualText);
		logger.info("cancelation message should be displayed as "+actualText );
	
	}	
	
	
	
	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(factory.orderPage().returnBtn);
		logger.info("User clicked on return button");
	    
	}
	@When("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String string) {
		selectByVisibleText(factory.orderPage().reasonInputReturn, string);
		logger.info("User selected the reason of returning");
	    
	}
	@When("User select the drop off service {string}")
	public void userSelectTheDropOffService(String string) {
		selectByVisibleText(factory.orderPage().dropOffInput, string);
		logger.info("User selected the drop off location");
	   
	}
	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(factory.orderPage().orderSubmitReturnBtn);
		logger.info("User successfully pressd the Return button");
	   
	}
	@Then("a cancelation message should be displayed ‘Return was successful’")
	public void aCancelationMessageShouldBeDisplayedReturnWasSuccessful() {
		String expectedText = "Return was successfull";
		String actualText = getText(factory.orderPage().returnOrderMessage);
		
		Assert.assertEquals(expectedText, actualText);
		logger.info("cancelation message displayed as "+actualText);
	}

	
	
	@When("User click on Review button")
	public void userClickOnReviewButton() {
		click(factory.orderPage().reviewBtn);
		logger.info("User clicked on review btn");
	   
	}
	@When("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String string, String string2) {
		sendText(factory.orderPage().headlineInput, string);
		sendText(factory.orderPage().descriptionInput, string2);
		logger.info("User wrote Review");
	   
	}
	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.orderPage().reviewSubmitBtn);
	logger.info("User Submited the review ");
	
	    
	}
	@Then("a review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayedYourReviewWasAddedSuccessfully(String message) {
		waitTillPresence(factory.orderPage().reviewSuccessMassage);
		
		String actualText = getText(factory.orderPage().reviewSuccessMassage);
		Assert.assertEquals(message,actualText);
		logger.info("review message displayed saccessfully>>>as "+actualText);
		
	}
	
	
	
	
	
	

}
