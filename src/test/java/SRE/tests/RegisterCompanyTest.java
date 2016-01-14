package SRE.tests;

import SRE.pages.RegistrationPage;
import SRE.pages.RegistrationSuccessfulPage;
import framework.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rabota.pages.SearchResultPage;

/**
 * Created by payu on 12/2/2015.
 */
public class RegisterCompanyTest extends BaseTest {

    private SearchResultPage searchResultPage;
    private RegistrationSuccessfulPage registrationSuccessfulPage;

    //        Test data
    String registrationPageUrl = "http://dev.sr.pp.ciklum.com/registration/";
    String email = "payu+59@ciklum.com";
    String first_name = "59 test";
    String last_name = "test";
    String password = "Qwerty123456";
    String company_name = "59 test company";
    String country = "Germany";

    @BeforeTest
    public void openLoginPage() {
        openBrowser();
        openPage(registrationPageUrl);
    }

    @AfterTest
    public void finishTest() {
        closeBrowser();
    }

    @Test
    public void registerCompany() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationSuccessfulPage = registrationPage.createCompany(email, first_name, last_name, password, company_name, country);
    }
}
