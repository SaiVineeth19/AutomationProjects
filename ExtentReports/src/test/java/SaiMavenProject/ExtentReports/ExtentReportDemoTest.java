package SaiMavenProject.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemoTest {

	ExtentReports extent;

	@BeforeTest
	public void extentReportConfig() {
		String path = System.getProperty("user.dir") + "\\ExtentReports\\index.html";
		// Extent spark reporter object initialization and config
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Automation Results");

		// Extent reports initialization and attaching above object to this one
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		// setting name of the tester
		extent.setSystemInfo("Tester", "Sai Vineeth Putchala");
	}

	@Test
	public void initialDemo() {

		// creating test so that the extent report object can consume and provide the
		// report for that particular test
		ExtentTest test = extent.createTest("Initial Test");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "https://www.google.com";

		driver.get(url);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		test.fail("Checking fail operation");
		extent.flush();
	}

}
