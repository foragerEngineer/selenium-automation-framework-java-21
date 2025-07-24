package utilities.waitutils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class SeleniumWaiterUtils {

    public void waitForVisibilityOfElement(WebDriver webDriver, long timeoutInSeconds, By locator) {
        log.info("Waiting for " + locator + " to be visible");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMillis(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForVisibilityOfElement(WebDriver webDriver, long timeoutInSeconds, WebElement locator) {
        log.info("Waiting for " + locator + " to be visible");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMillis(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void waitForElementToBeClickable(WebDriver webDriver, int timeoutInSeconds, By locator) {
        log.info("Waiting for " + locator + " to be clickable");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBeSelected(WebDriver webDriver, int timeoutInSeconds, By locator) {
        log.info("Waiting for " + locator + " to be selected");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    public void waitForInvisibilityOfElement(WebDriver webDriver, long milliSeconds, By locator) {
        log.info("Waiting for " + locator + " to be invisibile");
        System.out.println("Waiting for element to be invisible");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMillis(milliSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForTextToBePresentInElement(WebDriver webDriver, int timeoutInSeconds, By locator, String text) {
        log.info("Waiting for " + locator + " to be present");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public void fluentWaiter(WebDriver webDriver, int timeoutInSeconds, int pollingTime, By locator) {
        log.info("Waiting for " + locator + " with fluent wait");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeoutInSeconds));
        wait.pollingEvery(Duration.ofMillis(pollingTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForAlert(WebDriver webDriver, int timeoutInSeconds) {
        log.info("Waiting for alert to be present");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.alertIsPresent());
    }

}
