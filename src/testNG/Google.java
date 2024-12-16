package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Google {
	ChromeDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	@Parameters("s")
	@Test
	public void execute(String s) {
		driver.findElement(By.name("q")).sendKeys(s,Keys.ENTER);;
		
	}

}
