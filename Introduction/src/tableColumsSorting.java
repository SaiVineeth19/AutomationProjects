import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class tableColumsSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String url = "https://rahulshettyacademy.com/seleniumPractise/#/offers";

		driver.get(url);
		List<WebElement> productsList = driver.findElements(By.cssSelector("table tbody tr td:nth-child(2)"));
		driver.findElement(By.cssSelector("table tr th:nth-child(2)")).click();
		driver.findElement(By.cssSelector("table tr th:nth-child(2)")).click();

		ArrayList<String> copyOfProducts = new ArrayList<>();

		for (WebElement product : productsList) {
			copyOfProducts.add(product.getText());
		}

		// printing the copyOfProducts Array (Validation)
		System.out.println("*****Original List*****");
		Iterator<String> it = copyOfProducts.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		ArrayList<String> sortedProducts = new ArrayList<>();
		for (String s : copyOfProducts) {
			sortedProducts.add(s);
		}

		// Ascending order
		Collections.sort(sortedProducts);
		// Descending order
		Collections.reverse(sortedProducts);
		System.out.println("*****Sorted List*****");
		for (String sortedProduct : sortedProducts) {
			System.out.println(sortedProduct);
		}

		Assert.assertTrue(copyOfProducts.equals(sortedProducts));

	}

}

/*
 * Instructor's Code
 * driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
 * 
 * 
 * 
 * driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
 * 
 * 
 * 
 * driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
 * 
 * 
 * 
 * 
 * 
 * List<WebElement> firstColList=
 * driver.findElements(By.cssSelector("tr td:nth-child(2)"));
 * 
 * 
 * 
 * 
 * 
 * ArrayList<String> originalList=new ArrayList<String>();
 * 
 * 
 * 
 * for(int i=0;i<firstColList.size();i++)
 * 
 * 
 * 
 * {
 * 
 * 
 * 
 * originalList.add(firstColList.get(i).getText());
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * ArrayList<String> copiedList =new ArrayList<String>();
 * 
 * 
 * 
 * 
 * 
 * for(int i=0;i<originalList.size();i++)
 * 
 * 
 * 
 * {
 * 
 * 
 * 
 * copiedList.add(originalList.get(i));
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * //string
 * 
 * 
 * 
 * Collections.sort(copiedList);
 * 
 * 
 * 
 * 
 * 
 * // Collections.reverse(copiedList);
 * 
 * 
 * 
 * 
 * 
 * for(String s1:originalList )
 * 
 * 
 * 
 * {
 * 
 * 
 * 
 * System.out.println(s1);
 * 
 * 
 * 
 * }
 * 
 * System.out.println("*******************");
 * 
 * for(String s2:copiedList )
 * 
 * 
 * 
 * {
 * 
 * 
 * 
 * System.out.println(s2);
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * Assert.assertTrue(originalList.equals(copiedList));
 * 
 */
