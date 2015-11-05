package notus.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 10/28/2015.
 */
public class CheckoutPage extends BasePage {

    public CheckoutPage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "CheckoutPage");
    }

    public String getProductName() {
        String productName = $(Locators.PRODUCT_NAME).getText();
        return productName;
    }

    public interface Locators {
        By PAGE_LOCATOR = By.cssSelector(".my-order__title");
        By PRODUCT_NAME = By.cssSelector(".my-order__name");
    }
}
