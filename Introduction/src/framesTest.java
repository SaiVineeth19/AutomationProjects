import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class framesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "https://jqueryui.com/droppable/";

		driver.get(url);

		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		String frameTxt = driver.findElement(By.id("draggable")).getText();

		System.out.println(frameTxt);

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		
		//switch to default space 
		driver.switchTo().defaultContent();

	}

}
