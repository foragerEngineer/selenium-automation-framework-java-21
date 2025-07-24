package utilities.utilmethods;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.basepage.BasePage;
import utilities.UiHelper;

import java.util.List;

@Log4j2
public class MultiSelectUtil extends BasePage {

    public MultiSelectUtil() {
        super();
    }

    public void multiSelectByVisibleText(By locator, String multiSelectEl1, String multiSelectEl2) {
        Select select = new Select(driver.findElement(locator));
        log.info(">>>>>>>>>>>>>>>>>> SELECTED HERO NAME 1: {}", multiSelectEl1);
        select.selectByVisibleText(multiSelectEl1);
        UiHelper.sleep(1500);
        log.info(">>>>>>>>>>>>>>>>>> SELECTED HERO NAME 2: {}", multiSelectEl2);
        select.selectByVisibleText(multiSelectEl2);
        UiHelper.sleep(1500);
        log.info(">>>>>>>>>>>>>>>>>> SELECTED HERO NAMES: {} and {}", multiSelectEl1, multiSelectEl2);
    }

    public void listAllElementsInList() {
        List<WebElement> allOptions = new Select(driver.findElement(By.cssSelector("#superheros"))).getOptions();
        for (WebElement option : allOptions) {
            log.info(">>>>>>>>>>>>>>>>>> LIST OF HEROES: {}", option.getText());
        }
    }

}
