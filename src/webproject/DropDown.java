package webproject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
ChromeDriver driver;
	
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		driver.manage().window().maximize();
	}
	
	@Test
	public void Drophandle() {
		WebElement day=driver.findElement(By.xpath("//*[contains(@name,'DOB_Day')]"));
		Select dayDetail=new Select(day);
		dayDetail.selectByValue("06");
		
		WebElement mnth=driver.findElement(By.xpath("//*[contains(@name,'DOB_Month')]"));
		Select month=new Select(mnth);
		month.selectByVisibleText("MAR");
		
		WebElement yr=driver.findElement(By.xpath("//*[contains(@name,'DOB_Year')]"));
		Select year=new Select(yr);
		year.selectByValue("2024");
	}

}
