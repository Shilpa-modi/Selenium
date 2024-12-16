package webproject;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageSource {
ChromeDriver obj;	
	@Before
	public void setup() {
		obj=new ChromeDriver();
		obj.get("https://google.com/");
	}
	@Test
	public void pageSource() {
		String s=obj.getPageSource();
		if(s.contains("Gmail"))
			System.out.println("Present");
		else
			System.out.println("Not Present");
	}

}
