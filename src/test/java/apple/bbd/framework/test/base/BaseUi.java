package apple.bbd.framework.test.base;

import apple.bbd.framework.utilities.CommonUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class BaseUi extends CommonUtility{
	
	
	
	
	
	@Before
	public void setUpTest() {
		super.setUpBrowser();
	}
	
	
	
	@After
	public void closeTest(Scenario seca) {
		
		if(seca.isFailed()) {
			byte[] screenShot = takeScreenShotAsBytes();
			seca.attach(screenShot, "image/png", seca.getName()+"test failed");
		}
		
		super.quitBrowser();
		
	}
	
	
	
	
	
	
	

}
