package com.zoopla.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.utilities.TestBase;

public class SearchPO extends TestBase {
	Logger log = Logger.getLogger(getClass().getName());
	public SearchPO(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath = "selectboxit-options selectboxit-list")
	WebElement dropDownBtn;
	@FindBy(xpath = "//select[@name='results_sort']")
	WebElement sortDropDown;
	@FindBy(xpath = "//li[starts-with(@id,'listing')]//a[@class='photo-hover']")
	List<WebElement> searchList;
	
	public void sortPriceDesc(String sortText) {
		log.info("SearchPO : sortPriceDesc " + sortText + "\n"  + sortDropDown + "\n" + dropDownBtn);
		browserUtil.selectByValue(sortDropDown, sortText);
	}
	
	public void selectNthSearchResult(int n) {
		log.info("SearchPO : selectNthSearchResult");
		if (searchList.size() > n) {
			browserUtil.udfClick(searchList.get(n));
			
		}
	}
	
	
}
