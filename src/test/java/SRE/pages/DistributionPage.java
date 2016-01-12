package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;

import static framework.DriverManager.getDriver;

/**
 * Created by j.parfenenko on 1/6/16.
 */
public class DistributionPage extends BasePage {

    public DistributionPage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "DistributionPage");
    }

    public CreateContentRecordPage clickCreateContentRecord() {
        waitUntilElementLoaded(Locators.CREATE_NEW_CONTENT_RECORD_BUTTON, 5, "CREATE_NEW_CONTENT_RECORD_BUTTON");
        $(Locators.CREATE_NEW_CONTENT_RECORD_BUTTON).click();
//        getDriver().findElement(By.xpath("//span[@class='icon icon-round icon-create_new_cr']")).click();
        return new CreateContentRecordPage();
    }

    public interface Locators {
        By PAGE_LOCATOR = By.xpath("//h4[contains(@class,'top-counter')]");
        By CREATE_NEW_CONTENT_RECORD_BUTTON = By.xpath("//span[@class='icon icon-round icon-create_new_cr']");
    }
}
