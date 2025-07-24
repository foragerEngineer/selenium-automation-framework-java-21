package pageObjects.letcodepages.node_section_1;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.basepage.BasePage;

@Log4j2
public class InputPage extends BasePage {

    @FindBy(xpath = "//h1[normalize-space()='Input']")
    private WebElement inputTitleLocator;

    private static final String inputTitle = "//h1[normalize-space()='Input']";
    private static final By fullName = By.id("fullName");


    public InputPage() {
        super();
        baseWebElementIdentifier = inputTitleLocator;
    }

    public InputPage clickFullNameTextBox() {
        validateLoad();
        clickUtil.waitAndClick(fullName);
        return this;
    }

    public boolean isInputTitleDisplayed() {
        return displayUtil.isElementDisplayed(inputTitleLocator);
    }

    public void editApplication() {
        sendKeysUtil.sendKeys(fullName, "Darryn Valentino");
        sendKeysUtil.sendKeysTAB(fullName);

        By appendText = By.cssSelector("#join.input");
        sendKeysUtil.sendKeysRIGHT(appendText);
        sendKeysUtil.sendKeys(appendText, " at coding");
        sendKeysUtil.sendKeysTAB(appendText);

        By attributeLocator = By.id("getMe");
        elementAttributeUtil.getElementAttributeDOM(attributeLocator, "placeholder");
        sendKeysUtil.sendKeysTAB(attributeLocator);

        By clearText = By.id("clearMe");
        System.out.println("Clears text from box");
        driver.findElement(clearText).clear();
        sendKeysUtil.sendKeysTAB(clearText);

        elementAttributeUtil.isDisabled(By.id("noEdit"));

        By readonly = By.id("dontwrite");
        clickUtil.waitAndClick(readonly);
        elementAttributeUtil.getElementAttributeDOM(readonly, "readonly");
    }
}
