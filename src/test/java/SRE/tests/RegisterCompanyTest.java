package SRE.tests;

import SRE.pages.*;
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
    private InboxGmailPage inboxGmailPage;
    private EmailPage emailPage;

    //        Test data
    String jemail = "";
    String jpassword = "";
    String homePageUrl = "";
    String registrationPageUrl = "";
    String gmailLogin = "https://mail.google.com";
    String email = "";
    String first_name = "74 test";
    String last_name = "test";
    String password = "";
    String company_name = "74 test company";
    String country = "Germany";
    String message = "Invalid username or password";
    String sender = "";

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

    @Test(priority = 2, enabled = false)
    public void tryToLoginByInactiveUser(){
        openPage(homePageUrl);
        LoginPage loginPage = new LoginPage();
        loginPage.tryToLogin(email, password);
        assertEquals(loginPage.getErrorMessage(), message);
    }

    @Test(priority = 3, enabled = true)
    public void activateUser(){
        openPage(gmailLogin);
        GmailHomePage gmailHomePage = new GmailHomePage();
        inboxGmailPage = gmailHomePage.login(jemail, jpassword);
        inboxGmailPage.searchEmailBySender(sender);
        emailPage = inboxGmailPage.openEmail();
        emailPage.proccedByLink();

    }
}
