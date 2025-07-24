package utilities.utilmethods;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.basepage.BasePage;
import utilities.waitutils.SeleniumWaiterUtils;

@Log4j2
public class DisplayUtil extends BasePage {

    public DisplayUtil() {
        super();
    }

    public void waitAndIsDisplayed(By locator) {
        waitAndIsDisplayed(locator, 3000);
    }

    @Step("Wait for element to be displayed: {locator}")
    public void waitAndIsDisplayed(By locator, long milliSeconds) {
        log.info("Waiting for " + locator + " to be displayed");
        SeleniumWaiterUtils waiterUtilities = new SeleniumWaiterUtils();
        waiterUtilities.waitForVisibilityOfElement(driver, milliSeconds, locator);
        WebElement element = driver.findElement(locator);
        if (element.isDisplayed()) {
            log.info("Element is visible: {}", locator);
        }
    }

    public void waitAndIsNotDisplayed(By locator) {
        waitAndIsNotDisplayed(locator, 3000);
    }

    @Step("Wait for element to not be displayed: {locator}")
    public void waitAndIsNotDisplayed(By locator, long milliSeconds) {
        log.info("Waiting for " + locator + " to be displayed");
        SeleniumWaiterUtils waiterUtilities = new SeleniumWaiterUtils();
        try {
            waiterUtilities.waitForInvisibilityOfElement(driver, milliSeconds, locator);
            log.info("Element is not visible: {}", locator);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.info("Element not found, treating as not visible: {}", locator);
        }
    }

    @Step("Check if element is not displayed: {locator}")
    public boolean isElementNotDisplayed(By locator) {
        SeleniumWaiterUtils waiterUtilities = new SeleniumWaiterUtils();
        try {
            waiterUtilities.waitForInvisibilityOfElement(driver, 3000, locator);
            log.info("Element is not visisble: {}", locator);
            return true;
        } catch (NoSuchElementException e) {
            log.info("Element not found, treating as not visible: {}", locator);
            return true;
        } catch (Exception e) {
            log.info("Element is visible: {}", locator);
            return false;
        }
    }

    @Step("Check if element is displayed: {locator}")
    public boolean isElementDisplayed(By locator) {
        SeleniumWaiterUtils waiterUtilities = new SeleniumWaiterUtils();
        try {
            waiterUtilities.waitForVisibilityOfElement(driver, 4000, locator);
            log.info("Element is visible: {}", locator);
            return true;
        } catch (Exception e) {
            log.info("Element not found, treating as not visible: {}", locator);
            return false;
        }
    }

    @Step("Check if element is displayed: {locator}")
    public boolean isElementDisplayed(WebElement locator) {
        SeleniumWaiterUtils waiterUtilities = new SeleniumWaiterUtils();
        try {
            waiterUtilities.waitForVisibilityOfElement(driver, 4000, locator);
            log.info("Element is visible: {}", locator);
            return true;
        } catch (Exception e) {
            log.info("Element not found, treating as not visible: {}", locator);
            return false;
        }
    }

    @Step("Check if element is displayed with loop attempts: {locator}, attempts: {loopAttempts}")
    public boolean isElementDisplayed(By locator, int loopAttempts) {
        for (int i = 0; i < loopAttempts; i++) {
            if (isElementDisplayed(locator)) {
                return true;
            }
        }
        return false;
    }

    @Step("Check if text is displayed by tag name: {locator} with expected text: {expectedText}")
    public void isTextDisplayedByTagName(By locator, String expectedText) {
        String text = uiHelper.getText(locator);
        if (text.contains(expectedText)) {
            System.out.println(expectedText + " Is displayed");
        } else {
            Assert.fail(expectedText + " is not displayed");
        }
    }
}
