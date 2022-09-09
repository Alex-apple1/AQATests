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

import java.util.concurrent.TimeUnit;

public class YandexPostBoxLoginTest {
    private WebDriver webDriver;
    private FrontPage frontPage;
    private String frontPageUrl = "https://yandex.ru";
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
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        frontPage = new FrontPage(webDriver);

        // 1. Open test site by URL
        webDriver.navigate().to(frontPageUrl);

        // 2. Perform log in
        frontPage.findEnterButtonAndClick();
        frontPage.fillUserNameInAndClick();
        frontPage.fillUserPasswordInAndClick();

        // 3. Assert user account name
        frontPage.assertUserAccountName();
    }
}
