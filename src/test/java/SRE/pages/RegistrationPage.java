package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by payu on 12/2/2015.
 */
public class RegistrationPage extends BasePage {

    public RegistrationPage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "RegistrationPage");
    }

    public RegistrationSuccessfulPage createCompany(String email,
                                                    String first_name,
                                                    String last_name,
                                                    String password,
                                                    String company_name,
                                                    String country) {
        inputText(Locators.EMAIL, email);
        inputText(Locators.FIRST_NAME, first_name);
        inputText(Locators.LAST_NAME, last_name);
        inputText(Locators.PASSWORD, password);
        inputText(Locators.CONFIRM_PASSWORD, password);
        inputText(Locators.COMPANY_NAME, company_name);
        clickOn(Locators.COUNTRY);
        By LINK = (By.xpath(String.format(Locators.GENERAL_STRING, country)));
        sleep(500);
        clickOn(LINK);
        clickOn(Locators.REGISTER_BUTTON);
        return new RegistrationSuccessfulPage();
    }

    public interface Locators {
        By GERMANY = By.xpath("//option[contains(.,'Germany')]");
        String GENERAL_STRING = "//option[contains(.,'%s')]";
        By PAGE_LOCATOR = By.cssSelector(".login-header");
        By EMAIL = By.cssSelector("#user_email");
        By FIRST_NAME = By.cssSelector("#user_firstName");
        By LAST_NAME = By.cssSelector("#user_lastName");
        By PASSWORD = By.cssSelector("#user_plainPassword_password");
        By CONFIRM_PASSWORD = By.cssSelector("#user_plainPassword_confirm");
        By COMPANY_NAME = By.cssSelector("#user_company_name");
        By COUNTRY = By.cssSelector("#user_company_country");
        By REGISTER_BUTTON = By.cssSelector(".btn-auth.col-md-2.col-md-offset-5");
    }
}
