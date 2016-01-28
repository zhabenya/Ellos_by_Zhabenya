package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.WebElementsActions;

/**
 * Created by zhabenya on 19.01.16.
 */
public class Header {

    private WebDriver driver;
    private WebElementsActions web;
    private static final Logger LOG = Logger.getLogger(Header.class);


    public Header(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }

    public void clickLogo() {
        web.clickElement("Logo");
        LOG.info("Click on Logo Button");
    }

    public void goToLoginPage() {
        web.clickElement("LoginPageLink");
        LOG.info("Go to login page");
    }

    public void logout() {
        web.clickElement("LogoutButton");
    }

    public void goToProductList(String category) {
        String locator = category + "MenuLink";
        web.clickElement(locator);
        LOG.info("Go to " + category + " page " + locator);
    }
}
