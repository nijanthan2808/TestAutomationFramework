package com.example.framework.reporting;

import com.aventstack.extentreports.ExtentTest;

public final class TestLogger {
    private TestLogger() {
    }

    public static void info(String message) {
        ExtentTest test = ExtentReportManager.getTest();
        if (test != null) {
            test.info(message);
        }
    }
}
