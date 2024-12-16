package work;

	import java.net.HttpURLConnection;
	import java.net.URL;
import java.time.Duration;
import java.util.List;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import net.bytebuddy.asm.Advice.Argument;

	public class ThasmaiAdminPage {
		WebDriver driver;
		
		@Before
		public void setup() {
			driver=new ChromeDriver();
			driver.get("https://starlife.co.in/admin/login");
			driver.manage().window().maximize();
		}
		
		@Test
		public void brokencodes() {
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[2]/div/input")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[2]/div/span/input")).sendKeys("1111");
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[2]/div/button")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90000));
			WebElement sidebar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'overflow-y-auto')]")));

			
			//WebElement sidebar=driver.findElement(By.xpath("//div[contains(@class, 'overflow-y-auto')]"));
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			 
			
			List<WebElement> el=driver.findElements(By.tagName("a"));
			int i=el.size(); 
			  System.out.println("Count of Links:"+i);
			  
	
			  for(int j=0;j<i;j++) {
				  WebElement link=driver.findElements(By.tagName("a")).get(j);
				  String url=link.getAttribute("href");
				  if(url==null||url.isEmpty()) {
					  System.out.println("Empty or missing url");
					  continue;
				  }
				  String txt=link.getText();
				 // js.executeScript("arguments[0].scrollTop+=0;", sidebar);
				 // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

				  find(url,txt);
			  }
		
		}
		private void find(String url,String txt) {
		
			try {
				  URL u=new URL(url);
				  HttpURLConnection h=(HttpURLConnection)u.openConnection();
				  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

				  int code=h.getResponseCode();
				  
				/* if(code==404) {
					  System.out.println("Failed Link:"+url);
				  }*/
				  
				  if(code==200) {
					  
					  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					  System.out.println(" Success Link:"+txt+"\n \t"+url+"\n");
					  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
				  }
				  
				  else {
					  System.out.println("Failed link."+url+"\t"+"Response code:"+code);
				  }
				  
				
			}
			 
			catch(Exception e) {
		}
			
		
		
		}
		
	}



