package pages;

import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

/**
 * Created by zhabenya on 19.01.16.
 */
public class Header extends Page {

    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public Header(WebDriverWrapper driver) {
        super(driver);
    }

    public void clickLogo() {
        web.clickElement("Logo");
    }

    public void goToLoginPage() {
        web.clickElement("LoginPageLink");
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
