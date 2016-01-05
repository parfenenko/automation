package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by j.parfenenko on 1/5/16.
 */
public class LoginPage extends BasePage{

    public void login(String login, String password) {
        $(Locators.LOGIN_FIELD).sendKeys(login);
        $(Locators.PASSWORD_FIELD).sendKeys(password);
        $(Locators.LOGIN_BUTTON).click();
    }

    public interface Locators{
        By LOGIN_FIELD = By.xpath(".//*[@id='_username']");
        By PASSWORD_FIELD = By.xpath(".//*[@id='_password']");
        By LOGIN_BUTTON = By.cssSelector(".col-md-2.col-md-offset-5.btn.btn-auth.save-btn.save-info-btn");
    }
}
