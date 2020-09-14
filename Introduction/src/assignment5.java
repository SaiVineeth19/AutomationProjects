import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		driver.manage().window().maximize();

		String url = "https://the-internet.herokuapp.com";

		driver.get(url);

		Actions a = new Actions(driver);

		a.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]"))).click().build()
				.perform();

		System.out.println(driver.findElements(By.tagName("frame")).size());

		driver.switchTo().frame(driver.findElement(By.name("frame-top")));

		System.out.println(driver.findElements(By.tagName("frame")).size());

		driver.switchTo().frame(1);

		System.out.println(driver.findElement(By.id("content")).getText());

	}

}
