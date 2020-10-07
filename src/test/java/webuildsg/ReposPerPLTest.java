package webuildsg;
import java.io.IOException;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import webuildsg.Base.BaseTest;
import webuildsg.Pages.MainPage;
import webuildsg.Pages.ReposPerPLPage;
public class ReposPerPLTest extends BaseTest {
	ReposPerPLPage  reposperPLPage;
	

	
	@BeforeClass
	public void beforeclass() throws IOException {
		
		driversetup();
		reposperPLPage = new ReposPerPLPage(driver);
		PageFactory.initElements(driver, reposperPLPage);
		
	}
	@Test(priority=1,description = "Validate the title & subtitle of Repositories per programming language page")
	public void  titletest() {
		
		reposperPLPage.validatetitle();

		
	}
	@Test(priority=2,description = "Validate each of the languages is clickable on Repositories per programming language page")
	public void  languagetest() throws IOException, InterruptedException {
		
		reposperPLPage.selectlangs();

		
	}
	
	@Test(priority=3,description = "Validate social media links")	
	public void socialmedia() {
		reposperPLPage.socialmedialinks();
		
	}
	@AfterTest
	public void teardown() {
		
		BaseTest.quit();
	
	}
	
}
