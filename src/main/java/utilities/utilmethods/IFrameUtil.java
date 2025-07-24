package utilities.utilmethods;

import org.openqa.selenium.By;
import pageObjects.basepage.BasePage;

public class IFrameUtil extends BasePage {

    public IFrameUtil() {
        super();
    }

    public boolean isIframeIdElementDisplayed(String iframeId) {
        try {
            boolean isDisplayed = driver.findElement(By.id(iframeId)).isDisplayed();
            return isDisplayed;
        } catch (Exception e) {
            return false;
        }
    }

}
