package runner;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

public class RunerFiles {
	
	@Test
	public void testR() {
		JUnitCore.runClasses(TestRunner.class);
	}

	@RunWith(CucumberWithSerenity.class)
	@CucumberOptions( 
			plugin = {"pretty", "json:target/cucumber.json"},
			features = "src/test/resources/features", 
			tags = "@clonarExcel",
			snippets = CucumberOptions.SnippetType.CAMELCASE,
			glue = { "definitions" } )
	public class TestRunner {
	}

}
