package pageObjects.letcodepages.node_section_1;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageObjects.basepage.BasePage;

import java.util.List;

@Log4j2
public class DropdownPage extends BasePage {

    @FindBy(xpath = "//h1[normalize-space()='Dropdown']")
    private WebElement dropdownTitle;

    private final WebElement programLanguage = driver.findElement(By.id("lang"));

    public DropdownPage() {
        super();
        baseWebElementIdentifier = dropdownTitle;
    }

    public boolean isDropdownTitleDisplayed() {
        return displayUtil.isElementDisplayed(dropdownTitle);
    }

    public DropdownPage selectFruitByVisibleText() {
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByVisibleText("Orange");
        log.info("Selected fruit: " + select.getFirstSelectedOption().getText());
        return this;
    }

    public DropdownPage selectMultipleSuperHeroes() {
        Select select = new Select(driver.findElement(By.id("superheros")));
        select.selectByVisibleText("Ant-Man");
        select.selectByVisibleText("Wolverine");
        select.selectByVisibleText("Captain Marvel");
        List<WebElement> superHeroes = select.getAllSelectedOptions();
        for (WebElement superHero : superHeroes) {
            log.info("Selected superhero: " + superHero.getText());
        }
        return this;
    }

    public DropdownPage getListOfSuperheroes() {
        Select select = new Select(driver.findElement(By.id("superheros")));
        List<WebElement> allHeroes = select.getOptions();
        for (int i = 0; i < allHeroes.size(); i++) {
            log.info("Hero " + (i + 1) + ": " + allHeroes.get(i).getText());
        }
        return this;
    }

    public DropdownPage selectProgramLanguage() {
        Select select = new Select(programLanguage);
        select.selectByIndex(4);
        log.info("Selected program language: " + select.getFirstSelectedOption().getText());
        return this;
    }

    public DropdownPage getProgramLanguageList() {
        Select select = new Select(programLanguage);
        List<WebElement> programLang = select.getOptions();
        for (int j = 0; j < programLang.size(); j++) {
            log.info("Language " + (j + 1) + ": " + programLang.get(j).getText());
        }
        return this;
    }

    public void selectCountryByValue() {
        Select select = new Select(driver.findElement(By.id("country")));
        select.selectByValue("India");
        log.info("Selected country: " + select.getFirstSelectedOption().getText());
    }

}
