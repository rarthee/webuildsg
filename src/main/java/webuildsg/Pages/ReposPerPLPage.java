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

public class ReposPerPLPage extends BaseTest{

	
    @FindBy (xpath="/html/body/div/div[2]/ul[1]/li[6]/a/span") private WebElement reposperProgLang;
    @FindBy (xpath="/html/body/div/div[2]/div/h3") private WebElement subtitle;
    @FindAll({
 	   @FindBy(id = "language-c"),
 	   @FindBy(id = "language-c++"),
 	   @FindBy(id = "language-clojure"),
 	   @FindBy(id = "language-coffeescript"),
 	   @FindBy(id = "language-css"),
 	   @FindBy(id = "language-go"),
 	   @FindBy(id = "language-haskell"),
 	   @FindBy(id = "language-html"),
 	   @FindBy(id = "language-java"),
 	   @FindBy(id = "language-javascript"),
 	   @FindBy(id = "language-julia"),
 	   @FindBy(id = "language-objective-c"),
 	   @FindBy(id = "language-php"),
 	   @FindBy(id = "language-python"),
 	   @FindBy(id = "language-r"),
 	   @FindBy(id = "language-ruby"),
 	   @FindBy(id = "language-rust"),
 	   @FindBy(id = "language-shell"),
 	   @FindBy(id = "language-swift"),
 	   @FindBy(id = "language-tex")
 	 	       	})private List<WebElement> langdata;
    //To identify all the projects within each programming language
    @FindAll({
       @FindBy(xpath="//*[@id=\"repos-per-programming-language\"]/p/a")
  	  
		})private List<WebElement> projdata;
    @FindBy (className="footer-twitter") private WebElement twitter;
    @FindBy (className="footer-facebook") private WebElement facebook;
    @FindBy (className="footer-github") private WebElement github;
    @FindBy (className="footer-calendar") private WebElement caledar;
    @FindBy (className="footer-rss") private WebElement rss;
    @FindBy (className="footer-itunes") private WebElement itunes;
    
    Map<String,String> inputdata;
    int size;
    public ReposPerPLPage(WebDriver driver) {
		BaseTest.driver = driver; 
        PageFactory.initElements(driver, this);
	}
    
    public ReposPerPLPage validatetitle() {
		//Validate if we are on the right page and if the page title and subtitle are displayed
		implicitWait();
		click(reposperProgLang);
		Assert.assertTrue(getTitle().contains("We Build SG Data"));
		Assert.assertTrue(gettxt(subtitle).contains("repositories per programming languages"));
		return this;

    }

    public ReposPerPLPage selectlangs() throws IOException, InterruptedException {
    	//Read Language.xlsx into a Map and validate if the Language is present on the page or not
    	implicitWait();
    	inputdata = (Map<String,String>) ReadExcelClass.Readinputfile("C:\\Users\\Sahana Rangarajan\\Git Repo\\webuildsg\\Languages.xlsx");
    	int e_size = langdata.size();
    	WebElement e;
    	//Iterate across each language button
    	for(int i=0;i<e_size;i++) {
    		e=langdata.get(i);
    		System.out.println(e.getText());
    		scrollup();
    		implicitWait();
    		click(e);
    		//Check if the value of the webelement is same as that coming from the spreadsheet(inputdata)
    		implicitWait();
    		implicitWait();
    		
    		
    		Assert.assertTrue(inputdata.containsValue(gettxt(e)));
    		//Get the size of number of projects in each language
    		size = driver.findElements(By.xpath("//*[@id=\'repos-per-programming-language\']/p/a")).size();
    		System.out.println("size "+size);
    		int scroll = 100;
    		for(int j=1;j<=size;j++) {
    			implicitWait();
    			//scroll pagedown after every occurrence so that the page moves down for each of the items 
    			scrolldown(scroll);
    			scroll = scroll + 50;
    			Thread.sleep(2000);
    			//Iterate across each project in a specific language. Click them and come back
    			WebElement el = driver.findElement(By.xpath("//*[@id=\'repos-per-programming-language\']/p["+j+"]/a"));
    			System.out.println(j+" "+el.getText());
    			
    			click(el);
    			implicitWait();
    			navigateback();
    			implicitWait();
    		}
    		
    	}
	
   	
	return this;
    }
    
    public ReposPerPLPage socialmedialinks() {
    	scrolldown(1000);
    	
    	click(twitter);
    	implicitWait();
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
