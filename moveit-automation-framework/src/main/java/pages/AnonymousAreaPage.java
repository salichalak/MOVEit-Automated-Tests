package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnonymousAreaPage {

    @FindBy(id = "form_username")
    WebElement usernameField;

    @FindBy(id = "form_password")
    WebElement passwordField;

    @FindBy(id = "submit_button")
    WebElement signOnButton;

    @FindBy(xpath = "//div[contains(text(), 'Welcome to MOVEit-Mobile-1')]")
    WebElement signInMessage;

    @FindBy(xpath = "//div[contains(text(), 'Signed off successfully')]")
    WebElement signOffMessage;

    public AnonymousAreaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void signIn(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signOnButton.click();
    }
}
