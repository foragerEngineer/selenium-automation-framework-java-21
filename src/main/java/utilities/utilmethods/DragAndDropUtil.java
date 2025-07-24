package utilities.utilmethods;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pageObjects.basepage.BasePage;

@Log4j2
public class DragAndDropUtil extends BasePage {

    Actions actions = new Actions(driver);

    public DragAndDropUtil() {
        super();
    }

    @Step("Drag and drop element from {sourceLocator} to {targetLocator} and verify text")
    public void dragAndDrop(By sourceLocator, By targetLocator, String expectedText) {
        WebElement elementA = driver.findElement(sourceLocator);
        WebElement elementB = driver.findElement(targetLocator);
        actions.dragAndDrop(elementA, elementB).perform();
        String textTo = elementB.getText();
        if (textTo.equals(expectedText)) {
            System.out.println("Element was dropped at location");
        } else {
            System.out.println("Element was not dropped at location");
        }
    }

    @Step("Drag and drop element by offset {x}, {y} on locator {locator}")
    public void dragAndDropBy(int x, int y, By locator) {
        WebElement element = driver.findElement(locator);
        actions.dragAndDropBy(element, x, y).build().perform();
    }

    public void slideFromAndTo(By sourceLocator, By targetLocator) {
        WebElement elementA = driver.findElement(sourceLocator);
        WebElement elementB = driver.findElement(targetLocator);
        System.out.println(sourceLocator + " was dropped at " + targetLocator);
        Action dragAndDrop = actions.clickAndHold(elementA)
                .moveToElement(elementB)
                .release(elementB)
                .build();
        dragAndDrop.perform();
    }
}
