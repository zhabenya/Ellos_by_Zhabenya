package tests.java;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * Created by zhabenya on 28.01.16.
 */
public class ProductLoggedTests extends ClassFixture {

    @BeforeMethod
    public static void setUpTest() throws Exception {
        String category = "WomenClothes";
        String subcategory = "Tops";

        header.clickLogo();
        header.goToLoginPage();
        loginPage.fillLoginEmailField("rude.zhabenya@gmail.com");
        loginPage.fillLoginPasswordField("gr@yBulb40");
        loginPage.clickLoginButton();
        header.goToProductList(category);
        productListPage.goToSubcategory(subcategory);
        productListPage.goToProduct();
        productPage.scrollToFields();
    }

    @Test
//            (groups = {"logged user"})
    public void addToWishList(){
        productPage.selectColor();
        productPage.selectSize();
        productPage.addToWishList();
        assertTrue(productPage.checkItemAddedToWishList());
    }

    @Test
    public void writeReview(){
        productPage.clickWriteReviewButton();
        assertTrue(productPage.checkReviewFormEnabled());
    }
}
