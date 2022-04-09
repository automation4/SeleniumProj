package com.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.Utils;

import java.io.IOException;

public class RahulListener extends TestBase implements ITestListener {
    public ExtentReports extent;
    public ExtentTest test;

    public void onStart(ITestContext context) {
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/extent-report/ExtentReport.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Rahul");
        spark.config().setDocumentTitle("Document Title");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Browser","Chrome");
        extent.setSystemInfo("Build","10");
        extent.setSystemInfo("User","ExtentUser");

    }

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       /* String path= null;
       test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
        try {
            path = Utils.getInstance().captureScreenshot(result.getName(),driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(path);*/
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String path= null;
        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
        try {
            path = Utils.getInstance().captureScreenshot(result.getName(),driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
