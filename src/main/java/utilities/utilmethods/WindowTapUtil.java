package utilities.utilmethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pageObjects.basepage.BasePage;

public class WindowTapUtil extends BasePage {

    public WindowTapUtil() {
        super();
    }

    // coordinates to tap: X: 1125, Y: 633

    public void tapOnCoordinates(int x, int y) {
        System.out.println("Tapping on coordinates: X = " + x + ", Y = " + y);
        String script = String.format("window.scrollTo(%d, %d);", x, y);
        ((JavascriptExecutor) driver).executeScript(script);
        Actions actions = new Actions(driver);
        actions.moveByOffset(x, y).click().perform();
    }
}
