import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		Actions a = new Actions(driver);
		driver.manage().window().maximize();

		String url = "https://rahulshettyacademy.com/AutomationPractice/";

		driver.get(url);

		driver.findElement(By.id("autocomplete")).sendKeys("in");
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String option = "return document.getElementById(\"autocomplete\").value;";
		String text = (String) js.executeScript(option);
		System.out.println(text);
		Thread.sleep(1000);
		while (!text.equalsIgnoreCase("India")) {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(option);
		}
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
		System.out.println(text);
	}

}
