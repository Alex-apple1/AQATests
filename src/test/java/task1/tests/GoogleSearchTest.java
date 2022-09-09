package task1.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import task1.pages.FrontPage;

public class GoogleSearchTest {
    private WebDriver webDriver;
    private FrontPage frontPage;
    private String googleSearchPage = "https://google.com";
    private String driverName = "Chrome driver";

    @BeforeClass
    public void beforeClass(ITestContext context) {
        context.setAttribute(driverName, webDriver);
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void clear() {
        webDriver.quit();
    }

    @Test
    public void firstExerciseTest() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        frontPage = new FrontPage(webDriver);

        // 1. Open test site by URL
        webDriver.navigate().to(googleSearchPage);

        // 2. Perform log in
        frontPage.enterRequestText();

        // 3. Assert that over 10 search results are displayed and mvideo.ru is one of them
        frontPage.assertOverTenSearchResultsAreDisplayed();
    }
}
