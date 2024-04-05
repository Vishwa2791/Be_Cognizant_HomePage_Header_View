package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageObjects.EthicsPage;
import pageObjects.HomePage;
import utilities.ExcelUtility;

public class BaseClass {
	public static WebDriver driver;
	public static List<String> ls=new ArrayList<>();
	public static HomePage hp;
	public static EthicsPage ep;
	public static boolean flag = true;
	public static String browser, configPath = "src\\test\\resources\\config.properties";
	public static Properties ps = new Properties();
	public static FileReader fr;
	
	@BeforeTest
	@Parameters({"browser"})
	public void driverSetup(String br) throws IOException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--guest");
		
		switch(br.toLowerCase()) {
			case "chrome": {
				driver = new ChromeDriver(); 
				ExcelUtility.setCellCount();
				browser = br;
				break;
			}
			case "edge": {
				driver = new EdgeDriver(); 
				ExcelUtility.setCellCount();
				browser = br;
				break;
			}
		}
		fr = new FileReader(configPath);
		ps.load(fr);
		System.out.println("\n\t"+br.toUpperCase() + " TEST\n");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get(ps.getProperty("url"));
		driver.navigate().refresh();
		driver.manage().window().maximize();
		hp = new HomePage(driver);
		ep = new EthicsPage(driver);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
	}
	
	public static boolean checkIcon(WebElement ele) {
	    try {
	        return ele.isDisplayed();
	    } catch (NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
	        // Handle the exception, log it, or perform any necessary actions
	        return false;
	    }
	}
	
	public static boolean checkEthics(WebElement ele) {
		try {
			return ele.isDisplayed();
		} catch (NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
			// Handle the exception, log it, or perform any necessary actions
			return false;
		}
	}
	
	public static void printList(List<WebElement> list) {
		for(WebElement ele:list) {
			System.out.println(ele.getText().split("\n")[0]);
//			ls.add(ele.getText());
		}
	}
	
	public static void printHeaders(List<WebElement> list) {
		for(int i = 1; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
//			ls.add(ele.getText());
		}
	}
	
	public static void printEthicsInfo(WebElement e) {
		System.out.println("\n<<<<<<<<<<Ethics Page Information>>>>>>>>>>");
		System.out.println(e.getText());
	}
	
	public String captureScreen(String tname, boolean pass){

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=(pass==true)?System.getProperty("user.dir")+"\\passed_screenshots\\" + tname + "_" + timeStamp + ".jpg":System.getProperty("user.dir")+"\\failed_screenshots\\" + tname + "_" + timeStamp + ".jpg";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

	public static boolean checkHeaders(List<WebElement> headers) {
		// TODO Auto-generated method stub
        for (WebElement ele : headers) {
        	if (!ele.isDisplayed()) flag = false; break;
        }
		return flag;
	    
	}
}
