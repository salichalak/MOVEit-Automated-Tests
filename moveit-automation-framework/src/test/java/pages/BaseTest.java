package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected SendPackagePage sendPackagePage;
    protected RequestFilesPage requestFilesPage;
    protected AnonymousAreaPage anonymousAreaPage;

    private static final String BASE_URL = "https://www.moveitcloud.com/";
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    @BeforeAll
    void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        this.driver.navigate().to(BASE_URL);

        this.homePage = new HomePage(driver);
        this.sendPackagePage = new SendPackagePage(driver);
        this.requestFilesPage = new RequestFilesPage(driver);
        this.anonymousAreaPage = new AnonymousAreaPage(driver);
        this.anonymousAreaPage.signIn(USERNAME, PASSWORD);
    }

    @AfterEach
    void teardown() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
