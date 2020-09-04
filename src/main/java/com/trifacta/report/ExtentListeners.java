package com.trifacta.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.trifacta.base.Base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.trifacta.utility.Util.captureAsBase64;

public class ExtentListeners extends Base implements ITestListener {
    ExtentReports extent = ExtentReportNG.extentReportGenerator();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test case Passed is : "+result.getName());
        test.addScreenCaptureFromBase64String(captureAsBase64(), "Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test case failed is : "+result.getName());
        test.log(Status.FAIL, "Test case failed info : "+result.getThrowable());
        test.addScreenCaptureFromBase64String(captureAsBase64(), "Failure");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    public void takeScreenShot() {
        test.addScreenCaptureFromBase64String(captureAsBase64());
    }
}
