package utilities.utilmethods;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.basepage.BasePage;

@Log4j2
public class AttributeUtil extends BasePage {

    public AttributeUtil() {
        super();
    }

    @Step("Check if element is enabled: {locator}")
    public void IsEnabled(By locator) {
        log.info("Checking if element is enabled: {}", locator);
        boolean isElementEnabled = driver.findElement(locator).isEnabled();
        Assert.assertTrue(isElementEnabled, "The element is disabled");
    }

    @Step("Check if element is disabled: {locator}")
    public void isElementDisabled(By locator) {
        log.info("Checking if element is disabled: {}", locator);
        boolean isElementEnabled = driver.findElement(locator).isEnabled();
        Assert.assertFalse(isElementEnabled, "The element is enabled");
    }

}
