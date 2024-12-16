package testNG;

import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class CrossBrowser {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		
		if(browser.equalsIgnoreCase("ChromeTest")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("EdgeTest")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new FirefoxDriver();
		}
	}
	@Test
	public void title() {
		String s=driver.getTitle();
		System.out.println("title is "+s );
	}
	}
    


