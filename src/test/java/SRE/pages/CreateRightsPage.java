package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by payu on 1/11/2016.
 */
public class CreateRightsPage extends BasePage {

    public CreateRightsPage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "CreateRightsPage");
    }

    public void selectTypeOfRight(String typeOfRight) {
        $(Locators.TYPE_OF_RIGHTS).click();
        By LINK = (By.xpath(String.format(Locators.GENERAL_STRING, typeOfRight)));
        clickOn(LINK);
    }

    public void fillCompany(String companyName) {
        inputText(Locators.COMPANY_FROM, companyName);
    }

    public void selectTerritory(String territory) {
        $(Locators.TERRITORY).click();
        By LINK = (By.xpath(String.format(Locators.GENERAL_STRING, territory)));
        clickOn(LINK);
    }

    public void selectLanguage(String language) {
        $(Locators.LANGUAGE).click();
        By LINK = (By.xpath(String.format(Locators.GENERAL_STRING, language)));
        clickOn(LINK);
    }

    public void selectBroadcastingType(String broadcastingType) {
        $(Locators.BROADCASTING_TYPE).click();
        By LINK = (By.xpath(String.format(Locators.GENERAL_STRING, broadcastingType)));
        clickOn(LINK);
    }

    public void setStartLicenseDate(String startLicenseDate) {
        inputText(Locators.LICENSE_PERIOD_FROM, startLicenseDate);
    }

    public void setEndLicenseDate(String endLicenseDate) {
        inputText(Locators.LICENSE_PERIOD_TO, endLicenseDate);
    }

    public void setDeliveryDate(String deliveryDate) {
        inputText(Locators.DELIVERY_DATE, deliveryDate);
    }

    public void fillOrderNumbers(String orderNumber) {
        inputText(Locators.ORDER_NUMBER, orderNumber);
    }

    public CreateContentRecordConfirmationPage clickSaveButton() {
        waitUntilElementLoaded(Locators.SAVE_BUTTON, 5, "SAVE_BUTTON");
        $(Locators.SAVE_BUTTON).click();
        return new CreateContentRecordConfirmationPage();
    }

    public interface Locators {
        String GENERAL_STRING = "//option[contains(.,'%s')]";
        By PAGE_LOCATOR = By.xpath(".//*[@id='back-to-general-info']");
        By TYPE_OF_RIGHTS = By.xpath(".//*[@id='content_rights_0_state']");
        By ALL_RIGHTS_CHECKBOX = By.xpath(".//*[@id='content_rights_0_allRights']");
        By EXCLUSIVE_CHECKBOX = By.xpath(".//*[@id='content_rights_0_exclusive']");
        By COMPANY_FROM = By.xpath(".//*[@id='content_rights_0_companyName']");
        By TERRITORY = By.xpath(".//*[@id='select2-chosen-1']");
        By LANGUAGE = By.xpath(".//*[@id='select2-chosen-2']");
        By BROADCASTING_TYPE = By.xpath(".//*[@id='select2-chosen-3']");
        By UNLIMITED_RUNS_CHECKBOX = By.xpath(".//*[@id='content_rights_0_runsUnlimited']");
        By RUNS_AMOUNT = By.xpath(".//*[@id='content_rights_0_runs']");
        By LICENSE_PERIOD_FROM = By.xpath(".//*[@id='content_rights_0_dateStart']");
        By LICENSE_PERIOD_TO = By.xpath(".//*[@id='content_rights_0_dateEnd']");
        By DELIVERY_DATE = By.xpath(".//*[@id='content_rights_0_deliveryDate']");
        By ORDER_NUMBER = By.xpath(".//*[@id='content_rights_0_contractId']");
        By ADD_LINE_BUTTON = By.xpath("//span[contains(.,'Add line')]");
        By PREVIOUS_GENERAL_INFO_BUTTON = By.xpath(".//*[@id='back-to-general-info']");
        By SAVE_BUTTON = By.xpath(".//*[@id='content_create']");
    }
}
