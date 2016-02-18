package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.Ellos;
import utils.PropertyLoader;
import utils.WebDriverFactory;
import utils.WebDriverWrapper;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhabenya on 27.01.16.
 */
@Test
public class BrowserFixture {

    public static WebDriverWrapper driverWrapper;
    public static Ellos ellos;
    public static final Logger LOG = Logger.getLogger(LoginTests.class);

    public static final String wait = PropertyLoader.loadProperty("wait.timeout");

    @BeforeSuite(alwaysRun = true)
    public static void setBrowser() throws Exception {
        driverWrapper = WebDriverFactory.initDriver();
        ellos = new Ellos(driverWrapper);

        driverWrapper.manage().timeouts().implicitlyWait(Long.parseLong(wait), TimeUnit.SECONDS);
        driverWrapper.get("http://www.ellos.se/");
        LOG.info("Start test suite");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() throws Exception {
        LOG.info("End test");
        driverWrapper.quit();
    }
}
