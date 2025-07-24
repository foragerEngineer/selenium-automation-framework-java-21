package tests.letcodeWebTests;

import automationframework.basetests.BaseWebTest;
import org.testng.annotations.Test;
import pageObjects.CommonPage;
import pageObjects.HomePage;
import pageObjects.enums.NodeMenuEnums;
import pageObjects.letcodepages.node_section_1.AlertPage;
import pageObjects.letcodepages.node_section_1.ButtonPage;
import pageObjects.letcodepages.node_section_1.DropdownPage;
import pageObjects.letcodepages.node_section_1.InputPage;
import pageObjects.letcodepages.node_section_2.ElementsPage;
import pageObjects.letcodepages.node_section_2.RadioAndCheckboxPage;
import pageObjects.letcodepages.node_section_2.WindowsPage;
import pageObjects.letcodepages.node_section_3.DragPage;
import pageObjects.letcodepages.node_section_3.SortPage;
import pageObjects.letcodepages.node_section_4.FormsPage;
import pageObjects.letcodepages.node_section_4.WaitsPage;

import static utilities.AssertUtils.getSoftAssert;
import static utilities.AssertUtils.stopSoftAssert;

public class LetCodeWebTests extends BaseWebTest {

    @Test
    public void letCodeUiTest() {
        HomePage homePage = new HomePage();
        homePage.openLetCodePage();
        getSoftAssert().assertTrue(homePage.isLetCodeImageDisplayed(), "LetCode image title is not displayed");

        homePage.selectTestSection(NodeMenuEnums.INPUT);

        InputPage editPage = new InputPage();
        getSoftAssert().assertTrue(editPage.isInputTitleDisplayed(), "Input title is not displayed");
        editPage.clickFullNameTextBox()
                .editApplication();
        CommonPage.clickWorkSpaceBtn();

        homePage.selectTestSection(NodeMenuEnums.BUTTON);

        ButtonPage buttonPage = new ButtonPage();
        getSoftAssert().assertTrue(buttonPage.isButtonTitleDisplayed(), "Button title is not displayed");
        buttonPage.getCoordinates()
                .getColor()
                .getSize()
                .isBtnDisabled()
                .clickAndHoldBtn();
        CommonPage.clickWorkSpaceBtn();

        homePage.selectTestSection(NodeMenuEnums.SELECT);

        DropdownPage dropdownPage = new DropdownPage();
        getSoftAssert().assertTrue(dropdownPage.isDropdownTitleDisplayed(), "Dropdown title is not displayed");
        dropdownPage.selectFruitByVisibleText()
                .selectMultipleSuperHeroes()
                .getListOfSuperheroes()
                .selectProgramLanguage()
                .getProgramLanguageList()
                .selectCountryByValue();
        CommonPage.clickWorkSpaceBtn();

        homePage.selectTestSection(NodeMenuEnums.ALERT);

        AlertPage alertPage = new AlertPage();
        getSoftAssert().assertTrue(alertPage.isAlertTitleDisplayed(), "Alert title is not displayed");
        alertPage.clickSimpleAlertBtn()
                .acceptSimpleAlertBtn()
                .clickConfirmAlertBtn()
                .dismissConfirmAlertBtn()
                .clickPromptAlertBtn()
                .fillOutPromptAlert()
                .acceptPromptAlert()
                .clickModernAlertBtn()
                .dismissModernAlert();
        CommonPage.clickWorkSpaceBtn();

        homePage.selectTestSection(NodeMenuEnums.RADIO);

        RadioAndCheckboxPage radioAndCheckboxPage = new RadioAndCheckboxPage();
        getSoftAssert().assertTrue(radioAndCheckboxPage.isRadioTitleDisplayed(), "Radio and Checkbox title is not displayed");
        radioAndCheckboxPage.clickCheckboxOption()
                .isCheckboxSelected()
                .isCheckboxBtnDisabled();
        CommonPage.clickWorkSpaceBtn();

        homePage.selectTestSection(NodeMenuEnums.WINDOW);

        WindowsPage tabsPage = new WindowsPage();
        getSoftAssert().assertTrue(tabsPage.isWindowsTitleDisplayed(), "Windows title is not displayed");
        tabsPage.clickHomeBtn()
                .switchToChildWindow()
                .printTitleNewTab()
                .closeChildWindow()
                .clickMultipleWindowsBtn()
                .switchToDropdownPage()
                .printWindowTitle()
                .closeDropdownPage()
                .printTitle()
                .closeAlertPage();
        CommonPage.dismissAd();
        CommonPage.clickWorkSpaceBtn();

        homePage.selectTestSection(NodeMenuEnums.ELEMENTS);

        ElementsPage elementsPage = new ElementsPage();
        getSoftAssert().assertTrue(elementsPage.isElementsTitleDisplayed(), "Assert Elements title is not displayed");
        elementsPage.clickSearchBar()
                .sendKeysToSearchbar()
                .isImageDisplayed()
                .printSearchInfo(1, "Public Repos")
                .printSearchInfo(2, "Public Gists")
                .printSearchInfo(3, "Followers");
        CommonPage.clickWorkSpaceBtn();

        homePage.selectTestSection(NodeMenuEnums.DRAG);

        DragPage dragPage = new DragPage();
        getSoftAssert().assertTrue(dragPage.isDragTitleDisplayed(), "Drag title is not displayed");
        dragPage.dragAndDropBox();
        CommonPage.clickWorkSpaceBtn();

        homePage.selectTestSection(NodeMenuEnums.SORT);

        SortPage sortPage = new SortPage();
        getSoftAssert().assertTrue(sortPage.isSortTitleDisplayed(), "Sort title is not displayed");
        sortPage.moveTODOElementsToDone();
        CommonPage.clickWorkSpaceBtn();

        homePage.selectTestSection(NodeMenuEnums.WAITS);

        WaitsPage waitsPage = new WaitsPage();
        getSoftAssert().assertTrue(waitsPage.isWaitTitleDisplayed(), "Waits title is not displayed");
        waitsPage.clickSimpleAlert()
                .waitAndAcceptAlert();
        CommonPage.clickWorkSpaceBtn();

        homePage.selectTestSection(NodeMenuEnums.FORMS);

        FormsPage formsPage = new FormsPage();
        getSoftAssert().assertTrue(formsPage.isFormTitleDisplayed(), "Form title is not displayed");
        formsPage.fillOutForm();

        stopSoftAssert();
    }
}
