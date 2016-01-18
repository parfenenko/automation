package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 1/18/2016.
 */
public class InboxGmailPage extends BasePage {
    public InboxGmailPage(){
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "PAGE_LOCATOR");
    }

    public void searchEmailBySender(String sender) {
        inputText(Locators.SEARCH, sender);
        clickOn(Locators.SEARCH_BUTTON);
    }

    public EmailPage openEmail() {
        clickOn(Locators.EMAIL_LINK);
        return new EmailPage();
    }

    public interface Locators{
        By PAGE_LOCATOR = By.cssSelector(".aio.UKr6le");
        By SEARCH = By.cssSelector("#gs_taif50");
        By SEARCH_BUTTON = By.cssSelector("#gbqfb");
        By EMAIL_LINK = By.xpath(".//*[@id=':jw']");
    }
}
