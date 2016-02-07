package tests;

import data.Product;
import org.testng.annotations.BeforeMethod;
import pages.BasketPage;
import pages.ProductListPage;
import pages.ProductPage;

/**
 * Created by zhabenya on 04.02.16.
 */
public class ProductsFixture extends ClassFixture {


    protected static ProductListPage productListPage;
    protected static ProductPage productPage;

    protected static BasketPage basketPage;
    protected Product product;

    @BeforeMethod
    public void setUpProduct() throws Exception {
        product = new Product();
        productListPage = new ProductListPage(driver, product);
        productPage = new ProductPage(driver, product);
        basketPage = new BasketPage(driver);
    }
}
