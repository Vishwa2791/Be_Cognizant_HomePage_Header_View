package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testBase.BaseClass;
import utilities.ExcelUtility;

public class EthicsPage extends BasePage {
		
	//Constructor
	public EthicsPage(WebDriver driver)  
	{
		super(driver);
	}
	
	JavascriptExecutor jse = (JavascriptExecutor) driver ;
	
	@FindBy(id="title_text")
	WebElement txtTitle;
	
	@FindBy(xpath = "//div[@data-automation-id = 'textBox']/p[1]")
	WebElement EthicsPageInfo;
	
	@FindBy(xpath = "//div[@data-automation-id = 'textBox']/ul/li")
	List <WebElement> EthicsPageInfo1;
	
	@FindBy(xpath = "(//a[contains(@class,'ButtonCard')])[1]")
	WebElement lnkHelpLine;
	
	@FindBy(xpath = "(//a[contains(@class,'ButtonCard')])[2]")
	WebElement lnkCodeOfEthics;
	
	@FindBy(xpath = "(//a[contains(@class,'ButtonCard')])[3]")
	WebElement lnkGlobalCorporatePolicies;
	
	@FindBy(xpath = "(//a[contains(@class,'ButtonCard')])[4]")
	WebElement lnkEthicsandCompilancePolicies;
	
	@FindBy(xpath = "(//a[contains(@class,'ButtonCard')])[5]")
	WebElement lnkEthicsandCompilanceAmbassadors;
	
	@FindBy(xpath = "(//a[contains(@class,'ButtonCard')])[6]")
	WebElement lnkEthicsandCompilanceProgramOverview;
	
	@FindBy(xpath = "(//a[contains(@class,'ButtonCard')])[7]")
	WebElement lnkEthicsandCompilancePresentation;
	
	@FindBy(xpath = "(//a[contains(@class,'ButtonCard')])[8]")
	WebElement lnkGlobalPrivacy;
	
	@FindBy(xpath = "(//a[contains(@class,'ButtonCard')])[9]")
	WebElement lnkRegulatoryandBUCompilance;
	
	@FindBy(xpath="//div[@data-automation-id='textBox']")
	WebElement txtEthicsInfo;
	
	@FindBy(id="title_text")
	WebElement txtHeader;
	
	@FindBy(xpath = "(//button[@role='text'])[1]")
	WebElement txtPdfName;
	
	@FindBy(xpath = "//button[@role='text']/span/span[2]/span")
	WebElement txtPdfname2;
	public boolean verifyPage()
	{
		//Thread.sleep(5000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='title_text']")));
		return txtTitle.getText().equals("Ethics & Compliance");
	}
	
//	public void getLinks() {
//		links = driver.findElements(By.xpath("//a[contains(@class,'ButtonCard')]"));
//	}
	
	public void clickHelpLine() throws InterruptedException {
		Thread.sleep(5000);
		lnkHelpLine.click();
	}
	
	public void clickCodeOfEthics() {
		lnkCodeOfEthics.click();
	}
	
	public void clickGlobalCorporatePolicies() {
		lnkGlobalCorporatePolicies.click();
	}
	
	public void clickEthicsandComilancePolicies() {
		lnkEthicsandCompilancePolicies.click();
	}
	
	public void clickEthicsandComilanceAmbassadors() {
		lnkEthicsandCompilanceAmbassadors.click();
	}
	
	public void clickEthicsandCompilanceProgramOverview() {
		lnkEthicsandCompilanceProgramOverview.click();
	}
	
	public void clickEthicsandCompilancePresentation() {
		lnkEthicsandCompilancePresentation.click();
	}
	
	public void clickGlobalPrivacy() {
		lnkGlobalPrivacy.click();
	}
	
	public void clickRegulatoryandBUCompilance() {
		lnkRegulatoryandBUCompilance.click();
	}
	
	public boolean validateHelpline() throws InterruptedException {
//		Thread.sleep(5000);
		Url = lnkHelpLine.getAttribute("href");
		jse.executeScript("window.open()");
		windowIDList=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowIDList.get(1));			
		driver.get(Url);
		wait.until(ExpectedConditions.visibilityOf(txtHeader));
		Thread.sleep(2000);
		header =  txtHeader.getText();
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		new BaseClass().captureScreen(methodName, true);
		driver.close();			
		driver.switchTo().window(windowIDList.get(0));
		return header.equals("The Ethics & Compliance Helpline");
	}
	
	public boolean validateCodeofEthics() throws InterruptedException {
//		Thread.sleep(5000);
		Url = lnkCodeOfEthics.getAttribute("href");
		jse.executeScript("window.open()");
		windowIDList=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowIDList.get(1));			
		driver.get(Url);
		wait.until(ExpectedConditions.visibilityOf(txtPdfName));
		Thread.sleep(2000);
		header=  txtPdfName.getAttribute("title");
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		new BaseClass().captureScreen(methodName, true);
		driver.close();			
		driver.switchTo().window(windowIDList.get(0));
		return header.equals("code-of-ethics_english.pdf");
	}
	//"Global Corporate Policies"
	
	public boolean validateGlobalCorporatePolicies() throws InterruptedException {
//		Thread.sleep(5000);
		Url = lnkGlobalCorporatePolicies.getAttribute("href");
		jse.executeScript("window.open()");
		windowIDList=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowIDList.get(1));			
		driver.get(Url);
		wait.until(ExpectedConditions.visibilityOf(txtHeader));
		Thread.sleep(2000);	
		header =  txtHeader.getText();
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		new BaseClass().captureScreen(methodName, true);
		driver.close();			
		driver.switchTo().window(windowIDList.get(0));
		return header.equals("Global Corporate Policies");
	}
	
	//"Code of Ethics and Ethics & Compliance Policies"
	public boolean validateEthicsandCompliancePolicies() throws InterruptedException {
//		Thread.sleep(5000);
		Url= lnkEthicsandCompilancePolicies.getAttribute("href");
		jse.executeScript("window.open()");
		windowIDList = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowIDList.get(1));			
		driver.get(Url);
		wait.until(ExpectedConditions.visibilityOf(txtHeader));
		Thread.sleep(2000);	
		header =  txtHeader.getText();
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		new BaseClass().captureScreen(methodName, true);
		driver.close();			
		driver.switchTo().window(windowIDList.get(0));
		return header.equals("Code of Ethics and Ethics & Compliance Policies");
	}
	
	//"Ethics & Compliance Ambassadors"
	public boolean validateEthicsandComplianceAmbassadors() throws InterruptedException {
//		Thread.sleep(5000);
		Url= lnkEthicsandCompilanceAmbassadors.getAttribute("href");
		jse.executeScript("window.open()");
		windowIDList=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowIDList.get(1));			
		driver.get(Url);
		wait.until(ExpectedConditions.visibilityOf(txtHeader));
		Thread.sleep(2000);	
		header =  txtHeader.getAttribute("title");
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		new BaseClass().captureScreen(methodName, true);
		driver.close();			
		driver.switchTo().window(windowIDList.get(0));
		return header.equals("Ethics & Compliance Ambassadors");
	}
	
	//"overview-of-ethics-compliance-program.pdf"
	public boolean validateEthicsandCompilanceProgramOverview() throws InterruptedException {
//		Thread.sleep(5000);
		Url = lnkEthicsandCompilanceProgramOverview.getAttribute("href");
		jse.executeScript("window.open()");
		Set<String> windowIDs=driver.getWindowHandles();
		List<String> windowIDList=new ArrayList<>(windowIDs);
		driver.switchTo().window(windowIDList.get(1));			
		driver.get(Url);
		wait.until(ExpectedConditions.visibilityOf(txtPdfName));
		Thread.sleep(2000);
		header =  txtPdfName.getAttribute("title");
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		new BaseClass().captureScreen(methodName, true);
		driver.close();			
		driver.switchTo().window(windowIDList.get(0));
		return header.equals("overview-of-ethics-compliance-program.pdf");
	}
	
	//"ethics-and-compliance-program-overview-presentation.pdf"
	public boolean validateEthicsandCompilancePresentation() throws InterruptedException {
//		Thread.sleep(5000);
		Url = lnkEthicsandCompilancePresentation.getAttribute("href");
		jse.executeScript("window.open()");
		windowIDList=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowIDList.get(1));			
		driver.get(Url);
		wait.until(ExpectedConditions.visibilityOf(txtPdfName));
		Thread.sleep(2000);	
		header=  txtPdfName.getAttribute("title");
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		new BaseClass().captureScreen(methodName, true);
		driver.close();			
		driver.switchTo().window(windowIDList.get(0));
		return header.equals("ethics-and-compliance-program-overview-presentation.pdf");
	}
	
	public boolean validateGlobalPrivacy() throws InterruptedException {
//		Thread.sleep(5000);
		Url= lnkGlobalPrivacy.getAttribute("href");
		jse.executeScript("window.open()");
		windowIDList=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowIDList.get(1));			
		driver.get(Url);
		wait.until(ExpectedConditions.visibilityOf(txtHeader));
		Thread.sleep(2000);	
		header =  txtHeader.getAttribute("title");
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		new BaseClass().captureScreen(methodName, true);
		driver.close();			
		driver.switchTo().window(windowIDList.get(0));
		return header.equals("Global Privacy");
	}
	

	public boolean validateRegulatoryandBUCompilance() throws InterruptedException {
//		Thread.sleep(5000);
		Url = lnkRegulatoryandBUCompilance.getAttribute("href");
		jse.executeScript("window.open()");
		windowIDList=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowIDList.get(1));			
		driver.get(Url);
		wait.until(ExpectedConditions.visibilityOf(txtHeader));
		Thread.sleep(2000);
		header=  txtHeader.getAttribute("title");
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		new BaseClass().captureScreen(methodName, true);
		driver.close();			
		driver.switchTo().window(windowIDList.get(0));
		return header.equals("Regulatory Legal");
	}
	
	public void ethicsPageInfo() throws IOException {
		BaseClass.printEthicsInfo(txtEthicsInfo);
		ExcelUtility.writeEthicsPageInfo(txtEthicsInfo);
	}
}
