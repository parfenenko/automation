package pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 9/3/2015.
 */
public class NewBookingPage extends BasePage {

    public void verifyPopup() {
        isOnPage(Locators.BOOK_ITEM_FIELD);
        isOnPage(Locators.SUBMIT_BUTTON);
    }

    public interface Locators {
        By BOOK_ITEM_FIELD = By.xpath("//label[contains(.,'Book item')]");
        By SUBMIT_BUTTON = By.xpath("//button[contains(.,'Submit')]");
    }
}
