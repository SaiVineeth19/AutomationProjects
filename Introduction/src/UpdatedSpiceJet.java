import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UpdatedSpiceJet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String url = "https://www.spicejet.com/";
		driver.get(url);
		
		Thread.sleep(3000L);
		
		driver.findElement(By.cssSelector("input[value='RoundTrip']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='RoundTrip']")).isSelected());
		driver.findElement(By.cssSelector("input[value='OneWay']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='OneWay']")).isSelected());
		
		Thread.sleep(3000L);
		
		//Handling Dynamic dropdowns and indexing
		
		// origin city
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
				
		driver.findElement(By.cssSelector("a[value='VTZ']")).click();
				
		Thread.sleep(2000L);
		
		//destination city
		
		//driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();
		
		// alternative to the above step if in case indexes are not allowed to be used
				
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']")).click();
		
		//Thread.sleep(2000L);
		// calender
		
		//driver.findElement(By.cssSelector("a[class='ui-state-default.ui-state-highlight.ui-state-active']")).click();
		driver.findElement(By.cssSelector("td[class*='ui-datepicker-today'] a")).click();
		
		// style opacity checker for return calender enability verification
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.cssSelector("input[value='RoundTrip']")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("Return calender is enabled");
			Assert.assertTrue(true);
		} else {
			System.out.println("Return calender is not enabled");
		}
		
		// clicking on the return calender
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		
		driver.findElement(By.cssSelector("td[class*='ui-datepicker-today'] a")).click();
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='IndArm']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		
		// count of the checkboxes
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		driver.findElement(By.id("divpaxinfo")).click(); // main dropdown click for number of people
		
		Thread.sleep(3000L);
		
		driver.findElement(By.id("ctl00_mainContent_ddl_Adult")).click(); // click to open the child dropdown inside the main dropdown
		
		driver.findElement(By.xpath("//select[contains(@id,'mainContent_ddl_Adult')]//option[@value='3']")).click();

		
		// mouse hover action needed to close the opened dropdown
		
		
		// Handling dropdowns for currency using Select class as "select" exists for them
		
		Select s = new Select(driver.findElement(By.cssSelector("select[id*='DropDownListCurrency']")));
		s.selectByValue("USD");
		//System.out.println(driver.findElement(By.xpath("//select[contains(@id,'DropDownListCurrency')]//option")).getText());
		s.selectByIndex(2);
		s.selectByVisibleText("INR");
		
		// clicking on the search button
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		
		

	}

}

// Code snippet 63

/*
 // System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());

System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))

{

System.out.println("its enabled");

Assert.assertTrue(true);

}

else

{

Assert.assertTrue(false);

}
*/
