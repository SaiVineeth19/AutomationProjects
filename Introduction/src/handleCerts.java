import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.io.FileUtils;

public class handleCerts {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * //Using Desired capabilities to set a generic profile for chrome
		 * DesiredCapabilities ch = DesiredCapabilities.chrome(); 
		 * //way:1 to accept insecure Certs 
		 * ch.acceptInsecureCerts();
		 * 
		 * //way 2 to accept insecure and SSL certs
		 * ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		 * ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 * 
		 * //Using the desired capabilities from above, now setup local browser such
		 * that we can use it in our tests
		 * 
		 * ChromeOptions c = new ChromeOptions(); //merging the desired capabilities
		 * c.merge(ch); System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe")
		 * ; WebDriver driver = new ChromeDriver(c);
		 */

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		String url = "https://www.google.com/";

		driver.get(url);

		// Screenshot Aspect
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\User\\Documents\\SOFTWARE\\screenshot.png"));

	}

}
