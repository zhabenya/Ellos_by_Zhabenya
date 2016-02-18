package tests;

import data.UserData;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * Created by zhabenya on 19.01.16.
 */

public class RegistrationTests extends ClassFixture {

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationPositiveTest(String email, String pass){
        ellos.header.goToLoginPage();

        ellos.loginPage.fillRegistrationEmailField(email);
        ellos.loginPage.fillRepeatRegistrationEmailField(email);
        ellos.loginPage.fillRegistrationPasswordField(pass);
        ellos.loginPage.fillRepeatRegistrationPasswordField(pass);
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.clickRegisterSubmitButton();

        assertTrue(ellos.loginPage.checkRegistered());
        ellos.header.logout();
        assertTrue(ellos.loginPage.checkLoggedOut());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativeEmptyEmailTest(String email, String pass){
        ellos.header.goToLoginPage();

        ellos.loginPage.fillRegistrationEmailField("");
        ellos.loginPage.fillRepeatRegistrationEmailField(email);
        ellos.loginPage.fillRegistrationPasswordField(pass);
        ellos.loginPage.fillRepeatRegistrationPasswordField(pass);
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.clickRegisterSubmitButton();

        assertTrue(ellos.loginPage.checkRegistrationEmptyEmailError());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativeEmptyRepeatEmailTest(String email, String pass){
        ellos.header.goToLoginPage();

        ellos.loginPage.fillRegistrationEmailField(email);
        ellos.loginPage.fillRepeatRegistrationEmailField("");
        ellos.loginPage.fillRegistrationPasswordField(pass);
        ellos.loginPage.fillRepeatRegistrationPasswordField(pass);
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.clickRegisterSubmitButton();

        assertTrue(ellos.loginPage.checkRegistrationEmptyRepeatEmailError());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativeEmptyPasswordTest(String email, String pass){
        ellos.header.goToLoginPage();

        ellos.loginPage.fillRegistrationEmailField(email);
        ellos.loginPage.fillRepeatRegistrationEmailField(email);
        ellos.loginPage.fillRegistrationPasswordField("");
        ellos.loginPage.fillRepeatRegistrationPasswordField(pass);
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.clickRegisterSubmitButton();

        assertTrue(ellos.loginPage.checkRegistrationEmptyPassError());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativeEmptyRepeatPasswordTest(String email, String pass){
        ellos.header.goToLoginPage();

        ellos.loginPage.fillRegistrationEmailField(email);
        ellos.loginPage.fillRepeatRegistrationEmailField(email);
        ellos.loginPage.fillRegistrationPasswordField(pass);
        ellos.loginPage.fillRepeatRegistrationPasswordField("");
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.clickRegisterSubmitButton();

        assertTrue(ellos.loginPage.checkRegistrationEmptyRepeatPassError());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativeExistingEmailTest(String email, String pass){
        ellos.header.goToLoginPage();

        ellos.loginPage.fillRegistrationEmailField(email);
        ellos.loginPage.fillRepeatRegistrationEmailField(email);
        ellos.loginPage.fillRegistrationPasswordField(pass);
        ellos.loginPage.fillRepeatRegistrationPasswordField(pass);
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.clickRegisterSubmitButton();

        assertTrue(ellos.loginPage.checkUserExistsError());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativeExistingEmailSubmitByEnterTest(String email, String pass){
        ellos.header.goToLoginPage();

        ellos.loginPage.fillRegistrationEmailField(email);
        ellos.loginPage.fillRepeatRegistrationEmailField(email);
        ellos.loginPage.fillRegistrationPasswordField(pass);
        ellos.loginPage.fillRepeatRegistrationPasswordField(pass);
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationFormByEnter();

        assertTrue(ellos.loginPage.checkUserExistsError());
    }

    @Test
    @Parameters({ "pass" })
    public void registrationNegativeIncorrectEmailTest(String pass){
        ellos.header.goToLoginPage();

        ellos.loginPage.fillRegistrationEmailField("aaa");
        ellos.loginPage.fillRepeatRegistrationEmailField("aaa");
        ellos.loginPage.fillRegistrationPasswordField(pass);
        ellos.loginPage.fillRepeatRegistrationPasswordField(pass);
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.clickRegisterSubmitButton();

        assertTrue(ellos.loginPage.checkIncorrectEmailError());
    }

    /*
    * Email length larger then 60 chars
    * */
    @Test
    @Parameters({"longString", "pass"})
    public void registrationNegativeLongEmailTest(String longString, String pass){
        ellos.header.goToLoginPage();

        ellos.loginPage.fillRegistrationEmailField(longString);
        ellos.loginPage.fillRepeatRegistrationEmailField(longString);
        ellos.loginPage.fillRegistrationPasswordField(pass);
        ellos.loginPage.fillRepeatRegistrationPasswordField(pass);
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.clickRegisterSubmitButton();

        assertTrue(ellos.loginPage.checkIncorrectEmailError());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativeEmailsDontMatchTest(String email, String pass){
        ellos.header.goToLoginPage();

        ellos.loginPage.fillRegistrationEmailField("aaa" + email);
        ellos.loginPage.fillRepeatRegistrationEmailField(email);
        ellos.loginPage.fillRegistrationPasswordField(pass);
        ellos.loginPage.fillRepeatRegistrationPasswordField(pass);

        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.clickRegisterSubmitButton();

        assertTrue(ellos.loginPage.checkEmailsDontMatchError());
    }

    @Test
    @Parameters({ "email" })
    public void registrationNegativeShortPasswordTest(String email){
        ellos.header.goToLoginPage();

        ellos.loginPage.fillRegistrationEmailField(email);
        ellos.loginPage.fillRepeatRegistrationEmailField(email);
        ellos.loginPage.fillRegistrationPasswordField("1");
        ellos.loginPage.fillRepeatRegistrationPasswordField("1");
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.clickRegisterSubmitButton();

        assertTrue(ellos.loginPage.checkShortPasswordError());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativePasswordsDontMatchTest(String email, String pass){
        ellos.header.goToLoginPage();

        ellos.loginPage.fillRegistrationEmailField(email);
        ellos.loginPage.fillRepeatRegistrationEmailField(email);
        ellos.loginPage.fillRegistrationPasswordField(pass);
        ellos.loginPage.fillRepeatRegistrationPasswordField("aaa" + pass);
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.clickRegisterSubmitButton();

        assertTrue(ellos.loginPage.checkPasswordsDontMatchError());
    }

}
