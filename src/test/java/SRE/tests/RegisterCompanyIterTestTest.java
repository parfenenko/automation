package SRE.tests;

import SRE.pages.RegistrationPage;
import SRE.pages.RegistrationSuccessfulPage;
import com.opencsv.CSVReader;
import framework.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rabota.pages.SearchResultPage;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by payu on 12/3/2015.
 */
public class RegisterCompanyIterTestTest extends BaseTest {

    private SearchResultPage searchResultPage;
    private RegistrationSuccessfulPage registrationSuccessfulPage;

    String registrationPageUrl = "";
    String csvPath = "D:\\j.parfenenko\\Automation\\automation\\src\\test\\TestData\\RegisterCompanyIterTestData.csv";

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
    public void registerCompany() throws IOException {
        CSVReader reader = new CSVReader(new FileReader(csvPath));
        String[] csvCell;
        while ((csvCell = reader.readNext()) != null) {
            String email = csvCell[0];
            String first_name = csvCell[1];
            String last_name = csvCell[2];
            String password = csvCell[3];
            String company_name = csvCell[4];
            String country = csvCell[5];

            RegistrationPage registrationPage = new RegistrationPage();

//            for (int i = 15; i < 100; i++)
//                email = String.format("payu+%d@ciklum.com", i);
            registrationSuccessfulPage = registrationPage.createCompany(email, first_name, last_name, password, company_name, country);
        }
    }
}
