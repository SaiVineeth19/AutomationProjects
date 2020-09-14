import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/AutomationPractice";
		
		driver.get(url);
		
		String text = "Vineeth";
		
		// Text box related to alerts
		driver.findElement(By.id("name")).sendKeys(text);
		
		Thread.sleep(2000L);
		
		driver.findElement(By.id("alertbtn")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		
		String alertText = driver.switchTo().alert().getText();
		
		if(alertText.contains(text)) {
			System.out.println("Alert contains the desired text: " + text);
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
		driver.switchTo().alert().accept();
		
		String confirmText = "confirm";
		
		driver.findElement(By.id("confirmbtn")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		String confirmAlertText = driver.switchTo().alert().getText();
		
		if(confirmAlertText.contains(confirmText)) {
			Assert.assertTrue(true);
			System.out.println("Alert text for confirm contains the desired text: " + confirmText);
		} else {
			Assert.assertTrue(false);
		}
		
		driver.switchTo().alert().dismiss();
		

	}

}
