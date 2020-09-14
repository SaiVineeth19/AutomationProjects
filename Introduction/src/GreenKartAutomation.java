import java.awt.ItemSelectable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKartAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);

		String url = "https://rahulshettyacademy.com/seleniumPractise/#/";

		driver.get(url);

		Thread.sleep(3000L);

		// driver.findElement(By.xpath("//div[@class='product']//img[contains(@src,'broccoli')]//div[@class='stepper-input']//a[@class='increment']")).click();
		// driver.findElement(By.linkText("ADD TO CART")).click();
		// driver.findElement(By.xpath("//div[@class='products']/div[1]/div[2]/a[@class='increment']")).click();
		/*
		 * // this is for increment element for(int i=1;i<3;i++) {
		 * driver.findElement(By.xpath(
		 * "//img[contains(@src,'broccoli')]//parent::div//following-sibling::div//a[@class='increment']"
		 * )).click(); } driver.findElement(By.xpath(
		 * "//div[@class='products']//div[1]//div[3]//button")).click();
		 * 
		 * //System.out.println(driver.findElement(By.className("product")).getText());
		 * 
		 */

		String[] itemsNeeded = { "Cucumber", "Carrot" };

		GreenKartAutomation gka = new GreenKartAutomation();
		gka.addItems(driver, itemsNeeded);

		// clicking on the cart items
		driver.findElement(By.cssSelector("[class='cart-icon'] img")).click();

		// click proceed to checkout
		driver.findElement(By.cssSelector("[class='cart-preview active'] [class='action-block'] button")).click();

		// promocode dialog box
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");

		// click apply promo button
		driver.findElement(By.className("promoBtn")).click();

		// Explicit wait

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));

		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		WebElement foo = wait1.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				if (driver.findElement(By.className("promoInfo")).isDisplayed()) {
					return driver.findElement(By.className("promoInfo"));
				} else {
					return null;
				}
			}
		});

		// promo info
		System.out.println(driver.findElement(By.className("promoInfo")).getText());

		// place order
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();

		/*
		 * for(WebElement product: products) {
		 * 
		 * if(product.getText().contains("Carrot")) {
		 * driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click(); }
		 * //System.out.println(product.getText()); }
		 */

		// div[@class='product']//img[contains(@src,'broccoli')]//div[@class='stepper-input']//a[@class='increment']
		// div[@class='products']/div[1]/div[3]/button

	}

	public void addItems(WebDriver driver, String[] itemsNeeded) {
		List<WebElement> products = driver.findElements(By.className("product-name"));

		int temp = 0;

		for (int i = 0; i < products.size(); i++) {

			String[] item = products.get(i).getText().split("-");
			String formattedItem = item[0].trim();

			List itemsList = Arrays.asList(itemsNeeded);
			int itemsNeededSize = itemsNeeded.length;

			if (itemsList.contains(formattedItem)) {
				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();
				driver.findElements(By.cssSelector("div[class='product-action'] button")).get(i).click();
				temp += 1;
			}
			if (temp == itemsNeededSize) {
				break;
			}

		}
	}

}
