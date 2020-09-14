package SaiAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class RightNavBarTest extends Base {
	
	// initializing a local driver object at their repective tests helps in parallel
	// execution and prevents from being overridden
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to the desired URL");
	}

	@Test
	public void basePageNavigation() throws IOException {

		LandingPage lap = new LandingPage(driver);
		log.info("Checking if the right navigation bar is displayed");
		Assert.assertTrue(lap.getNavBarRight().isDisplayed());
		log.info("Checked and is displayed");

	}

	@AfterTest
	public void tearDown() {
		log.info("Closing browser");
		driver.close();
		driver = null;
	}

}
