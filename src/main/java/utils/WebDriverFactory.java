package utils;

import net.anthavio.phanbedder.Phanbedder;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.File;

/**
 * Created by zhabenya on 13.02.16.
 */
public class WebDriverFactory {

    public static WebDriverWrapper driverWrapper;

    /*Browsers constants*/
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";
    private static final String HTML_UNIT = "htmlunit";
    private static final String PHANTOMJS = "phantomjs";

    public static final String browserName = PropertyLoader.loadProperty("browser.name");
    public static final String browserVersion = PropertyLoader.loadProperty("browser.version");
    public static final String platform = PropertyLoader.loadProperty("browser.platform");

    public static final String grid = PropertyLoader.loadProperty("grid2.hub");

    public WebDriverFactory() {
    }

    public static WebDriverWrapper initDriver(){

        if(FIREFOX.equals(browserName)){
            driverWrapper = new WebDriverWrapper( new FirefoxDriver());
        }else if(PHANTOMJS.equals(browserName)){
            File phantomjs = Phanbedder.unpack();
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs.getAbsolutePath());
            driverWrapper = new WebDriverWrapper( new PhantomJSDriver(caps));

        } else if(CHROME.equals(browserName)){
            ChromeOptions options = new ChromeOptions();
            driverWrapper = new WebDriverWrapper( new ChromeDriver(options));
        }

        else {
            Assert.fail("Invalid driver name");
        }

        driverWrapper.manage().deleteAllCookies();
        driverWrapper.manage().window().maximize();

        return driverWrapper;
    }

}
