package ImpartSocial.tests;

import ImpartSocial.pages.*;
import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by j.parfenenko on 3/22/16.
 */
public class CreateOrderTest extends BaseTest{

    String firstName = "test order";
    String lastName = "test order";
    String jobTitle = "test order";
    String mobilePhone = "+777777777777";
    String email = "payu+iso@ciklum.com";
    String companyName = "test order";
    String basePageUrl = "http://impartsocial:ieJaig1quu@dev.impartsocial.pp.ciklum.com/";
    String checkoutPageUrl = "order/checkout";
    String cmsUrl = "admin/dashboard";
    String adminEmail = "payu+admin@ciklum.com";
    String adminPassword = "Qwerty123456";
    String country = "United Kingdom";
    String addressLine1 = "test order";
    String city = "test order";
    String state = "Angus";
    String postCode = "test order";
    String invoice = "Pay by invoice";
    String creditCard = "Pay by credit card";
    String PONumber = "test order";

    private CoursePage coursePage;
    private CheckoutPage checkoutPage;
    private ConfirmationPage confirmationPage;
    private CmsLoginPage cmsLoginPage;
    private PageService pageService;

    @BeforeTest
    public void openHomePage() {
        setChromeProperties();
        openBrowser();
        openPage(basePageUrl);
        pageService = new PageService();
    }

    @AfterTest
    public void finishTest() {
        closeBrowser();
    }

    @Test
    public void createOrderByInvoice(){
        HomePage homePage = new HomePage();
        coursePage = homePage.clickProceedToCoursePage();
        coursePage.addToBasket(firstName, lastName, jobTitle, mobilePhone, email, companyName);
        checkoutPage = coursePage.proceedToCheckoutFromTheBasket();
        checkoutPage.fillTheInformation(firstName, lastName, jobTitle, companyName, email, mobilePhone);
        checkoutPage.fillTheBillingAddress(country, addressLine1, city, state, postCode);
        checkoutPage.selectPaymentMethod(invoice);
        confirmationPage = checkoutPage.fillThePaymentDetailsByInvoice(PONumber, firstName+lastName, email);
        cmsLoginPage = pageService.openCmsLoginPage(basePageUrl+cmsUrl);
        cmsLoginPage.loginToCms(adminEmail, adminPassword);
////        Assert.assertTrue();
    }
}
