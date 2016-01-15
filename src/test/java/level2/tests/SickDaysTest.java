package level2.tests;

import framework.BaseTest;
import level2.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import level2.pages.MainPage;
import level2.pages.SickDaysAndVacationsPage;

import static org.testng.Assert.assertEquals;

/**
 * Created by payu on 7/15/2015.
 */
public class SickDaysTest extends BaseTest {

    //        Test data
    int currentCountOfTotalVacationsDays;
    int expectedCountOfTotalVacationsDays = 10;
    String login;
    String password;

    @BeforeTest
    public void openLoginPage() {
        openBrowser();
        openPage("http://level2.ciklum.net/index.php");
    }

    @AfterTest
    public void finishTest() {
        closeBrowser();
    }

    @Test(priority = 2, enabled = true)
    public void verifyAmountOfSickDaysByUser() {


//         Test steps
        LoginPage loginPage = new LoginPage();
        loginPage.login(login, password);
        MainPage mainPage = new MainPage();
        mainPage.navigateToPage("Sick Days & Vacations");
        SickDaysAndVacationsPage sickDaysAndVacationsPage = new SickDaysAndVacationsPage();
        sickDaysAndVacationsPage.selectUserByName("Yuliia Parfenenko");
        sickDaysAndVacationsPage.selectDate("2015-10-10");
        currentCountOfTotalVacationsDays = sickDaysAndVacationsPage.getCountOfTotalVacationsDays();
        assertEquals(currentCountOfTotalVacationsDays, expectedCountOfTotalVacationsDays, "Wrong expected vacations days number!");
    }
}
