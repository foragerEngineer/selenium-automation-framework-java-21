package pageObjects.letcodepages.node_section_4;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.basepage.BasePage;

import java.time.Duration;

@Log4j2
public class WaitsPage extends BasePage {

    @FindBy(xpath = "//h1[normalize-space()='Wait']")
    private WebElement waitTitle;

    public WaitsPage() {
        super();
        baseWebElementIdentifier = waitTitle;
    }

    public boolean isWaitTitleDisplayed() {
        return displayUtil.isElementDisplayed(waitTitle);
    }

    public WaitsPage clickSimpleAlert() {
        clickUtil.waitAndClick(By.cssSelector("#accept.button.is-link"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
        wait.until(ExpectedConditions.alertIsPresent()); // Wait until the alert is present
        return this;
    }

    public void waitAndAcceptAlert() {
        alertUtil.acceptAlerts(3);
    }

}
