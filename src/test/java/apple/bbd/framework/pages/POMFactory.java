package apple.bbd.framework.pages;

import apple.bbd.framework.base.BaseSetUp;

public class POMFactory extends BaseSetUp{
	
	
	private SignInPages signInPage;
	private AcountPage accountPage;
	private RetailHomePage homePage;
	private OrderPage orderPage;
	
	public POMFactory() {
		this.signInPage = new SignInPages();
		this.accountPage = new AcountPage();
		this.homePage = new RetailHomePage();
		this.orderPage = new OrderPage();
	}
	
	
	
	public SignInPages signInPage() {
		return signInPage;
	}
	
	public AcountPage accountPage() {
		return accountPage;
	}
	
	
	public RetailHomePage homePage() {
		return this.homePage;
	}
	
	public OrderPage orderPage() {
		return this.orderPage;
	}
	
	
	

}
