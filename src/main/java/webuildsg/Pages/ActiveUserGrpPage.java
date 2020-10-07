package webuildsg.Pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webuildsg.Base.BaseTest;
import webuildsg.util.ReadExcelClass;

public class ActiveUserGrpPage extends BaseTest{
	@FindBy (xpath="/html/body/div/div[2]/ul[1]/li[4]/a/span") private WebElement ActiveUsrGrplink;
	@FindBy (xpath="/html/body/div/div[2]/div/h3") private WebElement subtitle;
	@FindBy (xpath="/html/body/div/div[1]/header/div/ul/li[1]/span") private WebElement main;
	@FindBy (xpath="/html/body/div/div[1]/header/div/ul/li[1]/a") private WebElement maintxt;
	@FindBy (xpath="/html/body/div/div[1]/header/div/ul/li[2]/span") private WebElement apps;
	@FindBy (xpath="/html/body/div/div[1]/header/div/ul/li[2]/a") private WebElement appstxt;
	@FindBy (xpath="/html/body/div/div[1]/header/div/ul/li[3]/span") private WebElement live;
	@FindBy (xpath="/html/body/div/div[1]/header/div/ul/li[3]/a") private WebElement livetxt;
	@FindBy (xpath="/html/body/div/div[1]/header/div/ul/li[4]/span") private WebElement data;
	@FindBy (xpath="/html/body/div/div[1]/header/div/ul/li[4]/a") private WebElement datatxt;
	@FindBy (xpath="/html/body/div/div[1]/header/div/ul/li[5]/span") private WebElement notes;
	@FindBy (xpath="/html/body/div/div[1]/header/div/ul/li[5]/a") private WebElement notestxt;
	@FindBy (xpath="/html/body/div/div[1]/header/div/div") private WebElement SGdata;
	
	 //To identify all the active user groups for each language
    @FindAll({
       @FindBy(xpath="//*[@id=\"events-per-group\"]/div")
			})private List<WebElement> usergrpdata;
       
    Map<String,String> inputdata;
    int size;
	public ActiveUserGrpPage(WebDriver driver) {
		BaseTest.driver = driver; 
        PageFactory.initElements(driver, this);
	}
	 public ActiveUserGrpPage validatetitle() {
			//Validate if we are on the right page and if the page title and subtitle are displayed
			implicitWait();
			click(ActiveUsrGrplink);
			Assert.assertTrue(getTitle().contains("We Build SG Data"));
			Assert.assertTrue(gettxt(subtitle).contains("active user groups with > 5 events"));
			return this;

	   }
	 public ActiveUserGrpPage validateheader() {
			//Validate if we are on the right page and if the page title and subtitle are displayed
			implicitWait();
			
			Assert.assertTrue(gettxt(maintxt).contains("main"));
			click(main);
			navigateback();
			
			implicitWait();
			Assert.assertTrue(gettxt(appstxt).contains("apps"));
			click(apps);
			navigateback();
			
			implicitWait();
			Assert.assertTrue(gettxt(livetxt).contains("live"));
			click(live);
			navigateback();
			
			implicitWait();
			Assert.assertTrue(gettxt(datatxt).contains("data"));
			click(data);
			navigateback();
			
			implicitWait();
			Assert.assertTrue(gettxt(notestxt).contains("notes"));
			click(notes);
			navigateback();
			
			
			implicitWait();
			Assert.assertTrue(gettxt(SGdata).contains("SG DATA"));
			click(SGdata);
			navigateback();
			
			
			return this;

	   }
	 public ActiveUserGrpPage activeusergroup() throws IOException {
		
		 inputdata = (Map<String,String>) ReadExcelClass.Readinputfile("C:\\Users\\Sahana Rangarajan\\Git Repo\\webuildsg\\UserGroup.xlsx");
		System.out.println(inputdata.entrySet());
		 //Get the size of number of groups 
 		size = driver.findElements(By.xpath("//*[@id=\"events-per-group\"]/div")).size();
 		for(int j=1;j<=size;j++) { 
 			//Iterate across each element and check if the value matches with that in the spreadsheet
			WebElement el = driver.findElement(By.xpath("//*[@id='events-per-group']/div["+j+"]/div[1]"));
			WebElement elval = driver.findElement(By.xpath("//*[@id='events-per-group']/div["+j+"]/div[2]"));
			System.out.println(el.getText()+" "+elval.getText());
			String XLval = inputdata.get(gettxt(el));
			String pageVal = gettxt(elval);
			Assert.assertTrue(XLval.contains(pageVal));
				
			}
			
 		
 		
 		return this;
		 
		 
	 }


}
