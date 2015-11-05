package notus.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 10/28/2015.
 */
public class PreviewCartPage extends BasePage {

    public PreviewCartPage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "PreviewCartPage");
    }

    public String getProductName() {
        String productName = $(Locators.PRODUCT_NAME).getText();
        return productName;
    }

    public CheckoutPage submitOrderButton() {
        $(Locators.ORDER_BUTTON).click();
        return new CheckoutPage();
    }

    public interface Locators {
        By PAGE_LOCATOR = By.className("product_checksumm_title");
        By PRODUCT_NAME = By.xpath("//*[@class='cart_product_row']/a");
        By ORDER_BUTTON = By.xpath(".//*[@id='sc_form']/div[3]/a/span");
    }
}
