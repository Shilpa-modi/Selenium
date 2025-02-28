package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class TestNGdemo {
	
	@BeforeTest
	public void setup() {
		System.out.println("Loading");
	}
	
	@BeforeMethod
	public void url() {
		System.out.println("Before Method");
	}
	
	@Test(priority=3, invocationCount=3,enabled=true,groups="smoke" )
	public void test1() {
		System.out.println("test 1");

}
	@Test(priority=2,groups="smoke",enabled=false)
	public void test2() {
		System.out.println("test 2");

}
	@Test(priority=1,dependsOnMethods = "test1")
	public void test3() {
		System.out.println("test 3");

}
	@AfterMethod
	public void after() {
		System.out.println("After method");
	}
	
	@AfterTest
	public void end() {
		System.out.println("ended");
	}
}
