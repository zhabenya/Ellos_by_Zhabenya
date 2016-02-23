package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by zhabenya on 29.01.16.
 */
public class BasketTests extends ProductsFixture {

    @BeforeMethod
    public static void setUpTest() throws Exception {
        ellos.header.clickLogo();
        ellos.header.goToProductList("WomenClothes");
        ellos.productListPage.goToSubcategory("Tops");
        product = ellos.productListPage.goToProduct();
        ellos.productPage.scrollToFields();
        ellos.productPage.selectColor();
        ellos.productPage.selectSize();
        ellos.productPage.addProductInfo(product);
        ellos.productPage.clickAddToCartButton();
        ellos.productPage.checkCartCorrectInfo(product);
    }

    @Test
    public void positiveCheckout(){
        ellos.productPage.goToBasketPage();
        ellos.basketPage.checkout();
        assertTrue(ellos.loginPage.checkAtLoginPage());
    }

    @Test
    public void negativeIncorrectItemsQuantity(){
        ellos.productPage.goToBasketPage();
        ellos.basketPage.changeQuantity(0);
        assertTrue(ellos.basketPage.checkIncorrectItemsQuantity());
    }

    @Test
    public void checkTotal(){
        ellos.productPage.goToBasketPage();
        ellos.basketPage.changeQuantity(2);
        assertTrue(ellos.basketPage.checkTotalIsCorrect(product, 2));
    }

    @Test
    public void removeItem(){
        ellos.productPage.goToBasketPage();
        ellos.basketPage.removeProduct();
        assertTrue(ellos.basketPage.checkEmptyBasket());
    }

}
