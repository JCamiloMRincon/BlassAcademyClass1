package pages;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.Logs;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    @Override
    public void verifyPage() {
        Logs.info("Verifying the login page...");
        final var softAssert = new SoftAssert();
        softAssert.assertTrue(find(usernameInput).isDisplayed());
        softAssert.assertTrue(find(passwordInput).isDisplayed());
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertAll();
    }

    public void writeCredentials(String username, String password) {
        Logs.info("Typing the username...");
        find(usernameInput).sendKeys(username);
        Logs.info("Typing the password...");
        find(passwordInput).sendKeys(password);
        Logs.info("Clicking the login button...");
        find(loginButton).click();
    }

    public void verifyErrorMessage(String message) {
        final var softAssert = new SoftAssert();
        Logs.info("Verifying the error message...");
        softAssert.assertTrue(find(errorMessage).isDisplayed());
        softAssert.assertEquals(find(errorMessage).getText(), message);
        softAssert.assertAll();
    }
}
