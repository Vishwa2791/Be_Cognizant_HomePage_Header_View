package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testBase.BaseClass;
import utilities.ExcelUtility;

public class HomePage extends BasePage {

	JavascriptExecutor jse = (JavascriptExecutor)driver ;
	Actions act = new Actions(driver);
	
	//Constructor
	public HomePage(WebDriver driver)
	
	{
		super(driver);
	}
	
	@FindBy(xpath = "//div[@id= 'O365_MainLink_MePhoto']")
	WebElement btnProfile ;
	
	@FindBy(xpath = "//div[contains(@class,'accountDetails')]")
	WebElement divProfile;
	
	@FindBy(xpath="//div[@id='mectrl_main_body']")
	WebElement divProfileBox;
	
	@FindBy(xpath = "//div[@id='mectrl_currentAccount_primary']")
	WebElement txtUserName ;
	
	@FindBy(xpath = "//div[@id='mectrl_currentAccount_primary']//following::div[1]")
	WebElement txtUserMail ;
	
	@FindBy(xpath="//span[contains(@class,'ms-Button-label label')]")
	List<WebElement> headers;
	
	@FindBy(xpath = "//button[@name = 'Company']")
	WebElement btnCompany ;
	
	@FindBy(xpath = "//button[@name = 'Service Lines']")
	WebElement btnService ;
	
	@FindBy(xpath = "//button[@name = 'Sales Resources']")
	WebElement btnSales ;
	
	@FindBy(xpath = "//button[@name = 'Markets and Countries']")
	WebElement btnMarket ;
	
	@FindBy(xpath = "//button[@name = 'Corporate Functions']")
	WebElement btnCorporate;
	
	@FindBy(xpath = "//button[@name = 'People']")
	WebElement btnPeople;
	
	@FindBy(xpath = "//*[@id= 'spTopPlaceholder']/div/div[2]//div[2]//i")//xpath of icon in header company
	WebElement dropCompany;
	
	@FindBy(xpath = "//*[@id= 'spTopPlaceholder']/div/div[2]//div[3]//i")
	WebElement dropService;
	
	@FindBy(xpath = "//*[@id= 'spTopPlaceholder']/div/div[2]//div[4]//i")
	WebElement dropSales;
	
	@FindBy(xpath = "//*[@id= 'spTopPlaceholder']/div/div[2]//div[5]//i")
	WebElement dropMarket;
	
	@FindBy(xpath = "//*[@id= 'spTopPlaceholder']/div/div[2]//div[6]//i")
	WebElement dropCorporate;
	
	@FindBy(xpath = "//*[@id= 'spTopPlaceholder']/div/div[2]//div[7]//i")
	WebElement dropPeople;
	
	@FindBy(xpath = "//ul[@role='presentation']")
	WebElement SubHeader;
	
	@FindBy(xpath = "//li[@role='presentation']")
	List<WebElement> listHeader;
	
	@FindBy(xpath = "//button[@name='Corporate Functions']/descendant::i")
	WebElement btnCorporateFunctions ;
	
	@FindBy(xpath = "//a[@name = 'Legal & Corporate Administration']")
	WebElement btnLACA ;
	
	@FindBy(xpath = "//span[normalize-space()='Ethics and Compliance']")
	WebElement btnEthics;
	
	@FindBy(xpath = "//a[@name = 'Legal & Corporate Administration']")
	WebElement subBtnLegal;
	
	@FindBy(name="Ethics and Compliance")
	WebElement subBtnEthics;
	
	public void clickProfile() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		jse.executeScript("arguments[0].click();", btnProfile);	
//		if(ExpectedConditions.attributeContains(divProfileBox, "class", "expanded") == null) jse.executeScript("arguments[0].click();", btnProfile);	
	}
	
	public boolean isVisibleProfile() {
		try {
			flag = divProfileBox.getAttribute("class").contains("expanded");
		}catch(NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
			flag = false;
		}
		return flag;
	}
	
	public String getUserName() {
//		wait.until(ExpectedConditions.visibilityOf(txtUserName));
		return txtUserName.getText();
	}
	
	public String getUserEmail() {
//		wait.until(ExpectedConditions.visibilityOf(txtUserMail));
		return txtUserMail.getText();
	}
	
	public Boolean verifyUser() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(txtUserMail));
		Thread.sleep(2000);
		System.out.println(txtUserMail.getText());
		return txtUserMail.getText().contains("@cognizant.com");
	}
	
	
	public Boolean verifyPage() throws InterruptedException {
		Thread.sleep(5000);
		return driver.getTitle().equals("Be.Cognizant - Home");
	}
	
	public boolean verifyHeaders() {
		return BaseClass.checkHeaders(headers);
	}
	
	public void clickCompany() {
		jse.executeScript("arguments[0].click();", btnCompany);
	}
	
	public void clickService() {
		jse.executeScript("arguments[0].click();", btnService);
	}
	
	public void clickSales() {
		jse.executeScript("arguments[0].click();", btnSales);
	}
	
	public void clickMarket() {
		jse.executeScript("arguments[0].click();", btnMarket);
	}
	
	public void clickCorporate() {
		jse.executeScript("arguments[0].click();", btnCorporate);
	}
	public void clickPeople() {
		jse.executeScript("arguments[0].click();", btnPeople);
	}
	
	public void clickEthics() {
		subBtnEthics.click();
	}
	
	public boolean verifyEthics() throws InterruptedException {
		clickCorporate();
		hoverLegal();
		boolean flag =  BaseClass.checkEthics(subBtnEthics);
		clickCorporate();
		return flag;
	}
	
	public void hoverLegal() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(subBtnLegal));
		act.moveToElement(subBtnLegal).perform();
        wait.until(ExpectedConditions.elementToBeClickable(subBtnEthics));
	}
	
	public boolean checkIcon1() 
	{	
		return 	BaseClass.checkIcon(dropCompany);
	}
	
	public boolean checkIcon2() 
	{	
		return 	BaseClass.checkIcon(dropService);
	}
	
	public boolean checkIcon3() 
	{	
		return 	BaseClass.checkIcon(dropSales);
	}
	public boolean checkIcon4() 
	{	
		return 	BaseClass.checkIcon(dropMarket);
	}
	
	public boolean checkIcon5() 
	{	
		return 	BaseClass.checkIcon(dropCorporate);
	}
	
	public boolean checkIcon6() 
	{	
		return 	BaseClass.checkIcon(dropPeople);
	}
	
	
	public void printHeaders() throws IOException {
		System.out.println("\n<<<<<<<<<<HomePage Headers List>>>>>>>>>>");
		BaseClass.printHeaders(headers);
		ExcelUtility.writeHeadersData(headers);
	}

	public  void printCompanyList() throws IOException {
		System.out.println("\n<<<<<<<<<<Company list items>>>>>>>>>>");
		BaseClass.printList(listHeader);
		ExcelUtility.writeSubHeadersData(listHeader);
	}
	
	public  void printServiceList() throws IOException {
		System.out.println("\n<<<<<<<<<<Service list items>>>>>>>>>>");
		BaseClass.printList(listHeader);
		ExcelUtility.writeSubHeadersData(listHeader);
	}
	public  void printSalesList() throws IOException {
		System.out.println("\n<<<<<<<<<<Sales list items>>>>>>>>>>");
		BaseClass.printList(listHeader);
		ExcelUtility.writeSubHeadersData(listHeader);
	}
	
	public  void printMarketList() throws IOException {
		System.out.println("\n<<<<<<<<<<Market list items>>>>>>>>>>");
		BaseClass.printList(listHeader);
		ExcelUtility.writeSubHeadersData(listHeader);
	}
	
	public  void printCorporateList() throws IOException {
		System.out.println("\n<<<<<<<<<<Corporate list items>>>>>>>>>>");
		BaseClass.printList(listHeader);
		ExcelUtility.writeSubHeadersData(listHeader);
	}
	public  void printPeopleList() throws IOException {
		System.out.println("\n<<<<<<<<<<People list items>>>>>>>>>>");
		BaseClass.printList(listHeader);
		ExcelUtility.writeSubHeadersData(listHeader);
	}
	
	public void navigateEthicsPage() throws InterruptedException {
		clickCorporate();
		hoverLegal();
		clickEthics();
	}
}
