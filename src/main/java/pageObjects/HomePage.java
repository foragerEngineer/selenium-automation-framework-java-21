package pageObjects;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.basepage.BasePage;
import pageObjects.enums.NodeMenuEnums;
import utilities.Waiter;

@Log4j2
public class HomePage extends BasePage {

    @FindBy(css = "img[alt='letcode']")
    private WebElement letcodeImageLocator;

    public HomePage() {
        super();
        baseWebElementIdentifier = letcodeImageLocator;
    }

    public boolean isLetCodeImageDisplayed() {
        return displayUtil.isElementDisplayed(letcodeImageLocator);
    }

    public void openLetCodePage() {
        log.info("Opening Let Code Page");
        driver.get("https://letcode.in/test");
        validateLoad();
    }

    private By parentSectionContainer(NodeMenuEnums btnSelection) {
        return By.xpath(String.format("(//section)[2]//app-menu//footer//a[contains(text(), '%s')]", btnSelection.getText()));
    }

    public void selectTestSection(NodeMenuEnums btnSelection) {
        By parentSection = parentSectionContainer(btnSelection);
        clickUtil.waitAndClick(parentSection);
        Waiter.driverSleep(2000);
    }

}
