import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.cleartrip.com/";
		
		driver.get(url);
		
		Thread.sleep(2000L);
		
		Select s1 = new Select(driver.findElement(By.cssSelector("#Adults")));
		s1.selectByValue("4");
		
		Select s2 = new Select(driver.findElement(By.id("Childrens")));
		s2.selectByIndex(3);
		
		//
		driver.findElement(By.id("MoreOptionsLink")).click();
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("ind");
		
		Thread.sleep(6000L);
		
		List<WebElement> options = driver.findElements(By.cssSelector("[id='ui-id-3'] li"));
		
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("IndiGo (6E)")) {
				option.click();
				Assert.assertTrue(true);
				break;
			} 
		}
		
		driver.findElement(By.id("FromTag")).sendKeys("vis");
		Thread.sleep(4000L);
		options = driver.findElements(By.cssSelector("[id='ui-id-1'] li"));
		
		for(WebElement option:options) {
			if(option.getText().equalsIgnoreCase("Visakhapatnam, IN - Vishakhapatnam (VTZ)")) {
				option.click();
				Assert.assertTrue(true);
				break;
			}
			Assert.assertTrue(false);
			
		}
		
		driver.findElement(By.id("ToTag")).sendKeys("hyd");
		Thread.sleep(4000L);
		options = driver.findElements(By.cssSelector("[id='ui-id-2'] li"));
		
		for(WebElement option:options) {
			if(option.getText().equalsIgnoreCase("Hyderabad, IN - Rajiv Gandhi International (HYD)")) {
				option.click();
				Assert.assertTrue(true);
				break;
			}
			Assert.assertTrue(false);
			
		}
		
		//Calendar and calendar element (current date)
		driver.findElement(By.xpath("//input[@name='depart_date']//parent::div ")).click();
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();
		
		// click search button
		
		driver.findElement(By.id("SearchBtn")).click();
		
		Thread.sleep(2000L);
		
		System.out.println(driver.findElement(By.className("warningMessage")).getText());
		


	}

}
