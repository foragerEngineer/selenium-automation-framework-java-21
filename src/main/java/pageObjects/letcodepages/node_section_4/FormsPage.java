package pageObjects.letcodepages.node_section_4;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageObjects.basepage.BasePage;

@Log4j2
public class FormsPage extends BasePage {

    @FindBy(xpath = "//h1[normalize-space()='Form']")
    private WebElement formTitle;

    public FormsPage() {
        super();
        baseWebElementIdentifier = formTitle;
    }

    public boolean isFormTitleDisplayed() {
        return displayUtil.isElementDisplayed(formTitle);
    }

    public void fillOutForm() {
        By firstName = By.id("firstname");
        clickUtil.waitAndClick(firstName);
        sendKeysUtil.sendKeys(firstName, "Crunk");
        sendKeysUtil.sendKeysTAB(firstName);

        By lastName = By.id("lasttname");
        sendKeysUtil.sendKeys(lastName, "Beck-Davis");
        sendKeysUtil.sendKeysTAB(lastName);

        By email = By.cssSelector("#email.input");
        sendKeysUtil.sendKeysRIGHT(email);
        sendKeysUtil.sendKeys(email, "yahoo.net");
        sendKeysUtil.sendKeysTAB(email);

        By areaCode = By.xpath("(//div[@class='select'])[1]//select");
        Select select = new Select(driver.findElement(areaCode));
        select.selectByVisibleText("Argentina (+54)");
        System.out.println(select.getFirstSelectedOption().getText());
        sendKeysUtil.sendKeysTAB(areaCode);

        By phoneNumber = By.cssSelector("#Phno.input");
        sendKeysUtil.sendKeys(phoneNumber, "3893645098");
        sendKeysUtil.sendKeysTAB(phoneNumber);

        By address = By.cssSelector("#Addl1.input");
        sendKeysUtil.sendKeys(address, "3602 51st St");
        sendKeysUtil.sendKeysTAB(address);

        By address2 = By.cssSelector("#Addl2.input");
        sendKeysUtil.sendKeys(address2, "n/a");
        sendKeysUtil.sendKeysTAB(address2);

        By state = By.id("state");
        sendKeysUtil.sendKeys(state, "CA");
        sendKeysUtil.sendKeysTAB(state);

        By postalCode = By.xpath("//input[@placeholder='Postal-Code']");
        sendKeysUtil.sendKeys(postalCode, "47567");
        sendKeysUtil.sendKeysTAB(postalCode);

        By country = By.xpath("(//div[@class='select'])[2]//select");
        Select select1 = new Select(driver.findElement(country));
        select1.selectByVisibleText("Andorra");
        System.out.println(select1.getFirstSelectedOption().getText());
        sendKeysUtil.sendKeysTAB(country);

        By calendar = By.cssSelector("#Date.input");
        clickUtil.waitAndClick(calendar);
        sendKeysUtil.sendKeys(calendar, "02251994");
        sendKeysUtil.sendKeysTAB(calendar);

        By gender = By.cssSelector("#female");
        clickUtil.waitAndClick(gender);
        sendKeysUtil.sendKeysTAB(gender);

        clickUtil.waitAndClick(By.xpath("//input[@type='checkbox']"));

        clickUtil.waitAndClick(By.cssSelector("input.button.is-primary"));
    }
}
