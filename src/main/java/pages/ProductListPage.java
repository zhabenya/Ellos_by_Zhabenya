package pages;

import data.Product;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.WebElementsActions;

import static pages.ProductPage.parsePrice;

/**
 * Created by zhabenya on 27.01.16.
 */
public class ProductListPage {

    private WebDriver driver;
    private WebElementsActions web;
    private static final Logger LOG = Logger.getLogger(LoginPage.class);
    private Product product;

    public ProductListPage(WebDriver driver, Product product) {
        this.driver = driver;
        this.product = product;
        web = new WebElementsActions(driver);
    }

    public void goToSubcategory(String subcategory) {
        String locator = subcategory + "Link";
        web.waitForElementVisible(locator, 20);
        web.clickElement("TopsLink");
//        LOG.info("Go to " + subcategory + " page " + locator);
    }

    public void goToProduct() {
        getProductInfo();
        web.clickElement("FirstItemLink");
    }

    private void getProductInfo() {
        product.setName(web.getElementText("FirstItemName"));
        product.setPrice(parsePrice(web.getElementText("FirstItemPrice")));
        product.setCurrency(web.getElementText("FirstItemCurrency"));
//        LOG.info(web.getElementText("FirstItemName") + "////////////" + price);
    }
}
