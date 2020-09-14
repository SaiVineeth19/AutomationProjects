import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String url = "https://www.rediff.com";
		
		driver.get(url);
		driver.findElement(By.linkText("Sign in")).click();
		System.out.println(driver.findElement(By.cssSelector("p.form-label")).getText());
		String userName = driver.findElement(By.cssSelector("p.form-label")).getText();
		
		if (userName.contains("Username")) {
			System.out.println("Currently in the signin page");
		} else {
			System.out.println("Something is wrong");
		}
		
		driver.findElement(By.xpath("//input[contains(@id,'login')]")).sendKeys("username");
		driver.findElement(By.cssSelector("input#password")).sendKeys("password"); //non standard css : tagName#id
		driver.findElement(By.xpath("//input[@id='remember']")).click();
		driver.findElement(By.cssSelector("input.signinbtn")).click();  //non standard css : tagName.className
		
		System.out.println(driver.findElement(By.cssSelector("div.div_login_error")).getText());

	}

}
