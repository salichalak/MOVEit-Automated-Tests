package pages;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest extends BaseTest {
    private static final String VALID_SEARCH_INPUT = "interview.sali.chalak";
    private static final String INVALID_SEARCH_INPUT = "null";
    private static final String FOLDER_TO_REDIRECT = "/ Home / interview.sali.chalak";

    @Test
    @DisplayName("Sign in to the system and sign out from the system (TC-01)")
    public void logInAndLogOutWithValidCredentials() {
        assertTrue(anonymousAreaPage.signInMessage.isDisplayed(), "Unable to login!");
        homePage.signOut();
        assertTrue(anonymousAreaPage.signOffMessage.isDisplayed(), "Unable to logoff!");
    }

    @Test
    @DisplayName("Upload a single and multiple files (TC-02)")
    public void verifyUserIsAbleToUploadFiles() throws IOException {
        homePage.clickUploadButton();

        File file = generateFile();
        if (file.createNewFile()) {
            homePage.attachFiles(file.getAbsolutePath());
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.uploadAttachmentsButton));
        homePage.submitAttachedFiles();
    }

    @Test
    @DisplayName("Find file/folder by typing a valid input in the search box (TC-05)")
    public void verifyValidSearchInputReturnsCorrectResult() {
        homePage.performSearch(VALID_SEARCH_INPUT);
        assertTrue(homePage.validSearchMessage.isDisplayed(), "No results were found!");
    }

    @Test
    @DisplayName("Find file/folder by typing a invalid input in the search box (TC-06)")
    public void verifyInvalidSearchInputReturnsErrorMessage() {
        homePage.performSearch(INVALID_SEARCH_INPUT);
        assertTrue(homePage.invalidSearchMessage.isDisplayed(), "Incorrect results are displayed!");
    }

    @Test
    @DisplayName("Return error message for uploading the same file TC-10")
    public void verifyErrorMessageForUploadingSameFile() throws IOException {
        homePage.clickUploadButton();

        File duplicate = generateFile();
        if (duplicate.createNewFile()) {
            homePage.attachFiles(duplicate.getAbsolutePath());
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.uploadAttachmentsButton));
        homePage.submitAttachedFiles();

        homePage.closeUploadWindow();
        homePage.clickUploadButton();
        homePage.attachFiles(duplicate.getAbsolutePath());

        wait.until(ExpectedConditions.elementToBeClickable(homePage.uploadAttachmentsButton));
        homePage.submitAttachedFiles();

        assertTrue(homePage.errorMessage.isDisplayed(), "The file was uploaded successfully!");
    }

    @Test
    @DisplayName("Redirecting to specific folder from Go To Folder drop-down (TC-11)")
    public void verifyUserIsRedirectedToCorrectFolderFromGoToDropdown() {
        homePage.selectFolderFromDropdown(FOLDER_TO_REDIRECT);
        String actualFolderName = homePage.folderNameElement.getAttribute("title");
        String expectedFolderName = FOLDER_TO_REDIRECT.split("/")[2].trim();
        assertEquals(expectedFolderName, actualFolderName);
    }

    private File generateFile() {
        int fileVersion = new Random().nextInt(1, 100);
        String fileName = "attachment_v" + fileVersion + ".txt";
        return new File("src\\test\\java\\test_data\\" + fileName);
    }
}