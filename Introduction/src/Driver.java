import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
	
	public WebDriver chrDriver;
	public WebDriver firefoxDriver;
	public WebDriver internetExplorerDriver;
	
	
	public WebDriver getInternetExplorerDriver() {
		return internetExplorerDriver;
	}

	public void setInternetExplorerDriver(WebDriver internetExplorerDriver) {
		this.internetExplorerDriver = new InternetExplorerDriver();
	}

	public WebDriver getChromeDriver() {
		return chrDriver;
	}

	public WebDriver getFirefoxDriver() {
		return firefoxDriver;
	}

	public void setChromeDriverProperty() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
	}
	
	public void setFirefoxDriverProperty() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Documents\\SOFTWARE\\geckodriver-v0.27.0-win64\\geckodriver.exe");
	}
	
	public void setIEDriverProperty() {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\User\\Documents\\SOFTWARE\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
		 

	}

	public Driver(WebDriver chrDriver, WebDriver firefoxDriver, WebDriver internetExplorerDriver) {
		super();
		this.chrDriver = new ChromeDriver();
		this.firefoxDriver = new FirefoxDriver();
		this.internetExplorerDriver = new InternetExplorerDriver();
	}
// 
	public void setChromeDriver(WebDriver chromeDriver) {
		this.chrDriver = new ChromeDriver();
	}

	public void setFirefoxDriver(WebDriver firefoxDriver) {
		this.firefoxDriver = new FirefoxDriver();
	}

}
