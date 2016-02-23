package MR.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 1/11/2016.
 */
public class LoginPage extends BasePage {

    public LoginPage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "LoginPage");
    }

public DashboardPage login(String login, String password) {
    inputText(Locators.LOGIN_FIELD, login);
    inputText(Locators.PASSWORD_FIELD, password);
    return new DashboardPage();
    }

public interface Locators {
    By PAGE_LOCATOR = By.xpath("//h1[contains(.,'Login')]");
    By LOGIN_FIELD = By.xpath(".//*[@id='username']");
    By PASSWORD_FIELD = By.xpath(".//*[@id='password']");}
}