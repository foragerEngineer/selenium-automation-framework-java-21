package utilities;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.basepage.BasePage;

import java.time.Duration;

@Log4j2
public class Waiter extends BasePage {

    public Waiter() {
        super();
    }

    public static void sleep() {
        log.info("Sleeping for 3 seconds");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(long millis) {
        try {
            for (int i = 0; i < millis; i++) {
                Thread.sleep(millis);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Pauses the execution for the specified duration in milliseconds using Selenium's WebDriverWait.
     * <p>
     * <b>Discovery:</b> Using {@code Thread.sleep()} directly can block the thread and cause tests to hang
     * if not managed properly. This method uses Selenium's {@code WebDriverWait} with a trivial condition
     * to avoid blocking the thread unnecessarily.
     * </p>
     * <p>
     * <b>Workaround:</b> If you encounter issues with {@code Thread.sleep()}, use this method to pause execution
     * without relying on direct thread management.
     * </p>
     * <p>
     * <b>More Elegant Solution:</b> Instead of pausing execution arbitrarily, use explicit waits to wait for
     * specific conditions (e.g., element visibility, clickability) to ensure the test progresses dynamically
     * based on the application's state.
     * </p>
     *
     * @param millis The duration to pause execution, in milliseconds.
     */
    public static void driverSleep(int millis) {
        new WebDriverWait(driver, Duration.ofMillis(millis)).until(webDriver -> true);
    }

}
