package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features="src/resource/java",
glue = "Steps",
monochrome = true,
tags = "@Tag",
plugin= {"html:target/cucumber-report.html", "json:target/cucumber.json"}
		
		)
public class TestRunner {

}
