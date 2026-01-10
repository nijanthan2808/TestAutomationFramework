package com.example.framework.reporting;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        String description = result.getMethod().getDescription();
        ExtentReportManager.startTest(result.getName(), description);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().pass("Passed");
        ExtentReportManager.endTest();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.getTest().fail(result.getThrowable());
        ExtentReportManager.endTest();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().skip("Skipped");
        ExtentReportManager.endTest();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flush();
    }
}
