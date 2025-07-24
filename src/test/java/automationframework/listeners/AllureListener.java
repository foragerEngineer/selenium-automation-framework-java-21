package automationframework.listeners;

import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.LogParserUtility;

import java.util.Arrays;

@Log4j2
public class AllureListener implements ITestListener {

    private int passed = 0;
    private int failed = 0;
    private int skipped = 0;
    private int broken = 0;

    @Override
    public void onTestStart(ITestResult result) {
        Thread.currentThread().setName("thread" + Thread.currentThread().getId());// runs on single thread
        String qualifiedName = String.format("%s.%s", result.getTestClass().getName(), result.getName());// gets test class name
        long nanoTime = System.nanoTime();
        result.getTestContext().setAttribute(qualifiedName, nanoTime);
        System.out.println("TEST " + qualifiedName + nanoTime);// prints name
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // gets test method from test class that is using '@Test'
        System.out.println("TEST PASS: " + result.getName() + Arrays.toString(result.getParameters()));
        getTestLog(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TEST FAILED: " + result.getName() + Arrays.toString(result.getParameters()) + result.getThrowable().getMessage());
        getTestLog(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TEST SKIPPED: " + result.getName() + Arrays.toString(result.getParameters()));
    }

    @Attachment(value = "log", type = "text/plain")
    private String getTestLog(ITestResult testName) {
        String qualifiedName = testName.getMethod().getQualifiedName();
        String nanoTime = String.valueOf(testName.getTestContext().getAttribute(qualifiedName));
        return LogParserUtility.getParsedTestLog(String.format("%s(%s)", qualifiedName, nanoTime));
    }

    @Override
    public void onStart(ITestContext context) {
        // Reset counters at the start of the test context
        passed = 0;
        failed = 0;
        skipped = 0;
        broken = 0;
    }

    @Override
    public void onFinish(ITestContext context) {
        // Store results in the context for later retrieval
        context.setAttribute("passed", passed);
        context.setAttribute("failed", failed);
        context.setAttribute("skipped", skipped);
        context.setAttribute("broken", broken);
    }
}
