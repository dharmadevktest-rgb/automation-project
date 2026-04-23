package StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjectModel.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Stepdefinition {

	WebDriver driver;
	Logger logger;
	Login login;

	public Stepdefinition() {
		this.driver = Hook.driver;
		this.logger = LogManager.getLogger(Stepdefinition.class);
		this.login = new Login(driver);

	}

	@Given("the user launches the website {string}")
	public void the_user_launches_the_website(String url) {
		logger.info("Launching website: {}", url);
		driver.get(url);
		logger.info("URL Opened");
	}

	@When("the user enters a valid email id {string}")
	public void the_user_enters_a_valid_email_id(String email) {
		login.Enterusername(email);
		logger.info("Username: {}" + email);
	}

	@When("the user enters a valid password {string}")
	public void the_user_enters_a_valid_password(String password) {
		login.Enteruserpassword(password);
		logger.info("Userpassword: {}" + password);

	}

	@When("the user enters the captcha manually")
	public void the_user_enters_the_captcha_manually() throws Exception {
		login.Clickonthecaptchafield();
		Thread.sleep(10000);
		logger.info("Captcha Entered");

	}

	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
		login.ClickontheLogin();
		logger.info("Login clicked");

	}

	@When("the user clicks on the force login button")
	public void the_user_clicks_on_the_force_login_button() throws Exception {
		login.clickOnForceLogin();
		logger.info("Force Login clicked");
	}

	@When("the user enters a valid otp {string}")
	public void the_user_enters_a_valid_otp(String otp) throws Exception {
		login.Enterotp(otp);
		logger.info("OTP Entered");
	}

	@When("the user re-enters the captcha")
	public void the_user_re_enters_the_captcha() throws Exception {
		login.Entersecondcaptcha();
		logger.info("Second Captcha");
	}

	@When("the user clicks on the verify button")
	public void the_user_clicks_on_the_verify_button() throws Exception {
		login.Finalverify();
		Thread.sleep(1000);
		logger.info("Verified");
	}

}
