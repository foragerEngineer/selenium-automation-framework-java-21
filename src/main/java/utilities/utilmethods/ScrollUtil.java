package utilities.utilmethods;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.basepage.BasePage;

@Log4j2
public class ScrollUtil extends BasePage {

    public ScrollUtil() {
        super();
    }

    @Step
    public void scroll(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        log.info("Scrolling on page by x: {}, y: {}", x, y);
        js.executeScript("window.scrollBy(" + x + ", " + y + ")");
        log.info("Scrolling complete");
    }

    @Step
    public void scrollIntoView(By locator) {
        WebElement scrollLink = driver.findElement(locator);
        log.info("Scrolling on page by locator: {}", locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollLink);
        log.info("Scrolling complete");
    }

    @Step
    public void scrollWithActions(By locator) {
        WebElement scrollWithActions = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(scrollWithActions).perform();
    }

    @Step
    public void smoothScrollDownIncrementally(int times) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < times; i++) {
            js.executeScript("window.scrollBy(0, 100)");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Step
    public void smoothScrollToElementIncrementally(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int maxAttempts = 50; // Maximum number of scroll attempts
        int attempts = 0;

        while (!driver.findElement(locator).isDisplayed() && attempts < maxAttempts) {
            js.executeScript("window.scrollBy(0, 100)");
            uiHelper.waitAndSleep();
            attempts++;
        }

        if (driver.findElement(locator).isDisplayed()) {
            log.info("Element is now in view: {}", locator);
        } else {
            log.info("Element not found after {} attempts: {}", maxAttempts, locator);
        }
    }

    @Step
    public void smoothScrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        log.info("Smooth scrolling to top of the page");
        js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        log.info("Smooth scrolling complete");
    }

    public void smoothScrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        log.info("Smooth scrolling to bottom of the page");
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        log.info("Smooth scrolling to bottom complete");
    }

    @Step
    public void smoothScrollElementIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        log.info("Scrolling into view of element: {}", locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", element);
        log.info("Scrolling into view of element: {}", locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", element);
        log.info("Scrolling into view of element: {}", locator);
    }

}