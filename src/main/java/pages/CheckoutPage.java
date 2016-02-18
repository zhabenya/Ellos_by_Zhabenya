package pages;

import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

/**
 * Created by zhabenya on 11.02.16.
 */
public class CheckoutPage extends Page {

    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public CheckoutPage(WebDriverWrapper driver) {
        super(driver);
    }

    public boolean checkAtCheckoutPage() {
        if (checkAtPage("Checkout/PlaceOrder")){
            LOG.info("At checkout page");
            return true;
        }
        return false;
    }

    public void checkProductInfo() {
//        assertTrue(web.getElementText());
    }

    public void selectDelivery(String method) {
        web.clickElement(method + "Delivery");
    }

    public boolean checkDeliverySelected(String method) {
        String selectedDelivery = web.getElementText("SelectedDelivery");
        //TODO same delivery
        if (method.equalsIgnoreCase("normal") && selectedDelivery.equals("2-3 vardagar") ||
                method.equalsIgnoreCase("express") && selectedDelivery.equals("express24") ||
                method.equalsIgnoreCase("priority") && selectedDelivery.equals("2-3 vardagar")) {
            LOG.info("Delivery is shown correctly");
            return true;
        }
        return false;
    }

    public void goToMainPage() {
        web.clickElement("LogoToMainPage");
    }
}
