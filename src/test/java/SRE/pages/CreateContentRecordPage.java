package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by j.parfenenko on 1/6/16.
 */
public class CreateContentRecordPage extends BasePage {

    public CreateContentRecordPage() {
        waitPageLoaded(Locators.PAGE_LOCATOR, 5, "CreateContentRecordPage");
    }

    public void selectTypeByName(String contentRecordType) {
        clickOn(Locators.TYPE_DROPDOWN);
        By LINK = (By.xpath(String.format(Locators.GENERAL_STRING, contentRecordType)));
        clickOn(LINK);
    }

    public void fillTitle(String title) {
        inputText(Locators.TITLE, title);
    }

    public void fillYear(String year) {
        inputText(Locators.YEAR, year);
    }

    public void selectCountry(String country) {
        clickOn(Locators.COUNTRY_DROPDOWN);
        By LINK = (By.xpath(String.format(Locators.GENERAL_STRING, country)));
        clickOn(LINK);
    }

    public void selectLanguage(String language) {
        clickOn(Locators.LANGUAGE_DROPDOWN);
        By LINK = (By.xpath(String.format(Locators.GENERAL_STRING, language)));
        clickOn(LINK);
    }

    public void fillProducer(String producer) {
        inputText(Locators.PRODUCER, producer);
    }

    public void fillDirector(String director) {

       inputText(Locators.DIRECTOR, director);
    }

    public void selectFormat(String format) {
        clickOn(Locators.FORMAT_DROPDOWN);
        By LINK = (By.xpath(String.format(Locators.GENERAL_STRING, format)));
        clickOn(LINK);
    }

    public void selectGenres(String[] genres) {
        for (int i = 0; i < genres.length; i++) {
            clickOn(Locators.GENRES_DROPDOWN);
            By LINK = (By.xpath(String.format(Locators.GENERAL_STRING, genres[i])));
            clickOn(LINK);
        }
    }

    public void fillTags(String[] tags) {
        for (int i = 0; i < tags.length; i++) {
            waitUntilElementLoaded(Locators.TAGS, 5, "TAGS");
            $(Locators.TAGS).sendKeys(tags[i]);
        }
    }

    public void fillSynopsis(String synopsis) {
        inputText(Locators.SYNOPSIS, synopsis);
    }

    public void fillCast(String cast) {
        inputText(Locators.CAST, cast);
    }

    public CreateContentRecordConfirmationDialogPage clickSaveAndExit() {
        clickOn(Locators.SAVE_AND_EXIT_BUTTON);
        return new CreateContentRecordConfirmationDialogPage();
    }

    public CreateRightsPage clickNextRights() {
        clickOn(Locators.NEXT_RIGHTS_BUTTON);
        return new CreateRightsPage();
    }

    public interface Locators {
        String GENERAL_STRING = "//option[contains(.,'%s')]";
        By PAGE_LOCATOR = By.xpath("//h1[contains(.,'Create Content Record')]");
        By TYPE_DROPDOWN = By.xpath(".//*[@id='select2-chosen-1']");
        By TITLE = By.xpath(".//*[@id='content_name']");
        By YEAR = By.xpath(".//*[@id='content_year']");
        By COUNTRY_DROPDOWN = By.xpath(".//*[@id='select2-chosen-2']");
        By LANGUAGE_DROPDOWN = By.xpath(".//*[@id='select2-chosen-3']");
        By PRODUCER = By.xpath(".//*[@id='content_producer']");
        By DIRECTOR = By.xpath(".//*[@id='content_director']");
        By FORMAT_DROPDOWN = By.xpath(".//*[@id='select2-chosen-4']");
        By GENRES_DROPDOWN = By.xpath(".//*[@id='s2id_content_genres']/ul");
        By TAGS = By.cssSelector(".ui-widget-content.ui-autocomplete-input");
        By SYNOPSIS = By.xpath(".//*[@id='content_description']");
        By CAST = By.xpath(".//*[@id='content_cast']");
        By SAVE_AND_EXIT_BUTTON = By.xpath(".//*[@id='content_save']");
        By NEXT_RIGHTS_BUTTON = By.xpath(".//*[@id='content_next']");
    }
}
