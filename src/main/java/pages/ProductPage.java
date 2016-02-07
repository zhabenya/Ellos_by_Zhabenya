package pages;

import data.Product;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.WebElementsActions;

import static java.lang.Integer.parseInt;
import static org.testng.Assert.assertTrue;

/**
 * Created by zhabenya on 27.01.16.
 */
public class ProductPage {

    WebDriver driver;
    WebElementsActions web;
    private static final Logger LOG = Logger.getLogger(LoginPage.class);
    private Product product;

    public ProductPage(WebDriver driver, Product product) {
        this.driver = driver;
        this.product = product;
        web = new WebElementsActions(driver);
    }

    public static Integer parsePrice(String priceText) {
        priceText = priceText.replaceAll("\\D+","");;
        return parseInt(priceText);
    }

    public void reloadPage() {
        web.refreshPage();
    }

    public void checkProductInfo() {
        String name = web.getElementText("ProductName");
        assertTrue(name.equalsIgnoreCase(product.getName()));
        Integer price = parsePrice(web.getElementText("ProductPrice"));
        assertTrue(price == product.getPrice());
        String currency = web.getElementText("ProductCurrency");
        assertTrue(currency.equalsIgnoreCase(product.getCurrency()));
    }

    public void addProductInfo(){
        product.setId(web.getElementText("ProductId"));
        product.setColor(web.getElementText("ProductColor"));
        product.setSize(parseInt(web.getElementText("ProductSize")));
    }

    public void clickAddToCartButton() {
        String locator = "AddToBasketButton";
        web.clickElement(locator);
//        LOG.info("Click Add to basket button " + locator);
    }

    public boolean checkSizeNotSelectedError() {
        String locator = "SizeNotSelectedError";
        if (web.isElementPresent(locator)) {
            LOG.info("See Size not selected error " + locator);
            return true;
        }
        return false;
    }

    public void scrollToFields() {
//        web.movePageWithSpace("Logo");
        web.moveDownPage();
        web.moveDownPage();
    }

    public void goToTabs() {
        web.movePageWithSpace("Logo");
    }

    public void selectColor() {
        web.clickElement("ColorDropdown");
        String locator = "FirstColor";
        web.clickElement(locator);
//        LOG.info("Selected color " + web.getElementText(locator));
    }

    public void selectSize() {
        web.clickElement("SizeDropdown");
        String locator = "FirstSize";
        web.clickElement(locator);
        LOG.info("Selected size " + web.getElementText(locator));
    }

    public boolean checkItemAddedToBasket() {
        addProductInfo();
        String locator = "CartCount";
        web.waitForElementVisible(locator, 15);
        if (web.isElementPresent(locator) && checkCartCorrectInfo()) {
            LOG.info("Item added to cart successfully");
            return true;
        }
        return false;
    }

    public boolean checkCartCorrectInfo(){
        web.clickElement("CartContent");
        if (web.getElementText("CartProductTitle").equalsIgnoreCase(product.getName()) &&
                parseInt(web.getElementText("CartProductSize")) == product.getSize() &&
                parsePrice(web.getElementText("CartProductPrice")) == product.getPrice() &&
                web.getElementText("CartProductCurrency").equalsIgnoreCase(product.getCurrency())){
            LOG.info("Item added with correct info");
            return true;
        }
        return false;
    }

    public void addToWishList() {
        web.moveDownPage();
        String locator = "AddToWishListButton";
        web.clickElement(locator);
//        LOG.info("Click Add to basket button " + locator);
    }

    public boolean checkItemAddedToWishList() {
        String locator = "WishListConfirmation";
        web.waitForElementVisible(locator, 15);
        if (web.isElementPresent(locator)) {
            LOG.info("Item added to wish list successfully");
            return true;
        }
        return false;
    }

    public void clickDescriptionTab() {
        web.clickElement("DescriptionTab");
//        LOG.info("Click on " + locator);
    }

    public boolean checkDescriptionTabEnabled() {
        clickDescriptionTab();
        if (web.isElementPresent("DescriptionTabContentActive")) {
            LOG.info("Description tab is enabled");
            return true;
        }
        return false;
    }

    public void clickRatingTab() {
        web.clickElement("RatingTab");
//        LOG.info("Click on " + locator);
    }

    public boolean checkRatingTabEnabled() {
        clickRatingTab();
        if (web.isElementPresent("RatingTabContentActive")) {
            LOG.info("Rating tab is enabled");
            return true;
        }
        return false;
    }

    public void clickDeliveryTab() {
        web.clickElement("DeliveryTab");
//        LOG.info("Click on " + locator);
    }

    public boolean checkDeliveryTabEnabled() {
        clickDeliveryTab();
        if (web.isElementPresent("DeliveryTabContentActive")) {
            LOG.info("Delivery tab is enabled");
            return true;
        }
        return false;
    }

    public void clickSizeguideTab() {
        web.clickElement("SizeguideTab");
//        LOG.info("Click on " + locator);
    }

    public boolean checkSizeguideTabEnabled() {
        clickSizeguideTab();
        if (web.isElementPresent("SizeguideTabContentActive")) {
            LOG.info("Sizeguide tab is enabled");
            return true;
        }
        return false;
    }

    public void clickShowMoreLink() {
        String locator = "ShowMoreElement";
        web.clickElement(locator);
//        LOG.info("Click on " + locator);
    }

    public void clickRatingLink() {
        String locator = "RatingLink";
        web.clickElement(locator);
//        LOG.info("Click on " + locator);
    }

    public void clickImage() {
        String locator = "Image";
        web.clickElement(locator);
//        web.moveToElementAndClick("Image", "ShowImageButton");
//        LOG.info("Click on " + locator);
    }

    public boolean checkFullImage() {
        String locator = "FullImage";
        web.waitForElementVisible(locator, 15);
        if (web.isElementPresent(locator)) {
            LOG.info(locator + " is shown");
            return true;
        }
        return false;
    }

    public void closeFullImage() {
        web.clickElement("CloseFullImageButton");
        web.waitForElementNotVisible("FullImage", 10);
    }

    public void clickWriteReviewButton() {
        String locator = "WriteReviewButton";
        web.clickElement(locator);
//        LOG.info("Click on " + locator);
    }

    public boolean checkReviewFormEnabled() {
        String locator = "ReviewForm";
        web.waitForElementVisible(locator, 15);
        if (web.isElementPresent(locator)) {
            LOG.info(locator + " is enabled");
            return true;
        }
        return false;
    }

    public void goToBasketPage() {
        String locator = "BasketButton";
        web.clickElement(locator);
//        LOG.info("Click on " + locator);
    }

    public boolean checkTabs() {
        return checkDescriptionTabEnabled() &&
                checkRatingTabEnabled() &&
                checkDeliveryTabEnabled() && checkSizeguideTabEnabled();
    }

}
