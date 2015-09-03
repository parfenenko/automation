package framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

/**
 * Created by payu on 7/15/2015.
 */
public class BaseTest {

//        private WebDriver driver;
//        public WebDriver getDriver() {
//            return driver;
//        }
//
//        public void openBrowser() {
//            WebDriver driver = new FirefoxDriver();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.get("http://level2.ciklum.net/index.php");
//        }
//
//        public void closeBrowser() {
//            driver.quit();
//        }

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

    public static void open(String url) {
        DriverManager.getDriver().get(url);
    }

    public static void refreshPage() {
        DriverManager.getDriver().navigate().refresh();
    }

}
