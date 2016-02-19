package pages;

import data.Product;
import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

import static data.Parsers.parsePrice;

/**
 * Created by zhabenya on 27.01.16.
 */
public class ProductListPage extends Page {

    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public ProductListPage(WebDriverWrapper driver) {
        super(driver);
    }

    public void goToSubcategory(String subcategory) {
        web.waitForElementVisible(subcategory + "Link", 20);
        web.clickElement("TopsLink");
    }

    public Product goToProduct() {
        Product product = getProductInfo();
        web.clickElement("FirstItemLink");
        return product;

    }

    private Product getProductInfo() {
        Product product = new Product();
        product.setName(web.getElementText("FirstItemName"));
        product.setPrice(parsePrice(web.getElementText("FirstItemPrice")));
        product.setCurrency(web.getElementText("FirstItemCurrency"));
        return product;
    }
}
