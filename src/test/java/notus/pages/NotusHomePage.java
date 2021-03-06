package notus.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 9/24/2015.
 */
public class NotusHomePage extends BasePage {

    public NotusHomePage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "NotusHomePage");
    }

    public SubCategoryPage selectSubCatergoryByName(String linktext) {
        By LINK = (By.xpath(String.format(Locators.GENERAL_LINK_NAVIGATE_TO_SUBCATEGORY_XPATH, linktext)));
        clickOn(LINK);
        return new SubCategoryPage();
    }

    public interface Locators {
        By PAGE_LOCATOR = By.className("header");
        String GENERAL_LINK_NAVIGATE_TO_SUBCATEGORY_XPATH = "//div[@class='share2']/a[contains(@href, '%s')]";
    }
}