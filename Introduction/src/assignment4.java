import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment4 {

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

		// Click "multiple windows"
		WebElement multipleWindows = driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]"));
		a.moveToElement(multipleWindows).click().build().perform();

		WebElement parentClickable = driver.findElement(By.cssSelector("div[class='example'] a"));
		a.moveToElement(parentClickable).click().build().perform();

		Set<String> ids = driver.getWindowHandles();

		Iterator<String> it = ids.iterator();

		String parentId = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='example'] h3")));

		System.out.println(
				"Child window text: " + driver.findElement(By.cssSelector("div[class='example'] h3")).getText());

		driver.switchTo().window(parentId);

		System.out.println(
				"Parent window text: " + driver.findElement(By.cssSelector("div[class='example'] h3")).getText());

	}

}
