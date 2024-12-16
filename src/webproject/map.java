package webproject;


	import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

	public class map {
	    public static void main(String[] args) {
	        // Set the path of your ChromeDriver
	       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
              
	        // Initialize the ChromeDriver
	        WebDriver driver = new ChromeDriver();
	        
	        try {
	            // Maximize the window
	            driver.manage().window().setSize(new Dimension(1920, 1080));
	            
	            // Navigate to the website
	            driver.get("https://aksharammuseum.com/map");
	            
	            
	            WebDriverWait wai = new WebDriverWait(driver, Duration.ofSeconds(10));
	           

	            // Wait for the world map to be visible (adjust locator as needed)
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement worldMap = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("map"))); // Replace with actual map element locator
	          
	            JavascriptExecutor ps = (JavascriptExecutor) driver;
	            ps.executeScript("arguments[0].scrollIntoView(true);", worldMap);
	            
	            int xOffset=397;
	            int yOffset=322;
	            
	            System.out.println("Map size: " + worldMap.getSize());
	            System.out.println("Coordinates: X = " + xOffset + ", Y = " + yOffset);
	            

	            Actions actions = new Actions(driver);
	            actions.moveToElement(worldMap, xOffset, yOffset).click().perform();
	            
	            
	            // Wait for the sidebar with language buttons to be visible
	            WebElement sidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]")));// Replace with actual sidebar element locator
	            WebDriverWait wit = new WebDriverWait(driver, Duration.ofSeconds(10));
              
	            List<WebElement> languageButtons = sidebar.findElements(By.xpath("/html/body/div/div[1]/div/div[2]"));

	            // Scroll through the sidebar to check if all language buttons are visible
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            for (WebElement button : languageButtons) {
	                // Scroll to the button to ensure it's in view
	                js.executeScript("arguments[0].scrollIntoView(true);", button);
	                // Verify the button is clickable
	                if (button.isDisplayed() && button.isEnabled()) {
	                    // Click the button to test
	                    button.click();
	                    // Wait for any potential page changes
	                    wait.until(ExpectedConditions.stalenessOf(button));  // Wait for the page to refresh or change
	                    // Use the back button to go back
	                    driver.navigate().back();
	                    wait.until(ExpectedConditions.visibilityOf(sidebar)); // Wait until the sidebar is visible again
	                } else {
	                    System.out.println("Button is either not displayed or not clickable: " + button.getText());
	                }
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	           // driver.quit();
	        }
	    }
	}



