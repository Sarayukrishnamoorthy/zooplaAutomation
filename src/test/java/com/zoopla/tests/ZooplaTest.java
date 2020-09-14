package com.zoopla.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zoopla.pageobjects.AgentPO;
import com.zoopla.pageobjects.SearchPO;
import com.zoopla.pageobjects.ZooplaHomePO;
import com.zoopla.utilities.BrowserUtility;
import com.zoopla.utilities.TestBase;

public class ZooplaTest extends TestBase {
	Logger log = Logger.getLogger(getClass().getName());
	ZooplaHomePO homepo;
	SearchPO searchpo;
	AgentPO agentpo;
	
	@Test(priority = 1)
	@Parameters("browser")
	public void openBrowser(String sBrowser) {
		log.info("Test : openBrowser" + sBrowser);

		browserUtil.launchBrowser(sBrowser);
		browserUtil.openUrl(commonUtil.getUrl());
		driver = BrowserUtility.driver;
		
		homepo = new ZooplaHomePO(driver);
		searchpo = new SearchPO(driver);
		agentpo = new AgentPO(driver);
	}
	
	@Test(priority = 2)
	public void validateHomePage() {
		log.info("Test : validateHomePage");
		homepo.validateHomePage();
	}
	
	@Test(priority = 3)
	@Parameters("sCity")
	public void enterSearchText(String sCity) {
		log.info("Test : enterSearchText");
		homepo.enterSearchText(sCity);
	}
	
	@Test(priority = 4)
	@Parameters("sortBy")
	public void sortPrice(String sortBy) {
		log.info("Test : sortPrice" + searchpo +"\n"+ driver);
		searchpo.sortPriceDesc(sortBy);
	}
	
	@Test(priority = 5)
	@Parameters("propertyN")
	public void selectNthSearchRes(String propertyN) {
		log.info("Test : selectNthSearchRes");
		int n = Integer.parseInt(propertyN);
		log.info("select n value from list " + n);
		searchpo.selectNthSearchResult(n);
	}
	@Test(priority = 6)
	public void clickOnAgentName() {
		log.info("Test : clickOnAgentName");
		agentpo.goToAgentPage();
	}
	
	@Test(priority = 7)
	public void verifyNameInAgentPage() {
		log.info("Test : VerifyNameInAgentPage");
		agentpo.validatePropertiesForAgent();
	}
		
}
