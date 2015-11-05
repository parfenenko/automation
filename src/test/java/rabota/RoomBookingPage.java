package rabota;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 8/5/2015.
 */
public class RoomBookingPage extends BasePage {

    public RoomBookingPage(){
        waitPageLoaded(Locators.PAGE_LOCATOR, 10, "RoomBookingPage");
    }

    public void openNewBookingWindow() {
        waitUntilElementLoaded(Locators.NEW_BOOKING_BUTTON, 5, "NEW_BOOKING_BUTTON");
        clickOn(Locators.NEW_BOOKING_BUTTON);
    }

    public interface Locators{
        By NEW_BOOKING_BUTTON = By.xpath("//a[contains(.,'New Booking')]");
        By PAGE_LOCATOR = By.xpath("//span[contains(.,'   Room and Inventory Booking ')]");
    }
}
