package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	public static boolean flag;
	public WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	public static String Url, header, methodName;
	public static List<String> windowIDList, links;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
}
