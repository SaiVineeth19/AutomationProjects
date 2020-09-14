import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 7);
		driver.manage().window().maximize();

		String url = "https://rahulshettyacademy.com/AutomationPractice/";

		driver.get(url);

		System.out.println(driver.findElements(By.cssSelector("table[id='product'] tbody tr")).size());
		System.out.println(driver.findElements(By.cssSelector("table[id='product'] tbody tr th")).size());
		System.out.println(driver.findElement(By.cssSelector("table[id='product'] tbody tr:nth-child(3)")).getText());

	}

}
