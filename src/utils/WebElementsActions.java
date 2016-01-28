package utils;

import exceptions.ElementNotFoundException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by zhabenya on 10.01.16.
 */
public class WebElementsActions {

    private WebDriver driver;
    private ConfigData config;
    public static WebDriverWait waitForElement;

    public WebElementsActions(WebDriver driver) {
        this.driver = driver;
        this.config = ConfigData.getConfig();
        waitForElement = new WebDriverWait(driver, 20);
    }

    /**
    * CLick button
    * */
    public void clickElement(String elementLocator){
        try {
            driver.findElement(config.ui(elementLocator)).click();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
    * Click link
    * */
    public void clickLink(String linkLocator){
        try {
            driver.findElement(config.ui(linkLocator)).click();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
    * Clear field and insert value
    * */
    public void clearAndFillField(String inputLocator, String inputData){
        try {
            driver.findElement(config.ui(inputLocator)).clear();
            driver.findElement(config.ui(inputLocator)).sendKeys(inputData);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
    * Insert value into field
    * */
    public void fillField(String inputLocator, String inputData){
        try {
            driver.findElement(config.ui(inputLocator)).sendKeys(inputData);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
    * Press ENTER on the form
    * */
    public void submitByEnter(String inputLocator){
        try {
            driver.findElement(config.ui(inputLocator)).sendKeys(Keys.ENTER);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
    * Select/deselect the checkbox
    * */
    public void selectCheckbox(String checkboxLocator){
        try {
            driver.findElement(config.ui(checkboxLocator)).click();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
    * Check if element is present on the page
    * */
    public boolean isElementPresent(String elementLocator){
        try {
            return driver.findElement(config.ui(elementLocator)).isDisplayed();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
    * Check alert and accept it
    * */
    public boolean isAlertPresent(){
        boolean alertPresence = false;
        try {
            Alert alert = driver.switchTo().alert();
            alertPresence = true;
            alert.accept();
        } catch (NoAlertPresentException e){
            e.printStackTrace();
        } finally {
            return alertPresence;
        }
    }

    /**
    * Get alert text
    * */
    public String getAlertText(){
        String alertText;
        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            alert.accept();
        } catch (NoAlertPresentException e){
            alertText = "Alert not found";
            e.printStackTrace();
        }
        return alertText;
    }

    /**
    * Move to element and click
    * */
    public void moveToElementAndClick(String moveToLocator, String clickToElement){
        WebElement webElement = null;
        try {
            webElement = driver.findElement(config.ui(moveToLocator));
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement);
            actions.perform();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        clickElement(clickToElement);

        //log.info("moved To Element " + moveToLocator + "and clicked on" + clickToElement);
    }

    /**
    * Refresh page
    * */
    public void refreshPage(){
        driver.navigate().refresh();
    }

    /**
    * Check if current URL contains page link
    * */
    public boolean checkAtPage(String page){
        return driver.getCurrentUrl().contains(page);
    }

    public void moveDownPage(){
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,100)", "");
    }

    public String getElementText(String elementLocator){
        try {
            return driver.findElement(config.ui(elementLocator)).getText();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Wait the element to disappear from page specified time
     */
    public void waitForElementNotVisible(String elementLocator, int timeoutInS) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInS);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(config.ui(elementLocator)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Wait the element to appear on page specified time
     */
    public void waitForElementVisible(String elementLocator, int timeoutInS) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInS);
            wait.until(ExpectedConditions.visibilityOfElementLocated(config.ui(elementLocator)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void movePageWithSpace(String headerLocator){
        try {
            driver.findElement(config.ui(headerLocator)).sendKeys(Keys.SPACE);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

}
