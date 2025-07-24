package pageObjects.letcodepages.node_section_2;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.basepage.BasePage;

@Log4j2
public class ElementsPage extends BasePage {

    @FindBy(xpath = "//h1[normalize-space()='Elements']")
    private WebElement elementTitle;

    private final By searchBar = By.xpath("//input[@type='text']");

    public ElementsPage() {
        super();
        baseWebElementIdentifier = elementTitle;
    }

    public boolean isElementsTitleDisplayed() {
        return displayUtil.isElementDisplayed(elementTitle);
    }

    public ElementsPage clickSearchBar() {
        clickUtil.waitAndClick(searchBar);
        return this;
    }

    public ElementsPage sendKeysToSearchbar() {
        sendKeysUtil.sendKeys(searchBar, "Ajvh2254");
        sendKeysUtil.sendKeysAndPressKeyboardKey(searchBar, Keys.RETURN);
        return this;
    }

    public ElementsPage isImageDisplayed() {
        displayUtil.isElementDisplayed(By.cssSelector("img.is-rounded"));
        return this;
    }

    public ElementsPage printSearchInfo(int containerIndex, String expectedText) {
        By multiLineContainer = By.xpath(String.format("//div[@class='columns is-mobile is-multiline has-text-centered']/div[%d]/p", containerIndex));
        String text = driver.findElement(multiLineContainer).getText();
        if (text.equals(expectedText)) {
            log.info("Found expected text: " + text);
        } else {
            log.warn("Text mismatch! Expected: " + expectedText + ", Found: " + text);
        }
        return this;
    }

}
