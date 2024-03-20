package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BaseTest;
import utilities.Logs;

public class LoginTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();

    @DataProvider(name = "login-data")
    public Object[][] createData() {
        return new Object[][] {
                { "locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out." },
                { "asdasdasd", "asdasdasd", "Epic sadface: Username and password do not match any user in this service" }
        };
    }

    @BeforeMethod
    public void setUp() {
        Logs.info("Navigating to the web page...");
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void verifyLoginPageTest() {
        loginPage.verifyPage();
    }

    @Test(dataProvider = "login-data")
    public void errorMessageTest(String username, String password, String errorMessage) {
        loginPage.writeCredentials(username,password);
        loginPage.verifyErrorMessage(errorMessage);
    }

}
