package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.WebElementsActions;

/**
 * Created by zhabenya on 29.01.16.
 */
public class BasketPage {

    WebDriver driver;
    WebElementsActions web;
    private static final Logger LOG = Logger.getLogger(LoginPage.class);

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }

    public void clickCheckoutButton() {
        String locator = "CheckoutButton";
        web.moveDownPage();
        web.clickButton(locator);
//        LOG.info("Click " + locator);
    }

    public void clickChangeQuantityButton() {
        String locator = "ChangeQuantityButton";
        web.clickButton(locator);
//        LOG.info("Click " + locator);
    }

    public void setItemsQuantity(Integer number) {
        web.clearAndFillField("ItemsQuantityInput", number.toString());
        String locator = "UpdateQuantityButton";
        web.clickElement(locator);
//        LOG.info("Click " + locator);
    }

    public boolean checkIncorrectItemsQuantity() {
        String locator = "IncorrectItemsValueError";
        if (web.isElementPresent(locator)) {
            LOG.info("See error " + locator);
            return true;
        }
        return false;
    }
}
