package webproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	ChromeDriver driver;
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
	}
	
	@Test
	public void xpath() {
		driver.findElement(By.xpath("//*[@id='nav-xshop']/a[5]")).sendKeys("mobiles");
		driver.findElement(By.xpath("//*[@id='nav-tools']/a[4]")).click();
		driver.findElement(By.xpath("//*[@id='nav-search-bar-form']/div[2]/div[1]/div[1]/input")).click();
	}
	
	@After
	public void closed() {
		driver.quit();
	}

}
