package testNG;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
	}
	
	@Test
	public void func() {
		String current=driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Mobile");
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		
		Set<String> all=driver.getWindowHandles();
		for(String s:all) {
			if(!current.equalsIgnoreCase(s)) {
		
	
		String title=driver.getTitle();
		String expected="Amazon.in:Mobile phone";
		if(title.equalsIgnoreCase(expected)) {
			System.out.println("Expected and actual title is same");
		}
		else{
			System.out.println("Expected and actual title is same");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(0,250)"," ");
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a/div/img")).click();
		
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		driver.close();
		}	
		}
		driver.switchTo().window(current);
	}

}
