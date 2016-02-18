package tests;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * Created by zhabenya on 19.01.16.
 */

public class LoginTests extends ClassFixture {

    @Test
    @Parameters({ "email", "pass" })
    public void loginPositiveTest(String email, String password){
        ellos.header.goToLoginPage();

        ellos.loginPage.fillLoginEmailField(email);
        ellos.loginPage.fillLoginPasswordField(password);

        ellos.loginPage.clickLoginButton();
//        assertTrue(ellos.loginPage.checkLoggedIn());
        ellos.header.logout();
        assertTrue(ellos.loginPage.checkLoggedOut());
    }

    @Test
    @Parameters({"pass"})
    public void loginNegativeNotRegisteredEmailTest(String password){
        ellos.header.goToLoginPage();

        ellos.loginPage.fillLoginEmailField("admin@gmail.com");
        ellos.loginPage.fillLoginPasswordField(password);

        ellos.loginPage.clickLoginButton();
        assertTrue(ellos.loginPage.checkLoginError());
    }

    @Test
    @Parameters({"pass"})
    public void loginNegativeNotRegisteredEmailSubmitByEnterTest(String password){
        ellos.header.goToLoginPage();

        ellos.loginPage.fillLoginEmailField("admin@gmail.com");
        ellos.loginPage.fillLoginPasswordField(password);

        ellos.loginPage.submitLoginFormByEnter();
        assertTrue(ellos.loginPage.checkLoginError());
    }

    @Test
    @Parameters({"pass"})
    public void loginNegativeEmptyEmailFieldTest(String password){
        ellos.header.goToLoginPage();
        ellos.loginPage.fillLoginEmailField("");
        ellos.loginPage.fillLoginPasswordField(password);

        ellos.loginPage.clickLoginButton();
        assertTrue(ellos.loginPage.checkLoginEmptyEmailFieldError());
    }

    @Test
    @Parameters({"email"})
    public void loginNegativeEmptyPasswordFieldTest(String email){
        ellos.header.goToLoginPage();
        ellos.loginPage.fillLoginEmailField(email);
        ellos.loginPage.fillLoginPasswordField("");

        ellos.loginPage.clickLoginButton();
        assertTrue(ellos.loginPage.checkLoginEmptyPasswordFieldError());
    }

    @Test
    public void loginNegativeEmptyFieldsTest(){
        ellos.header.goToLoginPage();
        ellos.loginPage.fillLoginEmailField("");
        ellos.loginPage.fillLoginPasswordField("");

        ellos.loginPage.clickLoginButton();
        assertTrue(ellos.loginPage.checkLoginEmptyFieldsError());
    }

    @Test
    @Parameters({"longString"})
    public void loginNegativeLongInputsTest(String longString){
        ellos.header.goToLoginPage();
        ellos.loginPage.fillLoginEmailField(longString);
        ellos.loginPage.fillLoginPasswordField(longString);

        ellos.loginPage.clickLoginButton();
        assertTrue(ellos.loginPage.checkLoginError());
    }

    @BeforeGroups("basket")
    public void setUpGroup() {
        ellos.header.clickLogo();
        ellos.header.goToProductList("WomenClothes");
        ellos.productListPage.goToSubcategory("Tops");
        ellos.productListPage.goToProduct();
        ellos.productPage.scrollToFields();
        ellos.productPage.selectColor();
        ellos.productPage.selectSize();
        ellos.productPage.clickAddToCartButton();
        ellos.productPage.goToBasketPage();
        ellos.basketPage.checkout();
        ellos.loginPage.checkAtLoginPage();
    }

    @Test(groups = "basket")
    @Parameters({"email", "pass"})
    public void loginBasketPositiveTest(String email, String password) {
        ellos.loginPage.fillLoginEmailField(email);
        ellos.loginPage.fillLoginPasswordField(password);

        ellos.loginPage.clickLoginButton();
        ellos.header.logout();
        assertTrue(ellos.loginPage.checkLoggedOut());
    }
}
