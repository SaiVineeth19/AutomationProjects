import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Documents\\SOFTWARE\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);


	}

}
