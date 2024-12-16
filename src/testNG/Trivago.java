package testNG;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Trivago {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.trivago.in/en-IN?themeId=280&sem_keyword=trivago&sem_creativeid=598703244708&sem_matchtype=e&sem_network=g&sem_device=c&sem_placement=&sem_target=&sem_adposition=&sem_param1=&sem_param2=&sem_campaignid=12417347003&sem_adgroupid=118398776556&sem_targetid=kwd-5593367084&sem_location=9179999&cipc=br&cip=9119000005&gad_source=1&gclid=CjwKCAiAxea5BhBeEiwAh4t5K-BQEFBp5ZMGWmQ5L269GXevL2jI3UD9rtldpEpzNlkYMHdsOk61GBoCBGcQAvD_BwE");
	}
	
	@Test
	public void datePicker() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[1]/fieldset/button[1]/span/span[2]/span[2]")).click();
		checkin("December 2024","23");
	}
	public void checkin(String mnthyr,String date) {
		while(true) {
		String mnth=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div[1]/h3")).getText();
		if(mnth.equals(mnthyr)) {
			break;
		}
		else {
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/button[2]")).click();
		}
		List<WebElement> el=driver.findElements(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/button/time"));
		for(WebElement a:el) {
			String y=a.getText();
			if(date.equals(y)) {
				a.click();
				break;
			}
		}
	}
	}}
