package pages;

import data.Product;
import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

import static org.testng.Assert.assertTrue;

/**
 * Created by zhabenya on 29.01.16.
 */
public class BasketPage extends Page {

    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public BasketPage(WebDriverWrapper driver) {
        super(driver);
    }

    public boolean checkAtBasketPage() {
        if (checkAtPage("Basket")){
            LOG.info("At basket page");
            return true;
        }
        return false;
    }

    private void verifyProductData(Product product){
        String id = web.getElementText("BasketProductId");
        assertTrue(id.equalsIgnoreCase(product.getId()));
        String name = web.getElementText("BasketProductName");
        assertTrue(name.equalsIgnoreCase(product.getName()));
        //TODO: fucking discount #ctl00_ctl00_conMain_conMain_ucOrderView_ucOnlineOrderList_repParcels_ctl00_repProducts_ctl00_OrderListPrice1_lCurrentPrice
//        Integer price = parsePrice(web.getElementText("BasketProductPrice"));
//        assertTrue(price == product.getPrice());
//        String currency = web.getElementText("BasketProductCurrency");
//        assertTrue(currency.equalsIgnoreCase(product.getCurrency()));
        String color = web.getElementText("BasketProductColor");
        assertTrue(color.equalsIgnoreCase(product.getColor()));
        String size = web.getElementText("BasketProductSize");
        assertTrue(size.equalsIgnoreCase(product.getSize()));
    }

    public void checkout() {
        movePageWithSpace();
        web.clickElement("CheckoutButton");
    }

    public void changeQuantity(Integer number) {
        web.clickElement("ChangeQuantityButton");
        web.clearAndFillField("ItemsQuantityInput", number.toString());
        web.clickElement("UpdateQuantityButton");
    }

    public boolean checkIncorrectItemsQuantity() {
        if (web.isElementPresent("IncorrectItemsValueError")) {
            LOG.info("See incorrect items quantity error");
            return true;
        }
        return false;
    }
}
