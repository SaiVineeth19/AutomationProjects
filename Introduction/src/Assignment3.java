import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "http://www.itgeared.com/demo/1506-ajax-loading.html";

		WebDriverWait wait = new WebDriverWait(driver, 5);

		driver.get(url);

		driver.findElement(By.cssSelector("[href*='loadAjax()']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));

		System.out.println(driver.findElement(By.id("results")).getText());

	}

}
