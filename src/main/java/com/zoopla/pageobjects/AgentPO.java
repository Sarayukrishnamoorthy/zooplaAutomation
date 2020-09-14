package com.zoopla.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.zoopla.utilities.TestBase;

public class AgentPO extends TestBase{
	Logger log = Logger.getLogger(getClass().getName());
	String agentName="";
	public AgentPO(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='dp-sidebar-wrapper__contact']//div[@class='ui-agent__text']")
	WebElement agentNameText;
	@FindBy(xpath ="//h1[@class='bottom-half']")
	WebElement nameOnAgentPage;
	
	
	public void goToAgentPage() {
		log.info("AgentPO : gotoAgentPage");
		browserUtil.waitForVisibility(agentNameText);
		agentName = browserUtil.udfGetKeys(agentNameText); 
		browserUtil.udfClick(agentNameText);
	}
	
	public void validatePropertiesForAgent() {
		log.info("AgentPO : validatePropertiesForAgent");
		browserUtil.waitForVisibility(nameOnAgentPage);
		String agName = browserUtil.udfGetKeys(nameOnAgentPage).split(",")[0];
		Assert.assertEquals(agentName.contains(agName), true);
	}
	
}
