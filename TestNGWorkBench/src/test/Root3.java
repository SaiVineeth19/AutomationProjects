package test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Root3 {

	@Test(dependsOnMethods = { "testShell" },dataProvider="getData")
	public void day3(String username, String password) {
		System.out.println("Studying about prioritizing TestNG tests");
		System.out.println("Data Provider username: " + username);
		System.out.println("Data Provider password: " + password);

	}
	
	
	@Parameters({ "URL" })
	@Test(groups = { "Smoke" })
	public void testShell(String url) {
		System.out.println("Studied about suite having multiple test shells");
		System.out.println("Suite level parameters: " + url);
		
	}

	@BeforeSuite
	public void firstMethod() {
		System.out.println("Executed with highest priority as it's tagged to be executed before suite");
	}
	
	@DataProvider
	public Object[][] getData() {

	Object[][] data = new Object[3][2];

	// 1st row
	data[0][0]="firstUser";data[0][1]="firstPassword";

	// 2nd row
	data[1][0]="secondUser";data[1][1]="secondPassword";

	// 1st row
	data[2][0]="thirdUser";data[2][1]="thirdPassword";
	return data;
	}

}
