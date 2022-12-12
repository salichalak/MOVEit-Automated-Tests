package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    @FindBy(id = "lnk_signout")
    WebElement signOutButton;

    @FindBy(id = "uploadButton")
    WebElement uploadButton;

    @FindBy(xpath = "//button[contains(text(),'Upload')]")
    WebElement uploadAttachmentsButton;

    @FindBy(xpath = "//input[@type='file'][@class='file-selector-input']")
    WebElement fileUploadInput;

    @FindBy(xpath = "//div[contains(text(), 'Send Package')]")
    WebElement sendPackageButton;

    @FindBy(xpath = "//div[@class='text'][contains(text(), 'Request Files')]")
    WebElement requestFilesButton;

    @FindBy(id = "searchfield_findfile")
    WebElement searchBox;

    @FindBy(xpath = "//td[contains(text(), 'There are no files or folders which matched your criteria.')]")
    WebElement invalidSearchMessage;

    @FindBy(xpath = "//td[contains(text(), 'folder matching the search term')]")
    WebElement validSearchMessage;

    @FindBy(id = "searchfieldbutton_findfile")
    WebElement searchMagnifierButton;

    @FindBy(xpath = "//button[@class='header-control'][@data-testid='modal-header-close-button']")
    WebElement closeAttachmentsWindowButton;

    @FindBy(id = "field_gotofolder")
    WebElement goToFileDropdown;

    @FindBy(xpath = "//span[@class='error-description']")
    WebElement errorMessage;

    @FindBy(xpath = "//a[@title='Home']//following-sibling::a[1]")
    WebElement folderNameElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void signOut() {
        signOutButton.click();
    }

    public void clickUploadButton() {
        uploadButton.click();
    }

    public void attachFiles(String filePath) {
        fileUploadInput.sendKeys(filePath);
    }

    public void submitAttachedFiles() {
        uploadAttachmentsButton.click();
    }

    public void clickSendPackageButton() {
        sendPackageButton.click();
    }

    public void clickRequestFilesButton() {
        requestFilesButton.click();
    }

    public void performSearch(String input) {
        searchBox.sendKeys(input);
        searchMagnifierButton.click();
    }

    public void closeUploadWindow() {
        closeAttachmentsWindowButton.click();
    }

    public void selectFolderFromDropdown(String folder) {
        Select dropdown = new Select(goToFileDropdown);
        dropdown.selectByVisibleText(folder);
    }
}
