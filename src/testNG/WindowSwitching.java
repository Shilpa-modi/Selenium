package testNG;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowSwitching {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/popup.php");
	}
	
	@Test
	public void func() {
		String s=driver.getWindowHandle();
		System.out.println("Title is "+ driver.getTitle());
		driver.findElement(By.xpath("/html/body/p/a")).click();
		
		Set<String> allwindows=driver.getWindowHandles();
		for(String a:allwindows) {
			if(!a.equalsIgnoreCase(s)) {
				driver.switchTo().window(a);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input")).sendKeys("happy");
				driver.close();
			}
			driver.switchTo().window(s);
		}
	}
	

}
