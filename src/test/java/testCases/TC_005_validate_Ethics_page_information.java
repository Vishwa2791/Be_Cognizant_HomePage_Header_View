package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC_005_validate_Ethics_page_information extends BaseClass {
	
	@Test (priority = 1)
	public void printEthicsInfo() throws IOException {
		ep.ethicsPageInfo();
	}
	
}
