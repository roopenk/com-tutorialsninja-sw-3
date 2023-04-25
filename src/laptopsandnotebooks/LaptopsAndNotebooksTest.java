package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    @Before
    public void setUp() {
        openBrowser("http://tutorialsninja.com/demo/index.php?");
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        //hover over Laptops And Notebooks tab click on it
        mouseHoverOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        clickOnTheElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //once the page has loaded, select the option to order by price high to low
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        String expectedText = "Price (High > Low)";
        String actualText = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/select[1]/option[5]"));
        //verify the ordering is priced high to low
        Assert.assertEquals("not price high to low", expectedText, actualText);
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //hover over Laptops And Notebooks tab and click on it
        mouseHoverOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        clickOnTheElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //once the page has loaded, select the option to order by price high to low
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //Select Product “MacBook”
        clickOnTheElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));
        //define expected text
        String expectedTextProduct = "MacBook";
        //get actual text
        String actualTextProduct = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/h1[1]"));
        //2.5 Verify the text “MacBook”
        Assert.assertEquals("not on Macbook page", expectedTextProduct, actualTextProduct);
        //2.6 Click on ‘Add To Cart’ button
        clickOnTheElement(By.xpath("//button[@id='button-cart']"));
        String expectedSuccessMessage = "Success: You have added MacBook to your shopping cart!" + "\n×";
        String actualSuccessMessage = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertEquals("not added to cart", expectedSuccessMessage, actualSuccessMessage);
        //2.8 Click on link “shopping cart” display into success message
        clickOnTheElement(By.xpath("//body[1]/div[2]/div[1]/a[2]"));
        //define expected
        String expectedTextShoppingCart = "Shopping Cart  (0.00kg)";
        //get actual
        String actualTextShoppingCart = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h1[1]"));
        //2.9 Verify the text "Shopping Cart"
        Assert.assertEquals("not on shopping cart page", expectedTextShoppingCart, actualTextShoppingCart);
        //define expected
        String expectedProductName = "MacBook";
        //get actual
        String actualProductName = getTextFromElement(By.xpath("//div[@id='content']/form/div/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals("not on shopping cart", expectedProductName, actualProductName);
        //clear 1 from textbox
        driver.findElement(By.xpath("//div[@class='input-group btn-block']/input")).clear();
        //2.11 Change Quantity "2"
        sendTextToElement(By.xpath("//div[@class='input-group btn-block']/input"), "2");
        //2.12 Click on “Update” Tab
        clickOnTheElement(By.xpath("//button[@type='submit']"));
        //define expectedModificationSuccessMessage
        String expectedModificationSuccessMessage = "Success: You have modified your shopping cart!" + "\n×";
        //get actualModificationSuccessMessage
        String actualModificationSuccessMessage = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertEquals("not modified correctly", expectedModificationSuccessMessage, actualModificationSuccessMessage);
        //2.14 Verify the Total $1204.00
        String expectedTotal = "$1,204.00";
        String actualTotal = getTextFromElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        Assert.assertEquals("total not displayed", expectedTotal, actualTotal);
        //2.15 Click on “Checkout” button
        clickOnTheElement(By.xpath("//a[@class='btn btn-primary']"));
        //2.16 Verify the text “Checkout”
        String expectedCheckout = "Checkout";
        String actualCheckout = getTextFromElement(By.xpath("//div[@id='content']/h1"));
        Assert.assertEquals("not on checkout", expectedCheckout, actualCheckout);
        //2.17 Verify the Text “New Customer”
        String expectedNewCustomer = "New Customer";
        String actualNewCustomer = getTextFromElement(By.xpath("//div[@class='col-sm-6']/h2[text()='New Customer']"));
        Assert.assertEquals("New customer not found", expectedNewCustomer, actualNewCustomer);
        //2.18 Click on “Guest Checkout” radio button
        clickOnTheElement(By.xpath("//input[@value='guest']"));
        //2.19 Click on “Continue” tab
        mouseHoverAndClickOnElement(By.id("button-account"));
        //2.20 Fill the mandatory fields
        //first name
        sendTextToElement(By.id("input-payment-firstname"), "Hi");
        //last name
        sendTextToElement(By.id("input-payment-lastname"), "Patel");
        //email
        sendTextToElement(By.id("input-payment-email"), getRandomEmail());
        //telephone
        sendTextToElement(By.id("input-payment-telephone"), "07654321234");
        //address
        sendTextToElement(By.id("input-payment-address-1"), "11 Pinner Road");
        //city
        sendTextToElement(By.id("input-payment-city"), "Harrow");
        //postcode
        sendTextToElement(By.id("input-payment-postcode"), "HA61SY");
        //Region
        selectByVisibleTextFromDropDown(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/fieldset[1]/div[6]/select[1]"), "United Kingdom");
        //city
        selectByVisibleTextFromDropDown(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/fieldset[1]/div[7]/select[1]"), "Aberdeen");
        //2.21 Click on “Continue” Button
        clickOnTheElement(By.xpath("//div[@class='buttons']/div[@class='pull-right']/input[@value='Continue']"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//div[@class='panel-body']/p[2]/textarea[@name='comment']"), "Comment XYZA");
        //2.23 Check the Terms & Conditions check box
        mouseHoverAndClickOnElement(By.xpath("//input[@name='agree']"));
        //2.24 Click on “Continue” button
        clickOnTheElement(By.xpath("//input[@id='button-payment-method']"));
        //2.25 Verify the message “Warning: Payment method required!”
        String expectedWarningMessage = "Warning: You must agree to the Terms & Conditions!" + "\n×";
        String actualWarningMessage = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        //verify whether expected equals actual
        Assert.assertEquals("No Alert", expectedWarningMessage, actualWarningMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
