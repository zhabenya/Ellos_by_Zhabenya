package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.ClassNameUtil;
import utils.ConfigData;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

/**
 * Created by zhabenya on 13.02.16.
 */
public abstract class Page {

    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    private String page;
    private ConfigData config;
    public WebDriverWrapper driver;
    public WebElementsActions web;


    public Page(WebDriverWrapper driver, String page) {
        this.driver = driver;
        this.page = page;
        config = ConfigData.getConfig();
        web = new WebElementsActions(driver);
    }

    public Page(WebDriverWrapper driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }

    /*
     * Open Page in a browser
     */
    public boolean openPage(){
        try{
            LOG.info("Start open page.");
            driver.get(page);
            driver.getCurrentUrl();
        } catch (Exception e){
            LOG.error("Error in open page!\n");
            return false;
        }
        LOG.info("Page open successful.");
        return true;
    }

    public void goToUrl(String url){
        driver.get(url);
        LOG.info("Go to " + url);
    }

    /*
     * Verification Page open correct. Check on pageLocator
     */
    public boolean isPageOpen(String checkLocator){
        if (web.isElementPresent(checkLocator)) {
            LOG.info("Page: Check is page open. " + checkLocator + " is present!");
            LOG.info(ClassNameUtil.getCurrentClassName() + ": Page is opened.");
            return true;
        } else {
            LOG.error("Page: Error with check page!\n");
            Assert.fail("Incorrect swatch");
        }
        return false;
    }

    /*
     * Get page title for verification correct switch between pages
     */
    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageURL() {
        return driver.getCurrentUrl();
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }


    /**
     * Check if current URL contains page link
     * */
    public boolean checkAtPage(String page){
        return driver.getCurrentUrl().contains(page);
    }

    public void moveDownPage(){
        JavascriptExecutor jsx = (JavascriptExecutor) driver.getOriginalDriver();
        jsx.executeScript("window.scrollBy(0,100)", "");
    }

    public void movePageWithSpace(){
        Actions actions = new Actions(driver.getOriginalDriver());
        actions.sendKeys(Keys.SPACE).perform();
    }

}
