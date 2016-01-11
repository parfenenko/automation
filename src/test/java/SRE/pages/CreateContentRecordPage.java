package SRE.pages;

import framework.BasePage;
import org.openqa.selenium.By;

/**
 * Created by j.parfenenko on 1/6/16.
 */
public class CreateContentRecordPage extends BasePage{

    public CreateContentRecordPage() {waitPageLoaded(Locators.PAGE_LOCATOR, 5, "CreateContentRecordPage");}

    public void selectTypeByName(String linkText) {
        $(Locators.TYPE_DROPDOWN).click();
        By LINK = (By.xpath(String.format(Locators.TYPE_GENERAL, linkText)));
        clickOn(LINK);
    }

    public void fillTitle(String title) {
        $(Locators.TITLE).sendKeys(title);
    }

    public void fillYear(String  year) {
        $(Locators.YEAR).sendKeys(year);
    }

    public void selectCountry(String country) {
        $(Locators.COUNTRY_DROPDOWN).click();
        By LINK = (By.xpath(String.format(Locators.TYPE_GENERAL, country)));
        clickOn(LINK);
    }

    public void selectLanguage(String language) {
        $(Locators.LANGUAGE_DROPDOWN).click();
        By LINK = (By.xpath(String.format(Locators.TYPE_GENERAL, language)));
        clickOn(LINK);
    }

    public void fillProducer(String producer) {
        $(Locators.PRODUCER).sendKeys(producer);
    }

    public void fillDirector(String director) {
        $(Locators.DIRECTOR).sendKeys(director);
    }

    public void selectFormat(String format) {
        $(Locators.FORMAT_DROPDOWN).click();
        By LINK = (By.xpath(String.format(Locators.TYPE_GENERAL, format)));
        clickOn(LINK);}

    public void selectGenres(String[] genres) {
        for (int i = 0; i < genres.length; i++){
        $(Locators.GENRES_DROPDOWN).click();
        By LINK = (By.xpath(String.format(Locators.TYPE_GENERAL, genres[i])));
        clickOn(LINK);}
    }

    public void fillTags(String[] tags){
        for (int i=0; i< tags.length; i++){
            waitUntilElementLoaded(Locators.TAGS, 5, "TAGS");
            $(Locators.TAGS).sendKeys(tags[i]);
        }
    }

    public void fillSynopsis(String synopsis) {
        $(Locators.SYNOPSIS).sendKeys(synopsis);
    }

    public void fillCast(String cast) {
        $(Locators.CAST).sendKeys(cast);
    }

    public CreateContentRecordConfirmationPage clickSaveAndExit() {
        $(Locators.SAVE_AND_EXIT_BUTTON).click();
        return new CreateContentRecordConfirmationPage();
    }

    public CreateRightsPage clickNextRights() {
        $(Locators.NEXT_RIGHTS_BUTTON).click();
        return new CreateRightsPage();
    }

    public interface Locators{
        By PAGE_LOCATOR = By.xpath("//h1[contains(.,'Create Content Record')]");
        By TYPE_DROPDOWN = By.xpath(".//*[@id='select2-chosen-1']");
        String TYPE_GENERAL = "//option[contains(.,'%s')]";
        By TITLE = By.xpath(".//*[@id='content_name']");
        By YEAR = By.xpath(".//*[@id='content_year']");
        By COUNTRY_DROPDOWN = By.xpath(".//*[@id='select2-chosen-2']");
        String COUNTRY_GENERAL = "//span[contains(.,'%s')]";
        By LANGUAGE_DROPDOWN = By.xpath(".//*[@id='select2-chosen-3']");
        By PRODUCER = By.xpath(".//*[@id='content_producer']");
        By DIRECTOR =  By.xpath(".//*[@id='content_director']");
        By FORMAT_DROPDOWN = By.xpath(".//*[@id='select2-chosen-4']");
        By GENRES_DROPDOWN = By.xpath(".//*[@id='s2id_content_genres']/ul");
        By TAGS = By.cssSelector(".ui-widget-content.ui-autocomplete-input");
        By SYNOPSIS = By.xpath(".//*[@id='content_description']");
        By CAST = By.xpath(".//*[@id='content_cast']");
        By SAVE_AND_EXIT_BUTTON = By.xpath(".//*[@id='content_save']");
        By NEXT_RIGHTS_BUTTON = By.xpath(".//*[@id='content_next']");
    }
}
