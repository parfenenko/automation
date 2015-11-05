package rabota.tests;

import framework.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rabota.LoginPage;
import rabota.MainPage;
import rabota.NewBookingPage;
import rabota.RoomBookingPage;


/**
 * Created by payu on 9/3/2015.
 */
public class RoomBookingTest extends BaseTest {

    //        Test data

    @BeforeTest
    public void openLoginPage() {
        openBrowser();
        openPage("http://level2.ciklum.net/index.php");
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
