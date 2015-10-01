package tests;

import framework.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * Created by payu on 9/4/2015.
 */
public class LoginTest extends BaseTest {

    //        Test data
        @DataProvider
    private static final Object[][] loginData() {
        return new Object[][]{
                {"payu", "Qwerty12345"}};
    }

    @BeforeTest
    public void openLoginPage() {
        openBrowser();
        openPage("http://level2.ciklum.net/index.php");
    }

    @AfterTest
    public void finishTest() {
        closeBrowser();
    }

    @Test(dataProvider = "loginData")
    public void loginFormValidation(String login, String password) {


//         Test steps
        LoginPage loginPage = new LoginPage();
        loginPage.login(login, password);
    }
}
