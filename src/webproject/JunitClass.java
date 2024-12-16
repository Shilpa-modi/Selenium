package webproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitClass {
	ChromeDriver driver;
	@Before
	public void setUp() {
		driver=new ChromeDriver();
	    driver.get("https://chatgpt.com/");

	}
	@Test
	public void titleVerification() {
		String s=driver.getTitle();
		System.out.println("title:"+s);
		String expected="ChatGPT";
		if(s.equals(expected))
			System.out.println("Title same");
		else
			System.out.println("Title Different");
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
