package com.example.framework.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.framework.config.ConfigLoader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ExtentReportManager {
    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> TEST = new ThreadLocal<>();

    private ExtentReportManager() {
    }

    public static ExtentReports getExtent() {
        if (extent == null) {
            synchronized (ExtentReportManager.class) {
                if (extent == null) {
                    extent = createInstance();
                }
            }
        }
        return extent;
    }

    public static void startTest(String name, String description) {
        ExtentTest test = getExtent().createTest(name, description);
        TEST.set(test);
    }

    public static ExtentTest getTest() {
        return TEST.get();
    }

    public static void endTest() {
        TEST.remove();
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }

    private static ExtentReports createInstance() {
        String reportPath = ConfigLoader.getOrDefault(
            "report.path",
            "target/extent-report/extent.html"
        );
        String resolvedPath = resolveReportPath(reportPath);
        Path reportFile = Paths.get(resolvedPath);
        Path reportDir = reportFile.getParent();
        if (reportDir != null) {
            try {
                Files.createDirectories(reportDir);
            } catch (IOException e) {
                throw new RuntimeException("Failed to create report directory: " + reportDir, e);
            }
        }

        ExtentSparkReporter reporter = new ExtentSparkReporter(resolvedPath);
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Test Execution");

        ExtentReports reports = new ExtentReports();
        reports.attachReporter(reporter);
        return reports;
    }

    private static String resolveReportPath(String reportPath) {
        String timestamp = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        if (reportPath.contains("{timestamp}")) {
            return reportPath.replace("{timestamp}", timestamp);
        }
        if (reportPath.endsWith(".html")) {
            return reportPath.substring(0, reportPath.length() - 5)
                + "-" + timestamp + ".html";
        }
        return reportPath + "-" + timestamp + ".html";
    }
}
