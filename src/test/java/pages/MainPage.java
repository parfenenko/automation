package pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by payu on 7/15/2015.
 */
public class MainPage extends BasePage{

    public void navigateToPage(String linkText){
        By LINK = (By.xpath(String.format(Locators.GENERAL_LINK_DIRECTORY_NAVIGATE_XPATH, linkText)));
        clickOn(LINK);
    }

    public interface Locators{
        String GENERAL_LINK_DIRECTORY_NAVIGATE_XPATH = "//span[@class='ui-button-text'][text()='%s']";
    }
}
