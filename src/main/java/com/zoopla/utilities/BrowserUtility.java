package com.zoopla.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility {
	 public static WebDriver driver = null;
	 JavascriptExecutor jse = null;
	public void launchBrowser(String sBrowserName) {
		if (sBrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (sBrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		jse = (JavascriptExecutor)driver;

	}
	public void openUrl(String sUrl) {
		driver.get(sUrl);
	}

	public void quitBrowser(){
		driver.quit();
	}
	public void closeBrowser(){
		driver.close();
	}
	public void udfSendKeys(WebElement ele, String sData) {
		ele.clear();
		ele.sendKeys(sData);
	}
	public void udfClick(WebElement ele) {
		ele.click();
	}
	public String udfGetKeys(WebElement ele) {
		return ele.getText();
	}
	public void waitForVisibility(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void jsClick(WebElement element) {
		jse.executeScript("arguments[0].click();", element);
	}
	public void jsSendKeys(WebElement ele, String sValue) {

		jse.executeScript("arguments[0].value='"+sValue+"';", ele);
	}

	public void selectByVisibleText(WebElement selectEle, String visibleText) {
		Select dropDown = new Select(selectEle);
		dropDown.selectByVisibleText(visibleText);
	}
	public void selectByValue(WebElement selectEle, String value) {
		Select dropDown = new Select(selectEle);
		dropDown.selectByValue(value);
	}
	public void jsSelect(WebElement select, String value) {

		jse.executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", select, value);
	}

}
