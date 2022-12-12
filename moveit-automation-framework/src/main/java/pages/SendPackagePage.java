package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SendPackagePage extends BasePage {

    @FindBy(id = "tofield")
    WebElement contactInput;

    @FindBy(id = "fieldsubject")
    WebElement subjectInput;

    @FindBy(id = "classificationtype")
    WebElement classificationDropdown;

    @FindBy(xpath = "//div[@class='statuscontent'][contains(text(), 'Sent package with')]")
    WebElement successMessage;

    @FindBy(xpath = "//input[@type='file'][@id='$jswiz_file_verifier']")
    WebElement fileUploadInput;

    @FindBy(xpath = "//button[contains(text(),'Upload')]")
    WebElement uploadAttachmentsButton;

    @FindBy(xpath = "//button[contains(text(), 'Close')]")
    WebElement closeUploadWindowButton;

    @FindBy(xpath = "//a[@class='btn btn-secondary js-postlink']")
    WebElement sendAsAttachmentButton;

    public SendPackagePage(WebDriver driver) {
        super(driver);
    }

    public void typeContactName(String contactName) {
        contactInput.sendKeys(contactName);
    }

    public void typeSubject(String subject) {
        subjectInput.sendKeys(subject);
    }

    public void selectClassification(String classification) {
        classificationDropdown.click();
        Select dropDown = new Select(classificationDropdown);
        dropDown.selectByVisibleText(classification);
    }

    public void attachFiles(String filePath) {
        fileUploadInput.sendKeys(filePath);
    }

    public void clickUploadAttachmentButton() {
        uploadAttachmentsButton.click();
    }

    public void closeUploadWindow() {
        closeUploadWindowButton.click();
    }
}
