package MR.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 2/23/2016.
 */
public class MyCampaignsPage extends BasePage {

    public void navigateToCreateNewCampaignPage(){
        clickOn(Locators.CREATE_NEW_CAMPAIGN);
    }

    public interface Locators{
        By CREATE_NEW_CAMPAIGN = By.xpath("//button[contains(.,'Create new Campaign')]");
    }
}
