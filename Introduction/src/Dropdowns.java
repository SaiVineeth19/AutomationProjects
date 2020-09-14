import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(url);
		
		Select s = new Select(driver.findElement(By.cssSelector("select[id*='DropDownListCurrency']")));
		s.selectByValue("USD");
		//System.out.println(driver.findElement(By.xpath("//select[contains(@id,'DropDownListCurrency')]//option")).getText());
		s.selectByIndex(2);
		s.selectByVisibleText("INR");
	}

}
