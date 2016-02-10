package ImpartSocial.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 12/18/2015.
 */
public class HomePage extends BasePage {

    public HomePage(){
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "HomePage");
    }

    public void sendRequestForBespokeCourse(String clientName, String phoneNumber, String companyName, String email){
        inputText(Locators.NAME, clientName);
        inputText(Locators.PHONE_NUMBER, phoneNumber);
        inputText(Locators.COMPANY, companyName);
        inputText(Locators.EMAIL, email);
        clickOn(Locators.SUBMIT_REQUEST_BUTTON);
    }

    public interface Locators {
        By PAGE_LOCATOR = By.cssSelector(".title--main");
        By NAME = By.xpath("//input[@placeholder='Name']");
        By PHONE_NUMBER = By.xpath("//input[@placeholder='Phone number']");
        By COMPANY = By.xpath("//input[contains(@placeholder,'Company')]");
        By EMAIL = By.xpath("//input[@placeholder='Email address']");
        By SUBMIT_REQUEST_BUTTON = By.xpath("//button[contains(.,'Find out more')]");
    }
}
