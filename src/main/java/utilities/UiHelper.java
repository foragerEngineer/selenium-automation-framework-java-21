package utilities;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.basepage.BasePage;
import utilities.waitutils.SeleniumWaiterUtils;

import java.time.Duration;

@Log4j2
public class UiHelper extends BasePage {

    public UiHelper() {
        super();
    }

    public void sendKeys(By locator, String text) {
        log.info("Sending text to " + locator);
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public void clearTextField(By locator) {
        log.info("Clearing text from " + locator);
        WebElement element = driver.findElement(locator);
        element.clear();
        log.info("Cleared text from " + locator);
    }

    /**
     * This method waits for the specified number of seconds by waiting for the visibility of
     * the <html> element, which is always present. This effectively creates a delay without using Thread.sleep.
     *
     * @param milliSeconds the number of seconds to wait
     */
    public void waitFor(long milliSeconds) {
        log.info("Waiting for " + milliSeconds + " milliseconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(milliSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("html")));
    }

    public void fluentWaitFor(int timeoutInSeconds, int pollingTime, By locator) {
        SeleniumWaiterUtils waiterUtilities = new SeleniumWaiterUtils();
        waiterUtilities.fluentWaiter(driver, timeoutInSeconds, pollingTime, locator);
    }

    public void implicitWait(long milliSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(milliSeconds));
    }

    public void waitAndSleep() {
        sleep(3000);
    }

    public static void sleep(long milliSeconds) {
        log.info("Sleeping for " + milliSeconds + " milliseconds");
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getText(By locator) {
        log.info("Getting text from " + locator);
        WebElement element = driver.findElement(locator);
        log.info("Getted text from " + locator);
        return element.getText();
    }

    public void clickByShadowRoot(String parentCssLocator, String childCssLocator, String rootSelector) {
        WebElement element = driver.findElement(By.cssSelector(parentCssLocator)); // close-btn close-btn--secondary adc-button-icon
        SearchContext rootNode = element.getShadowRoot();
        SearchContext searchRootNode = rootNode.findElement(By.cssSelector(childCssLocator)).getShadowRoot(); // #button-icon
        searchRootNode.findElement(By.cssSelector(rootSelector)).click(); // .adc-icon
    }

    public String getElementAttribute(By locator, String attribute) {
        WebElement element = driver.findElement(locator);
        log.info("Getting attribute from " + locator);
        System.out.println("Attribute value: " + element.getAttribute(attribute));
        return element.getAttribute(attribute);
    }
}
