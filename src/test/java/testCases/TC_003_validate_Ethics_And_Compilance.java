package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC_003_validate_Ethics_And_Compilance extends BaseClass {

	@Test (priority = 1)
	public void verifyEthicsAndCompliance() throws InterruptedException {
		Assert.assertTrue(hp.verifyEthics());
	}
}
