package com.stepDefinitions;

import com.pages.BasePage;
import com.utils.ExtentManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.sql.Timestamp;

import static com.driverManager.DriverFactory.cleanupDriver;
import static com.driverManager.DriverFactory.getDriver;

public class MasterHooks {

    @Before
    public void setup() {
        getDriver();
    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", timeMilliseconds);
        }
    }
    @After
    public void tearDown() {
        cleanupDriver();
    }

    public static class Listeners extends BasePage implements ITestListener {

        public Listeners() throws IOException {
            super();
        }

        public synchronized void onStart(ITestContext context) {
            ExtentManager.getReport();
            ExtentManager.createTest(context.getHost(), context.getName());

        }

        @Override
        public void onTestStart(ITestResult iTestResult) {

        }

        @Override
        public void onTestSuccess(ITestResult iTestResult) {

        }

        public synchronized void onTestFailure(ITestResult result) {
            ExtentManager.getTest().fail(result.getThrowable());
            try {
                System.out.println("Test failed: " + result.getName());
                takeSnapShot(result.getMethod().getMethodName());
                ExtentManager.attachImage();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onTestSkipped(ITestResult iTestResult) {

        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

        }

        public synchronized void onFinish(ITestContext context) {
            ExtentManager.flushReport();
        }

    }
}