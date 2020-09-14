import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		driver.manage().window().maximize();

		String url = "https://rahulshettyacademy.com/AutomationPractice";

		driver.get(url);

		System.out.println(driver.findElements(By.tagName("a")).size());

		// minimizing the scope to only access footer and the links associated
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		/*
		 * // Further minimizing the scope to first section of the footer WebElement
		 * firstSectionFooter = driver .findElement(By.xpath(
		 * "//a[contains(text(),'Discount')]//parent::h3//parent::li//parent::ul"));
		 * System.out.println(firstSectionFooter.findElements(By.tagName("a")).size());
		 */
		// same step as above but by using the already established footerDriver
		WebElement footerColumn1 = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(footerColumn1.findElements(By.tagName("a")).size());

		for (int i = 1; i < footerColumn1.findElements(By.tagName("a")).size(); i++) {

			String clickOnTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerColumn1.findElements(By.tagName("a")).get(i).sendKeys(clickOnTab);
		}

		Set<String> handles = driver.getWindowHandles();
		int countofHandles = handles.size();
		Iterator<String> it = handles.iterator();
		//My method of capturing child window handle titles
		/*
		String parentId = it.next();
		int temp = 1;
		while (temp <= countofHandles) {

			driver.switchTo().window(it.next());
			System.out.println("Title of child window " + temp + " is " + driver.getTitle());
			temp++;
			if (temp == countofHandles) {
				break;
			}

		}
		*/
		
		// Instructor's way (optimized)
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println("Title: " + driver.getTitle());
		}

	}

}
