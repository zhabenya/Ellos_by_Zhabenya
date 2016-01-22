import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.ConfigData;

import java.io.IOException;

/**
 * Created by zhabenya on 10.01.16.
 */
public class WebElementsActions {

    WebDriver driver;

    public WebElementsActions(WebDriver driver) {
        this.driver = driver;
    }

    /*
    * CLick button
    * */
    public void clickElement(String elementLocator) throws IOException {
        driver.findElement(ConfigData.ui(elementLocator)).click();
//        log.info("Click on button " + elementLocator);
    }

    /*
    * Click link
    * */
    public void clickLink(String linkLocator) throws IOException {
        driver.findElement(ConfigData.ui(linkLocator)).click();
//        log.info("Click on Link " + linkLocator);
    }

    /*
    * Insert value into fillField field
    * */
    public void fillField(String inputLocator, String inputData) throws IOException {
        driver.findElement(ConfigData.ui(inputLocator)).clear();
        driver.findElement(ConfigData.ui(inputLocator)).sendKeys(inputData);
//        log.info("Input in " + inputLocator + ", value - " + inputData);
    }

    /*
    * Select/deselect the checkbox
    * */
    public void selectCheckbox(String checkboxLocator) throws IOException {
        driver.findElement(ConfigData.ui(checkboxLocator)).click();
    }

    /*
    * Check if element is present on the page
    * */
    public boolean isElementPresent(String elementLocator) throws IOException {
        if (!driver.findElement(ConfigData.ui(elementLocator)).isDisplayed()){
            return false;
        }
        return true;
    }

    /*
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

    /*
    * Get alert text
    * */
    public String getAlertText(){
        String alertText;
        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
//            log.info("Alert text: " + alertText);
            alert.accept();
        } catch (NoAlertPresentException e){
            alertText = "Alert not found";
//            log.error("Alert not found");
            e.printStackTrace();
        }
        return alertText;
    }

    /*
    * Move to element and click
    * */
    public void moveToElementAndClick(String moveToLocator, String clickToElement) throws IOException {
        WebElement webElement = null;
        webElement = driver.findElement(By.xpath(moveToLocator));

        Actions actions = new Actions(driver);
        actions.moveToElement(webElement);
        actions.perform();
        clickElement(clickToElement);

        //log.info("moved To Element " + moveToLocator + "and clicked on" + clickToElement);
    }

    /*
    * Refresh page
    * */
    public void refreshPage(){
        driver.navigate().refresh();
    }

    /*
    * Go to URL
    * */
    public void goToUrl(String url){
        driver.get(url);
    }

    public void moveDownPage(){
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,100)", "");
    }

    public String getElementText(String elementLocator) throws IOException {
        return driver.findElement(ConfigData.ui(elementLocator)).getText();
    }

}
