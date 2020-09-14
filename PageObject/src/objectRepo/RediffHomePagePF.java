package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RediffHomePagePF {

	WebDriver driver;

	public RediffHomePagePF(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(css = "a[class='signin']")
	WebElement signIn;

	@FindBy(css = "#login1")
	WebElement username;

	@FindBy(name = "passwd")
	WebElement password;

	@FindBy(xpath = "//div[@class='cell logo']//a")
	WebElement homePage;

	public WebElement signIn() {
		return signIn;
	}

	public WebElement userName() {
		return username;
	}

	public WebElement password() {
		return password;
	}

	public WebElement homePageAtSignIn() {
		return homePage;
	}

}
