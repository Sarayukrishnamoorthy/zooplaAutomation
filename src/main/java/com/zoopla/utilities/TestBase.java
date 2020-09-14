package com.zoopla.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.zoopla.reports.ExtendReportManager;


public class TestBase {
	public static CommonUtility commonUtil = new CommonUtility();
	public static BrowserUtility browserUtil = new BrowserUtility();
	public static ExtendReportManager extendReport = new ExtendReportManager();
	public static WebDriver driver;
	
	
	@BeforeSuite
	public static void initDependencies() throws Exception {
		// property file loading
		commonUtil.loadPropertyFile(commonUtil.sConfigPath);
		commonUtil.loadLog4jPropertyFile(commonUtil.slog4jPath);
		extendReport.deleteAndCreateReportFolder();
	}


	@AfterSuite
	public static void closeDependencies() {
		browserUtil.closeBrowser();
	}
}
