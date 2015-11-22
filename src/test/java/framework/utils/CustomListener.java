package framework.utils;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by pavo on 11/22/15.
 */
public class CustomListener implements ITestListener {

    private Logger log = Logger.getLogger(CustomListener.class);

    public void onTestStart(ITestResult iTestResult) {
        log.info("TEST STARTED: " + iTestResult.getName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.info("TEST PASSED: " + iTestResult.getName());
    }

    public void onTestFailure(ITestResult iTestResult) {
        log.info("TEST FAILED: " + iTestResult.getName());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        log.info("TEST SKIPPED: " + iTestResult.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
