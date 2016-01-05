package rabota.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 11/5/2015.
 */
public class RabotaUaHomePage extends BasePage{

    public RabotaUaHomePage(){
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "RabotaUaHomePage");
    }

    public SearchResultPage findVacancyByKeyword(String locator) {
        $(Locators.SEARCH_ENTRY).sendKeys(locator);
        $(Locators.SEARCH_BUTTON).click();
        return new SearchResultPage();
    }

    public interface Locators{
        By PAGE_LOCATOR = By.id("beforeContentZone_vacSearch_pnlsearch");
        By SEARCH_ENTRY = By.id("beforeContentZone_vacSearch_Keyword");
        By SEARCH_BUTTON = By.cssSelector(".searchform .btn.btn-primary.submit_button");
    }
}
