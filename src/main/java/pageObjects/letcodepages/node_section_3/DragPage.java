package pageObjects.letcodepages.node_section_3;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.basepage.BasePage;

@Log4j2
public class DragPage extends BasePage {

    @FindBy(xpath = "//h1[normalize-space()='Drag']")
    private WebElement dragTitle;

    public DragPage() {
        super();
        baseWebElementIdentifier = dragTitle;
    }

    public boolean isDragTitleDisplayed() {
        boolean isDisplayed = displayUtil.isElementDisplayed(dragTitle);
        log.info("ASSERT: Drag title is " + (isDisplayed ? "displayed" : "not displayed"));
        return isDisplayed;
    }

    public void dragAndDropBox() {
        dragAndDropUtil.dragAndDropBy(400, 200, By.id("sample-box"));
    }

}
