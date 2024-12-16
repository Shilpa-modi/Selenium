package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FBlogin {
	WebDriver driver;
	
	By FBemail=By.id("email");
	By FBpassword=By.id("pass");
	By loginbutton=By.name("login");
	
	public FBlogin(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setValues(String email,String password) {
		driver.findElement(FBemail).sendKeys(email);
		driver.findElement(FBpassword).sendKeys(password);
	}
	
	public void login() {
		driver.findElement(loginbutton).click();
	}

}
