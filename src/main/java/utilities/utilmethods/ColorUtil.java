package utilities.utilmethods;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pageObjects.basepage.BasePage;

@Log4j2
public class ColorUtil extends BasePage {

    public ColorUtil() {
        super();
    }

    @Step("Get color by CSS value for locator: {locator}")
    public String getColorByCssValue(By locator) {
        log.info(locator.toString());
        String color = driver.findElement(locator).getCssValue("color");
        return color;
    }

    @Step("Get background color by CSS value for locator: {locator}")
    public String getBackgroundColorByCssValue(By locator) {
        log.info(locator.toString());
        String color = driver.findElement(locator).getCssValue("background-color");
        return color;
    }

}
