package utilities.utilmethods;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.basepage.BasePage;
import utilities.waitutils.SeleniumWaiterUtils;

@Log4j2
public class ClickUtil extends BasePage {

    public ClickUtil() {
        super();   // Constructor can be used for initialization if needed
    }

    @Step("Click on element using JavaScript: {locator}")
    public void click(By locator) {
        log.info("Click on element using JavaScript locator: " + locator);
        try {
            SeleniumWaiterUtils waiterUtilities = new SeleniumWaiterUtils();
            waiterUtilities.waitForElementToBeClickable(driver, 5, locator);
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            log.info("Failed to click on element using JavaScript: " + locator);
            e.printStackTrace();
        }
    }

    @Step("Click on element {locator} {numberOfTimes} times")
    public void click(By locator, int numberOfTimes) {
        log.info("Click on element using JavaScript locator: " + locator);
        for (int i = 0; i <= numberOfTimes; i++) {
            waitAndClick(locator, 500);
        }
    }

    @Step("Wait and click on element: {locator} for 2000 milliseconds")
    public void waitAndClick(By locator) {
        waitAndClick(locator, 2000);
    }

    @Step("Wait and click on element: {locator} for {milliSeconds} milliseconds")
    public void waitAndClick(By locator, long milliSeconds) {
        log.info("Waiting for element to be visible: " + locator);
        SeleniumWaiterUtils waiterUtilities = new SeleniumWaiterUtils();
        waiterUtilities.waitForVisibilityOfElement(driver, milliSeconds, locator);
        click(locator);
        log.info("Clicked on element " + locator);
    }

    @Step("Click and hold on element: {locator}")
    public void clickAndHold(By locator) {
        Actions actions = new Actions(driver);
        System.out.println("Clicks and holds " + locator + " with Actions");
        actions.clickAndHold(driver.findElement(locator)).build().perform();
    }

}
