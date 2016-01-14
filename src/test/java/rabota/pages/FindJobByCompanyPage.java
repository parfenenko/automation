package rabota.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 11/5/2015.
 */
public class FindJobByCompanyPage extends BasePage {

    public FindJobByCompanyPage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "FindJobByCompanyPage");
    }

    public CompanyPage searchVacancyByCompanyName(String company) {
        inputText(Locators.SEARCH_BY_COMPANY_INPUT, company);
        clickOn(Locators.FIND_BUTTON);
        return new CompanyPage();
    }

    public interface Locators {
        By PAGE_LOCATOR = By.cssSelector(".headline.centered.rua-p-c-white.mtmb");
        By SEARCH_BY_COMPANY_INPUT = By.id("beforeContentZone_jobSearchVIPCompaniesSearch_txBxCompanyName");
        By FIND_BUTTON = By.id("beforeContentZone_jobSearchVIPCompaniesSearch_lnkBtnSearch");
    }
}