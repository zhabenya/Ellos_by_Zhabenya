package tests.java;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhabenya on 27.01.16.
 */
@Test
public class BrowserFixture {

    static WebDriver driver;
    private static final Logger LOG = Logger.getLogger(LoginTests.class);

    @BeforeSuite
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        LOG.info("Browser started");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.ellos.se/");
        LOG.info("Start test");
    }

    @AfterSuite
    public static void tearDown() throws Exception {
        LOG.info("End test");
        driver.quit();
    }
}
