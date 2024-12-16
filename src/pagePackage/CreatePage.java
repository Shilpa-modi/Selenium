package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreatePage {
	WebDriver driver;
	
	@FindBy(linkText="Create a Page")
	WebElement page;
	
	@FindBy(xpath = "//*[@id=\"blueBarDOMInspector\"]/div/div[2]/div/div/span/a")
	WebElement signup;
	
	public CreatePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void pageClick() {
		page.click();
	}
	
	public void pageTitleVerification() {
		String actual=driver.getTitle();
		Assert.assertEquals("Facebook", actual);
	}
	
	public void signupClick() {
		signup.click();
	}

}
