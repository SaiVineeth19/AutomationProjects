import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UpdatedDropDowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String url = "https://www.spicejet.com/";
		driver.get(url);
		
		Thread.sleep(2000L);
		
		
		
		//System.out.println(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='IndArm']")).click();
		//System.out.println(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		
		// count of the checkboxes
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		driver.findElement(By.id("divpaxinfo")).click(); // main dropdown click
		
		
		//driver.findElement(By.cssSelector("select[id*='mainContent_ddl_Adult']")).click();
		
		Thread.sleep(3000L);
		
		driver.findElement(By.id("ctl00_mainContent_ddl_Adult")).click(); // click to open the child dropdown inside the main dropdown
		
		driver.findElement(By.xpath("//select[contains(@id,'mainContent_ddl_Adult')]//option[@value='3']")).click();
		
		// mouse hover action needed to close the opened dropdown
		
		//System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult");
		
//		Select s = new Select(driver.findElement(By.cssSelector("select[id*='mainContent_ddl_Adult']")));
//		s.selectByValue("2");
//		s.selectByVisibleText("4");
//		s.selectByIndex(2);
//		
		
		//Handling Dynamic dropdowns and indexing
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.cssSelector("a[value='VTZ']")).click();
		
		Thread.sleep(2000L);
		
		//driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();
		
		// alternative to the above step if in case indexes are not allowed to be used
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']")).click();
		
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getText());
	}
}
		
		// Code Snippet (from lecture 52)
				/*   
		driver.findElement(By.id("divpaxinfo")).click();

		   Thread.sleep(2000L);

		   /*int i=1;

		while(i<5)

		{

		driver.findElement(By.id("hrefIncAdt")).click();//4 times

		i++;

		}*/
		
		/*

		   
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		for(int i=1;i<5;i++)

		{

		driver.findElement(By.id("hrefIncAdt")).click();

		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText(
		

	}

}
*/

// code snippet Lecture 55

/*
 //  //a[@value='MAA']  - Xpath for chennai

//  //a[@value='BLR']

driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

driver.findElement(By.xpath("//a[@value='BLR']")).click();

Thread.sleep(2000);

//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
*/

// code snippet 60
/*
 driver.get("http://spicejet.com"); //URL in the browser

Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

//Assert.assertFalse(true);System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
*/
