package pages;

import utils.WebDriverWrapper;

/**
 * Created by zhabenya on 13.02.16.
 */
public class Ellos {

    public Header header;
    public MainPage mainPage;
    public LoginPage loginPage;
    public ProductListPage productListPage;
    public ProductPage productPage;
    public BasketPage basketPage;
    public CheckoutPage checkoutPage;
    //public MyCabinetPage mycabinetPage;
    //public ScreenShotMaker screenShotMaker;
    //public Mock mock;

    public Ellos(WebDriverWrapper driver) {
        header = new Header(driver);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        productListPage = new ProductListPage(driver);
        productPage = new ProductPage(driver);
        basketPage = new BasketPage(driver);
        checkoutPage = new CheckoutPage(driver);
        //mycabinetPage = new MyCabinetPage(driver);

        //screenShotMaker = new ScreenShotMaker(driver);
        //mock = new Mock(driver);
    }

}
