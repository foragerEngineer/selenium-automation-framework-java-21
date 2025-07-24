package utilities.utilmethods;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import pageObjects.basepage.BasePage;

import static org.openqa.selenium.WindowType.TAB;

@Log4j2
public class WindowUtil extends BasePage {

    public WindowUtil() {
        super();
    }

    @Step
    public void openNewBlankTab() {
        System.out.println("Switches to new tab");
        driver.switchTo().newWindow(TAB);
    }

    public void closeBrowserWindow() {
        System.out.println("Closes browser window");
        driver.close();
        System.out.println("Browser window closed");
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @Step
    public void windowSize() {
        System.out.println("Getting window size");
        System.out.println(driver.manage().window().getSize());
        System.out.println("Window size loaded");
    }

    public void switchToActiveTab(int tabNumber) {
        log.info("Switching to tab index {}", tabNumber);
        driver.switchTo().window(driver.getWindowHandles().toArray()[tabNumber].toString());
        log.info("Switched to tab index {}", tabNumber);
    }

    public void switchToOriginalTab(int tabNumber) {
        driver.close();
        switchToActiveTab(tabNumber);
    }

    public void openNewTabURL(String url) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('" + url + "')");
    }
}
