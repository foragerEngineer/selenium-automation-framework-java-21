package pageObjects.letcodepages.node_section_4;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.basepage.BasePage;

@Log4j2
public class FilePage extends BasePage {

    public FilePage() {
        super();
    }

    public FilePage clickDownloadExcelBtn() {
//        clickUtil.waitAndClick(By.id("xls"));
        chromeInteracts.fileDownload(By.id("xls"));
        return this;
    }

    public FilePage uploadSampleFile() {
        WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
        String filePath = System.getProperty("user.home") + "/Downloads/sample.txt";
        System.out.println("Uploading " + filePath);
        upload.sendKeys(filePath);
        return this;
    }

    public FilePage clickDownloadPdfBtn() {
        clickUtil.waitAndClick(By.id("pdf"));
        return this;
    }

    public FilePage uploadSamplePdf() {
        WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
        String filePath = System.getProperty("user.home") + "/Downloads/sample.pdf";
        System.out.println("Uploading " + filePath);
        upload.sendKeys(filePath);
        return this;
    }

    public FilePage clickDownloadTextBtn() {
        clickUtil.waitAndClick(By.id("txt"));
        return this;
    }

    public void uploadSampleText() {
        WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
        String filePath = System.getProperty("user.home") + "/Downloads/sample.txt";
        System.out.println("Uploading " + filePath);
        upload.sendKeys(filePath);
    }
}
