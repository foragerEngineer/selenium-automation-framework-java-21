package utilities.utilmethods;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pageObjects.basepage.BasePage;
import utilities.waitutils.SeleniumWaiterUtils;

@Log4j2
public class AlertUtil extends BasePage {

    public AlertUtil() {
        super();
    }

    @Step
    public String acceptAlerts(int timeoutInSeconds) {
        SeleniumWaiterUtils waiterUtilities = new SeleniumWaiterUtils();
        try {
            long startTime = System.currentTimeMillis();
            waiterUtilities.waitForAlert(driver, timeoutInSeconds); // Wait for alert
            long endTime = System.currentTimeMillis();
            log.info("Alert appeared after " + (endTime - startTime) + " ms");

            String alertText = driver.switchTo().alert().getText();
            log.info("Alert text: " + alertText);
            driver.switchTo().alert().accept();
            log.info("Alert accepted successfully.");
            return alertText;
        } catch (Exception e) {
            log.error("Failed to accept alert: " + e.getMessage());
            return null;
        }
    }

    @Step
    public void dismissAlerts() {
        if (!isAlertPresent()) {
            log.info("No alert to dismiss.");
            return;
        }
        log.info("Alert dismissed to: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }

    @Step
    private boolean isAlertPresent() {
        SeleniumWaiterUtils waiterUtilities = new SeleniumWaiterUtils();
        try {
            waiterUtilities.waitForAlert(driver, 5); // Wait for up to 5 seconds for the alert to be present
            return true;
        } catch (Exception e) {
            log.info("No alert present: " + e.getMessage());
            return false;
        }
    }

    @Step
    public void promptAlerts(String text) {
        log.info("Alert prompted to: " + text);
        driver.switchTo().alert().sendKeys(text);
    }
}
