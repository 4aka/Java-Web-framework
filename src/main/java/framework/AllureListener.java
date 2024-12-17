package framework;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("=== FAILURE: '{}' TEST HAS FAILED ===", result.getName(), result.getThrowable());
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("=== ATTENTION: '{}' TEST HAS STARTED ===", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("=== SUCCESS: '{}' TEST HAS PASSED ===", result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("=== WARNING: '{}' TEST HAS SKIPPED ===", result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
