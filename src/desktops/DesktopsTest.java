package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        //hover over Desktops tab and click on desktops
        mouseHoverOnElement(By.linkText("Desktops"));
        clickOnTheElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //once the page has loaded, select the option to order by name reverse alphabetical order
        selectByVisibleTextFromDropDown(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/select[1]"), "Name (Z - A)");
        //verify the ordering is alphabetically
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //--------------------------desktops tab--------------------------
        //hover over desktops tab and click on Desktops
        mouseHoverOnElement(By.linkText("Desktops"));
        clickOnTheElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //once the page has loaded, select the dropdown option to order by name alphabetically
        selectByVisibleTextFromDropDown(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/select[1]"), "Name (A - Z)");
        //once the page has loaded with ordering alphabetically, click on the option for HP LP3065
        clickOnTheElement(By.xpath("//a[text()='HP LP3065']"));
        //-----------------------------HP LP3065 modification --------------------------
        //define the expected text when you load the HP LP3065 page
        String expectedText = "HP LP3065";
        //get the actual text on the HP LP3065
        String actualText = getTextFromElement(By.xpath("//a[text()='HP LP3065']"));
        //verify if expected equals actual
        Assert.assertEquals("not on HP LP3065 page", expectedText, actualText);
        //click on the calendar button
        clickOnTheElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/button[1]"));
        //define the year, month and date
        String year = "2022";
        String month = "November";
        String date = "30";
        //while statement containing if statement
        while (true) {
            //store the xpath for monthyear box in the calendar
            String monthYear = driver.findElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
            //split method to split monthyear into month and year
            String arr[] = monthYear.split(" ");
            //define month is the zero index of array
            String mon = arr[0];
            //define year is the first index of array
            String yer = arr[1];
            //if statement specifying to break if year = yer and month = mon
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
                //else statement specifying to click the calendar next button if the if-statement is not true
            } else {
                clickOnTheElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
            }
        }
        //Select Date 30
        //Create a list of all dates in calendar for the month specified
        List<WebElement> allDate = driver.findElements(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[3]"));
        //for loop to iterate through all elements of the list
        for (WebElement dt : allDate) {
            //if the expected date matches the actual date defined
            if (dt.getText().equalsIgnoreCase(date)) {
                //click the date
                dt.click();
                break;
            }
        }
        //add quantity 1 to the order
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "");

        //click the add to cart button
        clickOnTheElement(By.xpath("//button[@id='button-cart']"));

        //define expected message when added to cart
        String expectedMessage = "Success: You have added HP LP3065 to your shopping cart!" + "\n×";

        //get the actual message when added to cart
        String actualMessage = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        //Verify whether expectedMessage equals actualMessage
        Assert.assertEquals("not added to cart", expectedMessage, actualMessage);

        //click on shopping cart link in the success message
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/a[2]"));
        String expTextShoppingCart = "Shopping Cart  (1.00kg)", expTextProductName = "HP LP3065", expTextDeliveryDate = "Delivery Date:2022-11-30", expTextModel = "Product 21", expTextTotal = "$122.00";
        //get actTextShoppingCart
        String actTextShoppingCart = getTextFromElement(By.xpath("//div[@id='content']/h1"));
        //Verify the text "Shopping Cart"
        Assert.assertEquals("shopping cart not visible", expTextShoppingCart, actTextShoppingCart);
        //get actTextProductName
        String actTextProductName = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        //Verify the Product name "HP LP3065"
        Assert.assertEquals("Product name not visible", expTextProductName, actTextProductName);
        //get actDeliveryDate
        String actDeliveryDate = getTextFromElement(By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']"));
        //Verify the Delivery Date "2022-11-30"
        Assert.assertEquals("Delivery date not visible", expTextDeliveryDate, actDeliveryDate);
        //get actTextModel
        String actTextModel = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]"));
        //Verify the Model "Product 21"
        Assert.assertEquals("model not displayed", expTextModel, actTextModel);
        //get actTextTotal
        String actTextTotal = getTextFromElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]"));
        //Verify the Total "$122.00"
        Assert.assertEquals("Total not displayed", expTextTotal, actTextTotal);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
