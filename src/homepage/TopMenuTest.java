package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) throws InterruptedException {
        if (menu == "Desktops") {
            //Find Desktop tab, hover and click on "Show All Desktops"
            mouseHoverOnElement(By.linkText("Desktops"));
            clickOnTheElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ", "Desktops", title);

        } else if (menu == "Laptops & Notebooks") {
            //Find Laptops & Notebooks tab, hover and click on "Show All Laptops & Notebooks"
            mouseHoverOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
            clickOnTheElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ", "Laptops & Notebooks", title);

        } else if (menu == "Components") {
            //Find Components tab, hover and click on "Show All Components"
            mouseHoverOnElement(By.linkText("Components"));
            clickOnTheElement(By.xpath("//a[normalize-space()='Show AllComponents']"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ", "Components", title);


        } else {
            System.out.println("Please enter valid Top-menu name or check actual Top-menu name");
        }
    }

    //1.2 / 1.3 Click on  and verify navigation
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        selectMenu("Desktops");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        selectMenu("Laptops & Notebooks");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        selectMenu("Components");
    }

    @After
    public void teardown() {
        closeBrowser();
    }
}
