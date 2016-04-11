package ImpartSocial.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by j.parfenenko on 3/24/16.
 */
public class ConfirmationPage extends BasePage {

    public ConfirmationPage() {
        waitPageLoaded(LOcators.PAGE_LOCATOR, 5, "ConfirmationPage");
    }

    public interface LOcators{
        By PAGE_LOCATOR = By.cssSelector(".section--content.page-checkout");
    }
}
