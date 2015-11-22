package framework;
import framework.utils.CustomListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

/**
 * Created by payu on 7/15/2015.
 */
@Listeners({CustomListener.class})
public class BaseTest {

    public static String login = "";
    public static String password = "";

    public void openBrowser() {
        String browserName = System.getProperty("browser");
        WebDriver driver = DriverFactory.createInstance(browserName);
        DriverManager.setWebDriver(driver);
    }

    public void closeBrowser() {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }

    public static void openPage(String url) {
        DriverManager.getDriver().get(url);
    }

    public static void refreshPage() {
        DriverManager.getDriver().navigate().refresh();
    }

}
