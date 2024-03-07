package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void masterSetUp() {
        Logs.debug("Start driver...");
        driver = new ChromeDriver();

        Logs.debug("Maximize the driver...");
        driver.manage().window().maximize();

        Logs.debug("Deleting the cookies...");
        driver.manage().deleteAllCookies();

        Logs.debug("Applying implicit waits...");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        new WebDriverProvider().set(driver);
    }

    @AfterMethod
    public void masterTearDown() {
        //--- Kill driver
        Logs.debug("Kill driver...");
        driver.quit();
    }
}
