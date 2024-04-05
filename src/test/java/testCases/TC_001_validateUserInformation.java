package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC_001_validateUserInformation extends BaseClass {

	@Test(priority = 1)
	public void the_user_navigated_to_the_cognizant_page() throws InterruptedException {
	
	    Assert.assertTrue(hp.verifyPage());
	}

	 
	
	@Test(priority = 2 , dependsOnMethods = {"the_user_navigated_to_the_cognizant_page"} )
	public void the_user_clicks_on_user_icon() throws InterruptedException {
	
		hp.clickProfile();
		Thread.sleep(3000);
//		hp.clickProfile();
		if (!hp.isVisibleProfile())	{hp.clickProfile();}
	}

	
	@Test(priority = 3 , dependsOnMethods = {"the_user_clicks_on_user_icon"})
	public void user_can_validate_the_mail_contains_cognizant_com() throws InterruptedException {
		
	    Assert.assertTrue(hp.verifyUser());
	}
	
	
	@Test(priority = 4, dependsOnMethods = {"the_user_clicks_on_user_icon"})
	public void the_user_close_on_user_icon() throws InterruptedException {

			hp.clickProfile();
	}
}
