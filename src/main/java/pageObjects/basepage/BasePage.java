package pageObjects.basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseIdentifier;
import utilities.UiHelper;
import utilities.utilmethods.AlertUtil;
import utilities.utilmethods.ChromeInteracts;
import utilities.utilmethods.ClickUtil;
import utilities.utilmethods.ColorUtil;
import utilities.utilmethods.DisplayUtil;
import utilities.utilmethods.DragAndDropUtil;
import utilities.utilmethods.ElementAttributeUtil;
import utilities.utilmethods.HoverUtil;
import utilities.utilmethods.IFrameUtil;
import utilities.utilmethods.KeyboardUtil;
import utilities.utilmethods.SendKeysUtil;
import utilities.utilmethods.WindowTapUtil;
import utilities.utilmethods.WindowUtil;

public class BasePage extends BaseIdentifier {

    protected static WebDriver driver;
    protected static UiHelper uiHelper;
    protected static ChromeOptions chromeOptions;
    protected static AlertUtil alertUtil;
    protected static ChromeInteracts chromeInteracts;
    protected static ClickUtil clickUtil;
    protected static ColorUtil colorUtil;
    protected static DisplayUtil displayUtil;
    protected static DragAndDropUtil dragAndDropUtil;
    protected static ElementAttributeUtil elementAttributeUtil;
    protected static HoverUtil hoverUtil;
    protected static IFrameUtil iFrameUtil;
    protected static KeyboardUtil keyboardUtil;
    protected static SendKeysUtil sendKeysUtil;
    protected static WindowTapUtil windowTapUtil;
    protected static WindowUtil windowUtil;

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
        initializeUtilities();
    }

    private static void initializeUtilities() {
        alertUtil = new AlertUtil();
        chromeInteracts = new ChromeInteracts();
        clickUtil = new ClickUtil();
        colorUtil = new ColorUtil();
        displayUtil = new DisplayUtil();
        dragAndDropUtil = new DragAndDropUtil();
        elementAttributeUtil = new ElementAttributeUtil();
        hoverUtil = new HoverUtil();
        iFrameUtil = new IFrameUtil();
        keyboardUtil = new KeyboardUtil();
        sendKeysUtil = new SendKeysUtil();
        uiHelper = new UiHelper();
        windowTapUtil = new WindowTapUtil();
        windowUtil = new WindowUtil();
    }
}
