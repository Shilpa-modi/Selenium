package pagePackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThasmaiFirstPage {
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div[3]/div[2]/div/div/div[2]/div/input")
	WebElement username;
	
	@FindBy(xpath="/html/body/div/div[3]/div[2]/div/div/div[2]/div/span/input")
	WebElement password;
	
	@FindBy(xpath="/html/body/div/div[3]/div[2]/div/div/div[2]/div/button")
	WebElement login;
	
	@FindBy(css="button.w-10.h-6.text-blue-gray-900")
	WebElement on_off;
	
	@FindBy(tagName = "button")
	private List<WebElement> buttons;
	
	public ThasmaiFirstPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void signup(String name,String pass) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(name);
		password.sendKeys(pass);
		login.click();
	}
	
	public void elementClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(on_off));
		if(on_off.isDisplayed()&&on_off.isEnabled()) {
			on_off.click();
		}
		else {
			System.out.println("on-off not working");
		}
	}
	
	public void clickButtons() {
		for(WebElement button:buttons) {
			if(button.isDisplayed()||button.isEnabled()) {
				
				  try {
					  button.click();
					  System.out.println("\t Clicked is "+button.getText());
					  driver.navigate().to("https://starlife.co.in/admin/overview");
				  }
				  catch(StaleElementReferenceException e){
					  System.out.println("Exception");
				  }
			  }
			else {
				System.out.println("Not interactable button");
			}
		}
	}

}
