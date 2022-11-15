package apple.bbd.framework.base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;

import javax.management.RuntimeErrorException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import apple.bbd.framework.config.Browser;
import apple.bbd.framework.config.ChromeBrowser;
import apple.bbd.framework.config.ChromeHeadlessBrowser;
import apple.bbd.framework.config.EdgeBrowser;
import apple.bbd.framework.config.FirefoxBrowser;
import apple.bbd.framework.utilities.ReadYamlFiles;

public class BaseSetUp {
	
	
	private static WebDriver driver;
	private final ReadYamlFiles environmentVariables;
	public static Logger logger;
	
	
	
	
	
	public BaseSetUp() {
		String yamlFile = System.getProperty("user.dir")+"/src/main/resources/Login.yml";
		String log4jFiles = System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
		
		try {
			environmentVariables = ReadYamlFiles.getInstanceYamlFiles(yamlFile);
		} catch (FileNotFoundException e) {
			System.out.println("wrong file path address");
			throw new RuntimeException("errors to the file path"+e.getMessage());
		}
		
		logger = Logger.getLogger("Logger_files");
		PropertyConfigurator.configure(log4jFiles);
			
		
	}
	
	
	public WebDriver getDriver() {
		return driver;
		
	}
	
	
	public void setUpBrowser() {
		HashMap uiProperties = environmentVariables.getYamlProperty("ui");
		String url = uiProperties.get("url").toString();
		Browser browser;
		switch(uiProperties.get("browser").toString().toLowerCase().trim()) {
		case"chrome":
			if((boolean) uiProperties.get("headless")) {
				browser = new ChromeHeadlessBrowser();
			}else {
				browser = new ChromeBrowser();
			}
			driver = browser.openBrowser(url);
			break;
		case"firefox":
			browser = new FirefoxBrowser();
			driver = browser.openBrowser(url);
			break;
		case"edge":
			browser = new EdgeBrowser();
			driver = browser.openBrowser(url);
			break;
			default:
				throw new RuntimeException("invalid browser type");
				
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	
	
	public void quitBrowser() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	
	
	

}
