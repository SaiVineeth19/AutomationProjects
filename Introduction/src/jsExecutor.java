import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class jsExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 7);
		Actions a = new Actions(driver);
		driver.manage().window().maximize();

		String url = "https://ksrtc.in/oprs-web/guest/home.do?h=1";

		driver.get(url);
		
		driver.findElement(By.id("fromPlaceName")).sendKeys("beng");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class*='ui-widget-content'] li")));
		List<WebElement> options = driver.findElements(By.cssSelector("ul[class*='ui-widget-content'] li"));
		Iterator<WebElement> it = options.iterator();
		
			for(WebElement option:options) {
				if(option.getText().contains("AIRPORT")) {
					option.click();
					Assert.assertTrue(true);
					break;
				} 
			}
		

	}

}

/*
 * driver.get("https://www.ksrtc.in");
driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
Thread.sleep(2000);

driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

System.out.println(driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText());

//Javascript DOM can extract hidden elements
//because selenium cannot identify hidden elements - (Ajax implementation)
//investigate the properties of object if it have any hidden text

//JavascriptExecutor
JavascriptExecutor js= (JavascriptExecutor)driver;

String script = "return document.getElementById(\"fromPlaceName\").value;";
String text=(String) js.executeScript(script);
System.out.println(text);
int i =0;
//BENGALURU INTERNATION AIPORT
while(!text.equalsIgnoreCase("BENGALURU INTATION AIPORT"))
{
i++;
driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

text=(String) js.executeScript(script);
System.out.println(text);
if(i>10)
{
break;
}

}

if(i>10)
{
System.out.println("Element not found");
}
else
{
System.out.println("Element  found");
}
*/
