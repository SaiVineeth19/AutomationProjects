import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class tableExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 7);
		driver.manage().window().maximize();
		String url = "https://www.cricbuzz.com/live-cricket-scorecard/29079/eng-vs-pak-2nd-test-pakistan-tour-of-england-2020";

		driver.get(url);
		int total = 0;

		WebElement table1 = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		int rowcount = table1.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();

		int count = table1.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"))
				.size();

		for (int i = 0; i < count - 2; i++) {

			String value = table1
					.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i)
					.getText();
			int countValue = Integer.parseInt(value);
			total += countValue;
		}

		int extrasValue = Integer.parseInt(
				driver.findElement(By.xpath("//div[@id='innings_1']// div[text()='Extras']//following-sibling::div[1]"))
						.getText());
		total += extrasValue;
		int totalScore = Integer.parseInt(
				driver.findElement(By.xpath("//div[@id='innings_1']// div[text()='Total']//following-sibling::div[1]"))
						.getText());

		Assert.assertEquals(total, totalScore);

	}

}

/*
 * driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");

WebElement table=driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
int rowcount= table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
int count=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();

for(int i=0;i<count-2;i++)
{
String value=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
int valueinteger=  Integer.parseInt(value);
sum=sum+valueinteger;//103
}
//System.out.println(sum);

String Extras=driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
int extrasValue=Integer.parseInt(Extras);
int TotalSumValue=sum+extrasValue;
System.out.println(TotalSumValue);


String ActualTotal=driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
int ActualTotalVAlue=Integer.parseInt(ActualTotal);
if(ActualTotalVAlue==TotalSumValue)
{
System.out.println("Count Matches");
}
else
{
System.out.println("count fails");
}
*/
