package utilities.utilmethods;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pageObjects.basepage.BasePage;

@Log4j2
public class SliderUtil extends BasePage {

    public SliderUtil() {
        super();
    }

    @Step("Slide from source to target element")
    public void slideFromAndTo(WebElement sourceLocator, WebElement targetLocator) {
        Actions actions = new Actions(driver);
        log.info("Slide from " + sourceLocator.getAttribute("value"));
        Action dragAndDrop = actions.clickAndHold(sourceLocator)
                .moveToElement(targetLocator)
                .release(targetLocator)
                .build();
        dragAndDrop.perform();
        log.info("Drag and drop element");
    }

}
