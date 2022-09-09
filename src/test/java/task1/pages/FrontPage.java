package task1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FrontPage {

    private String loginName = "alex-apple-alex";
    private String loginPassword = "qwerty@!12345";
    private String expectedAccountName = "alex-apple-alex";
    private String requestText = "купить кофемашину bork c804";
    private String userNameIsCorrect = "Username is correct";
    private String searchListIsBiggerThanTen = "Search list size id bigger than 10";
    private String searchResultsContainMVideoLink = "Search results contain mvideo link";

    @FindBy(css = ".desk-notif-card__card .desk-notif-card__login-new-item-title")
    private WebElement enterButton;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement name;
    @FindBy(xpath = "//input[@data-t='field:input-passwd']")
    private WebElement password;
    @FindBy(xpath = "//*[@data-t='button:action:passp:sign-in']")
    private WebElement loginButton;
    @FindBy(css = ".desk-notif-card .username")
    private WebElement userAccountName;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement googleSearchField;
    @FindBy(css = ".MjjYud")
    private List<WebElement> googleSearchResultsList;
    @FindBy(xpath = "//*[contains(@href, 'mvideo.ru')]")
    private WebElement googleSearchContainsMVideo;


    public FrontPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void enterRequestText() {
        googleSearchField.sendKeys(requestText);
        googleSearchField.submit();
    }

    public void findEnterButtonAndClick() {
        enterButton.click();
    }

    public void fillUserNameInAndClick() {
        name.sendKeys(loginName);
        loginButton.click();
    }

    public void fillUserPasswordInAndClick() {
        password.sendKeys(loginPassword);
        loginButton.click();
    }

    public void assertUserAccountName() {
        assertThat(userAccountName.getText())
                .as(userNameIsCorrect)
                .isEqualTo(expectedAccountName);
    }

    public void assertOverTenSearchResultsAreDisplayed() {
        int listSize = googleSearchResultsList.size();

        assertThat(listSize > 10)
                .as(searchListIsBiggerThanTen)
                .isTrue();
        assertThat(googleSearchResultsList.contains(googleSearchContainsMVideo))
                .as(searchResultsContainMVideoLink);
    }
}
