package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by zhabenya on 27.01.16.
 */
@Test
public class ClassFixture extends BrowserFixture {

    protected static LoginPage loginPage;
    protected static Header header;


    @BeforeClass
    public static void setUpClass() throws Exception {
        header = new Header(driver);
        loginPage = new LoginPage(driver);

        header.clickLogo();
    }
}
