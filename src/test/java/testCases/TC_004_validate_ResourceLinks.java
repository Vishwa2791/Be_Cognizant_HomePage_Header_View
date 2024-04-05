package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EthicsPage;
import testBase.BaseClass;

public class TC_004_validate_ResourceLinks extends BaseClass {
	
	
	@Test(priority = 1)
	public void navigateEthics() throws InterruptedException 
	{	
		hp.navigateEthicsPage();
	}
	
	
	@Test(priority = 2)
	public void verifyPage(){
		ep = new EthicsPage(driver);
		Assert.assertTrue(ep.verifyPage());
	}
	
	@Test(priority = 3, dependsOnMethods = {"navigateEthics"})
	public void validateHelpline() throws InterruptedException {
		ep = new EthicsPage(driver);
		Assert.assertTrue(ep.validateHelpline());
	}
	
	@Test(priority = 4, dependsOnMethods = {"navigateEthics"})
	public void validateCodeofEthics() throws InterruptedException {
		ep = new EthicsPage(driver);
		Assert.assertTrue(ep.validateCodeofEthics());
	}
	
	@Test(priority = 5, dependsOnMethods = {"navigateEthics"})
	public void validateGlobalCorporatePolicies() throws InterruptedException {
		ep = new EthicsPage(driver);
		Assert.assertTrue(ep.validateGlobalCorporatePolicies());
	}
	@Test(priority = 6, dependsOnMethods = {"navigateEthics"})
	public void validateEthicsandCompliancePolicies() throws InterruptedException {
		ep = new EthicsPage(driver);
		Assert.assertTrue(ep.validateEthicsandCompliancePolicies());
	}
	@Test(priority = 7, dependsOnMethods = {"navigateEthics"})
	public void validateEthicsandComplianceAmbassadors() throws InterruptedException {
		ep = new EthicsPage(driver);
		Assert.assertTrue(ep.validateEthicsandComplianceAmbassadors());
	}
	@Test(priority = 8, dependsOnMethods = {"navigateEthics"})
	public void validateEthicsandComplianceProgramOverview() throws InterruptedException {
		ep = new EthicsPage(driver);
		Assert.assertTrue(ep.validateEthicsandCompilanceProgramOverview());
	}
	@Test(priority = 9, dependsOnMethods = {"navigateEthics"})
	public void validateEthicsandCompliancePresentation() throws InterruptedException {
		ep = new EthicsPage(driver);
		Assert.assertTrue(ep.validateEthicsandCompilancePresentation());
	}
	@Test(priority = 10, dependsOnMethods = {"navigateEthics"})
	public void validateGlobalPrivacy() throws InterruptedException {
		ep = new EthicsPage(driver);
		Assert.assertTrue(ep.validateGlobalPrivacy());
	}
	@Test(priority = 11, dependsOnMethods = {"navigateEthics"})
	public void validateRegulatoryandBUCompilance() throws InterruptedException {
		ep = new EthicsPage(driver);
		Assert.assertTrue(ep.validateRegulatoryandBUCompilance());
	}
		
}
