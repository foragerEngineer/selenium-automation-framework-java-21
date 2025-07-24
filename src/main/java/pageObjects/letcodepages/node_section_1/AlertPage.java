package pageObjects.letcodepages.node_section_1;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.basepage.BasePage;

@Log4j2
public class AlertPage extends BasePage {

    @FindBy(xpath = "//h1[normalize-space()='Alert']")
    private WebElement alertTitle;

    public AlertPage() {
        super();
        baseWebElementIdentifier = alertTitle;
    }

    public boolean isAlertTitleDisplayed() {
        return displayUtil.isElementDisplayed(alertTitle);
    }

    public AlertPage clickSimpleAlertBtn() {
        clickUtil.waitAndClick(By.cssSelector("#accept.button.is-link"));
        return this;
    }

    public AlertPage acceptSimpleAlertBtn() {
        alertUtil.acceptAlerts(3);
        return this;
    }

    public AlertPage clickConfirmAlertBtn() {
        clickUtil.waitAndClick(By.cssSelector("#confirm.button.is-link.is-outlined"));
        return this;
    }

    public AlertPage dismissConfirmAlertBtn() {
        alertUtil.dismissAlerts();
        return this;
    }

    public AlertPage clickPromptAlertBtn() {
        clickUtil.waitAndClick(By.xpath("//button[@id='prompt']"));
        return this;
    }

    public AlertPage fillOutPromptAlert() {
        alertUtil.promptAlerts("Craig Schmitt");
        return this;
    }

    public AlertPage acceptPromptAlert() {
        alertUtil.acceptAlerts(3);
        return this;
    }

    public AlertPage clickModernAlertBtn() {
        clickUtil.waitAndClick(By.cssSelector("#modern.button.is-success"));
        return this;
    }

    public void dismissModernAlert() {
        clickUtil.waitAndClick(By.xpath("//button[@aria-label='close']"));
    }
}
