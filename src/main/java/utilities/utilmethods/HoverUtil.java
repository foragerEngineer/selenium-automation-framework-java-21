package utilities.utilmethods;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.basepage.BasePage;

public class HoverUtil extends BasePage {

    Actions actions = new Actions(driver);

    public HoverUtil() {
        super();
    }

    @Step
    public void hoverAndWait(By locator, long milliseconds) {
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
        uiHelper.waitFor(milliseconds);
    }

    @Step
    public void hoverAndClick(By locator) {
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element);
        clickUtil.click(locator);
    }

}
