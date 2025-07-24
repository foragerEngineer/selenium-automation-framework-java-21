package pageObjects.letcodepages.node_section_1;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.basepage.BasePage;

@Log4j2
public class ButtonPage extends BasePage {

    @FindBy(xpath = "//h1[normalize-space()='Button']")
    private WebElement buttonTitle;

    public ButtonPage() {
        super();
        baseWebElementIdentifier = buttonTitle;
    }

    public boolean isButtonTitleDisplayed() {
        return displayUtil.isElementDisplayed(By.xpath("//h1[normalize-space()='Button']"));
    }


    public ButtonPage getCoordinates() {
        validateLoad();
        Point location = driver.findElement(By.id("position")).getLocation();
        System.out.println("Location of X: " + location.getX() + "," + " Location of Y: " + location.getY());
        return this;
    }

    public ButtonPage getColor() {
        String color = colorUtil.getColorByCssValue(By.id("color"));
        log.info("Color: " + color);
        return this;
    }

    public ButtonPage getSize() {
        Dimension size = driver.findElement(By.cssSelector("#property.button.is-success")).getSize();
        log.info("Width of button: " + size.getWidth() + ", Height of button: " + size.getHeight());
        return this;
    }

    public ButtonPage isBtnDisabled() {
        elementAttributeUtil.isDisabled(By.xpath("//button[@title='Disabled button']"));
        return this;
    }

    public void clickAndHoldBtn() {
        clickUtil.clickAndHold(By.xpath("//h2[contains(text(), ' Button Hold!')]"));
    }
}
