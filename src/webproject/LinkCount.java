package webproject;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkCount {
	ChromeDriver driver;
	
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void links() {
		List<WebElement> count=driver.findElements(By.tagName("a"));
		System.out.println("Link count:"+count.size());
		
		for(WebElement element:count) {
			System.out.println("Link:"+element.getAttribute("href"));
			System.out.println("Visible LinkText:"+element.getText());
		}
	}

}
