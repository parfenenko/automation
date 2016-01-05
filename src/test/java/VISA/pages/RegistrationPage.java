package VISA.pages;

import framework.BasePage;
import org.openqa.selenium.By;
import rabota.pages.SearchResultPage;

/**
 * Created by payu on 12/18/2015.
 */
public class RegistrationPage extends BasePage {

//    public RegistrationPage(){
//        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "RegistrationPage");
//    }

    public void fillTheFields(String first_name, String last_name, String father_name, String phone_number, String email) {
        $(Locators.LAST_NAME).sendKeys(last_name);
        $(Locators.FIRST_NAME).sendKeys(first_name);
        $(Locators.FATHER_NAME).sendKeys(father_name);
        $(Locators.PHONE_NUMBER).sendKeys(phone_number);
        $(Locators.EMAIL).sendKeys(email);
    }

    public interface Locators{
        By PAGE_LOCATOR = By.id("");
        By LAST_NAME = By.id("formid_2443");
        By FIRST_NAME = By.id("formid_2444");
        By FATHER_NAME = By.id("formid_2445");
        By PHONE_NUMBER = By.id("formid_2447");
        By EMAIL = By.id("formid_2446");
    }
}
