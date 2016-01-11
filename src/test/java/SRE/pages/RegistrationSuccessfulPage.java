package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 12/3/2015.
 */
public class RegistrationSuccessfulPage extends BasePage{

    public RegistrationSuccessfulPage(){
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "RegistrationSuccessfulPage");
    }

    public interface Locators{
        By PAGE_LOCATOR = By.xpath("//div[@class='register-notification']");
    }
}
