package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RequestFilesPage extends BasePage {

    @FindBy(id = "tofield")
    WebElement contactInput;

    @FindBy(id = "fieldsubject")
    WebElement subjectInput;

    @FindBy(id = "classificationtype")
    WebElement classificationDropdown;

    @FindBy(xpath = "//div[@class='statuscontent'][contains(text(), 'Sent package with')]")
    WebElement successMessage;

    public RequestFilesPage(WebDriver driver) {
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
}