package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC_002_validate_Headers_and_SubHeaders extends BaseClass {
	
	@Test(priority = 1)
	public void getHeaders() throws IOException {
		if (hp.verifyHeaders()) {
			Assert.assertTrue(true); 
			hp.printHeaders();
		}
		else Assert.assertTrue(false);
	}
	
	
	@Test(priority = 2)
	public void clickCompany() throws IOException {
		hp.clickCompany();
		if(hp.checkIcon1()) {
			Assert.assertTrue(true);
			hp.printCompanyList();
		}else {
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 3)
	public void clickServicesLines() throws IOException {
		hp.clickService();
		if(hp.checkIcon2()) {
			Assert.assertTrue(true);
			hp.printServiceList();
		}else {
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 4)
	public void clickSalesResources() throws IOException {
		hp.clickSales();
		if(hp.checkIcon3()) {
			Assert.assertTrue(true);
			hp.printSalesList();
		}else {
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 5)
	public void clickMarketsandCountries() throws IOException {
		hp.clickMarket();
		if(hp.checkIcon4()) {
			Assert.assertTrue(true);
			hp.printMarketList();
		}else {
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 6)
	public void clickCorporatefunction() throws IOException {
		hp.clickCorporate();
		if(hp.checkIcon5()) {
			Assert.assertTrue(true);
			hp.printCorporateList();
		}else {
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 7)
	public void clickPeople() throws IOException {
//		HomePage hp = new HomePage(driver);
		hp.clickPeople();
		if(hp.checkIcon6()) {
			Assert.assertTrue(true);
			hp.printPeopleList();
		}else {
			Assert.assertTrue(false);
		}
	}
}
