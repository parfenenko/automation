package SRE.pages;

import framework.BasePage;
import framework.DriverManager;
import org.openqa.selenium.By;

/**
 * Created by j.parfenenko on 1/5/16.
 */
public class LoginPage extends BasePage {

    String url = "http://dev.sr.pp.ciklum.com/content/create";

    public LoginPage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "LoginPage");
    }

    public DistributionPage login(String login, String password) {
        inputText(Locators.LOGIN_FIELD, login);
        inputText(Locators.PASSWORD_FIELD, password);
        clickOn(Locators.LOGIN_BUTTON);
        return new DistributionPage();
    }

    public CreateContentRecordPage openCreateContentRecordPage() {
        DriverManager.getDriver().get(url);
        return new CreateContentRecordPage();
    }

    public interface Locators {
        By PAGE_LOCATOR = By.xpath("//*[@class='login-header']");
        By LOGIN_FIELD = By.xpath(".//*[@id='_username']");
        By PASSWORD_FIELD = By.xpath(".//*[@id='_password']");
        By LOGIN_BUTTON = By.xpath("//button[@name='login']");
    }
}
