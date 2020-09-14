import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 7);
		driver.manage().window().maximize();

		Actions a = new Actions(driver);

		// String url = "https://www.makemytrip.com/";
		String url = "https://www.spicejet.com/";
		driver.get(url);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//input[@id='ctl00_mainContent_view_date1']//following-sibling::button")));
		// driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']//following-sibling::button")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"div[class*='ui-datepicker-group-first'] div[class*='ui-corner-left'] div[class='ui-datepicker-title'] span[class='ui-datepicker-month']")));
		System.out.println(driver.findElement(By.cssSelector(
				"div[class*='ui-datepicker-group-first'] div[class*='ui-corner-left'] div[class='ui-datepicker-title'] span[class='ui-datepicker-month']"))
				.getText());
		a.moveToElement(driver.findElement(By.cssSelector("a[class='ui-datepicker-next ui-corner-all'] span"))).build()
				.perform();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='ui-datepicker-header
		// ui-widget-header ui-helper-clearfix ui-corner-left']
		// div[class='ui-datepicker-title'] span[class='ui-datepicker-month']")));
		// System.out.println(driver.findElement(By.cssSelector("div[class='ui-datepicker-header
		// ui-widget-header ui-helper-clearfix ui-corner-left']
		// div[class='ui-datepicker-title']
		// span[class='ui-datepicker-month']")).getText());

		while (!(driver.findElement(By.cssSelector(
				"div[class*='ui-datepicker-group-first'] div[class*='ui-corner-left'] div[class='ui-datepicker-title'] span[class='ui-datepicker-month']"))
				.getText().equalsIgnoreCase("December"))) {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
					"a[class='ui-datepicker-next ui-corner-all ui-state-hover ui-datepicker-next-hover'] span")));
			driver.findElement(By.cssSelector(
					"a[class='ui-datepicker-next ui-corner-all ui-state-hover ui-datepicker-next-hover'] span"))
					.click();
		}

		List<WebElement> dates = driver.findElements(By.cssSelector("td[data-handler='selectDay'] a"));
		for (WebElement date : dates) {
			if (date.getText().equalsIgnoreCase("19")) {
				date.click();
				break;
			}
		}
		// Instructor's code
		/*
		 * driver.get("https://www.path2usa.com/travel-companions"); //April 23
		 * driver.findElementByXPath(".//*[@id='travel_date']").click();
		 * 
		 * 
		 * while(!driver.findElement(By.
		 * cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText
		 * ().contains("May")) { driver.findElement(By.
		 * cssSelector("[class='datepicker-days'] th[class='next']")).click(); }
		 * 
		 * 
		 * List<WebElement> dates= driver.findElements(By.className("day")); //Grab
		 * common attribute//Put into list and iterate int
		 * count=driver.findElements(By.className("day")).size();
		 * 
		 * for(int i=0;i<count;i++) { String
		 * text=driver.findElements(By.className("day")).get(i).getText();
		 * if(text.equalsIgnoreCase("21")) {
		 * driver.findElements(By.className("day")).get(i).click(); break; }
		 * 
		 * }
		 */

	}

}
