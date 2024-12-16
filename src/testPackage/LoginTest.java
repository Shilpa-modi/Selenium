package testPackage;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import pagePackage.FBlogin;

public class LoginTest {
	public WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@org.testng.annotations.Test
	public void testLogin() {
		FBlogin obj=new FBlogin(driver);
		obj.setValues("shi@78","huu");
		obj.login();
	}

}
