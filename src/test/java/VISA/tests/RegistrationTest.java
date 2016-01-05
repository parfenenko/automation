package VISA.tests;

import VISA.pages.RegistrationPage;
import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rabota.pages.CompanyPage;
import rabota.pages.FindJobByCompanyPage;
import rabota.pages.RabotaUaHomePage;
import rabota.pages.SearchResultPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by payu on 12/18/2015.
 */
public class RegistrationTest extends BaseTest{

    //        Test data
    String first_name = "Юлія";
    String last_name = "Парфененко";
    String father_name = "Валеріївна";
    String phone_number = "380937749890";
    String email = "julyparfenenko@gmail.com";
    String date = "";
    String number = "";
    String amount = "";

    @BeforeTest
    public void openLoginPage() {
        openBrowser();
        openPage("https://www.visa-promotions.com/promotions/smallwinsua/contest.jsp");
    }

    @AfterTest
    public void finishTest() {
        closeBrowser();
    }

    @Test(priority = 1)
    public void fillTheSTaticFields() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.fillTheFields(first_name, last_name, father_name, phone_number, email);

    }
}
