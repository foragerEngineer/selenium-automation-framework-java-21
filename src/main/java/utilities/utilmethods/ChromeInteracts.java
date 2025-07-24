package utilities.utilmethods;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pageObjects.basepage.BasePage;

@Log4j2
public class ChromeInteracts extends BasePage {

    public ChromeInteracts() {
        super();
    }

    /**
     * This class contains methods utilizing strictly ChromeOptions to interact with Chrome browser features.
     * It is designed to handle file downloads by clicking on elements that trigger downloads.
     * @param locator
     */
    public void fileDownload(By locator) {
        log.info(">>>>>> Attempting File Download...");
        try {
            // Ensure ChromeOptions is configured for file downloads
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--no-sandbox");

            // Click the element to trigger the file download
            clickUtil.waitAndClick(locator);
            log.info("File download triggered successfully using locator: " + locator.toString());
        } catch (Exception e) {
            log.error("Failed to download file using locator: " + locator.toString(), e);
        }
    }

}
