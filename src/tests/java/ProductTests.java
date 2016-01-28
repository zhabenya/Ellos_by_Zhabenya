package tests.java;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * Created by zhabenya on 27.01.16.
 */
public class ProductTests extends ClassFixture {

    @BeforeMethod
    public static void setUpTest() throws Exception {
        String category = "WomenClothes";
        String subcategory = "Tops";

        header.clickLogo();
        header.goToProductList(category);
        productListPage.goToSubcategory(subcategory);
        productListPage.goToProduct();
        productPage.scrollToFields();
    }

    @Test
//            (groups = {"not logged user"})
    public void positiveTest(){
        productPage.selectColor();
        productPage.selectSize();
        productPage.clickAddToCartButton();
        assertTrue(productPage.checkItemAddedToBasket());
    }

    @Test
//            (groups = {"not logged user"})
    public void negativeAddToCartNoSize(){
        productPage.clickAddToCartButton();
        assertTrue(productPage.checkSizeNotSelectedError());
    }

    @Test
//            (groups = {"not logged user"})
    public void addToWishList(){
        productPage.selectColor();
        productPage.selectSize();
        productPage.addToWishList();
        assertTrue(loginPage.checkAtLoginPage());
    }

    @Test
    public void viewFullImage(){
        productPage.clickImage();
        assertTrue(productPage.checkFullImage());
    }

    @Test
    public void switchTabs() {
        productPage.clickDescriptionTab();
        assertTrue(productPage.isDescriptionTabEnabled());
        productPage.clickRatingTab();
        assertTrue(productPage.isRatingTabEnabled());
        productPage.clickDeliveryTab();
        assertTrue(productPage.isDeliveryTabEnabled());
        productPage.clickSizeguideTab();
        assertTrue(productPage.isSizeguideTabEnabled());
    }

    @Test
    public void showMoreAboutProduct(){
        productPage.clickRatingTab();
        productPage.clickShowMoreLink();
        assertTrue(productPage.isDescriptionTabEnabled());
    }

    @Test
    public void viewRating(){
        productPage.clickRatingLink();
        assertTrue(productPage.isRatingTabEnabled());
    }

    @Test
    public void writeReview(){
        productPage.clickWriteReviewButton();
        assertTrue(loginPage.checkAtLoginPage());
    }
}
