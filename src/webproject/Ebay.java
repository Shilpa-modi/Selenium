package webproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ebay {
	ChromeDriver driver;
	
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		}
	
	@Test
	public void titleVerification() {
		String s=driver.getTitle();
		System.out.println("Real title:"+s);
		String exp="Ebay.com";
		if(s.equals(exp)) {
			System.out.println("Same Title");
		}
		else
		{
			System.out.println("Different Title");
		}
	
	
	
		driver.findElement(By.id("gh-shop-a")).click();;
		driver.findElement(By.xpath("//*[@id='gh-sbc']/tbody/tr/td/ul/li[4]/a")).click();
		driver.getPageSource().contains("SHOP BY CATEGORY");
		driver.findElement(By.xpath("//*[@id='mainContent']/section/div[2]/span[2]/a/div/img")).click();
		driver.findElement(By.className("gh-cart-icon")).click();
		driver.findElement(By.id("gh-ac")).sendKeys("Books",Keys.ENTER);
	
	}
}
