import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create driver object for chrome browser
		
		// once created, we will strictly implement the methods of the interface "ChromeDriver"
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		String url = "http://www.google.com";
		
		driver.get(url);
		String title = driver.getTitle();
		System.out.println(title);
		String urlToCheck = driver.getCurrentUrl();
		System.out.println(urlToCheck);
		if(url == urlToCheck) {
			System.out.println("URL matches");
		} else {
			System.out.println("URL mismatch");
		}
		
		//String pageSource = driver.getPageSource();
		//System.out.println(pageSource);
		
		driver.get("http://www.nike.com");
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		

	}

}
