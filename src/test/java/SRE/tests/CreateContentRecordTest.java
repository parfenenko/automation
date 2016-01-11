package SRE.tests;

import SRE.pages.*;
import framework.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by j.parfenenko on 1/5/16.
 */
public class CreateContentRecordTest extends BaseTest{

    private DistributionPage distributionPage;
    private CreateContentRecordPage createContentRecordPage;
    private CreateContentRecordConfirmationPage createContentRecordConfirmationPage;
    private CreateRightsPage createRightsPage;

    //        Test data
    String login = "payu+1@ciklum.com";
    String password = "Qwerty123456";
    String contentRecordType = "Short Film";
    String title = "Auto Title";
    String year = "2020";
    String country = "DZ";
    String language = "MAN";
    String producer = "Steven Spielberg";
    String director = "Quentin Tarantino";
    String format = "< 5";
    String[] genres = new String[]{"Coming-Of-Age" , "Pornography" , "Sitcom"};
    String[] tags = new String[]{"automation,", "selenium,", "test,"};
    String synopsis = "" +
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
            "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
            "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
            "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
            "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
    String cast = "" +
            "Harrison Ford - Han Solo\n" +
            "Mark Hamill - Luke Skywalker\n" +
            "Carrie Fisher - Princess Leia\n" +
            "Adam Driver - Kylo Ren\n" +
            "Daisy Ridley - Rey\n" +
            "John Boyega - Finn\n" +
            "Oscar Isaac - Poe Dameron\n" +
            "Lupita Nyong'o - Maz Kanata\n" +
            "Andy Serkis - Supreme Leader Snoke\n" +
            "Domhnall Gleeson - General Hux\n" +
            "Anthony Daniels - C-3PO\n" +
            "Max von Sydow - Lor San Tekka\n" +
            "Peter Mayhew - Chewbacca\n" +
            "Gwendoline Christie - Captain Phasma\n" +
            "Joonas Suotamo - Chewbacca Double ";

    @BeforeTest
    public void openLoginPage() {
        openBrowser();
        openPage("http://dev.sr.pp.ciklum.com/");
    }

    @AfterTest
    public void finishTest() {
        closeBrowser();
    }

    @Test(priority = 1)
    public void createContentRecord(){
        LoginPage loginPage = new LoginPage();
        distributionPage = loginPage.login(login, password);
        createContentRecordPage = distributionPage.clickCreateContentRecord();
        createContentRecordPage.selectTypeByName(contentRecordType);
        createContentRecordPage.fillTitle(title);
        createContentRecordPage.fillYear(year);
        createContentRecordPage.selectCountry(country);
        createContentRecordPage.selectLanguage(language);
        createContentRecordPage.fillProducer(producer);
        createContentRecordPage.fillDirector(director);
        createContentRecordPage.selectFormat(format);
        createContentRecordPage.selectGenres(genres);
        createContentRecordPage.fillTags(tags);
        createContentRecordPage.fillSynopsis(synopsis);
        createContentRecordPage.fillCast(cast);
        createContentRecordConfirmationPage = createContentRecordPage.clickSaveAndExit();
    }

    @Test(priority = 2)
    public void createContentRecordWithRights(){
        openPage("http://dev.sr.pp.ciklum.com/content/create");
        createContentRecordPage.selectTypeByName(contentRecordType);
        createContentRecordPage.fillTitle(title);
        createContentRecordPage.fillYear(year);
        createContentRecordPage.selectCountry(country);
        createContentRecordPage.selectLanguage(language);
        createContentRecordPage.fillProducer(producer);
        createContentRecordPage.fillDirector(director);
        createContentRecordPage.selectFormat(format);
        createRightsPage = createContentRecordPage.clickNextRights();
    }
}
