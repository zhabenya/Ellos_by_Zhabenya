package pages;

import data.Product;
import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

import static java.lang.Integer.parseInt;
import static org.testng.Assert.assertTrue;

/**
 * Created by zhabenya on 27.01.16.
 */
public class ProductPage extends Page {

    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public ProductPage(WebDriverWrapper driver) {
        super(driver);
    }

    public static Integer parsePrice(String priceText) {
        priceText = priceText.replaceAll("\\D+","");;
        return parseInt(priceText);
    }

    public void checkProductInfo(Product product) {
        String name = web.getElementText("ProductName");
        assertTrue(name.equalsIgnoreCase(product.getName()));
        Integer price = parsePrice(web.getElementText("ProductPrice"));
        assertTrue(price == product.getPrice());
        String currency = web.getElementText("ProductCurrency");
        assertTrue(currency.equalsIgnoreCase(product.getCurrency()));
    }

    public Product addProductInfo(Product product){
        product.setId(web.getElementText("ProductId"));
        product.setColor(web.getElementText("ProductColor"));
        product.setSize(web.getElementText("ProductSize"));
        product.setPrice(parsePrice(web.getElementText("ProductPrice")));

        return product;
    }

    public void clickAddToCartButton() {
        web.clickElement("AddToBasketButton");
    }

    public boolean checkSizeNotSelectedError() {
        if (web.isElementPresent("SizeNotSelectedError")) {
            LOG.info("See Size not selected error ");
            return true;
        }
        return false;
    }

    public void scrollToFields() {
        moveDownPage();
        moveDownPage();
    }

    public void goToTabs() {
        movePageWithSpace();
    }

    public void selectColor() {
        web.clickElement("ColorDropdown");
        web.clickElement("FirstColor");
    }

    public void selectSize() {
        web.clickElement("SizeDropdown");
        web.clickElement("FirstSize");
        LOG.info("Selected size " + web.getElementText("FirstSize"));
    }

    public boolean checkItemAddedToBasket(Product product) {
        addProductInfo(product);
        web.waitForElementVisible("CartCount", 15);
        if (web.isElementPresent("CartCount")) {
            checkCartCorrectInfo(product);
            LOG.info("Item added to cart successfully");
            return true;
        }
        return false;
    }

    public void checkCartCorrectInfo(Product product){
        web.clickElement("CartContent");
//        TODO: Klänning i geo... - wtf???

//        System.out.println(web.getElementText("CartProductTitle") + "\n" + product.getName() );
//        assertTrue(web.getElementText("CartProductTitle").equalsIgnoreCase(product.getName()));
        assertTrue(checkCartProductSize(product));

        System.out.println(parsePrice(web.getElementText("CartProductPrice")) + "//////////"+ product.getPrice());
        assertTrue(parsePrice(web.getElementText("CartProductPrice")) == product.getPrice());
        System.out.println("price");
        assertTrue(web.getElementText("CartProductCurrency").equalsIgnoreCase(product.getCurrency()));
        LOG.info("Item added with correct info");
    }

    private boolean checkCartProductSize(Product product) {
        String size = web.getElementText("CartProductSize");
//        System.out.println(size + "/////////" + product.getSize());
        if (size.contains(product.getSize())){
            product.setSize(size);
            return true;
        }
        return false;
    }

    public void addToWishList() {
        moveDownPage();
        web.clickElement("AddToWishListButton");
    }

    public boolean checkItemAddedToWishList() {
        web.waitForElementVisible("WishListConfirmation", 15);
        if (web.isElementPresent("WishListConfirmation")) {
            LOG.info("Item added to wish list successfully");
            return true;
        }
        return false;
    }

    public void clickDescriptionTab() {
        web.clickElement("DescriptionTab");
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
        if (web.isElementPresent("ShowMoreElement")) {
            web.clickElement("ShowMoreElement");
        }
    }

    public void clickRatingLink() {
        web.clickElement("RatingLink");
    }

    public void clickImage() {
        web.clickElement("Image");
    }

    public boolean checkFullImage() {
        web.waitForElementVisible("FullImage", 15);
        if (web.isElementPresent("FullImage")) {
            LOG.info("FullImage" + " is shown");
            return true;
        }
        return false;
    }

    public void closeFullImage() {
        web.clickElement("CloseFullImageButton");
        web.waitForElementNotVisible("FullImage", 10);
    }

    public void clickWriteReviewButton() {
        web.clickElement("WriteReviewButton");
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
        web.clickElement("BasketButton");
    }

    public boolean checkTabs() {
        return checkDescriptionTabEnabled() &&
                checkRatingTabEnabled() &&
                checkDeliveryTabEnabled() && checkSizeguideTabEnabled();
    }

}
