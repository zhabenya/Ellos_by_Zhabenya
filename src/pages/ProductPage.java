package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.WebElementsActions;

/**
 * Created by zhabenya on 27.01.16.
 */
public class ProductPage {

    WebDriver driver;
    WebElementsActions web;
    private static final Logger LOG = Logger.getLogger(LoginPage.class);

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }

    public void reloadPage(){
        web.refreshPage();
    }

    public void clickAddToCartButton() {
        String locator = "AddToBasketButton";
        web.clickElement(locator);
        LOG.info("Click Add to basket button " + locator);
    }

    public boolean checkSizeNotSelectedError() {
        String locator = "SizeNotSelectedError";
        if (web.isElementPresent(locator)){
            LOG.info("See Size not selected error " + locator);
            return true;
        }
        return false;
    }

    public void scrollToFields() {
        web.movePageWithSpace("Logo");
    }

    public void selectColor() {
        web.clickElement("ColorDropdown");
        String locator = "FirstColor";
        web.clickElement(locator);
        LOG.info("Selected color " + web.getElementText(locator));
    }

    public void selectSize() {
        web.clickElement("SizeDropdown");
        String locator = "FirstSize";
        web.clickElement(locator);
        LOG.info("Selected size " + web.getElementText(locator));
    }

    public boolean checkItemAddedToBasket() {
        String locator = "CartCount";
        web.waitForElementVisible(locator, 15);
        if (web.isElementPresent(locator)){
            LOG.info("Item added successfully");
            return true;
        }
        return false;
    }

    public void addToWishList() {
        String locator = "AddToWishListButton";
        web.clickElement(locator);
        LOG.info("Click Add to basket button " + locator);
    }

    public boolean checkItemAddedToWishList() {
        String locator = "WishListConfirmation";
        web.waitForElementVisible(locator, 15);
        if (web.isElementPresent(locator)){
            LOG.info("Item added to wish list successfully");
            return true;
        }
        return false;
    }

    public void clickDescriptionTab() {
        String locator = "DescriptionTab";
        web.clickElement(locator);
        LOG.info("Click on " + locator);
    }

    public boolean isDescriptionTabEnabled() {
        String locator = "DescriptionTabContentActive";
        if (web.isElementPresent(locator)){
            LOG.info("Description tab is enabled");
            return true;
        }
        return false;
    }

    public void clickRatingTab() {
        String locator = "RatingTab";
        web.clickElement(locator);
        LOG.info("Click on " + locator);
    }

    public boolean isRatingTabEnabled() {
        String locator = "RatingTabContentActive";
        if (web.isElementPresent(locator)){
            LOG.info("Rating tab is enabled");
            return true;
        }
        return false;
    }

    public void clickDeliveryTab() {
        String locator = "DeliveryTab";
        web.clickElement(locator);
        LOG.info("Click on " + locator);
    }

    public boolean isDeliveryTabEnabled() {
        String locator = "DeliveryTabContentActive";
        if (web.isElementPresent(locator)){
            LOG.info("Delivery tab is enabled");
            return true;
        }
        return false;
    }

    public void clickSizeguideTab() {
        String locator = "SizeguideTab";
        web.clickElement(locator);
        LOG.info("Click on " + locator);
    }

    public boolean isSizeguideTabEnabled() {
        String locator = "SizeguideTabContentActive";
        if (web.isElementPresent(locator)){
            LOG.info("Sizeguide tab is enabled");
            return true;
        }
        return false;
    }

    public void clickShowMoreLink() {
        String locator = "ShowMoreElement";
        web.clickElement(locator);
        LOG.info("Click on " + locator);
    }

    public void clickRatingLink() {
        String locator = "RatingLink";
        web.clickElement(locator);
        LOG.info("Click on " + locator);
    }

    public void clickImage() {
        String locator = "Image";
        web.clickElement(locator);
        LOG.info("Click on " + locator);
    }

    public boolean checkFullImage() {
        String locator = "FullImage";
        web.waitForElementVisible(locator, 15);
        if (web.isElementPresent(locator)){
            LOG.info(locator + " is shown");
            return true;
        }
        return false;
    }

    public void clickWriteReviewButton() {
        String locator = "WriteReviewButton";
        web.clickElement(locator);
        LOG.info("Click on " + locator);
    }

    public boolean checkReviewFormEnabled() {
        String locator = "ReviewForm";
        web.waitForElementVisible(locator, 15);
        if (web.isElementPresent(locator)){
            LOG.info(locator + " is enabled");
            return true;
        }
        return false;
    }
}
