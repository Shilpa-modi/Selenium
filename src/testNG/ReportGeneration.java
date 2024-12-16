package testNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportGeneration {
	WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentTest test;
	ExtentReports extents;
	String url="https://www.facebook.com/";
	
	@BeforeTest
	public void extentrepo() {
		reporter=new ExtentHtmlReporter("./report/firstReport.html");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Functional test");
		reporter.config().setTheme(Theme.DARK);
		extents=new ExtentReports();
		extents.attachReporter(reporter);
		extents.setSystemInfo("Verified by ", "abc");
		extents.setSystemInfo("os","Windows 11");
		extents.setSystemInfo("Browser ", "chrome");
		
	}
	
	@BeforeMethod
	public void beforemthd() {
		driver=new ChromeDriver();
		driver.get(url);
		
	}
	
	@Test
	public void titleVerification() {
		test=extents.createTest("Title Verification");
		String title=driver.getTitle();
		String exp="Facebook";
		Assert.assertEquals(title, exp);
	}
	
	@Test
	public void logo() {
		test=extents.createTest("Logo Checking");
		boolean b=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img")).isDisplayed();
		Assert.assertTrue(b);
		
	}
	
	@AfterTest
	public void teardown() {
		extents.flush();
	}
	
	@AfterMethod
	public void browserClose(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "test failed is "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "test skipped is "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "test successed is "+result.getName());
		}
	}

}
