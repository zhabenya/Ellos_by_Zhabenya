import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by zhabenya on 19.01.16.
 */
public class MainPage {

    private WebDriver driver;
    private WebElementsActions web;
    private Logger log = Logger.getLogger(MainPage.class);


    public MainPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }

    public void clickLogo() {
        try {
            web.clickElement("Logo");
            log.info("Click on Logo Button");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToLoginPage() {
        try {
            web.clickElement("LoginPageLink");
            log.info("Go to login page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void logout() {
        try {
            web.clickElement("LogoutButton");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
