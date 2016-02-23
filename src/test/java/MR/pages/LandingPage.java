package MR.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 2/23/2016.
 */
public class LandingPage extends BasePage{

    public LandingPage() {
    waitPageLoaded(Locators.PAGE_LOCATOR, 5, "LandingPage");
}

    public void fillForm(String firstName, String lastName, String email) {
//        waitUntilElementLoaded(Locators.FIRST_NAME, 5, "FIRST_NAME");
        inputText(Locators.FIRST_NAME, firstName);
//        waitUntilElementLoaded(Locators.LAST_NAME, 5, "FIRST_NAME");
        inputText(Locators.LAST_NAME, lastName);
//        waitUntilElementLoaded(Locators.EMAIL, 5, "FIRST_NAME");
        inputText(Locators.EMAIL, email);
        clickOn(Locators.SUBMIT_BUTTON);
    }

    public interface Locators {
        By PAGE_LOCATOR = By.xpath("//input[@name='firstname']");
        By FIRST_NAME = By.xpath("//input[@name='firstname']");
        By LAST_NAME = By.xpath("//input[@name='lastname']");
        By EMAIL = By.xpath("//input[@name='email']");
        By SUBMIT_BUTTON = By.xpath("//button[@class='btn submit center-block']");
    }
}
