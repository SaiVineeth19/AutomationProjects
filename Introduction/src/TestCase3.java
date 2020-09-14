import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestCase3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.ie.driver", "C:\\Users\\User\\Documents\\SOFTWARE\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
		
		
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);

	}

}
