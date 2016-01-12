package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 1/11/2016.
 */
public class CreateContentRecordConfirmationDialogPage extends BasePage {

    public CreateContentRecordConfirmationDialogPage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "CreateContentRecordConfirmationDialogPage");
    }

    public interface Locators {
        By PAGE_LOCATOR = By.cssSelector("#user-flash-widget-label");
    }
}
