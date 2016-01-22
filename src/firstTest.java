import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by zhabenya on 10.01.16.
 */
public class firstTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private WebElementsActions actions;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        actions = new WebElementsActions(driver);
        baseUrl = "http://www.ellos.se/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    /*public void loginTest(){
        actions.goToUrl(baseUrl);
        actions.refreshPage();
        actions.clickLink(getLoginPageLink());
        actions.fillField(getLoginEmailInput(),"rude.zhabenya@gmail.com");
//        actions.clickElement(".//fillField[@id='LoginPasswordText']");
//        driver.findElement(By.tagName("body")).sendKeys(Keys.TAB);
        actions.fillField(".//fillField[@id='LoginPasswordText']", "gr@yBulb40");
        actions.clickElement(getLoginSubmitButton());
        assertTrue(actions.isElementPresent(getLogoutButton()));
    }*/


    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

