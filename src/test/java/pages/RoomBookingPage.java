package pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 8/5/2015.
 */
public class RoomBookingPage extends BasePage {

    public void openNewBookingWindow() {
        clickOn(Locators.NEW_BOOKING_BUTTON);
    }

    public interface Locators{
        By NEW_BOOKING_BUTTON = By.xpath("//a[contains(.,'New Booking')]");
    }
}
