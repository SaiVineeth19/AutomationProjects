package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectRepo.RediffHomePagePF;

public class RediffLoginTest {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void signInTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.get("https://www.rediff.com/");
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 7);
		RediffHomePagePF rhp = new RediffHomePagePF(driver);
		// wait.until(ExpectedConditions.elementToBeClickable(rhp.signIn()));
		// rhp.signIn().click();
		wait.until(ExpectedConditions.visibilityOf(rhp.userName()));
		rhp.userName().sendKeys("KakashiHatake");
		rhp.password().sendKeys("MinatoNamikaze");
		rhp.homePageAtSignIn().click();
	}

}
