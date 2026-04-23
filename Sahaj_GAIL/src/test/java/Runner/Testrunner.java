package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "Features\\Login\\login.feature", glue = {
		"StepDefinition" }, dryRun = false, monochrome = true, plugin = { "pretty", "html:target/Report/reports.html",
				"json:target/Report/report.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })

public class Testrunner extends AbstractTestNGCucumberTests {

}
