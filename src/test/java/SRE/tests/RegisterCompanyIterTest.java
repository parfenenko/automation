package SRE.tests;

import SRE.pages.RegistrationPage;
import SRE.pages.RegistrationSuccessfulPage;
import framework.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rabota.pages.SearchResultPage;

/**
 * Created by payu on 12/3/2015.
 */
public class RegisterCompanyIterTest extends BaseTest{

private SearchResultPage searchResultPage;
private RegistrationSuccessfulPage registrationSuccessfulPage;

    //        Test data
    String email;
    String first_name = "11 test";
    String last_name = "test";
    String password = "Qwerty123456";
    String company_name = "11 test company";
    String country = "Germany";

    @BeforeTest
    public void openLoginPage() {
        openBrowser();
        openPage("http://dev.sr.pp.ciklum.com/registration/");
    }

    @AfterTest
    public void finishTest() {
        closeBrowser();
    }

    @Test
    public void registerCompany() {
        RegistrationPage registrationPage = new RegistrationPage();

        for (int i=15; i < 100; i++)
            email = String.format("payu+%d@ciklum.com", i);
        registrationSuccessfulPage = registrationPage.createCompany(email, first_name, last_name, password, company_name, country);
    }
}
