package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by j.parfenenko on 1/6/16.
 */
public class CreateContentRecordPage extends BasePage{

    public void selectTypeByName(String linkText) {
        $(Locators.TYPE_DROPDOWN).click();
        By LINK = (By.xpath(String.format(Locators.TYPE_GENERAL, linkText)));
        clickOn(LINK);
    }

    public interface Locators{
        By PAGE_LOCATOR = By.xpath("");
        By TYPE_DROPDOWN = By.xpath(".//*[@id='select2-chosen-1']");
        String TYPE_GENERAL = "//option[contains(.,'%s')]";
    }
}
