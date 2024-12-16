package webproject;

import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResponseCode {
	String l;
	@Before
	public void setup() {
		l="https://www.facebook.com/";
	}
	
	@Test
	public void response() {
		try {
		URL u=new URL(l); 
		HttpURLConnection con=(HttpURLConnection)u.openConnection();
		int code=con.getResponseCode();
		System.out.println(code);
		
		if(code==200) {
			System.out.println("Success");
		}
		else {
			System.out.println("Fail");
		}
		
		}
		catch(Exception e){
			
		}
		
		
	}

}
