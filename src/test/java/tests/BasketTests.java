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
        String category = "WomenClothes";
        String subcategory = "Tops";

        header.clickLogo();
        header.goToProductList(category);
        productListPage.goToSubcategory(subcategory);
        productListPage.goToProduct();
        productPage.scrollToFields();
        productPage.selectColor();
        productPage.selectSize();
        productPage.clickAddToCartButton();
        productPage.goToBasketPage();
    }

    @Test
    public void positiveCheckout(){
        basketPage.clickCheckoutButton();
        assertTrue(loginPage.checkAtLoginPage());
    }

    @Test
    public void negativeIncorrectItemsQuantity(){
        basketPage.clickChangeQuantityButton();
        basketPage.setItemsQuantity(0);
        assertTrue(basketPage.checkIncorrectItemsQuantity());
    }

}
