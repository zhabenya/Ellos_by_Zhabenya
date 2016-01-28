package tests.java;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by zhabenya on 19.01.16.
 */

public class LoginTests extends ClassFixture {

    private String myEmail = "rude.zhabenya@gmail.com";
    private String pass = "gr@yBulb40";

    @Test
    public void loginPositiveTest(){
        header.clickLogo();
        header.goToLoginPage();

        loginPage.fillLoginEmailField(myEmail);
        loginPage.fillLoginPasswordField(pass);

        loginPage.clickLoginButton();
//        assertTrue(loginPage.checkLoggedIn());
        header.logout();
        assertTrue(loginPage.checkLoggedOut());
    }

    @Test
    public void loginNegativeNotRegisteredEmailTest(){
        header.goToLoginPage();

        loginPage.fillLoginEmailField("admin@gmail.com");
        loginPage.fillLoginPasswordField(pass);

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginError());
    }

    @Test
    public void loginNegativeNotRegisteredEmailSubmitByEnterTest(){
        header.goToLoginPage();

        loginPage.fillLoginEmailField("admin@gmail.com");
        loginPage.fillLoginPasswordField(pass);

        loginPage.submitLoginFormByEnter();
        assertTrue(loginPage.checkLoginError());
    }

    @Test
    public void loginNegativeEmptyEmailFieldTest(){
        header.goToLoginPage();

        loginPage.fillLoginEmailField("");
        loginPage.fillLoginPasswordField(pass);

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginEmptyEmailFieldError());
    }

    @Test
    public void loginNegativeEmptyPasswordFieldTest(){
        header.goToLoginPage();

        loginPage.fillLoginEmailField(myEmail);
        loginPage.fillLoginPasswordField("");

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginEmptyPasswordFieldError());
    }

    @Test
    public void loginNegativeEmptyFieldsTest(){
        header.goToLoginPage();

        loginPage.fillLoginEmailField("");
        loginPage.fillLoginPasswordField("");

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginEmptyFieldsError());
    }

    @Test
    public void loginNegativeLongInputsTest(){
        header.goToLoginPage();

        String longString = "veryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryverylongstring";
        loginPage.fillLoginEmailField(longString);
        loginPage.fillLoginPasswordField(longString);

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginError());
    }


}
