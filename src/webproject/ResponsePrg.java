package webproject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResponsePrg {
	ChromeDriver driver;
	
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void hrefL() {
		List<WebElement> el=driver.findElements(By.tagName("a"));
		System.out.println("Count:"+el.size());
		
		for(WebElement web:el) {
		      String o=web.getAttribute("href");
		      verify(o);
		}
	}	
	
	
	private void verify(String o) {
		try {
			URL u=new URL(o);
			HttpURLConnection con=(HttpURLConnection)u.openConnection();
			int code=con.getResponseCode();
			System.out.println(code);
			
			if(code==200) {
				System.out.println("Response code is 200..."+o);
			}
			else if(code==404) {
				System.out.println("Response code is 404..."+o);
			}
			else {
				System.out.println("System crash");
			}
		}
	  catch(Exception e) {
				
			}
		}
		
	
}


