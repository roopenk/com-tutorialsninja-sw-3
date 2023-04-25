package utility;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

/**
 * Created by Jay Vaghani
 */
public class Utility extends BaseTest {

    public void clickOnTheElement(By by) { // Method to click on the element supplied with "by" variable
        driver.findElement(by).click();
    }

    public void sendTextToElement(By by, String text) { // Method to send the text to element
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by) { // Method to get text from the element
        return driver.findElement(by).getText();
    }

    // Select Class methods
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text); // Selecting by visible text
    }

    //************************* Alert Methods *****************************************************
    /*
    This method will select dropdown option using text value
     */
    public void selectByValue(By by, String text) {
        WebElement value = driver.findElement(by);
        Select select = new Select(value);
        select.selectByValue(text);
    }

    /*
    This method will select dropdown option using index value
     */
    public void selectByIndex(By by, int num) {
        WebElement index = driver.findElement(by);
        Select select = new Select(index);
        select.selectByIndex(num);
    }

    /*
    This method will switch driver to any popup alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /*
    This method will tell driver to accept any popup alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /*
    This method will tell driver to dismiss any popup alert
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /*
    This method will send text to any popup alert
     */
    public void sendTextToAlert(By by, String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    /*
    This method will get text from any popup alert
     */
    public String getTextFromAlert(By by) {
        return driver.switchTo().alert().getText();
    }

    /*
    This method will mouse hover over any element
     */

    public void mouseHoverOnElement(By by) throws InterruptedException {
        WebElement element = driver.findElement(by);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    /*
    This method will mouse hover over any element and click on it
     */
    public void mouseHoverAndClickOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement text1 = driver.findElement(by);
        actions.moveToElement(text1).click().build().perform();
    }

    public static String getRandomEmail() { // Method generating Random email everytime
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder random = new StringBuilder();
        Random rnd = new Random();
        while (random.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            random.append(chars.charAt(index));
        }
        String email = random.toString() + "@gmail.com";
        return email;
    }

    /**
     * This method will get text from element and check whether it is displayed or not.
     */
    public boolean verifyTextDisplayed(By by, String expectedText) {
        boolean actualText = (driver.findElement(by).getText()).contains(expectedText); // Find and get actual text on page and check whether it contains expected text or not?
        assert actualText : "Text is not found: " + expectedText;
        return true;
    }

    /**
     * This method will get number from element and check
     * whether it is displayed or not.
     */
    public boolean verifyNumberFromElement(By by, int expectedNumber) {
        int actualNumber = driver.findElements(by).size();
        assert actualNumber == expectedNumber : "Expected Number of items not displayed: " + expectedNumber;
        return true;
    }

    public String getAttValueFromElement(By by) {
        return driver.findElement(by).getAttribute("value");
    }
}
