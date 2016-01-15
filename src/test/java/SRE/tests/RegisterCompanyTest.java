package SRE.tests;

import SRE.pages.LoginPage;
import SRE.pages.RegistrationPage;
import SRE.pages.RegistrationSuccessfulPage;
import framework.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rabota.pages.SearchResultPage;

import static org.testng.Assert.assertEquals;

/**
 * Created by payu on 12/2/2015.
 */
public class RegisterCompanyTest extends BaseTest {

    private SearchResultPage searchResultPage;
    private RegistrationSuccessfulPage registrationSuccessfulPage;

    //        Test data
    String homePageUrl = "";
    String registrationPageUrl = "";
    String email = "payu+73@ciklum.com";
    String first_name = "73 test";
    String last_name = "test";
    String password = "";
    String company_name = "73 test company";
    String country = "Germany";
    String message = "Invalid username or password";

    @BeforeTest
    public void openLoginPage() {
        openBrowser();
        openPage(registrationPageUrl);
    }

    @AfterTest
    public void finishTest() {
        closeBrowser();
    }

    @Test(priority = 1, enabled = false)
    public void registerCompany() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationSuccessfulPage = registrationPage.createCompany(email, first_name, last_name, password, company_name, country);
    }

    @Test(priority = 2, enabled = true)
    public void tryToLoginByInactiveUser(){
        openPage(homePageUrl);
        LoginPage loginPage = new LoginPage();
        loginPage.tryToLogin(email, password);
        assertEquals(loginPage.getErrorMessage(), message);
    }
}
