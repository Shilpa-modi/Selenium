package webproject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class BrokenLinks {
	ChromeDriver driver;
	
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://santamonicaedu.in/");
	}
	
	@Test
	public void brokencodes() {
		List<WebElement> el=driver.findElements(By.tagName("a"));
		int i=el.size(); 
		  System.out.println("Count of Links:"+i);
	
		for(WebElement web:el) {
			String a=web.getAttribute("href");
			find(a);
			//System.out.println(f);
		}
	}
	private int find(String a) {
		int f=0;
		try {
			  URL u=new URL(a);
			  HttpURLConnection h=(HttpURLConnection)u.openConnection();
			  int code=h.getResponseCode();
			  
			  if(code==404) {
				  System.out.println("Failed Link:"+a);
			  }
			  
			  else {
				  
				  System.out.println("Success Link:"+a);
			  
			  }
			  
			
		}
		 
		catch(Exception e) {
	}
		return f;
	
	
	}
	
}
