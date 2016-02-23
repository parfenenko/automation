package MR.tests;

import MR.pages.DashboardPage;
import MR.pages.LoginPage;
import framework.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by j.parfenenko on 2/19/16.
 */
public class CreateCampaignTest extends BaseTest{

    private DashboardPage dashboardPage;
//    private MyCampaignsPage myCampaignsPage;

    //        Test data
    String homePageUrlProd = "https://mr.solidmediagroup.com/";
    String homePageUrlDemo = "http://demo.mrlight.pp.ciklum.com/";
    String login = "payu+prod1@ciklum.com";
    String password = "Qwerty123456";
    String myCampaingsUrl = "/campaign/list";

    @BeforeTest
    public void openLoginPage() {
        openBrowser();
        openPage(homePageUrlProd);
    }

    @AfterTest
    public void finishTest() {
        closeBrowser();
    }

    @Test
    public void createSimpleCampaign(){
        LoginPage loginPage = new LoginPage();
        dashboardPage = loginPage.login(login, password);
//        myCampaignsPage = dashboardPage.navigateTo(myCampaingsUrl);
//        myCampaignsPage.openCreateMyCampaignsPage();


    }
}
