package apple.bbd.framework.test.runner;

import io.cucumber.junit.Cucumber; 
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

import org.junit.runner.RunWith;




@RunWith(Cucumber.class)	
@CucumberOptions(
	
	tags = "",
	features = "src/test/resources/Features",
	glue = "apple.bbd.framework.test",
	dryRun = false,
	
	plugin = {
			
			"pretty",
			"html:target/Htmlreports/html-report.html",
			"json:target/Jsonreports/Json-report.json"
	},
	
	snippets = CAMELCASE,
	monochrome = true)




public class TestRunner {
	
	

	
	
	
	
	

}
