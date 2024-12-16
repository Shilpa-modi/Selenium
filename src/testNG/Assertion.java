package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assertion {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void softAssertion() {
		String s=driver.getTitle();
		String expected="Gogle";
		if(s.equals(expected)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		System.out.println("Finished");
	}
	
	@Test
	public void hardAssertion() {
		String a=driver.getTitle();
		String exp="Goole";
		Assert.assertEquals(a, exp);
		System.out.println("Hard");
	}

}
