package ImpartSocial.pages;

import framework.BasePage;
import framework.DriverManager;
import org.openqa.selenium.By;

/**
 * Created by j.parfenenko on 3/22/16.
 */
public class CoursePage extends BasePage {
    public CoursePage(){
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "CoursePage");
    }

    public void addToBasket(String firstName,
                            String lastName,
                            String jobTitle,
                            String mobilePhone,
                            String email,
                            String companyName) {
        inputText(Locators.FIRST_NAME, firstName);
        inputText(Locators.LAST_NAME, lastName);
        inputText(Locators.JOB_TITLE, jobTitle);
        inputText(Locators.PHONE_NUMBER, mobilePhone);
        inputText(Locators.EMAIL, email);
        inputText(Locators.COMPANY, companyName);
        clickOn(Locators.ADD_TO_BASKET_BUTTON);
        waitUntilElementLoaded(Locators.COUNT_OF_ITEMS_BASKET, 10, "COUNT_OF_ITEMS_BASKET");
    }

    public CheckoutPage proceedToCheckoutFromTheBasket() {
        clickOn(Locators.BASKET_ICON);
        waitUntilElementLoaded(Locators.TOTAL_BASKET, 5, "TOTAL_BASKET");
        clickOn(Locators.TOTAL_BASKET);
        return new CheckoutPage();
    }

    public CheckoutPage openCheckoutPage(String checkoutPageUrl) {
        DriverManager.getDriver().get(checkoutPageUrl);
        return new CheckoutPage();
    }

    public interface Locators{
        By PAGE_LOCATOR = By.cssSelector("#header-price");
        By FIRST_NAME = By.cssSelector("#basket_item_delegates_0_firstName");
        By LAST_NAME = By.cssSelector("#basket_item_delegates_0_lastName");
        By JOB_TITLE = By.cssSelector("#basket_item_delegates_0_jobTitle");
        By PHONE_NUMBER = By.cssSelector("#basket_item_delegates_0_phone");
        By EMAIL = By.cssSelector("#basket_item_delegates_0_email");
        By COMPANY = By.cssSelector("#basket_item_delegates_0_company");
        By ADD_TO_BASKET_BUTTON = By.xpath(".//*[@id='basket_item']/div[4]/button");
        By BASKET_ICON = By.cssSelector(".icon-basket");
        By TOTAL_BASKET = By.xpath(".//*[@id='js-basket-info-container']/a");
        By COUNT_OF_ITEMS_BASKET = By.cssSelector(".user-menu--counter.js-basket-count");
//        By FIRST_NAME = By.cssSelector("#basket_item_delegates_0_firstName");
//        By FIRST_NAME = By.cssSelector("#basket_item_delegates_0_firstName");

    }
}
