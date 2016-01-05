package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 12/2/2015.
 */
public class RegistrationPage extends BasePage{
    public RegistrationSuccessfulPage createCompany(String email,
                              String first_name,
                              String last_name,
                              String password,
                              String company_name,
                              String country) {
        $(Locators.EMAIL).sendKeys(email);
        $(Locators.FIRST_NAME).sendKeys(first_name);
        $(Locators.LAST_NAME).sendKeys(last_name);
        $(Locators.PASSWORD).sendKeys(password);
        $(Locators.CONFIRM_PASSWORD).sendKeys(password);
        $(Locators.COMPANY_NAME).sendKeys(company_name);
        $(Locators.COUNTRY).sendKeys(country);
        $(Locators.REGISTER_BUTTON).click();
        return new RegistrationSuccessfulPage();
}

    public interface Locators{
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
