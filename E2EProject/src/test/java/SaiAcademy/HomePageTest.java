package SaiAcademy;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePageTest extends Base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException, SQLException {

		driver.get(prop.getProperty("url"));
		log.info("Navigated to the desired URL");
		LandingPage lap = new LandingPage(driver);
		WebDriverWait wait = initializeWait();
		// wait.until(ExpectedConditions.visibilityOf(lap.getPopUpWindow()));
//		if (lap.popUpWindowDisplayCheck()) {
//			lap.getPopUpMsg().click();
//		}
		if (lap.getPopUpList().size() > 0) {
			lap.getPopUpMsg().click();
		}
		wait.until(ExpectedConditions.visibilityOf(lap.getSignIn()));
		log.info("Clicking on login link");
		LoginPage lop = lap.getLogin();
		log.info("CLicked on login and in login page now");
		log.info("Entering username");
		lop.getEmail().sendKeys(username);
		log.info("Username entered");
		log.info("Entering password");
		lop.getPassword().sendKeys(password);
		log.info("Password entered");
		log.info(text);
		log.info("Related text entered");
		log.info("Clicking on login button");
		lop.clickLogin().click();
		log.info("Clicked on login button");
		ForgotPassword fp = lop.forgotPswrd();
//		fp.getEmail().sendKeys(jdbcConnection());
		fp.getEmail().sendKeys(getNamejdbc());
		fp.sendInstructions().click();

	}

	@AfterTest
	public void tearDown() {
		log.info("Closing browser");
		driver.close();
		driver = null;
	}

	@DataProvider
	public static Object[][] getData() {
		Object[][] data = new Object[2][3];

		// Row stands for the number of types of data sets to be run
		// 0th row
		data[0][0] = "nonrestricted@user.com";
		data[0][1] = "12345";
		data[0][2] = "Non restricted user";
		// 1st row
		data[1][0] = "restricted@user.com";
		data[1][1] = "09876";
		data[1][2] = "Restricted user";

		return data;
	}

}
