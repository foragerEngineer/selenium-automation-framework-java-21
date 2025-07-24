package pageObjects.letcodepages.node_section_2;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.basepage.BasePage;
import utilities.Waiter;

@Log4j2
public class WindowsPage extends BasePage {

    @FindBy(xpath = "//h1[normalize-space()='Windows']")
    private WebElement windowsTitle;

    public WindowsPage() {
        super();
        baseWebElementIdentifier = windowsTitle;
    }

    public boolean isWindowsTitleDisplayed() {
        return displayUtil.isElementDisplayed(windowsTitle);
    }

    public WindowsPage clickHomeBtn() {
        clickUtil.waitAndClick(By.id("home"));
        return this;
    }

    public WindowsPage switchToChildWindow() {
        windowUtil.switchToActiveTab(1);
        return this;
    }

    public WindowsPage printTitleNewTab() {
        System.out.println(driver.getTitle());
        return this;
    }

    public WindowsPage closeChildWindow() {
        windowUtil.switchToOriginalTab(0);
        return this;
    }

    public WindowsPage clickMultipleWindowsBtn() {
        clickUtil.waitAndClick(By.xpath("//button[@id='multi']"));
        return this;
    }

    public WindowsPage switchToDropdownPage() {
        windowUtil.switchToActiveTab(1);
        return this;
    }

    public WindowsPage printWindowTitle() {
        displayUtil.isElementDisplayed(By.cssSelector("img[alt='letcode']"));
        return this;
    }

    public WindowsPage closeDropdownPage() {
        windowUtil.switchToOriginalTab(1);
        return this;
    }

    public WindowsPage printTitle() {
        System.out.println(driver.getTitle());
        return this;
    }

    public void closeAlertPage() {
        windowUtil.switchToOriginalTab(0);
        Waiter.sleep();
    }

}
