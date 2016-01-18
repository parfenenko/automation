package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 1/18/2016.
 */
public class GmailHomePage extends BasePage {

    public GmailHomePage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "PAGE_LOCATOR");
    }

    public InboxGmailPage login(String jemail, String jpassword) {
        inputText(Locators.LOGIN, jemail);
        clickOn(Locators.NEXT_BUTTON);
        waitUntilElementLoaded(Locators.PASSWORD, 10, "PASSWORD");
        inputText(Locators.PASSWORD, jpassword);
        clickOn(Locators.LOGIN_BUTTON);
        return new InboxGmailPage();
    }

    public interface Locators {
        By PAGE_LOCATOR = By.cssSelector(".hidden-small");
        By LOGIN = By.cssSelector("#Email");
        By NEXT_BUTTON = By.cssSelector("#next");
        By PASSWORD = By.xpath(".//*[@id='Passwd']");
        By LOGIN_BUTTON = By.cssSelector("#signIn");
    }
}
