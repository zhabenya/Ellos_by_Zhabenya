package pages;

import data.Product;
import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

import static data.Parsers.parsePrice;
import static org.testng.Assert.assertTrue;

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

    public void checkProductInfo(Product product) {
        assertTrue(web.getElementText("BasketProductName").equalsIgnoreCase(product.getName()));
        assertTrue(web.getElementText("BasketProductColor").equalsIgnoreCase(product.getColor()));
        assertTrue(web.getElementText("BasketProductSize").equalsIgnoreCase(product.getSize()));
        assertTrue(web.getElementText("BasketProductId").equalsIgnoreCase(product.getId()));
        assertTrue(parsePrice(web.getElementText("BasketProductPrice")) == product.getPrice());
        assertTrue(web.getElementText("BasketProductCurrency").equalsIgnoreCase(product.getCurrency()));
        LOG.info("Product info is correct");
    }

    public void selectDelivery(String method) {
        web.clickElement(method + "Delivery");
    }

    public boolean checkDeliverySelected(String method) {
        String selectedDelivery = web.getElementText("SelectedDelivery");

        switch (method){
            case "Normal":
                return selectedDelivery.equals("2-3 vardagar");
            case "Express":
                return selectedDelivery.equals("express24");
            case "Priority":
                return selectedDelivery.equals("2-3 vardagar");
            default:
                return false;
        }
        /*if (method.equalsIgnoreCase("normal") && selectedDelivery.equals("2-3 vardagar") ||
                method.equalsIgnoreCase("express") && selectedDelivery.equals("express24") ||
                method.equalsIgnoreCase("priority") && selectedDelivery.equals("2-3 vardagar")) {
            LOG.info("Delivery is shown correctly");
            return true;
        }
        return false;*/
    }

    public void goToMainPage() {
        web.clickElement("LogoToMainPage");
    }

    public void checkDeliveryOptions() {
        selectDelivery("Normal");
        assertTrue(checkDeliverySelected("Normal"));
        selectDelivery("Express");
        assertTrue(checkDeliverySelected("Express"));
        selectDelivery("Priority");
        assertTrue(checkDeliverySelected("Priority"));
        LOG.info("Delivery options switch correct");
    }

    public void selectPayment(String method) {
        web.clickElement(method + "Payment");
    }

    public boolean checkPaymentSelected(String method){
        switch (method){
            case "Credit":
                return web.isElementPresent("CreditPaymentActive");
            case "Account":
                return web.isElementPresent("AccountPaymentActive");
            case "Cash":
                return web.isElementPresent("CashPaymentActive");
            case "Card":
                return web.isElementPresent("CardPaymentActive");
            default:
                return false;
        }
    }

    public void checkPaymentMethods() {
        selectPayment("Credit");
        assertTrue(checkPaymentSelected("Credit"));
        selectPayment("Account");
        assertTrue(checkPaymentSelected("Account"));
        selectPayment("Cash");
        assertTrue(checkPaymentSelected("Cash"));
        selectPayment("Card");
        assertTrue(checkPaymentSelected("Card"));
        LOG.info("Payment methods switch correct");
    }
}
