package webproject;

import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {
	public static void main(String[] args) {
		ChromeDriver ob=new ChromeDriver();
		ob.get("https://chatgpt.com/");
		String s=ob.getTitle();
		System.out.println(s);
		String expected="ChatGPT";
		if(s.equals(expected))
			System.out.println("Same Title");
		else 
			System.out.println("Not same Title \n Actual:"+s+" Expected:"+expected);
		
		if(s==expected)
			System.out.println("Same Title");
		else 
			System.out.println("Not same Title \n Actual:"+s+" Expected:"+expected);
		ob.close();
		}

}
