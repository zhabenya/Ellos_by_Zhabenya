package tests.java;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;
import static utils.Generator.generateEmail;

/**
 * Created by zhabenya on 19.01.16.
 */

public class RegistrationTests extends ClassFixture {

    private String myEmail = "rude.zhabenya@gmail.com";
    private String pass = "gr@yBulb40";

    @Test
    public void registrationPositiveTest(){
        header.clickLogo();
        header.goToLoginPage();

        String email = generateEmail();
        loginPage.fillRegistrationEmailField(email);
        loginPage.fillRepeatRegistrationEmailField(email);
        loginPage.fillRegistrationPasswordField("12345");
        loginPage.fillRepeatRegistrationPasswordField("12345");
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkRegistered());
        header.logout();
        assertTrue(loginPage.checkLoggedOut());
    }

    @Test
    public void registrationNegativeEmptyEmailTest(){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField("");
        loginPage.fillRepeatRegistrationEmailField(myEmail);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkRegistrationEmptyEmailError());
    }

    @Test
    public void registrationNegativeEmptyRepeatEmailTest(){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(myEmail);
        loginPage.fillRepeatRegistrationEmailField("");
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkRegistrationEmptyRepeatEmailError());
    }

    @Test
    public void registrationNegativeEmptyPasswordTest(){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(myEmail);
        loginPage.fillRepeatRegistrationEmailField(myEmail);
        loginPage.fillRegistrationPasswordField("");
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkRegistrationEmptyPassError());
    }

    @Test
    public void registrationNegativeEmptyRepeatPasswordTest(){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(myEmail);
        loginPage.fillRepeatRegistrationEmailField(myEmail);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField("");
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkRegistrationEmptyRepeatPassError());
    }

    @Test
    public void registrationNegativeExistingEmailTest(){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(myEmail);
        loginPage.fillRepeatRegistrationEmailField(myEmail);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkUserExistsError());
    }

    @Test
    public void registrationNegativeExistingEmailSubmitByEnterTest(){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(myEmail);
        loginPage.fillRepeatRegistrationEmailField(myEmail);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.submitRegistrationFormByEnter();

        assertTrue(loginPage.checkUserExistsError());
    }

    @Test
    public void registrationNegativeIncorrectEmailTest(){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField("aaa");
        loginPage.fillRepeatRegistrationEmailField("aaa");
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkIncorrectEmailError());
    }

    /*
    * Email length larger then 60 chars
    * */
    @Test
    public void registrationNegativeLongEmailTest(){
        header.goToLoginPage();

        String longString = "vveryveryveryveryveryveryveryveryveryverylongstring";
        loginPage.fillRegistrationEmailField(longString);
        loginPage.fillRepeatRegistrationEmailField(longString);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkIncorrectEmailError());
    }

    @Test
    public void registrationNegativeEmailsDontMatchTest(){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField("aaa" + myEmail);
        loginPage.fillRepeatRegistrationEmailField(myEmail);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkEmailsDontMatchError());
    }

    @Test
    public void registrationNegativeShortPasswordTest(){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(myEmail);
        loginPage.fillRepeatRegistrationEmailField(myEmail);
        loginPage.fillRegistrationPasswordField("1");
        loginPage.fillRepeatRegistrationPasswordField("1");
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkShortPasswordError());
    }

    @Test
    public void registrationNegativePasswordsDontMatchTest(){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(myEmail);
        loginPage.fillRepeatRegistrationEmailField(myEmail);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField("aaa" + pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkPasswordsDontMatchError());
    }

}
