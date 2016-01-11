package SRE.tests;

import SRE.pages.CreateContentRecordPage;
import SRE.pages.DistributionPage;
import SRE.pages.LoginPage;
import framework.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by j.parfenenko on 1/5/16.
 */
public class CreateContentRecordTest extends BaseTest{

    private DistributionPage distributionPage;
    private CreateContentRecordPage createContentRecordPage;

    //        Test data
    String login = "payu+1@ciklum.com";
    String password = "Qwerty123456";
    String contentRecordType = "Short Film";

    @BeforeTest
    public void openLoginPage() {
        openBrowser();
        openPage("http://dev.sr.pp.ciklum.com/");
    }

    @AfterTest
    public void finishTest() {
        closeBrowser();
    }

    @Test
    public void createContentRecord(){
        LoginPage loginPage = new LoginPage();
        distributionPage = loginPage.login(login, password);
        createContentRecordPage = distributionPage.clickCreateContentRecord();
        createContentRecordPage.selectTypeByName(contentRecordType);
    }

}
