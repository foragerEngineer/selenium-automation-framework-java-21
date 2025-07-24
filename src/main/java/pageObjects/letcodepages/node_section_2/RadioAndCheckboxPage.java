package pageObjects.letcodepages.node_section_2;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.basepage.BasePage;

@Log4j2
public class RadioAndCheckboxPage extends BasePage {

    @FindBy(xpath = "//h1[normalize-space()='Radio & Checkbox']")
    private WebElement radioAndCheckboxTitle;

    public RadioAndCheckboxPage() {
        super();
        baseWebElementIdentifier = radioAndCheckboxTitle;
    }

    public boolean isRadioTitleDisplayed() {
        return displayUtil.isElementDisplayed(radioAndCheckboxTitle);
    }

    public RadioAndCheckboxPage clickCheckboxOption() {
        clickUtil.waitAndClick(By.cssSelector("input#yes"));
        return this;
    }

    public RadioAndCheckboxPage isCheckboxSelected() {
        WebElement selectedCheckbox = driver.findElement(By.cssSelector("#notfoo"));
        Assert.assertTrue(selectedCheckbox.isSelected(), selectedCheckbox + " is not selected");
        System.out.println(selectedCheckbox.isSelected());
        return this;
    }

    public void isCheckboxBtnDisabled() {
        elementAttributeUtil.isDisabled(By.cssSelector("#maybe"));
    }
}
