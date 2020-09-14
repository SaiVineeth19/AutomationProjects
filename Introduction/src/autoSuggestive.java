import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class autoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 7);
		Actions a = new Actions(driver);
		driver.manage().window().maximize();
		
		String url = "https://www.makemytrip.com/";
		driver.get(url);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromCity")));
		WebElement source = driver.findElement(By.id("fromCity"));
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='autopop__wrap makeFlex column defaultCursor']")));
		if(driver.findElement(By.cssSelector("div[class='autopop__wrap makeFlex column defaultCursor']")).isDisplayed()) {
			a.moveToElement(source).click().build().perform();
		} else {
			source.click();
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromCity")));
		source = driver.findElement(By.id("fromCity"));
		source.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class*='react-autosuggest__input--open']")));
		WebElement sourceTextEnter = driver.findElement(By.cssSelector("input[class*='react-autosuggest__input--open']"));
		sourceTextEnter.sendKeys("vis");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='react-autosuggest__section-container--first'] div[class='react-autosuggest__section-title'] p")));
		//Thread.sleep(2000);
		sourceTextEnter.sendKeys(Keys.ARROW_DOWN);
		sourceTextEnter.sendKeys(Keys.ENTER);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='searchToCity'] div[class*='react-autosuggest__container--open'] input")));
		WebElement destinationTextEnter = driver.findElement(By.cssSelector("div[class*='searchToCity'] div[class*='react-autosuggest__container--open'] input"));
		destinationTextEnter.click();
		destinationTextEnter.sendKeys("ban");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='searchToCity'] div[class*='react-autosuggest__section-container--first'] div[class='react-autosuggest__section-title'] p")));
		destinationTextEnter.sendKeys(Keys.ARROW_DOWN);
		destinationTextEnter.sendKeys(Keys.ENTER);
		

	}

}
