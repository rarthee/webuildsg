package webuildsg.Base;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import webuildsg.util.TestUtils;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class BaseTest {


		protected static WebDriver driver;
		static InputStream inputStream;
		static Properties prop;
	
		public static  Logger logger = LogManager.getLogger(BaseTest.class);
		
		public void driversetup() throws IOException {
			System.out.println("Setting up WebDriver");
			prop = new Properties();
			String propFileName = "config.properties";
			inputStream = BaseTest.class.getClassLoader().getResourceAsStream(propFileName);
			prop.load(inputStream);
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sahana Rangarajan\\Documents\\Arthee\\chromedriver.exe");
			driver = new ChromeDriver();	
			String urlval = prop.getProperty("urlvalue");
			driver.get(urlval);
			System.out.println(urlval);
			driver.manage().window().maximize();
		
	}
		
		public void waitforvisibility(WebElement e) {
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver,TestUtils.WAIT);
			wait.until(ExpectedConditions.visibilityOf(e));
			
		}
		
		public  void implicitWait() {

			driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		}
		
		public void click(WebElement e) {
			e.click();
			logger.info("This is an information message for click");
			logger.warn("This is a warning message for click");
			logger.error("This is an error message for click");
			logger.fatal("This is a fatal message for click");
		}
			
			
		public void sendkeys(WebElement e,String value) {
			
			e.sendKeys(value);
			logger.info("This is an information message for sendkeys");
			logger.warn("This is a warning message for sendkeys");
			logger.error("This is an error message for sendkeys");
			logger.fatal("This is a fatal message for sendkeys");
		}
		public void clear(WebElement e) {
			
			e.clear();
		}
		public void getattribute(WebElement e,String attr) {
		
			e.getAttribute(attr);
		}
		public  String gettxt(WebElement e) {
			
			
			String txt = e.getText();
			logger.info("This is an information message for getText");
			logger.warn("This is a warning message for getText");
			logger.error("This is an error message for getText");
			logger.fatal("This is a fatal message for getText");
			
			return txt;
			
		}
		public static void navigateback(){
			
			driver.navigate().back();
		}
		public static void refresh() {
			
			driver.navigate().refresh();
		}
		public String getTitle() {
			
			return driver.getTitle();
			
		}
		public static void quit(){
			
			driver.quit();
		}

}



