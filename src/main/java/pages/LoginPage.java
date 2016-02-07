package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.WebElementsActions;

/**
 * Created by zhabenya on 19.01.16.
 */
public class LoginPage {

    WebDriver driver;
    WebElementsActions web;
    private static final Logger LOG = Logger.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }

    /*private void fillPassword(String passInput, String passField, String pass) {
//        web.clickElement(passInput);
        web.fillField(passInput, pass);
        LOG.info("Fill password field");
    }*/

    public boolean checkAtLoginPage(){
        return web.checkAtPage("LoginAndRegistration");
    }

    private boolean checkError(String messageLocator, String errorMessage, String logMessage) {
        if (web.getElementText(messageLocator).contains(errorMessage)) {
            LOG.info(logMessage + " in " + messageLocator);
            return true;
        }
        return false;
    }

    public void fillLoginEmailField(String email) {
        String locator = "LoginEmailInput";
        web.clearAndFillField(locator, email);
//        LOG.info("Fill email field " + locator);
    }

    public void fillLoginPasswordField(String pass) {
//        fillPassword("LoginPassField", "LoginPassInput", pass);
        String locator = "LoginPassField";
        web.fillField(locator, pass);
//        LOG.info("Fill login password field " + locator);
    }

    public void clickLoginButton() {
        web.clickButton("LoginSubmitButton");
    }

    public boolean checkLoggedIn() {
        String locator = "LogoutButton";
        if (web.isElementPresent(locator)) {
            LOG.info("Logged in successfully " + locator);
            return true;
        }
        return false;
    }

    public boolean checkLoggedOut() {
        String locator = "LoginPageLink";
        if (web.isElementPresent(locator)) {
            LOG.info("Logged out successfully " + locator);
            return true;
        }
        return false;
    }

    public boolean checkLoginError() {
        String locator = "LoginErrorMessage";
        if (web.isElementPresent(locator)) {
            LOG.info("See login error " + locator);
            return true;
        }
        return false;
    }

    public boolean checkLoginEmptyEmailFieldError() {
        return checkError("LoginEmptyFieldsError", "Måste ange ett användarnamn.", "See empty email error");
    }

    public boolean checkLoginEmptyPasswordFieldError() {
        return checkError("LoginEmptyFieldsError", "Måste ange ett lösenord.", "See empty password error");
    }

    public boolean checkLoginEmptyFieldsError() {
        return checkLoginEmptyEmailFieldError() && checkLoginEmptyPasswordFieldError();
    }

    public void fillRegistrationEmailField(String email) {
        String locator = "RegistrationEmailInput";
        web.clearAndFillField(locator, email);
//        LOG.info("Fill email field " + locator);
    }

    public void fillRepeatRegistrationEmailField(String email) {
        String locator = "RepeatEmailInput";
        web.clearAndFillField(locator, email);
//        LOG.info("Fill repeat email field " + locator);
    }

    public void fillRegistrationPasswordField(String pass) {
        String locator = "RegistrationPassInput";
        web.fillField(locator, pass);
//        LOG.info("Fill password field " + locator);
    }

    public void fillRepeatRegistrationPasswordField(String pass) {
        String locator = "RepeatPassInput";
        web.fillField(locator, pass);
//        LOG.info("Fill repeat password field " + locator);
    }

    public void uncheckNewsletters() {
        String locator = "NewsletterCheckbox";
        web.selectCheckbox(locator);
//        LOG.info("Uncheck newsletters " + locator);
    }

    public void clickRegisterButton() {
        web.clickButton("RegistrationSubmitButton");
    }

    public boolean checkRegistered() {
        if (web.isElementPresent("SuccessfulRegistrationElement")) {
            LOG.info("Registration is Successful");
            return true;
        }
        return false;
    }

    public boolean checkRegistrationEmptyEmailError() {
        return checkError("RegistrationEmptyFieldsError", "Vänligen kontrollera stavningen", "See empty email error");
    }

    public boolean checkRegistrationEmptyRepeatEmailError() {
        return checkError("RegistrationEmptyFieldsError", "Bekräfta e-post", "See empty repeat email error");
    }

    public boolean checkRegistrationEmptyPassError() {
        return checkError("RegistrationEmptyFieldsError", "Du har inte valt ett lösenord", "See empty password error");
    }

    public boolean checkRegistrationEmptyRepeatPassError() {
        return checkError("RegistrationEmptyFieldsError", "Bekräfta lösenord", "See empty repeat password error");
    }

    public boolean checkUserExistsError() {
        return checkError("RegistrationError", "E-postadressen är redan registerad.", "See email already registered error");
    }

    public boolean checkIncorrectEmailError() {
        return checkError("RegistrationError", "Felaktig e-postadress", "See incorrect email error");
    }

    public boolean checkEmailsDontMatchError() {
        return checkError("RegistrationError", "E-post och bekräfta e-post överensstämmer inte", "See emails don't match error");
    }

    public boolean checkShortPasswordError() {
        return checkError("RegistrationError", "Lösenordet måste innehålla minst 4 tecken.", "See short password error");
    }

    public boolean checkPasswordsDontMatchError() {
        return checkError("RegistrationError", "Lösenord och bekräfta lösenord överensstämmer inte", "See passwords don't match error");
    }

    public void submitLoginFormByEnter() {
        web.submitByEnter("LoginPassInput");
//        LOG.info("Clicked ENTER");
    }

    public void submitRegistrationFormByEnter() {
        web.submitByEnter("RegistrationPassField");
//        LOG.info("Clicked ENTER");
    }
}
