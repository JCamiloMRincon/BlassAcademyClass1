package automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseTest;
import utilities.Logs;

public class SauceDemoTest extends BaseTest {

    @Test
    public void loginUiTest() {
        Logs.info("Navigating to the web page...");
        driver.get("https://www.saucedemo.com/");

        final var usernameLocator = By.id("user-name");
        final var passwordLocator = By.id("password");
        final var loginButtonLocator = By.id("login-button");

        final var softAssert = new SoftAssert();

        Logs.info("Verifying the page UI...");
        softAssert.assertTrue(driver.findElement(usernameLocator).isDisplayed());
        softAssert.assertTrue(driver.findElement(passwordLocator).isDisplayed());
        softAssert.assertTrue(driver.findElement(loginButtonLocator).isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void lockedUserTest() {
        Logs.info("Navigating to the web page...");
        driver.get("https://www.saucedemo.com/");

        final var usernameLocator = By.id("user-name");
        final var passwordLocator = By.id("password");
        final var loginButtonLocator = By.id("login-button");

        Logs.info("Typing the username...");
        driver.findElement(usernameLocator).sendKeys("locked_out_user");
        Logs.info("Typing the password...");
        driver.findElement(passwordLocator).sendKeys("secret_sauce");
        Logs.info("Clicking the login button...");
        driver.findElement(loginButtonLocator).click();

        final var errorWebElement = driver.findElement(By.cssSelector("h3[data-test='error']"));
        final var softAssert = new SoftAssert();

        Logs.info("Verifying the error message...");
        softAssert.assertTrue(errorWebElement.isDisplayed());
        softAssert.assertEquals(errorWebElement.getText(),
                "Epic sadface: Sorry, this user has been locked out.");
        softAssert.assertAll();
    }

    @Test
    public void noExistingUserTest() {
        Logs.info("Navigating to the web page...");
        driver.get("https://www.saucedemo.com/");

        final var usernameLocator = By.id("user-name");
        final var passwordLocator = By.id("password");
        final var loginButtonLocator = By.id("login-button");

        Logs.info("Typing the username...");
        driver.findElement(usernameLocator).sendKeys("asdasdasd");
        Logs.info("Typing the password...");
        driver.findElement(passwordLocator).sendKeys("asdasdasd");
        Logs.info("Clicking the login button...");
        driver.findElement(loginButtonLocator).click();

        final var errorWebElement = driver.findElement(By.cssSelector("h3[data-test='error']"));
        final var softAssert = new SoftAssert();

        Logs.info("Verifying the error message...");
        softAssert.assertTrue(errorWebElement.isDisplayed());
        softAssert.assertEquals(errorWebElement.getText(),
                "Epic sadface: Username and password do not match any user in this service");
        softAssert.assertAll();
    }

}
