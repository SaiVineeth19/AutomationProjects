package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

@RunWith(Cucumber.class)
public class StepDefinition extends Base {

	public WebDriver driver;
	public WebDriverWait wait;
	Actions a;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	LandingPage lap;
	LoginPage lop;

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
		log.info("Driver is initialized");

	}

	@Given("^Navigate to QAClickAcademy site$")
	public void navigate_to_QAClickAcademy_site() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(prop.getProperty("url"));
		log.info("Navigated to the desired URL");
		lap = new LandingPage(driver);
		wait = initializeWait();

	}

	@Given("^Once landed click on login link$")
	public void once_landed_click_on_login_link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.visibilityOf(lap.getSignIn()));
		log.info("Clicking on login link");
		lop = lap.getLogin();
		log.info("CLicked on login and in login page now");
	}

	@When("^Enter (.+) and (.+) to login$")
	public void enter_and_to_login(String username, String password) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		log.info("Entering username");
		lop.getEmail().sendKeys(username);
		log.info("Username entered");
		log.info("Entering password");
		lop.getPassword().sendKeys(password);
		log.info("Password entered");
		log.info("Related text entered");
		log.info("Clicking on login button");
		lop.clickLogin().click();
		log.info("Clicked on login button");

	}

	@Then("^Verify the user login$")
	public void verify_the_user_login() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ForgotPassword fp = lop.forgotPswrd();
//		fp.getEmail().sendKeys(jdbcConnection());
		log.info("Getting text from database");
		fp.getEmail().sendKeys(getNamejdbc());
		fp.sendInstructions().click();
		log.info("Closing browser");
		driver.close();
		driver = null;
	}

}
