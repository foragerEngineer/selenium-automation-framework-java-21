package utilities.utilmethods;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pageObjects.basepage.BasePage;
import utilities.UiHelper;

import java.awt.*;
import java.awt.event.KeyEvent;

@Log4j2
public class KeyboardUtil extends BasePage {

    private final Actions actions = new Actions(driver);

    public KeyboardUtil() {
        super();
    }

    @Step("Pressing keyboard key: {keyBoardKey}")
    public void keyBoardKey(Keys keyBoardKey) {
        System.out.println("Pressing the key: " + keyBoardKey);
        actions.sendKeys(keyBoardKey).perform();
        System.out.println("Pressed the key: " + keyBoardKey);
        UiHelper.sleep(1000);
    }

    @Step("Clearing the text field")
    public void clearField() {
        System.out.println("Clearing the field");
        actions.sendKeys(Keys.DELETE).perform();
        System.out.println("Field cleared");
        UiHelper.sleep(1000);
    }

    public void programmaticKeyboardKey(Keys keyBoardKey, int times) {
        try {
            Robot robot = new Robot();
            for (int i = 0; i < times; i++) {
                switch (keyBoardKey) {
                    case ENTER:
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                        break;
                    case DELETE:
                        robot.keyPress(KeyEvent.VK_DELETE);
                        robot.keyRelease(KeyEvent.VK_DELETE);
                        break;
                    case TAB:
                        robot.keyPress(KeyEvent.VK_TAB);
                        robot.keyRelease(KeyEvent.VK_TAB);
                        break;
                    case ESCAPE:
                        robot.keyPress(KeyEvent.VK_ESCAPE);
                        robot.keyRelease(KeyEvent.VK_ESCAPE);
                        break;
                    default:
                        System.out.println("Unsupported key: " + keyBoardKey);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
