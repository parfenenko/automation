package rabota.tests;

import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rabota.pages.CompanyPage;
import rabota.pages.FindJobByCompanyPage;
import rabota.pages.RabotaUaHomePage;
import rabota.pages.SearchResultPage;
import static java.nio.charset.StandardCharsets.*;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by payu on 11/5/2015.
 */
public class RabotaUaSearchTest extends BaseTest {

    private SearchResultPage searchResultPage;
    private FindJobByCompanyPage findJobByCompanyPage;
    private CompanyPage companyPage;

    //        Test data
    String keyword = "automation";
    String location = "Киев";
    String category = "По компаниям";
    String company = "Ciklum";
    String categoryName = "Телекоммуникации - Связь";
    int actualCountOfVacancies = 2;

    //        Encoding
//    byte[] locationByte = location.getBytes(UTF_8);
//    String locationConverted = new String(locationByte, UTF_8);

        @BeforeTest
        public void openLoginPage() {
            openBrowser();
        openPage("http://rabota.ua/");
    }

    @AfterTest
    public void finishTest() {
        closeBrowser();
    }

    @Test(priority = 1)
    public void searchAutomationVacancies() {
        RabotaUaHomePage rabotaUaHomePage = new RabotaUaHomePage();
        searchResultPage = rabotaUaHomePage.findVacancyByKeyword(keyword);
        List<String> searhResultListTitles = searchResultPage.getVacancyTitles();

        for (String item : searhResultListTitles) {
            assertTrue(item.toLowerCase().contains(keyword));
        }
    }

    @Test(priority = 2)
    public void searchAutomationVacanciesInKyiv() {
        searchResultPage.selectLocation();
        List<String> searhResultListLocations = searchResultPage.getVacancyLocations();
        for (String item : searhResultListLocations){
            Assert.assertTrue(item.contains(location));
        }
    }

    @Test(priority = 3)
    public void searchVacancyByCompany(){
        findJobByCompanyPage = searchResultPage.navigateToFindJobByCategory();
        companyPage = findJobByCompanyPage.searchVacancyByCompanyName(company);
        Assert.assertTrue(companyPage.getPageTitle().contains(company));
    }

    @Test(priority = 4)
    public void searchVacancyByCategory(){
        companyPage.selectCategoryByName(categoryName);
        assertEquals(companyPage.getCountOfVacancies(), actualCountOfVacancies);
    }

    @Test(priority = 5)
    public void searchVacancyByCategoryInKyiv(){
        companyPage.selectLocation(location);
        List<String> searhResultListLocations = companyPage.getVacancyLocations();

        for (String item : searhResultListLocations){
            assertEquals(item, location);
        }
    }
}
