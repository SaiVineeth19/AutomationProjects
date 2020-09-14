import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Driver chromeDriver = new Driver(WebDriver chrDriver,null,null);
//		
//		//WebDriver driver = null;
//		
//		chromeDriver.chrDriver.setChromeDriverProperty();
//		chromeDriver.setChromeDriver(chrDriver);
//		chromeDriver.chrDriver.get("http://www.facebook.com");
//		chromeDriver.chrDriver.getTitle();
//		chromeDriver.chrDriver.close();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
//		String url = "http://www.facebook.com";
//		
//		driver.get(url);
//		
//		driver.getTitle();
//		
//		driver.findElement(By.id("email")).sendKeys("hey I know this is an email tab");
//		
//		driver.findElement(By.id("pass")).sendKeys("Password");
//		
//		driver.findElement(By.linkText("Forgotten account?")).click();
//		
//		System.out.println(driver.getTitle());
//		
//		System.out.println(driver.getCurrentUrl());
//		
//		driver.close();
		
		String url = "https://login.salesforce.com/";
		driver.get(url);
		System.out.println(driver.getTitle());
//		//driver.findElement(By.id("username")).sendKeys("username");
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("username");
//		//driver.findElement(By.cssSelector("#username")).sendKeys("username");
//		//driver.findElement(By.id("password")).sendKeys("password");
//		//driver.findElement(By.cssSelector("#password")).sendKeys("password");
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
//		//driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
//		driver.findElement(By.xpath("//input[@id ='Login']")).click();
//		//driver.findElement(By.linkText("Forgot Your Password?")).click();
//		//System.out.println(driver.findElement(By.xpath("//div[@id='error']")).getText());
//		//String errorMsg = driver.findElement(By.cssSelector("div#error.loginError")).getText();
//		//System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());
//		System.out.println(driver.getTitle());
		
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("username");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("password");
		driver.findElement(By.cssSelector("input[id='Login']")).click();
		System.out.println(driver.getTitle());
		String errorMsg = driver.findElement(By.cssSelector("div#error.loginError")).getText();
		//System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());
		System.out.println(driver.findElement(By.cssSelector("div[id='error']")).getText());
		//driver.close();
		
		// xpath for facebook forgotten password link (//*[@id="login_form"]/table/tbody/tr[3]/td[2]/div/a)
		

	}

}
