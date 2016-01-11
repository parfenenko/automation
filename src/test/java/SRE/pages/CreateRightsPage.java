package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 1/11/2016.
 */
public class CreateRightsPage extends BasePage {

    public CreateRightsPage(){
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "CreateRightsPage");}

    public interface Locators{
        By PAGE_LOCATOR = By.xpath(".//*[@id='back-to-general-info']");
    }
}
