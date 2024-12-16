package webproject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Htmlprg {
	ChromeDriver driver;
	
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/user/Downloads/alert.html");
	}
	
	@Test
	public void adding() {
		driver.findElement(By.xpath("/html/body/input[1]")).click();
		Alert a=driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
		//a.dismiss();
		driver.findElement(By.xpath("/html/body/input[2]")).sendKeys("Anu");
		driver.findElement(By.xpath("/html/body/input[3]")).sendKeys("Ammu");

	

	}

}
