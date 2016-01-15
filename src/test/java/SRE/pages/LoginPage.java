package SRE.pages;

import framework.BasePage;
import framework.DriverManager;
import org.openqa.selenium.By;

/**
 * Created by j.parfenenko on 1/5/16.
 */
public class LoginPage extends BasePage {

    String url = "";

    public LoginPage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "LoginPage");
    }

    public DistributionPage login(String email, String password) {
        inputText(Locators.LOGIN_FIELD, email);
        inputText(Locators.PASSWORD_FIELD, password);
        clickOn(Locators.LOGIN_BUTTON);
        return new DistributionPage();
    }

    public CreateContentRecordPage openCreateContentRecordPage() {
        DriverManager.getDriver().get(url);
        return new CreateContentRecordPage();
    }

    public String getErrorMessage() {
        String errorMessage = new String();
        waitUntilElementLoaded(Locators.ERROR_MESSAGE, 5, "ERROR_MESSAGE");
        errorMessage = $(Locators.ERROR_MESSAGE).getText();
        return errorMessage;
    }

    public void tryToLogin(String email, String password) {
        inputText(Locators.LOGIN_FIELD, email);
        inputText(Locators.PASSWORD_FIELD, password);
        clickOn(Locators.LOGIN_BUTTON);}

    public interface Locators {
        By PAGE_LOCATOR = By.xpath("//*[@class='login-header']");
        By LOGIN_FIELD = By.xpath(".//*[@id='_username']");
        By PASSWORD_FIELD = By.xpath(".//*[@id='_password']");
        By LOGIN_BUTTON = By.xpath("//button[@name='login']");
        By ERROR_MESSAGE = By.cssSelector(".text-danger");
    }
}
