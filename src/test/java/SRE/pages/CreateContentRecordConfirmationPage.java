package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 1/11/2016.
 */
public class CreateContentRecordConfirmationPage extends BasePage {

    public CreateContentRecordConfirmationPage(){
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "CreateContentRecordConfirmationPage");
    }

    public interface Locators{
        By PAGE_LOCATOR = By.cssSelector("#user-flash-widget-label");
    }
}
