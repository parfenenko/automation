package SRE.tests;

import SRE.pages.LoginPage;
import framework.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by j.parfenenko on 1/5/16.
 */
public class CreateContentRecordTest extends BaseTest{

    //        Test data
    String login = "";
    String password = "";

    @BeforeTest
    public void openLoginPage() {
        openBrowser();
        openPage("");
    }

    @AfterTest
    public void finishTest() {
        closeBrowser();
    }

    @Test
    public void createContentRecord(){
        LoginPage loginPage = new LoginPage();
        loginPage.login(login, password);
    }

}