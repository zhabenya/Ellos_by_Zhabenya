import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static utils.Generator.generateEmail;

/**
 * Created by zhabenya on 19.01.16.
 */
public class LoginTests {

    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    Logger log = Logger.getLogger(LoginTests.class);
    private String myEmail = "rude.zhabenya@gmail.com";
    private String pass = "gr@yBulb40";

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        log.info("Browser started");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.ellos.se/");
        System.out.println("Start test");

    }

    @Test
    public void loginPositiveTest(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickLogo();
        mainPage.goToLoginPage();

        loginPage.fillLoginEmailField(myEmail);
        loginPage.fillLoginPasswordField(pass);

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoggedIn());
    }

    @Test
    public void loginNegativeIncorrectEmailTest(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickLogo();
        mainPage.goToLoginPage();

        loginPage.fillLoginEmailField("admin@gmail.com");
        loginPage.fillLoginPasswordField(pass);

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginError());
    }

    @Test
    public void loginNegativeEmptyEmailFieldTest(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickLogo();
        mainPage.goToLoginPage();

        loginPage.fillLoginEmailField("");
        loginPage.fillLoginPasswordField(pass);

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginEmptyEmailFieldError());
    }

    @Test
    public void loginNegativeEmptyPasswordFieldTest(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickLogo();
        mainPage.goToLoginPage();

        loginPage.fillLoginEmailField(myEmail);
        loginPage.fillLoginPasswordField("");

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginEmptyPasswordFieldError());
    }

    @Test
    public void registrationPositiveTest(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickLogo();
        mainPage.goToLoginPage();

        String email = generateEmail();
        loginPage.fillRegistrationEmailField(email);
        loginPage.fillRepeatRegistrationEmailField(email);
        loginPage.fillRegistrationPasswordField("12345");
        loginPage.fillRepeatRegistrationPasswordField("12345");
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkRegistered());
    }

    @Test
    public void registrationNegativeEmptyEmailTest(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickLogo();
        mainPage.goToLoginPage();

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
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickLogo();
        mainPage.goToLoginPage();

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
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickLogo();
        mainPage.goToLoginPage();

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
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickLogo();
        mainPage.goToLoginPage();

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
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickLogo();
        mainPage.goToLoginPage();

        loginPage.fillRegistrationEmailField(myEmail);
        loginPage.fillRepeatRegistrationEmailField(myEmail);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkUserExistsError());
    }

    @Test
    public void registrationNegativeIncorrectEmailTest(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickLogo();
        mainPage.goToLoginPage();

        loginPage.fillRegistrationEmailField("aaa");
        loginPage.fillRepeatRegistrationEmailField("aaa");
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField(pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkIncorrectEmailError());
    }

    @Test
    public void registrationNegativeEmailsDontMatchTest(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickLogo();
        mainPage.goToLoginPage();

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
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickLogo();
        mainPage.goToLoginPage();

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
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickLogo();
        mainPage.goToLoginPage();

        loginPage.fillRegistrationEmailField(myEmail);
        loginPage.fillRepeatRegistrationEmailField(myEmail);
        loginPage.fillRegistrationPasswordField(pass);
        loginPage.fillRepeatRegistrationPasswordField("aaa" + pass);
        loginPage.uncheckNewsletters();
        loginPage.clickRegisterButton();

        assertTrue(loginPage.checkPasswordsDontMatchError());
    }

    @After
    public void tearDown() throws Exception {
        log.info("End test");
        driver.quit();
    }

}
