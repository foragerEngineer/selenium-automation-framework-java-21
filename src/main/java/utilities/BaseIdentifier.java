package utilities;

import constants.TimeConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Log4j2
public class BaseIdentifier {

    protected By baseIdentifier;
    protected WebElement baseWebElementIdentifier;

    protected void waitForElementPresence(int loopAttempts) {
        int loop = 0;

        while (true) {
            try {
                if (baseIdentifier != null && isElementVisible(baseIdentifier)) {
                    log.info("Base Element Identifier (By locator) is visible: " + baseIdentifier);
                    break; // Exit the loop if the By locator is visible
                } else if (baseWebElementIdentifier != null && isElementVisible(baseWebElementIdentifier)) {
                    log.info("Base Element Identifier (WebElement) is visible: " + baseWebElementIdentifier);
                    break; // Exit the loop if the WebElement is visible
                }
            } catch (NoSuchElementException e) {
                log.warn("Base Element Identifier not found during visibility check: " +
                        (baseIdentifier != null ? baseIdentifier : baseWebElementIdentifier), e);
            } catch (Exception e) {
                log.error("Unexpected exception occurred while checking element visibility: " +
                        (baseIdentifier != null ? baseIdentifier : baseWebElementIdentifier), e);
            }

            ++loop;
            log.info("Waiting for " + loop + " attempts for the element to be visible");
            if (loop > loopAttempts) {
                log.info("Base Element Identifier not visible after " + loopAttempts + " attempts, breaking out of the loop.");
                break;
            }
            Waiter.driverSleep(TimeConstants.WAIT_MILLIS_3000);
        }

        if ((baseIdentifier != null && !isElementVisible(baseIdentifier)) ||
                (baseWebElementIdentifier != null && !isElementVisible(baseWebElementIdentifier))) {
            log.error(String.format("Base Element identifier %s is not visible after waiting %d seconds!",
                    baseIdentifier != null ? baseIdentifier : baseWebElementIdentifier, loopAttempts));
        }
    }


    public void validateLoad(int loopAttempts) {
        waitForElementPresence(loopAttempts);
    }

    public void validateLoad() {
        waitForElementPresence(3);
    }

    public Boolean isElementVisible(By by) {
        return true;
    }

    public Boolean isElementVisible(WebElement element) {
        return true;
    }

}
