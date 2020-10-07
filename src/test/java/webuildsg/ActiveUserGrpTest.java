package webuildsg;
import java.io.IOException;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import webuildsg.Base.BaseTest;
import webuildsg.Pages.ActiveUserGrpPage;


public class ActiveUserGrpTest extends BaseTest{
	ActiveUserGrpPage activeusergrpPage;
	
	
	@BeforeClass
	public void beforeclass() throws IOException {
		
		driversetup();
		activeusergrpPage = new ActiveUserGrpPage(driver);
		PageFactory.initElements(driver, activeusergrpPage);
				
	}
	@Test(priority=1,description = "Validate the title & subtitle of Active user group page")
	public void  titletest() {
		
		activeusergrpPage.validatetitle();

		
	}
	@Test(priority=2,description = "Validate the header of Active user group page")
	public void  headertest() {
		
		activeusergrpPage.validateheader();

		
	}
	@Test(priority=3,description = "Validate the Active user group list ")
	public void  usergrouptest() throws IOException {
		
		activeusergrpPage.activeusergroup();

		
	}
	@AfterTest
	public void teardown() {
	
		BaseTest.quit();
	
	}
}
