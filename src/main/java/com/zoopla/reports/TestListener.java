package com.zoopla.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	Logger log = Logger.getLogger(getClass().getName());
	private static ExtentReports exReport = ExtendReportManager.createInstance();
	private static ExtentTest testLogger = ExtendReportManager.testLog;

	public void onStart(ITestContext context) {
		log.info(" Testlistener started ");
	}
	
	public void onTestStart(ITestResult result) {
		testLogger = exReport.startTest(result.getMethod().getMethodName());
		testLogger.log(LogStatus.INFO, result.getMethod().getMethodName() + " TestStarted..!");
	}

	public void onTestSuccess(ITestResult result) {
		testLogger.log(LogStatus.PASS, result.getMethod().getMethodName() + " TestSuccess..!");
	}

	public void onTestFailure(ITestResult result){
		String sTestMethodName = result.getMethod().getMethodName();
		testLogger.log(LogStatus.FAIL, sTestMethodName + " TestFailed..!");
		try {
			testLogger.log(LogStatus.FAIL, testLogger.addScreenCapture(ExtendReportManager.udfTakeScreenShot(sTestMethodName)));
		} catch (Exception e) {
			testLogger.log(LogStatus.ERROR, sTestMethodName + e.getLocalizedMessage());
		}
	}

	public void onTestSkipped(ITestResult result) {
		testLogger.log(LogStatus.SKIP, result.getMethod().getMethodName() + " TestSkipped..!");
	}

	public void onFinish(ITestContext context) {
		exReport.endTest(testLogger); 
		exReport.flush();
		log.info(" Testlistener finished ");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info(" onTestFailedButWithinSuccessPercentage");
		
	}
}
