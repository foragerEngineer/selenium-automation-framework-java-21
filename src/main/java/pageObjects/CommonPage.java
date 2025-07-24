package pageObjects;

import constants.TimeConstants;
import org.openqa.selenium.By;
import pageObjects.basepage.BasePage;
import utilities.Waiter;

public class CommonPage extends BasePage {

    public CommonPage() {
        super();
    }

    public static void clickWorkSpaceBtn() {
        clickUtil.waitAndClick(By.cssSelector("a#testing.navbar-item"));
        Waiter.driverSleep(TimeConstants.WAIT_MILLIS_2000);
    }

    public static void dismissAd() {
        System.out.println(">>>>>>>>>>>>>>>> Checking if ad is displayed...");
        if (displayUtil.isElementNotDisplayed(By.xpath("//img[alt='letcode']"))) {
            driver.get("https://letcode.in/test");
        } else {
            System.out.println("Ad is not displayed");
        }
    }

}
