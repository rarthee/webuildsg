package webuildsg.Pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import webuildsg.Base.BaseTest;
import webuildsg.util.ReadExcelClass;

public class MainPage extends BaseTest{
	
	@FindBy (xpath="/html/body/div/div[1]/div/header/div/h1") private WebElement title;
    @FindBy (xpath="/html/body/div/div[1]/div/header/div/ul/li[1]/a") private WebElement mainwifi;
    @FindBy (xpath="/html/body/div/div[1]/div/header/div/ul/li[2]/a") private WebElement live;
    @FindBy (xpath="/html/body/div/div[1]/div/header/div/div") private WebElement sgdata;
    @FindBy (xpath="/html/body/div/div[1]/div/div/p") private WebElement subtitle;
    @FindBy (id="search") private WebElement searchData;
    @FindAll({
    	   @FindBy(id = "search"),
    	   @FindBy(className = "graph-name")
    	      	})
    private List<WebElement> searchAllData;
    	
    	
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[1]/a/span") private WebElement reposperWeek;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[1]/a/p") private WebElement reposperWeektxt;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[2]/a/span") private WebElement eventsperWeek;
    @FindBy (xpath ="/html/body/div/div[2]/ul[1]/li[2]/a/span/svg/path")private WebElement eventsperWeekGraph;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[2]/a/p") private WebElement eventsperWeektxt;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[3]/a/span") private WebElement actvperPLang;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[3]/a/p") private WebElement actvperPLangtxt;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[4]/a/span") private WebElement actvUserGrp;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[4]/a/p") private WebElement actvUserGrptxt;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[5]/a/span") private WebElement actvRepos;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[5]/a/p") private WebElement actvRepostxt;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[6]/a/span") private WebElement reposperProgLang;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[6]/a/p") private WebElement reposperProgLangtxt;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[7]/a/span") private WebElement evntdayofWeek;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[7]/a/p") private WebElement evntdayofWeektxt;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[8]/a/span") private WebElement evntperWeekofMonth;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[8]/a/p") private WebElement evntperWeekofMonthtxt;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[9]/a/span") private WebElement evntdur;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[9]/a/p") private WebElement evntdurtxt;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[10]/a/span") private WebElement evnttime;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[10]/a/p") private WebElement evnttimetxt;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[11]/a/span") private WebElement evntloc;
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[11]/a/p") private WebElement evntloctxt;
    @FindBy (xpath="/html/body/div/div[2]/div/h3") private WebElement nextPagetext;
    @FindBy (className="footer-twitter") private WebElement twitter;
    @FindBy (className="footer-facebook") private WebElement facebook;
    @FindBy (className="footer-github") private WebElement github;
    @FindBy (className="footer-calendar") private WebElement caledar;
    @FindBy (className="footer-rss") private WebElement rss;
    @FindBy (className="footer-itunes") private WebElement itunes;
    @FindAll({
 	    @FindBy(className = "big")
 	      	}) private List<WebElement> staticBox;
  

    Map<String,String> inputdata;
    
    
    
	public MainPage(WebDriver driver) {
		BaseTest.driver = driver; 
        PageFactory.initElements(driver, this);
	}
	public MainPage validatetitles() {
		
		implicitWait();
		String titleval = gettxt(title);
		Assert.assertEquals("we build!", titleval);
		
		implicitWait();
		String subtitleval = gettxt(subtitle);
		Assert.assertEquals("Using data to inspire variety, openness and projects for the design and engineering community", subtitleval);
		return this;
		
		
	}
	//validate if all the group names are correct
	public MainPage validatealltext() {
		Assert.assertEquals("repos per week", gettxt(reposperWeektxt));
		Assert.assertEquals("events per week", gettxt(eventsperWeektxt));
		Assert.assertEquals("activities per programming languages", gettxt(actvperPLangtxt));
		return this;
	}
	public MainPage searchdata() {
		
		implicitWait();
		
		sendkeys(searchData,"event");
		
		implicitWait();
		for(WebElement e : searchAllData) {
			//When the search keyword is 'event', the mainpage displayed all groups containing the word 'event' but in addition,
			///it also displayed 'Active User Group' for which I would like to check if the result is retrieved correctly by the mainpage.
			
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(gettxt(e).contains("event"));
			sa.assertTrue(gettxt(e).contains("active"));
		}
		clear(searchData);
		refresh();
		return this;
		
		
	}
	
	public MainPage reposperweek() {
		implicitWait();
		implicitWait();
		Assert.assertEquals("repos per week", gettxt(reposperWeektxt));
		click(reposperWeek);
		Assert.assertEquals("repositories updated per week",gettxt(nextPagetext));
		navigateback();
		return this;
		
	}
	
	public MainPage eventsperweek() {
		
		Assert.assertTrue(gettxt(eventsperWeektxt).contains("events per week"));
		click(eventsperWeek);
		implicitWait();
		Assert.assertTrue(gettxt(nextPagetext).contains("events per week"));
		navigateback();
		return this;
		
	}
public MainPage activitiesproglink() {
		
		Assert.assertTrue(gettxt(actvperPLangtxt).contains("activities per programming languages"));
		click(actvperPLang);
		implicitWait();
		Assert.assertTrue(gettxt(nextPagetext).contains("update activities per programming languages"));
		navigateback();
		return this;
		
	}
public MainPage activeusergrps() {
	
	Assert.assertTrue(gettxt(actvUserGrptxt).contains("active user groups"));
	click(actvUserGrp);
	implicitWait();
	Assert.assertTrue(gettxt(nextPagetext).contains("active user groups with > 5 events"));
	navigateback();
	return this;
	
}
public MainPage activerepos() {
	
	Assert.assertTrue(gettxt(actvRepostxt).contains("active repositories"));
	click(actvRepos);
	implicitWait();
	Assert.assertTrue(gettxt(nextPagetext).contains("active repos with > 10 updates"));
	navigateback();
	return this;
	
}
public MainPage reposproglang() {
	
	Assert.assertTrue(gettxt(reposperProgLangtxt).contains("repositories per programming language"));
	click(reposperProgLang);
	implicitWait();
	Assert.assertTrue(gettxt(nextPagetext).contains("repositories per programming languages"));
	navigateback();
	return this;
	
}
public MainPage eventdayofweek() {
	
	Assert.assertTrue(gettxt(evntdayofWeektxt).contains("event day of week"));
	click(evntdayofWeek);
	implicitWait();
	Assert.assertTrue(gettxt(nextPagetext).contains("events by day of week"));
	navigateback();
	return this;
	
}
public MainPage evntperwkofmth() {
	
	Assert.assertTrue(gettxt(evntperWeekofMonthtxt).contains("event per week of month"));
	click(evntperWeekofMonth);
	implicitWait();
	Assert.assertTrue(gettxt(nextPagetext).contains("events per week of month"));
	navigateback();
	return this;
	
}

public MainPage eventdur() {
	
	Assert.assertTrue(gettxt(evntdurtxt).contains("event duration"));
	click(evntdur);
	implicitWait();
	Assert.assertTrue(gettxt(nextPagetext).contains("events by duration"));
	navigateback();
	return this;
	
}
public MainPage evnttmodday() {
	
	Assert.assertTrue(gettxt(evnttimetxt).contains("event time of day"));
	click(evnttime);
	implicitWait();
	Assert.assertTrue(gettxt(nextPagetext).contains("events by time of day"));
	navigateback();
	return this;
	
}

public MainPage evntloc() {
	
	Assert.assertTrue(gettxt(evntloctxt).contains("event locations"));
	click(evntloc);
	implicitWait();
	Assert.assertTrue(gettxt(nextPagetext).contains("popular event locations"));
	navigateback();
	return this;
	
}
public MainPage staticnumbers() throws IOException {
	
	inputdata = (Map<String,String>) ReadExcelClass.Readinputfile("C:\\Users\\Sahana Rangarajan\\Git Repo\\webuildsg\\Staticnumbers.xlsx");
	for(WebElement e : staticBox) {
		System.out.print(gettxt(e));
		//Check if the value of the webelement is same as that coming from the spreadsheet(inputdata)
		Assert.assertTrue(inputdata.containsValue(gettxt(e)));
	   
	}
	return this;
	
}

public MainPage socialmedialinks() {
	
	
	click(twitter);
	System.out.println(getTitle());
	implicitWait();
	Assert.assertTrue(getTitle().contains("Twitter"));
	navigateback();
	implicitWait();
	
	click(facebook);
	System.out.println(getTitle());
	Assert.assertTrue(getTitle().contains("We Build SG - Home | Facebook"));
	navigateback();
	implicitWait();
	
	implicitWait();
	click(github);
	System.out.println(getTitle());
	Assert.assertTrue(getTitle().contains("We Build SG · GitHub"));
	navigateback();
	implicitWait();
	
	click(caledar);
	navigateback();
	implicitWait();
	
	click(rss);
	System.out.println(getTitle());
	Assert.assertTrue(getTitle().contains("We Build SG LIVE - powered by FeedBurner"));
	navigateback();
	implicitWait();
	
	click(itunes);
	navigateback();
	implicitWait();
	
	
	return this;
	
}
}
