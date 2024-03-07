package automation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseTest;
import utilities.Logs;

public class FirstTest extends BaseTest {

    @Test
    public void firstTest() {
        Logs.info("Navigate to the page");
        driver.get("https://www.saucedemo.com/");

        final var url = driver.getCurrentUrl();

        Logs.info("verifying the url...");
        Assert.assertEquals(url, "https://www.saucedemo.com/");
    }

    @Test
    public void secondTest() {
        Logs.info("Navigate to the Internet Heroku App page...");
        driver.get("https://the-internet.herokuapp.com/");

        Logs.info("Navigate to the GitHub page...");
        driver.get("https://github.com/");

        Logs.info("Going back to the previous page...");
        driver.navigate().back();

        final var url = driver.getCurrentUrl();

        Logs.info("verifying the url...");
        Assert.assertEquals(url, "https://the-internet.herokuapp.com/");
    }
}
