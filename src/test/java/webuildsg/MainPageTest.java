package webuildsg;

import java.io.IOException;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import webuildsg.Base.BaseTest;
import webuildsg.Pages.MainPage;

public class MainPageTest extends BaseTest {
	MainPage mainPage;

@BeforeClass
	public void beforeclass() throws IOException {
		
		driversetup();
		mainPage = new MainPage(driver);
		PageFactory.initElements(driver, mainPage);
	}
	@Test(priority=1)
	public void  titletest() {
		
		mainPage.validatetitles();
		mainPage.validatealltext();
		
	}
	@Test(priority=2,description = "check if we enter value into search box, it retrieves results as expected")
	public void  searchdata() {
		mainPage.searchdata();
	}
	
	@Test(priority=3,description = "validate if repos link is working")
	public void  repostests() {
		mainPage.reposperweek();
	}
	
	@Test(priority=4,description = "validate if events per week link is working")
	public void  eventstests() {
		mainPage.eventsperweek();
	}
	
	@Test(priority=5,description = "validate if activities per programming language link is working")
	public void  actvitiesproglnk() {
		mainPage.activitiesproglink();
	}
	
	@Test(priority=6,description = "validate if active usrs group link is working")
	public void  activeusergroups() {
		mainPage.activeusergrps();
	}
	@Test(priority=7,description = "validate if active usrs group link is working")
	public void  activerepositories() {
		mainPage.activerepos();
	}
	@Test(priority=8,description = "validate if repositories per prog lang link is working")
	public void  reposperprogLang() {
		mainPage.reposproglang();
	}
	@Test(priority=9,description = "validate if event by day of week link is working")
	public void  eventsdayofweek() {
		mainPage.eventdayofweek();
	}
	@Test(priority=10,description = "validate if event per week of month link is working")
	public void  eventsperweekofMon() {
		mainPage.evntperwkofmth();
	}
	@Test(priority=11,description = "validate if event time of day link is working")
	public void  eventtimeofDay() {
		mainPage.evnttmodday();
	}
	@Test(priority=12,description = "validate if event locations link is working")
	public void  eventlocations() {
		mainPage.evntloc();
	}
	@Test(priority=13,description = "validate if the numbers within the static boxes are displaying as expected")
	public void  staticnum()  {
		try {
			mainPage.staticnumbers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority=14,description = "validate if the numbers within the static boxes are displaying as expected")
	public void  socmediaicons()  {
		mainPage.socialmedialinks();
		
	}
	
	@AfterTest
	public void teardown() {
		BaseTest.quit();
		
	}
}
