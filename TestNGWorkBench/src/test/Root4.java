package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Root4 {

	@BeforeMethod
	public void executeEvery() {
		System.out.println("Executed before every method in this class");
	}

	@Test(groups= {"Smoke"})
	public void skippingTests() {
		System.out.println("Place holder for learning about skipping certain TestNG tests from the suite");
		Assert.assertTrue(false);
	}

}
