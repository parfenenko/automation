package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 1/18/2016.
 */
public class EmailPage extends BasePage{

    public EmailPage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "PAGE_LOCATOR");
    }

    public void proccedByLink() {
        clickOn(Locators.LINK);
    }

    public interface Locators{
        By PAGE_LOCATOR = By.cssSelector(".gD");
        By LINK = By.linkText("confirm");
    }
}
