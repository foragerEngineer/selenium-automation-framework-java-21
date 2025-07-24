package utilities.utilmethods;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pageObjects.basepage.BasePage;

@Log4j2
public class SendKeysUtil extends BasePage {

    public SendKeysUtil() {
        super();
    }

    public void sendKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        log.info("Sends string text: " + text);
        element.sendKeys(text);
    }

    public void sendKeysTAB(By locator) {
        log.info("Tabs over to: " + locator);
        driver.findElement(locator).sendKeys(Keys.TAB);
    }

    public void sendKeysAndPressKeyboardKey(By locator, Keys key) {
        log.info("Returning string text: " + driver.findElement(locator).getText());
        driver.findElement(locator).sendKeys(key); //press RETURN
    }

    public void sendKeysRIGHT(By locator) {
        System.out.println("Sends right arrow key to: " + locator);
        driver.findElement(locator).sendKeys(Keys.RIGHT);
    }
}
