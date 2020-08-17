package com.stackoverflow;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.stackoverflow.pages.BasePage;
import com.stackoverflow.utilities.ConfigurationReader;
import com.stackoverflow.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.stackoverflow.utilities.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver=null;
    protected Pages pages=null;

    protected static ExtentReports report;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;

    @BeforeMethod
    public void setupMethod() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        pages = new Pages();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotLocation = BasePage.getScreenshot(result.getName());
            extentLogger.fail(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotLocation);
            extentLogger.fail(result.getThrowable());

        } else if (result.getStatus() == ITestResult.SKIP) {
            extentLogger.skip("Test Case Skipped: " + result.getName());
        }
        Driver.closeDriver();
    }

    @BeforeTest
    public void setUpTest() {
        report = new ExtentReports();
        String filePath = System.getProperty("user.dir") + "/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(filePath);

        report.attachReporter(htmlReporter);

        report.setSystemInfo("Environment", "Test");
        report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        htmlReporter.config().setDocumentTitle("StackOverflow Reports");
        htmlReporter.config().setReportName("StackOverflow Automated Test Reports");
//        htmlReporter.config().setTheme(Theme.DARK);

    }

    @AfterTest
    public void tearDownTest() {
        report.flush();
    }
}
