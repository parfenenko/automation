package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by j.parfenenko on 1/6/16.
 */
public class DistributionPage extends BasePage{

    public CreateContentRecordPage clickCreateContentRecord() {
        $(Locators.CREATE_NEW_CONTENT_RECORD_BUTTON).click();
//        waitUntilElementLoaded(Locators.PAGE_LOCATOR, 10, "CR");
//        isOnPage(Locators.PAGE_LOCATOR);
        return new CreateContentRecordPage();
    }

    public interface Locators{
        By PAGE_LOCATOR = By.xpath("//h1[contains(.,'Create Content Record')]");
        By CREATE_NEW_CONTENT_RECORD_BUTTON = By.xpath("//span[@class='icon icon-round icon-create_new_cr']");
    }
}
