package tests;

import data.UserData;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by zhabenya on 19.01.16.
 */

public class RegistrationTests extends ClassFixture {

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationPositiveTest(String email, String pass){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(email);
        loginPage.fillRepeatRegistrationEmailField(email);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkRegistered());
        header.logout();
        assertTrue(loginPage.checkLoggedOut());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativeEmptyEmailTest(String email, String pass){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField("");
        loginPage.fillRepeatRegistrationEmailField(email);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkRegistrationEmptyEmailError());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativeEmptyRepeatEmailTest(String email, String pass){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(email);
        loginPage.fillRepeatRegistrationEmailField("");
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkRegistrationEmptyRepeatEmailError());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativeEmptyPasswordTest(String email, String pass){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(email);
        loginPage.fillRepeatRegistrationEmailField(email);
        loginPage.fillRegistrationPasswordField("");
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkRegistrationEmptyPassError());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativeEmptyRepeatPasswordTest(String email, String pass){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(email);
        loginPage.fillRepeatRegistrationEmailField(email);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField("");
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkRegistrationEmptyRepeatPassError());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativeExistingEmailTest(String email, String pass){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(email);
        loginPage.fillRepeatRegistrationEmailField(email);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkUserExistsError());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativeExistingEmailSubmitByEnterTest(String email, String pass){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(email);
        loginPage.fillRepeatRegistrationEmailField(email);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.submitRegistrationFormByEnter();

        assertTrue(loginPage.checkUserExistsError());
    }

    @Test
    @Parameters({ "pass" })
    public void registrationNegativeIncorrectEmailTest(String pass){
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
    @Parameters({"longString", "pass"})
    public void registrationNegativeLongEmailTest(String longString, String pass){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(longString);
        loginPage.fillRepeatRegistrationEmailField(longString);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkIncorrectEmailError());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativeEmailsDontMatchTest(String email, String pass){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField("aaa" + email);
        loginPage.fillRepeatRegistrationEmailField(email);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkEmailsDontMatchError());
    }

    @Test
    @Parameters({ "email" })
    public void registrationNegativeShortPasswordTest(String email){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(email);
        loginPage.fillRepeatRegistrationEmailField(email);
        loginPage.fillRegistrationPasswordField("1");
        loginPage.fillRepeatRegistrationPasswordField("1");
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkShortPasswordError());
    }

    @Test
    @Parameters({ "email", "pass" })
    public void registrationNegativePasswordsDontMatchTest(String email, String pass){
        header.goToLoginPage();

        loginPage.fillRegistrationEmailField(email);
        loginPage.fillRepeatRegistrationEmailField(email);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField("aaa" + pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkPasswordsDontMatchError());
    }

}
