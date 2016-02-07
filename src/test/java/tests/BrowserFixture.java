package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.PropertyLoader;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhabenya on 27.01.16.
 */
@Test
public class BrowserFixture {

    static WebDriver driver;
    /** Browsers constants */
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String INTERNET_EXPLORER = "ie";
    public static final String PHANTOMJS = "phantomjs";

    public static final Logger LOG = Logger.getLogger(LoginTests.class);
    public static final String browserName = PropertyLoader.loadProperty("browser.name");

    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws Exception {
//        driver = new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver", "/home/tania/Downloads/Tools/chromedriver");
//        driver = new ChromeDriver();
//        driver = new PhantomJSDriver();
        if(browserName.equals(FIREFOX)){
            driver = new FirefoxDriver();
        }else if(browserName.equals(PHANTOMJS)){
            driver = new PhantomJSDriver();
        } else if(browserName.equals(CHROME)){
            driver = new ChromeDriver();
        } else {
            Assert.fail("invalid driver name");
        }

        LOG.info("Browser started");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://www.ellos.se/");
        LOG.info("Start test");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() throws Exception {
        LOG.info("End test");
        driver.quit();
    }
}
