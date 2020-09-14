package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Root2 {
	
	@Parameters({"URL"})
	@Test
	public void anotherTest(String url) {
		System.out.println("Learning of the roots of TestNG deepens : Using xml file to trigger the whole suite");
		System.out.println("Test level parameter: " + url);
	}

	@BeforeTest
	public void preRequisite() {
		System.out.println("I will get executed first as a pre-requisite");
	}

}
