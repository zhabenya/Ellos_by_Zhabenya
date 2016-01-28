package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.WebElementsActions;

/**
 * Created by zhabenya on 27.01.16.
 */
public class ProductListPage {

    private WebDriver driver;
    private WebElementsActions web;
    private static final Logger LOG = Logger.getLogger(LoginPage.class);

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }

    public void goToSubcategory(String subcategory) {
        String locator = subcategory + "Link";
        web.waitForElementVisible(locator, 20);
        web.clickElement("TopsLink");
        LOG.info("Go to " + subcategory + " page " + locator);
    }

    public void goToProduct() {
        web.clickElement("FirstItemLink");
    }
}
