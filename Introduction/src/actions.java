import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class actions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		String url = "https://www.amazon.com/";

		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		Actions a = new Actions(driver);

		// WebElement moveOver = driver.findElement(By.id("nav-link-accountList"));

		// WebElement visibilityCheckResultPage1 =
		// driver.findElement(By.cssSelector(".a-button.a-button-dropdown.a-button-small"));

		// Enter input in caps into the search bar
		WebElement twoTabSearchInput = driver.findElement(By.id("twotabsearchtextbox"));
		a.moveToElement(twoTabSearchInput).click().keyDown(Keys.SHIFT).sendKeys("Laptops").doubleClick().build()
				.perform();

		// Mouse hover action --->build ---> perform
		// a.moveToElement(moveOver).click().build().perform();

		// click search
		WebElement searchBtn = driver.findElement(By.id("nav-search-submit-text"));
		a.moveToElement(searchBtn).click().build().perform();

		// validation to see selenium still sticks with the parentwindow

		System.out.println("Before switching:" + driver.getTitle());

		// getting all the window handles into a data structure (set)

		Set<String> ids = driver.getWindowHandles();

		// Using the iterator to iterate through the child window so that the control
		// changes from parent to child

		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		// control to first child window
		driver.switchTo().window(childId);

		// wait for the next screen to load
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("span[class='a-button a-button-dropdown a-button-small']")));
		// search results
		WebElement page1SearchResults = driver
				.findElement(By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']"));

		// validation to see selenium now gets control of the child window

		System.out.println("After switching: " + driver.getTitle());

		// Prints the list of the products in the first child products page
		List<WebElement> products = driver
				.findElements(By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']"));
		for (WebElement product : products) {
			System.out.println(product.getText());
		}
		// remember to make the search results a list
		// System.out.println(page1SearchResults.getText());
		
		//Switch back to parent window
		driver.switchTo().window(parentId);
		
		//Switch back to parent window validation
		System.out.println("Switch back to parent window title: " + driver.getTitle());

	}

}
