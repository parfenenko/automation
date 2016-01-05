package rabota.pages;

import framework.BasePage;
import framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by payu on 11/5/2015.
 */
public class SearchResultPage extends BasePage {

    public SearchResultPage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "SearchResultPage");
    }

    public List<String> getVacancyTitles() {
        List<String> vacancyTitles = new ArrayList();
        List<WebElement> titlesList = $$(Locators.VACANCY_TITLES);
        for (WebElement title : titlesList) {
            vacancyTitles.add(title.getText());
        }
        return vacancyTitles;
    }

    public void selectLocation() {
        $(Locators.OPEN_DROPDOWN).click();
        waitUntilElementLoaded(Locators.DROPDOWN_OPEN, 5, "DROPDOWN_OPEN");

//       By LINK = (By.xpath(String.format(Locators.LOCATION_GENERAL, linkText)));
//       clickOn(LINK);

        $(Locators.LOCATION_KYIV).click();

//        if ($(Locators.DROPDOWN_OPEN).isDisplayed()) {
//            $(Locators.LOCATION_KYIV).click();
//        } else {
//            $(Locators.OPEN_DROPDOWN).click();
//        }

        $(RabotaUaHomePage.Locators.SEARCH_BUTTON).click();
    }

    public List<String> getVacancyLocations() {
        List<String> vacancyLocations = new ArrayList();
        List<WebElement> locationsList = $$(Locators.VACANCY_LOCATION);
        for (WebElement title : locationsList) {
            vacancyLocations.add(title.getText());
        }
        return vacancyLocations;
   }
    public FindJobByCompanyPage navigateToFindJobByCategory() {
        driver = DriverManager.getDriver();
        Actions action = new Actions(driver);
        action.moveToElement($(Locators.FIND_JOB_MENU)).build().perform();
        $(Locators.FIND_JOB_BY_COMPANY_LINK).click();
        return new FindJobByCompanyPage();
    }

    public interface Locators {
        By PAGE_LOCATOR = By.cssSelector(".vvt");
        By VACANCY_TITLES = By.className("t");
        String FIND_JOB_BY_GENERAL = "";
        String LOCATION_GENERAL = "//a[contains(.,'%s')]";
        By DROPDOWN_OPEN = By.xpath(".//div[@class='dropdown open']");
        By LOCATION_KYIV = By.xpath(".//*[@id='beforeContentZone_HorizontalContainer1_CityPickerWork_topLevelCities']/li[6]/a");
        By OPEN_DROPDOWN = By.cssSelector(".searchform .city-picker.uneditable-input");
        By VACANCY_LOCATION = By.xpath("//div[@class='s']");
        By FIND_JOB_MENU = By.xpath(".//*[@id='Header_header']/ul/li[2]/a");
        By FIND_JOB_BY_COMPANY_LINK = By.xpath("//a[contains(.,'По компаниям')]");
    }
}
