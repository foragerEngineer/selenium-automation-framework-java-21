package pageObjects.letcodepages.node_section_3;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.basepage.BasePage;

@Log4j2
public class SortPage extends BasePage {

    @FindBy(xpath = "//h1[normalize-space()='Sort']")
    private WebElement sortTitle;

    public SortPage() {
        super();
        baseWebElementIdentifier = sortTitle;
    }

    public boolean isSortTitleDisplayed() {
        return displayUtil.isElementDisplayed(sortTitle);
    }

    public void moveTODOElementsToDone() {
        By parentContainer = By.xpath("(//div[@class='cdk-drop-list example-list'])[2]");
        By childContainer = By.xpath("(//div[@class='cdk-drop-list example-list'])[1]//div[1]");
        dragAndDropUtil.slideFromAndTo(childContainer, parentContainer);
        dragAndDropUtil.slideFromAndTo(childContainer, parentContainer);
        dragAndDropUtil.slideFromAndTo(childContainer, parentContainer);
        dragAndDropUtil.slideFromAndTo(childContainer, parentContainer);
    }
}
