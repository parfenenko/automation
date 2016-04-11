package ImpartSocial.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by j.parfenenko on 3/22/16.
 */
public class CheckoutPage extends BasePage {

    public CheckoutPage(){
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "CheckoutPage");
    }

    public void fillTheInformation(String firstName,
                                   String lastName,
                                   String jobTitle,
                                   String companyName,
                                   String email,
                                   String mobilePhone) {
        inputText(Locators.FIRST_NAME, firstName);
        inputText(Locators.LAST_NAME, firstName);
        inputText(Locators.JOB_TITLE, jobTitle);
        inputText(Locators.COMPANY, companyName);
        inputText(Locators.EMAIL, email);
        inputText(Locators.PHONE, mobilePhone);
    }

    public void fillTheBillingAddress(String country,
                                      String addressLine1,
                                      String city,
                                      String state,
                                      String postCode) {
        clickOn(Locators.COUNTRY_DROPDOWN);
        By LINK_COUNTRY = (By.xpath(String.format(Locators.GENERAL_STATE_STRING, country)));
        clickOn(LINK_COUNTRY);

        inputText(Locators.ADDRESS_LINE_1, addressLine1);
        inputText(Locators.CITY, city);

        clickOn(Locators.STATE_DROPDOWN);
        By LINK_STATE = (By.xpath(String.format(Locators.GENERAL_STATE_STRING, state)));
        clickOn(LINK_STATE);

        inputText(Locators.POST_CODE, postCode);
    }

    public void selectPaymentMethod(String invoice) {
        By LINK = (By.xpath(String.format(Locators.PAYMENT_METHOD, invoice)));
        clickOn(LINK);
    }

    public ConfirmationPage fillThePaymentDetailsByInvoice(String POnumber,
                                                           String name,
                                                           String email) {
        inputText(Locators.PO_NUMBER, POnumber);
        inputText(Locators.FINANCE_CONTACT_NAME, name);
        inputText(Locators.FINANCE_CONTACT_EMAIL, email);
        clickOn(Locators.MAKE_PAYMENT_BUTTON);
        return new ConfirmationPage();
    }

    public interface Locators{
        By PAGE_LOCATOR = By.cssSelector(".total-price");
        By ONE_OF_DELEGATE_CHECKBOX = By.cssSelector(".middle>label");
        By FIRST_NAME = By.cssSelector("#checkout_info_customer_firstName");
        By LAST_NAME = By.cssSelector("#checkout_info_customer_lastName");
        By JOB_TITLE = By.cssSelector("#checkout_info_customer_jobTitle");
        By COMPANY = By.cssSelector("#checkout_info_customer_company");
        By EMAIL = By.cssSelector("#checkout_info_customer_email");
        By PHONE = By.cssSelector("#checkout_info_customer_phone");
        By ADDRESS_LINE_1 = By.cssSelector("#checkout_info_billingAddress_address1");
        By CITY = By.cssSelector("#checkout_info_billingAddress_city");
        By STATE_DROPDOWN = By.cssSelector("#select2-checkout_info_billingAddress_state-container");
        By POST_CODE = By.cssSelector("#checkout_info_billingAddress_zipCode");
        String PAYMENT_METHOD = "//label[contains(.,'%s')]";
        By COUNTRY_DROPDOWN = By.xpath(".//*[@id='select2-checkout_info_billingAddress_country-container']");
        String GENERAL_STATE_STRING = "//option[contains(.,'%s')]";
        By PO_NUMBER = By.cssSelector("#checkout_info_payment_info_poNumber");
        By FINANCE_CONTACT_NAME = By.cssSelector("#checkout_info_payment_info_contactName");
        By FINANCE_CONTACT_EMAIL = By.cssSelector("#checkout_info_payment_info_emailAddress");
        By MAKE_PAYMENT_BUTTON = By.cssSelector(".button--payment.submit-btn");
    }
}
