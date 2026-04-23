package StepDefinition;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hook {
	public static WebDriver driver;
	Logger logger = LogManager.getLogger("Hook.class");

	@Before
	public void Start() {
		if (driver == null) {
			driver = new ChromeDriver();
			logger.info("Browser Open");
			driver.manage().window().maximize();
		}

	}

	@After
	public void tearDown(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
			String filePath = "C:\\Users\\dkhatua\\eclipse-workspace\\Sahaj_GAIL\\Failedscreenshots\\" + scenarioName
					+ "_" + timeStamp + ".png";
			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
			File desfile = new File(filePath);
			FileUtils.copyFile(scrfile, desfile);
			byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotBytes, "image/png", "Failed Scenario Screenshot");
			
			Allure.addAttachment(
	                "Failure Screenshot",
	                new ByteArrayInputStream(screenshotBytes));

		}
		if (driver != null) {
			// driver.quit();
		}
		logger.info("Application Closed");

	}

}
