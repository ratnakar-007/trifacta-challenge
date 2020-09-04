package com.trifacta.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.trifacta.base.Base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportNG extends Base {

    /**
     * Generate Extent Report
     * @name extentReportGenerator
     * @return ExtentReports
     */
    public static ExtentReports extentReportGenerator(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String resultPath = System.getProperty("user.dir")+"\\reports\\report.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(resultPath);
        reporter.config().setReportName("Trifacta Ui Automation Report");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Ratnakar");
        extent.setSystemInfo("Environment","Local");
        return extent;
    }
}