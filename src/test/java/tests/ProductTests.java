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
        ellos.header.clickLogo();
        ellos.header.goToLoginPage();
        ellos.loginPage.fillLoginEmailField("rude.zhabenya@gmail.com");
        ellos.loginPage.fillLoginPasswordField("gr@yBulb40");
        ellos.loginPage.clickLoginButton();
    }

    @AfterGroups("logged")
    public void tearDownTest(){
        ellos.header.logout();
    }

    @BeforeMethod
    public static void setUpTest() throws Exception {
        ellos.header.clickLogo();
        ellos.header.goToProductList("WomenClothes");
        ellos.productListPage.goToSubcategory("Tops");
        product = ellos.productListPage.goToProduct();
        ellos.productPage.checkProductInfo(product);
        ellos.productPage.scrollToFields();
    }

    @Test
    public void positiveTest(){
        ellos.productPage.selectColor();
        ellos.productPage.selectSize();
        ellos.productPage.clickAddToCartButton();
        assertTrue(ellos.productPage.checkItemAddedToBasket(product));
    }

    @Test
    public void negativeAddToCartNoSize(){
        ellos.productPage.clickAddToCartButton();
        assertTrue(ellos.productPage.checkSizeNotSelectedError());
    }

    @Test
    public void addToWishList(){
        ellos.productPage.selectColor();
        ellos.productPage.selectSize();
        ellos.productPage.addToWishList();
        assertTrue(ellos.loginPage.checkAtLoginPage());
    }

    @Test(groups = "logged")
    public void loggedAddToWishList(){
        ellos.productPage.selectColor();
        ellos.productPage.selectSize();
        ellos.productPage.addToWishList();
        assertTrue(ellos.productPage.checkItemAddedToWishList());
    }

    @Test
    public void viewFullImage(){
        ellos.productPage.clickImage();
        assertTrue(ellos.productPage.checkFullImage());
        ellos.productPage.closeFullImage();
    }

    @Test
    public void switchTabs() {
        ellos.productPage.goToTabs();
        assertTrue(ellos.productPage.checkTabs());
    }

    @Test(enabled = false)
    public void showMoreAboutProduct(){
        ellos.productPage.clickShowMoreLink();
        assertTrue(ellos.productPage.checkDescriptionTabEnabled());
    }

    @Test
    public void viewRating(){
        ellos.productPage.clickRatingLink();
        assertTrue(ellos.productPage.checkRatingTabEnabled());
    }

    @Test
    public void writeReview(){
        ellos.productPage.clickWriteReviewButton();
        assertTrue(ellos.loginPage.checkAtLoginPage());
    }

    @Test(groups = "logged")
    public void loggedWriteReview(){
        ellos.productPage.clickWriteReviewButton();
        assertTrue(ellos.productPage.checkReviewFormEnabled());
    }


}
