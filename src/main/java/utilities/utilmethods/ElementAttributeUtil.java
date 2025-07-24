package utilities.utilmethods;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.basepage.BasePage;

@Log4j2
public class ElementAttributeUtil extends BasePage {

    public ElementAttributeUtil() {
        super();
    }

    /***
     * get DOM attribute needs the attribute tag from an element.
     * EXAMPLE:
     * get-data="value" -> the attribute here is get-data but getDomAttribute will get the value of the attribute
     * @param locator provide locator
     * @param attribute
     */
    @Step("Fetching attribute for locator: {locator} with attribute: {attribute}")
    public void getElementAttributeDOM(By locator, String attribute) {
        log.info("Fetching attribute for locator: {}", locator);
        String domAttribute = driver.findElement(locator).getDomAttribute(attribute);
        log.info("Found attribute: {}", domAttribute);
    }

    @Step("Fetching property for locator: {locator} with property: {property}")
    public void getElementPropertyDOM(By locator, String property) {
        log.info("Fetching property for locator: {}", locator);
        String domProperty = driver.findElement(locator).getDomProperty(property);
        log.info("Found property: {}", domProperty);
    }

    public void isEnabled(By locator) {
        log.info("Checking if element {} is enabled", locator);
        boolean isElementEnabled = driver.findElement(locator).isEnabled();
        Assert.assertTrue(isElementEnabled, "Element is disabled");
    }

    public void isDisabled(By locator) {
        log.info("Checking if element {} is disabled", locator);
        boolean isElementDisabled = driver.findElement(locator).isEnabled();
        Assert.assertFalse(isElementDisabled, "Element is enabled");
    }
}
