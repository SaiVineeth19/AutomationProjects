import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		driver.manage().window().maximize();

		String url = "https://rahulshettyacademy.com/AutomationPractice";

		driver.get(url);

		// CheckBox
		driver.findElement(By.id("checkBoxOption2")).click();
		String dynamicText = driver.findElement(By.cssSelector("label[for='benz']")).getText();

		// Validation that text is captured in that String
		System.out.println(dynamicText);

		// DropDown
		driver.findElement(By.id("dropdown-class-example")).click();

		List<WebElement> options = driver.findElements(By.cssSelector("select[id='dropdown-class-example'] option"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(dynamicText)) {
				option.click();
				break;
			}
		}

		// Text box related to alerts
		driver.findElement(By.id("name")).sendKeys(dynamicText);

		driver.findElement(By.id("alertbtn")).click();

		// Validation that pop up gives out some message
		System.out.println(driver.switchTo().alert().getText());

		String alertText = driver.switchTo().alert().getText();

		if (alertText.contains(dynamicText)) {
			System.out.println("Alert contains the desired text: " + dynamicText);
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		driver.switchTo().alert().accept();

	}

}
