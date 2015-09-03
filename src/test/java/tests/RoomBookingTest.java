package tests;

import framework.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.NewBookingPage;
import pages.RoomBookingPage;

import static org.testng.Assert.assertEquals;

/**
 * Created by payu on 9/3/2015.
 */
public class RoomBookingTest extends BaseTest {

    //        Test data
    String login = "payu";
    String password = "Qwerty12345";

    @BeforeTest
    public void openLoginPage() {
        openBrowser();
        open("http://level2.ciklum.net/index.php");
    }

    @AfterTest
    public void finishTest() {
        closeBrowser();
    }

    @Test
    public void verifyCalendar() {


//         Test steps
        LoginPage loginPage = new LoginPage();
        loginPage.login(login, password);
        MainPage mainPage = new MainPage();
        mainPage.navigateToPage("Room Booking");
        RoomBookingPage roomBookingPage = new RoomBookingPage();
        roomBookingPage.openNewBookingWindow();
        NewBookingPage newBookingPage = new NewBookingPage();
        newBookingPage.verifyPopup();
    }
}
