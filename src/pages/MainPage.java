package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.WebElementsActions;

/**
 * Created by zhabenya on 27.01.16.
 */
public class MainPage {

    WebDriver driver;
    WebElementsActions web;
    private static final Logger LOG = Logger.getLogger(LoginPage.class);

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


}
