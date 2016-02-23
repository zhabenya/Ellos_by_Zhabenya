package pages;

import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

/**
 * Created by zhabenya on 19.01.16.
 */
public class LoginPage extends Page {

    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public LoginPage(WebDriverWrapper driver) {
        super(driver);
    }

    public boolean checkAtLoginPage() {
        return checkAtPage("LoginAndRegistration");
    }

    private boolean checkError(String messageLocator, String errorMessage, String logMessage) {
        if (web.getElementText(messageLocator).contains(errorMessage)) {
            LOG.info(logMessage + " in " + messageLocator);
            return true;
        }
        return false;
    }

    public void fillLoginEmailField(String email) {
        web.clearAndFillField("LoginEmailInput", email);
    }

    public void fillLoginPasswordField(String pass) {
        web.fillField("LoginPassField", pass);
    }

    public void clickLoginButton() {
        web.clickElement("LoginSubmitButton");
    }

    public boolean checkLoggedIn() {
        if (web.isElementPresent("LogoutButton")) {
            LOG.info("Logged in successfully");
            return true;
        }
        return false;
    }

    public boolean checkLoggedOut() {
        if (web.isElementPresent("LoginPageLink")) {
            LOG.info("Logged out successfully");
            return true;
        }
        return false;
    }

    public boolean checkLoginError() {
        if (web.isElementPresent("LoginErrorMessage")) {
            LOG.info("See login error message");
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
        web.clearAndFillField("RegistrationEmailInput", email);
    }

    public void fillRepeatRegistrationEmailField(String email) {
        web.clearAndFillField("RepeatEmailInput", email);
    }

    public void fillRegistrationPasswordField(String pass) {
        web.fillField("RegistrationPassInput", pass);
    }

    public void fillRepeatRegistrationPasswordField(String pass) {
        web.fillField("RepeatPassInput", pass);
    }

    public void uncheckNewsletters() {
        moveDownPage();
        web.selectCheckbox("NewsletterCheckbox");
    }

    public void clickRegisterSubmitButton() {
        web.clickElement("RegistrationSubmitButton");
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

    public boolean checkLongEmailsError() {
        return checkError("RegistrationError", "E-post adressen får max vara 60 tecken lång", "See long emails error");
    }

    public boolean checkShortPasswordError() {
        return checkError("RegistrationError", "Lösenordet måste innehålla minst 4 tecken.", "See short password error");
    }

    public boolean checkPasswordsDontMatchError() {
        return checkError("RegistrationError", "Lösenord och bekräfta lösenord överensstämmer inte", "See passwords don't match error");
    }

    public void submitLoginFormByEnter() {
        web.submitByEnter("LoginPassInput");
    }

    public void submitRegistrationFormByEnter() {
        web.submitByEnter("RegistrationPassField");
    }

    public boolean checkLoggedEmail(String email) {
        if (email.equals(web.getElementText("LoggedEmail"))) {
            LOG.info("Logged successfully");
            return true;
        }
        return false;
    }

    public void clickRegisterButton() {
        web.clickElement("RegisterButton");
    }

    public void fillRegistrationEmail(String email) {
        web.fillField("RegisterEmailInput", email);
        web.fillField("ConfirmEmailInput", email);
    }

    public void fillRegistrationEmail(String email1, String email2) {
        web.fillField("RegisterEmailInput", email1);
        web.fillField("ConfirmEmailInput", email2);
    }

    public void fillRegistrationPassword(String pass) {
        web.fillField("RegisterPassInput", pass);
        web.fillField("ConfirmPassInput", pass);
    }

    public void fillRegistrationPassword(String pass1, String pass2) {
        web.fillField("RegisterPassInput", pass1);
        web.fillField("ConfirmPassInput", pass2);
    }

    public void fillName(String name) {
        web.fillField("NameInput", name);
    }

    public void fillLastName(String name) {
        web.fillField("LastNameInput", name);
    }

    public void fillAddress(String address) {
        web.fillField("AddressInput", address);
    }

    public void fillZip(String zip) {
        web.fillField("ZipInput", zip);
    }

    public void fillCity(String city) {
        web.fillField("CityInput", city);
    }

    public void fillMobile(String number) {
        web.fillField("MobileInput", number);
//        moveDownPage();
    }

    public void checkReceivePackageMessages() {
        moveDownPage();
        web.clickElement("ReceivePackageSmsYesButton");
    }

    public void uncheckReceivePackageMessages() {
        moveDownPage();
        web.clickElement("ReceivePackageSmsNoButton");
    }

    public void checkReceiveOfferMessages() {
        moveDownPage();
        web.clickElement("ReceiveOfferSmsYesButton");
    }

    public void uncheckReceiveOfferMessages() {
        moveDownPage();
        web.clickElement("ReceiveOfferSmsNoButton");
    }

    public void acceptTerms() {
        moveDownPage();
        web.clickElement("AcceptTermsCheckbox");
    }

    public void submitRegistrationForm() {
//        moveDownPage();
        web.clickElement("ContinueButton");
    }

    public boolean checkEmailRegisteredError(){
        return checkError("ErrorFrame", "E-postadressen är redan registerad.", "See email already registered error");
    }

    public boolean checkBasketIncorrectEmailError(){
        return checkError("ErrorFrame", "Vänligen kontrollera stavningen i din e-postadress och försök igen.", "See incorrect email error");
    }

    public boolean checkBasketShortEmailError(){
        return checkError("ErrorFrame", "E-postadressen måste innehålla minst 4 tecken.", "See short email error");
    }

    public boolean checkEmptyFieldsError() {
        return checkEmptyEmailField() && checkEmptyRepeatEmailField() && checkEmptyPassField() &&
                checkEmptyRepeatPassField() && checkEmptyNameField() && checkEmptyLastNameField() &&
                checkEmptyAddressField() && checkEmptyPostCodeError() && checkCityError() &&
                checkMobileError() && checkNotificationError() && checkAgreementError();
    }

    public boolean checkEmptyEmailField() {
        return checkError("ErrorFrame", "Du måste ange en e-postadress", "See empty email error");
    }

    public boolean checkEmptyRepeatEmailField() {
        return checkError("ErrorFrame", "E-postadresserna stämmer inte överens", "See emails don't match error");
    }

    public boolean checkBasketLongEmailsError() {
        return checkError("ErrorFrame", "E-post adressen får max vara 60 tecken lång", "See long emails error");
    }

    public boolean checkEmptyPassField() {
        return checkError("ErrorFrame", "Du har inte valt ett lösenord.", "See empty pass error");
    }

    public boolean checkEmptyRepeatPassField() {
        return checkError("ErrorFrame", "Du måste upprepa lösenordet", "See empty repeat pass error");
    }

    public boolean checkPasswordsDontMatch(){
        return checkError("ErrorFrame", "Det upprepande lösenordet stämmer inte överens med det första lösenordet.", "See passwords don't match error");
    }

    public boolean checkShortPassword(){
        return checkError("ErrorFrame", "Lösenordet måste innehålla minst 4 tecken.", "See short password error");
    }

    public boolean checkEmptyNameField() {
        return checkError("ErrorFrame", "Förnamn ej ifyllt.", "See empty name error");
    }

    public boolean checkIncorrectName() {
        return checkError("ErrorFrame", "Fel i förnamnet.", "See incorrect name error");
    }

    public boolean checkEmptyLastNameField() {
        return checkError("ErrorFrame", "Efternamn ej ifyllt", "See empty last name error");
    }

    public boolean checkIncorrectLastName() {
        return checkError("ErrorFrame", "Fel i efternamnet", "See incorrect name error");
    }

    public boolean checkEmptyAddressField() {
        return checkError("ErrorFrame", "Adress ej ifyllt", "See empty address error");
    }

    public boolean checkIncorrectAddress() {
        return checkError("ErrorFrame", "Fel i adressen", "See incorrect address error");
    }

    public boolean checkEmptyPostCodeError() {
        System.out.println(web.getElementText("ErrorFrame"));
        return checkError("ErrorFrame", "Postnummer ej ifyllt", "See postcode error");
    }

    public boolean checkPostCodeError() {
        return checkError("ErrorFrame", "Fel i postnumret", "See postcode error");
    }

    public boolean checkEmptyCityError() {
        return checkError("ErrorFrame", "Postadress ej ifyllt.", "See empty city error");
    }

    public boolean checkCityError() {
        return checkError("ErrorFrame", "Fel i postadressen", "See empty city error");
    }

    public boolean checkMobileError() {
        return checkError("ErrorFrame", "För att vi skall kunna ge dig avisering eller erbjudanden via SMS behöver vi ditt mobilnummer.", "See empty mobile number field");
    }

    public boolean checkNotificationError() {
        return checkError("ErrorFrame", "Du måste välja Ja eller Nej till paketavisering via SMS", "See package notification not selected");
    }

    public boolean checkAgreementError() {
        return checkError("ErrorFrame", "Du måste godkänna Ellos köpvillkor innan du kan gå vidare.", "See agreement not accepted");
    }

    public void goToSubmitButton() {
        moveDownPage();
        moveDownPage();
        web.waitForElementVisible("ContinueButton", 5);
//        movePageWithSpace();
    }
}
