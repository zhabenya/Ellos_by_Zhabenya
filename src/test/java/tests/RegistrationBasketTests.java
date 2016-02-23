package tests;

import data.UserData;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * Created by zhabenya on 16.02.16.
 */
public class RegistrationBasketTests extends ClassFixture {

    /*@BeforeMethod
    public void setUp() {
        ellos.mainPage.goToBasketRegistrationPage();
    }*/

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketPositiveTest(String email, String password) {
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
        ellos.loginPage.clickRegisterButton();

        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Johns");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.checkoutPage.checkAtCheckoutPage());

        ellos.checkoutPage.goToMainPage();
        ellos.header.logout();
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketPositiveEmptyMobileTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Jones");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("");
        ellos.loginPage.uncheckReceivePackageMessages();
        ellos.loginPage.uncheckReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.basketPage.checkAtBasketPage());

        ellos.header.logout();
    }

    @Test
    @Parameters({"email", "pass"})
    public void registrationBasketNegativeRegisteredEmailTest(String email, String password){
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Johns");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkEmailRegisteredError());
    }

    @Test
    @Parameters({"email", "pass"})
    public void registrationBasketNegativeIncorrectEmailTest(String email, String password){
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail("   " + email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Johns");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkBasketIncorrectEmailError());
    }

    @Test
    @Parameters({"pass"})
    public void registrationBasketNegativeShortEmailTest(String password){
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail("aaa");
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Johns");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkBasketShortEmailError());
    }
    //TODO when input email with special characters $* error Incorrect password (Felaktigt användarnamn)

    //TODO
    @Test
//            (enabled = false)
    public void registrationBasketNegativeBlankFieldsTest() {
//        ellos.loginPage.goToSubmitButton();
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail("");
        ellos.loginPage.fillRegistrationPassword("");
        ellos.loginPage.fillName("");
        ellos.loginPage.fillLastName("");
        ellos.loginPage.fillAddress("");
        ellos.loginPage.fillZip("");
        ellos.loginPage.fillCity("");
        ellos.loginPage.fillMobile("");
        ellos.loginPage.submitRegistrationForm();
        //submit by enter
        assertTrue(ellos.loginPage.checkEmptyFieldsError());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeBlankEmailTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail("", email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Johns");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkEmptyEmailField());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeEmailsDontMatchTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email, "aaa" + email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Johns");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkEmptyRepeatEmailField());
    }

    @Test
    @Parameters({"longString", "pass"})
    public void registrationBasketNegativeLongEmailsTest(String longString, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(longString);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Johns");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkBasketLongEmailsError());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeBlankPasswordTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword("", password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Johns");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkEmptyPassField());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeBlankRepeatPasswordTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password, "");
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Johns");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkEmptyRepeatPassField());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativePasswordsDontMatchTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password, "11" + password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Johns");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkPasswordsDontMatch());
    }

    @Test
    @Parameters({"email"})
    public void registrationBasketNegativeShortPasswordTest(String email) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword("11");
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Johns");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkShortPassword());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeBlankNameTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("");
        ellos.loginPage.fillLastName("Johns");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkEmptyNameField());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeIncorrectNameTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("1111");
        ellos.loginPage.fillLastName("Johns");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkIncorrectName());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeBlankLastNameTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkEmptyLastNameField());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeIncorrectLastNameTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("111");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkIncorrectLastName());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeBlankAddressTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Jones");
        ellos.loginPage.fillAddress("");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkEmptyAddressField());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeIncorrectAddressTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Jones");
        ellos.loginPage.fillAddress("1111");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkIncorrectAddress());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeBlankPostCodeTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Jones");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkPostCodeError());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeIncorrectPostCodeTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Jones");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("hello");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkPostCodeError());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeBlankCityTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Jones");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkEmptyCityError());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeIncorrectCityTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Jones");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("1111");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkCityError());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeBlankMobileTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Jones");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkMobileError());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeIncorrectMobileTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Jones");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("phone");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkMobileError());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeNotCheckedNotificationTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Jones");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.acceptTerms();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkNotificationError());
    }

    @Test(dataProviderClass = UserData.class, dataProvider = "users")
    public void registrationBasketNegativeNotCheckedAgreementTest(String email, String password) {
        ellos.mainPage.goToBasketRegistrationPage();
        ellos.loginPage.fillRegistrationEmail(email);
        ellos.loginPage.fillRegistrationPassword(password);
        ellos.loginPage.fillName("Jane");
        ellos.loginPage.fillLastName("Jones");
        ellos.loginPage.fillAddress("Street 1");
        ellos.loginPage.fillZip("181 50");
        ellos.loginPage.fillCity("Stockholm");
        ellos.loginPage.fillMobile("0702505933");
        ellos.loginPage.checkReceivePackageMessages();
        ellos.loginPage.checkReceiveOfferMessages();
        ellos.loginPage.uncheckNewsletters();
        ellos.loginPage.submitRegistrationForm();
        assertTrue(ellos.loginPage.checkAgreementError());
    }

}
