package tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * Created by zhabenya on 27.01.16.
 */
public class ProductTests extends ProductsFixture {

    @BeforeGroups("logged")
    public static void setUpGroup() throws Exception {
        header.clickLogo();
        header.goToLoginPage();
        loginPage.fillLoginEmailField("rude.zhabenya@gmail.com");
        loginPage.fillLoginPasswordField("gr@yBulb40");
        loginPage.clickLoginButton();
    }

    @AfterGroups("logged")
    public void tearDownTest(){
        header.logout();
    }

    @BeforeMethod
    public static void setUpTest() throws Exception {
        header.clickLogo();
        header.goToProductList("WomenClothes");
        productListPage.goToSubcategory("Tops");
        productListPage.goToProduct();
        productPage.checkProductInfo();
        productPage.scrollToFields();
    }

    @Test
    public void positiveTest(){
        productPage.selectColor();
        productPage.selectSize();
        productPage.clickAddToCartButton();
        assertTrue(productPage.checkItemAddedToBasket());
    }

    @Test
    public void negativeAddToCartNoSize(){
        productPage.clickAddToCartButton();
        assertTrue(productPage.checkSizeNotSelectedError());
    }

    @Test
    public void addToWishList(){
        productPage.selectColor();
        productPage.selectSize();
        productPage.addToWishList();
        assertTrue(loginPage.checkAtLoginPage());
    }

    @Test(groups = "logged")
    public void loggedAddToWishList(){
        productPage.selectColor();
        productPage.selectSize();
        productPage.addToWishList();
        assertTrue(productPage.checkItemAddedToWishList());
    }

    @Test
    public void viewFullImage(){
        productPage.clickImage();
        assertTrue(productPage.checkFullImage());
        productPage.closeFullImage();
    }

    @Test
    public void switchTabs() {
        productPage.goToTabs();
        assertTrue(productPage.checkTabs());
    }

    @Test
    public void showMoreAboutProduct(){
        productPage.clickShowMoreLink();
        assertTrue(productPage.checkDescriptionTabEnabled());
    }

    @Test
    public void viewRating(){
        productPage.clickRatingLink();
        assertTrue(productPage.checkRatingTabEnabled());
    }

    @Test
    public void writeReview(){
        productPage.clickWriteReviewButton();
        assertTrue(loginPage.checkAtLoginPage());
    }

    @Test(groups = "logged")
    public void loggedWriteReview(){
        productPage.clickWriteReviewButton();
        assertTrue(productPage.checkReviewFormEnabled());
    }


}
