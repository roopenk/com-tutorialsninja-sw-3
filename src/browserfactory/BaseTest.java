package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Created by Jay Vaghani
 */
public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        driver = new ChromeDriver();
        // Launce the URL
        driver.get(baseUrl);
        // Maximise Window
        driver.manage().window().maximize();
        //Implicit Time out
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeBrowser(){
        driver.quit();
    }

}
