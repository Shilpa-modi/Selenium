package testPackage;

import org.testng.annotations.Test;

import pagePackage.CreatePage;

public class PageTest extends BaseClass{
	
	@Test
	public void page() {
		CreatePage pg=new CreatePage(driver);
		pg.pageClick();
		pg.pageTitleVerification();
		pg.signupClick();
	}
	
	

}
