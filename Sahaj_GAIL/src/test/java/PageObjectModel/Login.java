package PageObjectModel;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class Login {

	public WebDriver driver;
	public WebDriverWait wait;
	public Logger logger;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		logger = LogManager.getLogger(Login.class);
	}

	@FindBy(xpath = "//input[@id='UserName']")
	WebElement username;

	@Step("Enter username")
	public void Enterusername(String UserName) {
		wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(UserName);
		logger.info("Entered username:" + UserName);
	}

	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;
	
	@Step("Enter password")
	public void Enteruserpassword(String Password) {
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(Password);
		logger.info("Entered Password" + Password);
	}

	@FindBy(xpath = "//input[@id='CaptchaInputText']")
	WebElement captcha;

	@Step("Click on captcha field for manual entry")
	public void Clickonthecaptchafield() {
		wait.until(ExpectedConditions.elementToBeClickable(captcha));
		captcha.click();
		logger.info("Entered captcha" + captcha);
	}

	@FindBy(xpath = "//button[text()='Login']")
	WebElement login;

	@Step("Click on Login button")
	public void ClickontheLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(login));
		login.click();
		logger.info("Login click:" + login);
	}

	@FindBy(xpath = "//button[text()='Force Login !']")
	WebElement forceLogin;

	@Step("Click on Force Login button")
	public void clickOnForceLogin() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(forceLogin));
		wait.until(ExpectedConditions.elementToBeClickable(forceLogin));
		Thread.sleep(10000);
		forceLogin.click();
		logger.info("Force Login clicked");
	}

	@FindBy(xpath = "//input[@id='OTP']")
	WebElement otp;

	@Step("Enter OTP")
	public void Enterotp(String Otp) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(otp));
		Thread.sleep(10000);
		otp.sendKeys(Otp);
		logger.info("Enter OTP");
	}

	@FindBy(xpath = "//input[@id='CaptchaInputText']")
	WebElement secondcaptcha;

	@Step("Re-enter captcha")
	public void Entersecondcaptcha() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(secondcaptcha));
		secondcaptcha.click();
		Thread.sleep(6000);
		logger.info("Second captcha entered");
	}

	@FindBy(xpath = "//button[text()='Verify']")
	WebElement verify;

	@Step("Click on Verify button")
	public void Finalverify() {
		wait.until(ExpectedConditions.elementToBeClickable(verify));
		verify.click();
		logger.info("Final Verify");
	}

}
