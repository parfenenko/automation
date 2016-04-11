package ImpartSocial.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by j.parfenenko on 3/27/16.
 */
public class CmsLoginPage extends BasePage {

    public void loginToCms(String adminEmail, String adminPassword) {
        inputText(Locators.EMAIL_FIELD, adminEmail);
        inputText(Locators.PASSWORD_FIELD, adminPassword);
        clickOn(Locators.LOGIN_BUTTON);
    }

    public interface Locators{
       By PAGE_LOCATOR = By.cssSelector("");
        By EMAIL_FIELD = By.cssSelector("#_username");
        By PASSWORD_FIELD = By.cssSelector("#_password");
        By LOGIN_BUTTON = By.cssSelector(".btn.btn-sm.btn-success");
    }
}
