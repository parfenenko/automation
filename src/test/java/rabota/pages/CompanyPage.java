package rabota.pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.nio.charset.StandardCharsets.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by payu on 11/5/2015.
 */
public class CompanyPage extends BasePage {

    public CompanyPage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "CompanyPage");
    }

    public String getPageTitle() {
        String pageTitle = $(Locators.PAGE_TITLE).getText();
        return pageTitle;
    }

    public void selectCategoryByName(String linkText) {
        clickOn(Locators.CATEGORY_DROPDOWN);
        By LINK = (By.xpath(String.format(Locators.CATEGORY_GENERAL, linkText)));
        clickOn(LINK);
    }

    public int getCountOfVacancies() {
        int vacancyCount = $$(Locators.VACANCY).size();
        return vacancyCount;
    }

    public void selectLocation(String linkText) {
        clickOn(Locators.LOCATION_DROPDOWN);
        By LINK = (By.xpath(String.format(Locators.LOCATION_GENERAL, linkText)));
        clickOn(LINK);
    }

    public List<String> getVacancyLocations() {
        List<String> vacancyLocations = new ArrayList<String>();
        List<WebElement> locationList = $$(Locators.VACANCY_LOCATION);
        for (WebElement location : locationList) {
            vacancyLocations.add(location.getText().substring(0, 4));
        }
        return vacancyLocations;
    }

/*    public List<String> getVacancyLocations() {
        List<String> vacancyLocations = new ArrayList<String>();
        List<byte[]> vacancyLocationsBytes = new ArrayList<byte[]>();
        List<WebElement> locationList = $$(Locators.VACANCY_LOCATION);
        for (WebElement location : locationList) {
            vacancyLocationsBytes.add(location.getText().substring(0, 4).getBytes(UTF_8));
        }

        for (byte location : vacancyLocationsBytes) {
            List<String> locations;
            locations = new ArrayList<String>(vacancyLocationsBytes, UTF_8);
        }

        return vacancyLocations;
    }*/

    public interface Locators {
        By PAGE_LOCATOR = By.cssSelector("#centerZone_lnkBack");
        By PAGE_TITLE = By.xpath("//h2");
        By CATEGORY_DROPDOWN = By.id("centerZone_centerZone_CompanyInfoCenterAreaSwitcher1_ctl00_ctl00_CompanyListFilter1_ddlRubric");
        By LOCATION_DROPDOWN = By.xpath(".//*[@id='centerZone_centerZone_CompanyInfoCenterAreaSwitcher1_ctl00_ctl00_CompanyListFilter1_ddlCity']");
        String CATEGORY_GENERAL = "//option[contains(.,'%s')]";
        String LOCATION_GENERAL = "//option[contains(.,'%s')]";
        By VACANCY = By.cssSelector(".comvac_list .compvac_holder");
        By VACANCY_LOCATION = By.xpath("//div[@class='compvac_info']");
    }
}
