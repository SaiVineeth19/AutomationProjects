package stepDefinitions;

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

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class StepDefinition {
	public WebDriver driver;
	public WebDriverWait wait;
	Actions a;

	@Given("^User is on an e-commerce landing page$")
	public void user_is_on_e_commerce_landing_page() throws Throwable {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 7);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
	}

	@When("^User login into application with username and password$")
	public void user_login_into_application_with_username_and_password() throws Throwable {
		a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@text(),'Sign in')]")));
		WebElement signInBtn = driver.findElement(By.xpath("//span[contains(@text(),'Sign in')]"));
		a.moveToElement(signInBtn).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
		WebElement emailInput = driver.findElement(By.id("ap_email"));
		a.moveToElement(emailInput).click().sendKeys("abc123@gmail.com").build().perform();
		WebElement continuBtn = driver.findElement(By.id("continue"));
		a.moveToElement(continuBtn).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
		WebElement pswrdInput = driver.findElement(By.id("ap_password"));
		a.moveToElement(pswrdInput).click().sendKeys("a23H!erty").build().perform();
	}

	@Then("^Home Page is populated$")
	public void home_page_is_populated() throws Throwable {
		System.out.println("Home page is populated");
	}

	@And("^default items are displayed$")
	public void default_items_are_displayed() throws Throwable {
		System.out.println("Default items are displayed");
	}

}
