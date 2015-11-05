package rabota;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 9/3/2015.
 */
public class NewBookingPage extends BasePage {

    public NewBookingPage(){
        waitPageLoaded(Locators.NEW_BOOKING_PAGE_LOCATOR, 5, "NewBookingPage");
    }

    public void verifyPopup() {
        isOnPage(Locators.BOOK_ITEM_FIELD);
        isOnPage(Locators.SUBMIT_BUTTON);
    }

    public interface Locators {
        By BOOK_ITEM_FIELD = By.xpath("//label[contains(.,'Book item')]");
        By SUBMIT_BUTTON = By.xpath("//button[contains(.,'Submit')]");
        By NEW_BOOKING_PAGE_LOCATOR = By.xpath("//label[contains(.,'Date')]");
    }
}
