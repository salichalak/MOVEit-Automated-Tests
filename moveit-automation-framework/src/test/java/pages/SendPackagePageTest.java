package pages;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SendPackagePageTest extends BaseTest {
    private static final String CONTACT_NAME = "Sali Chalak";
    private static final String SUBJECT = "Test subject";
    private static final String CLASSIFICATION = "Secret";
    private static final String FILE_TO_SEND = "KVsh76.jpg";

    @Test
    @DisplayName("Send a package (TC-03)")
    public void verifyUserIsAbleToSendPackage() {
        homePage.performSearch(FILE_TO_SEND);
        driver.findElement(By.linkText(FILE_TO_SEND)).click();

        sendPackagePage.sendAsAttachmentButton.click();
        sendPackagePage.typeContactName(CONTACT_NAME);
        sendPackagePage.typeSubject(SUBJECT);
        sendPackagePage.selectClassification(CLASSIFICATION);

        driver.switchTo().frame("arg04")
                .findElement(By.xpath("//body")).sendKeys("Test note.");
        driver.switchTo().defaultContent();
        driver.findElements(By.id("ButtonSend")).get(0).click();

        assertTrue(sendPackagePage.successMessage.isDisplayed(), "The file was not sent!");
    }
}
