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

public class TitlePageTextTest extends Base {

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
	public void titleCheckInLandingPage() throws IOException {

		LandingPage lap = new LandingPage(driver);
		log.info("Checking the text validation on the home page");
		Assert.assertEquals(lap.getTitleText().getText(), "FEATURED COURSE");
		log.info("Text validation checked");

	}

	@Test
	public void videoBannerHeadTextCheckInLandingPage() throws IOException {

		LandingPage lap = new LandingPage(driver);
		log.info("Checking the Video Banner Header text validation on the home page");
		Assert.assertEquals(lap.getvideoBannerHeadText().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Video banner Header Text validation checked");

	}

	@Test
	public void videoBannerTextCheckInLandingPage() throws IOException {

		LandingPage lap = new LandingPage(driver);
		log.info("Checking the Video Banner text validation on the home page");
		Assert.assertEquals(lap.getvideoBannerText().getText(),
				"Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		log.info("Video banner Text validation checked");

	}

	@AfterTest
	public void tearDown() {
		log.info("Closing browser");
		driver.close();
		driver = null;
	}

}
