package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by zhabenya on 19.01.16.
 */

public class LoginTests extends ClassFixture {

    @Test
    @Parameters({ "email", "pass" })
    public void loginPositiveTest(String email, String password){
        header.goToLoginPage();

        loginPage.fillLoginEmailField(email);
        loginPage.fillLoginPasswordField(password);

        loginPage.clickLoginButton();
//        assertTrue(loginPage.checkLoggedIn());
        header.logout();
        assertTrue(loginPage.checkLoggedOut());
    }

    @Test
    @Parameters({"pass"})
    public void loginNegativeNotRegisteredEmailTest(String password){
        header.goToLoginPage();

        loginPage.fillLoginEmailField("admin@gmail.com");
        loginPage.fillLoginPasswordField(password);

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginError());
    }

    @Test
    @Parameters({"pass"})
    public void loginNegativeNotRegisteredEmailSubmitByEnterTest(String password){
        header.goToLoginPage();

        loginPage.fillLoginEmailField("admin@gmail.com");
        loginPage.fillLoginPasswordField(password);

        loginPage.submitLoginFormByEnter();
        assertTrue(loginPage.checkLoginError());
    }

    @Test
    @Parameters({"pass"})
    public void loginNegativeEmptyEmailFieldTest(String password){
        header.goToLoginPage();

        loginPage.fillLoginEmailField("");
        loginPage.fillLoginPasswordField(password);

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginEmptyEmailFieldError());
    }

    @Test
    @Parameters({"email"})
    public void loginNegativeEmptyPasswordFieldTest(String email){
        header.goToLoginPage();

        loginPage.fillLoginEmailField(email);
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
    @Parameters({"longString"})
    public void loginNegativeLongInputsTest(String longString){
        header.goToLoginPage();

        loginPage.fillLoginEmailField(longString);
        loginPage.fillLoginPasswordField(longString);

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginError());
    }


}
