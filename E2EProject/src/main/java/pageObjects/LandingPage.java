package pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Base;

public class LandingPage {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	private By signIn = By.cssSelector("a[href*='sign_in']");
	private By titleText = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By navBarRight = By.cssSelector("ul[class*='navbar-right'] li");
	private By popUpWindow = By.cssSelector("div[class='sumome-react-wysiwyg-move-handle'] input");
	private By popUpMsg = By.xpath("//button[contains(text(),'NO THANKS')]");
	private By videoBannerHeadText = By.cssSelector("div[class*='video-banner'] h3");
	private By videoBannerText = By.cssSelector("div[class*='video-banner'] p");

	public WebElement getSignIn() {
		return driver.findElement(signIn);
	}

	public LoginPage getLogin() {
		driver.findElement(signIn).click();
		LoginPage lop = new LoginPage(driver);
		return lop;
	}

	public WebElement getTitleText() {
		return driver.findElement(titleText);
	}

	public WebElement getvideoBannerHeadText() {
		return driver.findElement(videoBannerHeadText);
	}

	public WebElement getvideoBannerText() {
		return driver.findElement(videoBannerText);
	}

	public WebElement getNavBarRight() {
		log.info("Navigation Bar element");
		return driver.findElement(navBarRight);
	}

	public List<WebElement> getPopUpList() {
		log.info("Pop message appeared that needs to be handled");
		return driver.findElements(popUpMsg);
	}

	public WebElement getPopUpMsg() {
		log.info("Pop message appeared that needs to be handled");
		return driver.findElement(popUpMsg);
	}

	public WebElement getPopUpWindow() {
		log.info("Pop message appeared that needs to be handled");
		return driver.findElement(popUpWindow);
	}

	public boolean popUpWindowDisplayCheck() {
		return driver.findElement(popUpWindow).isDisplayed();

	}

	public boolean popUpMsgDisplayCheck() {
		return driver.findElement(popUpMsg).isDisplayed();

	}
}
