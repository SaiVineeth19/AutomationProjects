package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public WebDriver driver;
	public Properties prop;
	WebDriverWait wait;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		// System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Data.properties");
		prop.load(fis);
		// Declaring it as system property helps giving mvn commands and eventually in
		// parametrizing jenkins build according to browser type.
		// String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");

			ChromeOptions co = new ChromeOptions();
			if (browserName.contains("headless")) {
				co.addArguments("headless");
			}
			driver = new ChromeDriver(co);
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriverWait initializeWait() {
		wait = new WebDriverWait(driver, 10);
		return wait;
	}

	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;

	}

	public ResultSet jdbcConnection() throws SQLException {
		String name = "";
		String host = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qaDbTest", "root", "root");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from qadbtest.EmployeeInfo where id = 1");
		return rs;
//		while (rs.next()) {
//			name = rs.getString("name");
//		}
//		return name;
	}

	public String getNamejdbc() throws SQLException {
		String name = "";
		ResultSet rs = jdbcConnection();
		while (rs.next()) {
			name = rs.getString("name");
		}
		return name;

	}

	public String getLocationjdbc() throws SQLException {
		String name = "";
		ResultSet rs = jdbcConnection();
		while (rs.next()) {
			name = rs.getString("location");
		}
		return name;

	}

}
