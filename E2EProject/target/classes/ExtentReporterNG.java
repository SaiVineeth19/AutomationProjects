package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent;

	public static ExtentReports getReportObject() {
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
		return extent;
	}

}
