package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragDrop {
	ChromeDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
	}
	
	@Test
	public void dragAndDrop() {
		Actions act=new Actions(driver);
		WebElement five=driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		WebElement dest=driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
		act.dragAndDrop(five, dest);
		WebElement bank=driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
		WebElement destbank=driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
		act.dragAndDrop(bank, destbank);
		act.perform();

		

	}

}
