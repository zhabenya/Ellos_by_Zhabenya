import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by zhabenya on 19.01.16.
 */
public class LoginPage {

    WebDriver driver;
    WebElementsActions web;
    Logger log = Logger.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }

    private void fillPassword(String passInput, String passField, String pass) {
        try {
            web.clickElement(passInput);
            web.fillField(passField, pass);
            log.info("Fill password field");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clickButton(String buttonLocator, String message) {
        try {
            web.moveDownPage();
            web.clickElement(buttonLocator);
            log.info(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkEmptyFieldError(String messageLocator, String errorMessage, String logMessage) {
        boolean res = false;
        try {
            res = web.getElementText(messageLocator).contains(errorMessage);
            log.info(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    private boolean checkRegistrationError(String errorText, String message) {
        boolean res = false;
        try {
            res = web.getElementText("RegistrationError").contains(errorText);
            log.info(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void fillLoginEmailField(String email) {
        try {
            web.fillField("LoginEmailInput", email);
            log.info("Fill email field");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fillLoginPasswordField(String pass) {
        fillPassword("LoginPassField", "LoginPassInput", pass);
    }

    public void clickLoginButton() {
        clickButton("LoginSubmitButton", "Click login button");
    }

    public boolean checkLoggedIn() {
        boolean res = false;
        try {
            res = web.isElementPresent("LogoutButton");
            log.info("See logout element");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean checkLoginError() {
        boolean res = false;
        try {
            res = web.isElementPresent("LoginErrorMessage");
            log.info("See login error");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean checkLoginEmptyEmailFieldError() {
        return checkEmptyFieldError("LoginEmptyFieldsError", "Måste ange ett användarnamn.", "See empty email error");
    }

    public boolean checkLoginEmptyPasswordFieldError() {
        return checkEmptyFieldError("LoginEmptyFieldsError", "Måste ange ett lösenord.", "See empty password error");
    }

    public void fillRegistrationEmailField(String email) {
        try {
            web.fillField("RegistrationEmailInput", email);
            log.info("Fill email field");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fillRepeatRegistrationEmailField(String email) {
        try {
            web.fillField("RepeatEmailInput", email);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fillRegistrationPasswordField(String pass) {
        fillPassword("RegistrationPassInput", "RegistrationPassField", pass);
    }

    public void fillRepeatRegistrationPasswordField(String pass) {
        fillPassword("RepeatPassInput", "RepeatPassField", pass);
    }

    public void uncheckNewsletters() {
        try {
            web.selectCheckbox("NewsletterCheckbox");
            log.info("Uncheck newsletters");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickRegisterButton() {
        clickButton("RegistrationSubmitButton", "Click register button");
    }

    public boolean checkRegistered() {
        boolean res = false;
        try {
            res = web.isElementPresent("SuccessfulRegistrationElement");
            log.info("Registration is Successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean checkRegistrationEmptyEmailError() {
        return checkEmptyFieldError("RegistrationEmptyFieldsError", "Vänligen kontrollera stavningen", "See empty email error");
    }

    public boolean checkRegistrationEmptyRepeatEmailError() {
        return checkEmptyFieldError("RegistrationEmptyFieldsError", "Bekräfta e-post", "See empty repeat email error");
    }

    public boolean checkRegistrationEmptyPassError() {
        return checkEmptyFieldError("RegistrationEmptyFieldsError", "Du har inte valt ett lösenord", "See empty password error");
    }

    public boolean checkRegistrationEmptyRepeatPassError() {
        return checkEmptyFieldError("RegistrationEmptyFieldsError", "Bekräfta lösenord", "See empty repeat password error");
    }

    public boolean checkUserExistsError() {
        return checkRegistrationError("E-postadressen är redan registerad.", "See email already registered error");
    }

    public boolean checkIncorrectEmailError() {
        return checkRegistrationError("Felaktig e-postadress", "See incorrect email error");
    }

    public boolean checkEmailsDontMatchError() {
        return checkRegistrationError("E-post och bekräfta e-post överensstämmer inte", "See emails don't match error");
    }

    public boolean checkShortPasswordError() {
        return checkRegistrationError("Lösenordet måste innehålla minst 4 tecken.", "See short password error");
    }

    public boolean checkPasswordsDontMatchError() {
        return checkRegistrationError("Lösenord och bekräfta lösenord överensstämmer inte", "See passwords don't match error");
    }

}
