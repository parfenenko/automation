package rabota;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 7/15/2015.
 */
public class LoginPage extends BasePage {

    public LoginPage(){
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "Login Page");
    }

    public MainPage login(String login, String password){
        inputText(Locators.LOGIN_FIELD, login);
        inputText(Locators.PASSWORD_FIELD, password);
        clickOn(Locators.LOGIN_BUTTON);
        return new MainPage();
    }

    public interface Locators{
        By LOGIN_FIELD = By.cssSelector("#mod_login_username");
        By PASSWORD_FIELD = By.cssSelector("#mod_login_password");
        By LOGIN_BUTTON = By.xpath("//input[@name='Submit']");
        By PAGE_LOCATOR = By.xpath("//a[contains(.,'Home')]");
    }
}