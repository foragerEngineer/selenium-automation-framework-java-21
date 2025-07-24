package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.waitutils.SeleniumWaiterUtils;

public class AssertUtils {

    private AssertUtils() {
    }

    public static final ThreadLocal<SoftAssert> SOFT_ASSERT = new ThreadLocal<>();

    public static SoftAssert getSoftAssert() {
        return SOFT_ASSERT.get();
    }

    public static void setSoftAssert(SoftAssert softAssert) {
        AssertUtils.SOFT_ASSERT.set(softAssert);
    }

    public static void stopSoftAssert() {
        if (getSoftAssert() != null) {
            try {
                getSoftAssert().assertAll();
            } catch (AssertionError e) {
                throw new RuntimeException("Soft assertions failed: " + e.getMessage(), e);
            } finally {
                SOFT_ASSERT.remove();
            }
        }
    }

    @Step("Check for Presence of an Element - {element}")
    public static void assertElementPresent(WebDriver driver, By element) {
        SeleniumWaiterUtils waiterUtils = new SeleniumWaiterUtils();
        waiterUtils.waitForVisibilityOfElement(driver, 5000, element);
        getSoftAssert().assertTrue(
                !driver.findElements(element).isEmpty(),
                String.format("Element %s not found!", element));
    }
}
