package com.zoopla.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.zoopla.utilities.TestBase;

public class ZooplaHomePO extends TestBase {
	Logger log = Logger.getLogger(getClass().getName());
	public ZooplaHomePO(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "//a[@aria-label='Zoopla']")
	WebElement homePage;
	@FindBy(xpath ="//input[@id='search-input-location']")
	WebElement searchBox;
	@FindBy(xpath = "//button[@id='search-submit']")
	WebElement searchBtn;
	@FindBy(xpath ="//button[@class='ui-button-secondary']")
	WebElement cookiesSaveBtn;	
	
	public void validateHomePage() {
		log.info("ZooplaHomePO:validateHomePage");
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(cookiesSaveBtn).perform();
			browserUtil.udfClick(cookiesSaveBtn);
			log.info("cookies pop up is present" + cookiesSaveBtn.getText());
		} catch(Exception e) {
			log.info("cookies pop up is not present " + e.getLocalizedMessage());
		}
		browserUtil.waitForVisibility(homePage);
		Assert.assertEquals(homePage.isDisplayed(), true);
	}
	
	public void enterSearchText(String sText) {
		log.info("ZooplaHomePO:enterSearchText");
		browserUtil.waitForVisibility(searchBox);
		browserUtil.udfSendKeys(searchBox, sText);
//		browserUtil.udfClick(searchBox);
		browserUtil.udfClick(searchBtn);
	}
}
