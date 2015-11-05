package level2.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 7/29/2015.
 */
public class SickDaysAndVacationsPage extends BasePage {

    public SickDaysAndVacationsPage(){
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "SickDaysAndVacationsPage");
    }

    public void selectUserByName(String linkText) {
        By LINK = (By.xpath(String.format(Locators.GENERAL_LINK_USER_NAVIGATE_XPATH, linkText)));
        $(LINK).click();
    }

    public int getCountOfTotalVacationsDays() {
        int count_of_vacation_days_allowed_to_take = Integer.parseInt($(Locators.COUNT_OF_TOTAL_VACATION_DAYS).getText());
        return count_of_vacation_days_allowed_to_take;
    }

    public void selectDate(String date) {
        inputText(Locators.END_DATE, date);
        $(Locators.SHOW_BUTTON).click();
    }

    public interface Locators {
        String GENERAL_LINK_USER_NAVIGATE_XPATH = "//a[contains(.,'%s')]";
        By COUNT_OF_TOTAL_VACATION_DAYS = By.xpath("//table[contains(@class, 'employeeData')]/tbody/tr[43]/td[3]");
        By END_DATE = By.xpath("//input[contains(@name,'end_date')]");
        By SHOW_BUTTON = By.xpath("//input[@value='Show']");
        By PAGE_LOCATOR = By.xpath("//h1[contains(.,'Sick Days and Vacations')]");
    }
}