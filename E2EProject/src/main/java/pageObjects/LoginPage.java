package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	private By email = By.id("user_email");
	private By password = By.xpath("//input[@id='user_password']");
	private By login = By.cssSelector("input[value='Log In']");
	private By forgotPswrd = By.cssSelector("a[class='link-below-button']");

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement clickLogin() {
		return driver.findElement(login);
	}

	public ForgotPassword forgotPswrd() {
		driver.findElement(forgotPswrd).click();
		return new ForgotPassword(driver);
		// return fp;
	}

}
