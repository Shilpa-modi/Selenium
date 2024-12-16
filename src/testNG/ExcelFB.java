package testNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExcelFB {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
	}
	
	@Test
	public void dataDrivenTest() throws IOException {
		driver.get("https://www.facebook.com/");
		FileInputStream fi=new FileInputStream("C:\\Users\\user\\Downloads\\test data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Sheet1");
		int rowCount=sh.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++) {
			String username=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Username:"+username);
			String pass=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Password:"+pass);
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys(username);
			driver.findElement(By.name("pass")).sendKeys(pass);
			driver.findElement(By.name("login")).click();
			driver.navigate().to("https://www.facebook.com/");
		}
	}

}
