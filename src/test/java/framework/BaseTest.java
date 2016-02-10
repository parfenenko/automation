package framework;

import org.openqa.selenium.WebDriver;

import java.nio.charset.Charset;

/**
 * Created by payu on 7/15/2015.
 */
public class BaseTest {

    public void openBrowser() {
        String browserName = System.getProperty("browser");
        WebDriver driver = DriverFactory.createInstance(browserName);
        DriverManager.setWebDriver(driver);
//        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(300,500));
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

    private final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    String decodeUTF8(byte[] bytes) {
        return new String(bytes, UTF8_CHARSET);
    }

    byte[] encodeUTF8(String string) {

        return string.getBytes(UTF8_CHARSET);
    }

    public static void maximizeResolution() {
        String browserName = System.getProperty("browser");
        WebDriver driver = DriverFactory.createInstance(browserName);
        DriverManager.setWebDriver(driver);
        driver.manage().window().maximize();
    }

    public static void setChromeProperties(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\payu\\Downloads\\chromedriver.exe");
    }

}
