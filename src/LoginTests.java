import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by zhabenya on 19.01.16.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTests {

    static WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    static Logger log = Logger.getLogger(LoginTests.class);
    private String myEmail = "rude.zhabenya@gmail.com";
    private String pass = "gr@yBulb40";

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        log.info("Browser started");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.ellos.se/");
        System.out.println("Start test");
    }

    @Before
    public void setUpTest() throws Exception {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginPositiveTest(){
        mainPage.clickLogo();
        mainPage.goToLoginPage();

        loginPage.fillLoginEmailField(myEmail);
        loginPage.fillLoginPasswordField(pass);

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoggedIn());
        mainPage.logout();
    }

    @Test
    public void loginNegativeNotRegisteredEmailTest(){
        mainPage.goToLoginPage();

        loginPage.fillLoginEmailField("admin@gmail.com");
        loginPage.fillLoginPasswordField(pass);

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginError());
    }

    @Test
    public void loginNegativeNotRegisteredEmailSubmitByEnterTest(){
        mainPage.goToLoginPage();

        loginPage.fillLoginEmailField("admin@gmail.com");
        loginPage.fillLoginPasswordField(pass);

        loginPage.submitForm();
        assertTrue(loginPage.checkLoginError());
    }

    @Test
    public void loginNegativeEmptyEmailFieldTest(){
        mainPage.goToLoginPage();

        loginPage.fillLoginEmailField("");
        loginPage.fillLoginPasswordField(pass);

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginEmptyEmailFieldError());
    }

    @Test
    public void loginNegativeEmptyPasswordFieldTest(){
        mainPage.goToLoginPage();

        loginPage.fillLoginEmailField(myEmail);
        loginPage.fillLoginPasswordField("");

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginEmptyPasswordFieldError());
    }

    @Test
    public void loginNegativeEmptyFieldsTest(){
        mainPage.goToLoginPage();

        loginPage.fillLoginEmailField("");
        loginPage.fillLoginPasswordField("");

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginEmptyFieldsError());
    }

    @Test
    public void loginNegativeLongInputsTest(){
        mainPage.goToLoginPage();

        String longString = "veryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryverylongstring";
        loginPage.fillLoginEmailField(longString);
        loginPage.fillLoginPasswordField(longString);

        loginPage.clickLoginButton();
        assertTrue(loginPage.checkLoginError());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        log.info("End test");
        driver.quit();
    }

}
