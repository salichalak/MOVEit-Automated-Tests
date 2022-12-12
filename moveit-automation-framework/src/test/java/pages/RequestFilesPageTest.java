package pages;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RequestFilesPageTest extends BaseTest {
    private static final String CONTACT_NAME = "Sali Chalak";
    private static final String SUBJECT = "Test subject";
    private static final String CLASSIFICATION = "Secret";

    @Test
    @DisplayName("Request files (TC-04)")
    public void verifyUserIsAbleToRequestFiles() {
        homePage.clickRequestFilesButton();
        requestFilesPage.typeContactName(CONTACT_NAME);
        requestFilesPage.typeSubject(SUBJECT);
        requestFilesPage.selectClassification(CLASSIFICATION);

        driver.switchTo().frame("arg04")
                .findElement(By.xpath("//body")).sendKeys("Test note.");
        driver.switchTo().defaultContent();
        driver.findElements(By.id("ButtonSend")).get(0).click();

        assertTrue(requestFilesPage.successMessage.isDisplayed(),"The file request was not successful!");
    }
}
