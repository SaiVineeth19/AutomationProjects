package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Root1 {

	@AfterTest
	public void executeLast() {
		System.out.println("Executed after all the tests");
	}
	
	@Parameters({"URL"})
	@Test(groups= {"Smoke"})
	public void Demo(String url) {
		System.out.println("Roots of TestNG");
		System.out.println("Paramter: " + url);
	}

	@Test
	public void secondTest() {
		System.out.println("Deepening of the roots of TestNG");
	}

}
