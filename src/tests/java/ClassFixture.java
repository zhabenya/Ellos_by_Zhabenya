package tests.java;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Header;
import pages.LoginPage;
import pages.ProductListPage;
import pages.ProductPage;

/**
 * Created by zhabenya on 27.01.16.
 */
@Test
public class ClassFixture extends BrowserFixture {

    protected static LoginPage loginPage;
    protected static Header header;

    protected static  ProductListPage productListPage;
    protected static ProductPage productPage;

    @BeforeClass
    public static void setUpClass() throws Exception {
        header = new Header(driver);
        loginPage = new LoginPage(driver);
        productListPage = new ProductListPage(driver);
        productPage = new ProductPage(driver);
    }
}
