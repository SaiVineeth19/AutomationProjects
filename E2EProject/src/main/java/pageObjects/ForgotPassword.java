package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	WebDriver driver;

	public ForgotPassword(WebDriver driver) {
		super();
		this.driver = driver;
	}

	private By email = By.id("user_email");
	private By sendInstructions = By.cssSelector("input[type='submit']");

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement sendInstructions() {
		return driver.findElement(sendInstructions);
	}

}
