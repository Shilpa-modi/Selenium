package webproject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SantaMonica {
	ChromeDriver driver;
	
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://santamonicaedu.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void actions() {
		String s=driver.getTitle();
		String a="Santa Monica Study Abraod Pvt. Ltd";
		if(s.equals(a)) {
			System.out.println("Same Title");
		}
		else {
			System.out.println("Real title is "+s+"\n Wrong title");
		}
		if(driver.getPageSource().contains("Santa")) {
			System.out.println("Contains");
		}
		else {
			System.out.println("Absent");
		}
		driver.findElement(By.xpath("//*[@id='launchevent']/div/div/div/button/span")).click();
		driver.findElement(By.xpath("//*[@href='https://santamonicaedu.in/overseas-education-santamonica-study-abroad-pvt-ltd/']")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div/div[2]/div[5]/div/div/div[2]/a")).click();
		driver.findElement(By.xpath("//*[@href='#']")).click();
		driver.findElement(By.xpath("/html/body/div/a[3]")).click();
		driver.findElement(By.name("qname")).sendKeys("Shilpa");
	
	
	}
	
	

}
