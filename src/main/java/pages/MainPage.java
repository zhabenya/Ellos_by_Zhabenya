package pages;

import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.PropertyLoader;
import utils.WebDriverWrapper;

/**
 * Created by zhabenya on 27.01.16.
 */
public class MainPage extends Page {

    private static final String MAIN_PAGE = PropertyLoader.loadProperty("site.url");

    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public MainPage(WebDriverWrapper driver) {
        super(driver, MAIN_PAGE);
    }

    public void goToBasketRegistrationPage() {
        goToUrl("https://www.ellos.se/LoginAndRegistration/RegisterCustomer");
    }
}
