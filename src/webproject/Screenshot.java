package webproject;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	ChromeDriver driver;
	
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/user/Downloads/alert.html");
	}
	
	@Test
	public void shot() throws IOException {
		File x=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(x, new File("C:\\Users\\user\\OneDrive\\Pictures\\Screenshots\\New folder\\scn.png"));
		
		WebElement button=driver.findElement(By.xpath("/html/body/input[4]"));
		File ButtonImg=button.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ButtonImg, new File("./Screenshot/element.png"));

	}

}
