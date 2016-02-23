package MR.tests;

import MR.pages.LandingPage;
import framework.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by payu on 2/23/2016.
 */
public class CreateLeadTest extends BaseTest{

    //        Test data
    String landingPage = "http://demorsp.mrlight.pp.ciklum.com/landing/1052";
    String firstName = "Test";
    String lastName = "Test";
    String email = "payu+lp1@ciklum.com";

    @BeforeTest
    public void openLandingPage() {
        setChromeProperties();
        openBrowser();
        openPage(landingPage);
    }

    @AfterTest
    public void finishTest() {
        closeBrowser();
    }

    @Test
    public void createSimpleCampaign(){
        LandingPage landingPage = new LandingPage();
        landingPage.fillForm(firstName, lastName, email);
    }
}
