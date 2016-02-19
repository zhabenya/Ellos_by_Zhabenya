package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * Created by zhabenya on 11.02.16.
 */
public class CheckoutTests extends ProductsFixture {

    @BeforeClass
//    @Parameters({"email", "pass"})
    public static void setUp() throws Exception {
        ellos.header.clickLogo();
        ellos.header.goToLoginPage();
        ellos.loginPage.fillLoginEmailField("test1111@gmail.com");
        ellos.loginPage.fillLoginPasswordField("1111");
        ellos.loginPage.clickLoginButton();

        ellos.header.goToProductList("WomenClothes");
        ellos.productListPage.goToSubcategory("Tops");
        product = ellos.productListPage.goToProduct();
        ellos.productPage.scrollToFields();
        ellos.productPage.selectColor();
        ellos.productPage.selectSize();
        ellos.productPage.addProductInfo(product);
        ellos.productPage.clickAddToCartButton();
        ellos.productPage.checkCartCorrectInfo(product);
        ellos.productPage.goToBasketPage();
        ellos.basketPage.checkout();
        ellos.checkoutPage.checkProductInfo(product);
    }

    @Test
    public void checkDelivery(){
        ellos.checkoutPage.checkDeliveryOptions();
    }

    @Test
    public void checkPaymentMethods(){
        ellos.checkoutPage.checkPaymentMethods();
    }

    @AfterClass
    public static void tearDown(){

    }
}
