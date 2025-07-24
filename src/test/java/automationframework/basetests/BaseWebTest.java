package automationframework.basetests;

import allureReporting.AllureAttachments;
import automationframework.listeners.AllureListener;
import driver.WebDriverFactory;
import lombok.extern.log4j.Log4j2;
import monteScreenRec.MonteScreenRecUtil;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import pageObjects.basepage.BasePage;
import slackbotmessenger.slackReportSender.SlackReportUtil;
import utilities.ScreenShotUtil;

import java.io.IOException;

import static utilities.AssertUtils.setSoftAssert;

@Log4j2
@Listeners(AllureListener.class)
public class BaseWebTest extends WebDriverFactory {

    SlackReportUtil slackReportUtil = new SlackReportUtil();
    AllureListener logListener = new AllureListener();

    @BeforeMethod
    public void launchApplication() throws Exception {
        MonteScreenRecUtil.startVideoRec();
        driver = initializeDriver();
        setSoftAssert(new SoftAssert());
        BasePage.setDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        ScreenShotUtil screenShotUtil = new ScreenShotUtil();
        screenShotUtil.takeScreenShot(driver, "test");
        MonteScreenRecUtil.stopRecording();
        quitDriver();
        AllureAttachments.fetchAndAttachVideoToAllure();
    }


    /**
     * Option 1: Uncomment the slackReportUtil if you want to send test results to a Slack channel.
     * Ensure you follow the setup instructions in the Slack documentation within this project.
     *
     * Option 2: If you want to open the Allure report automatically in the browser, uncomment the method for
     * openAllureReport() method.
     */
    @AfterTest
    public void sendResultsToReplyThread(ITestContext context) {
//        slackReportUtil.setupParentMessage();
//        logListener.onFinish(context);
//        slackReportUtil.sendTestResults(context);

// This method is optional to open the Allure report automatically in the browser.
// Make sure to terminate the process in the terminal after you're done viewing.
        openAllureReport();
        System.out.println("TESTS COMPLETED");
    }

    private void openAllureReport() {
        try {
            // Generate the Allure report
            System.out.println("Generating Allure report...");
            ProcessBuilder generateReport = new ProcessBuilder("allure", "generate", "target/allure-results", "-o", "target/allure-report", "--clean");
            generateReport.inheritIO();
            Process generateProcess = generateReport.start();
            generateProcess.waitFor();

            // Open the Allure report
            System.out.println("Opening Allure report...");
            ProcessBuilder openReport = new ProcessBuilder("allure", "open", "target/allure-report");
            openReport.inheritIO();
            Process openProcess = openReport.start();
            openProcess.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
