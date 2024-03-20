package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShoppingPage;
import utilities.BaseTest;
import utilities.Logs;

public class ShoppingTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();

    @BeforeMethod
    public void setUp() {
        Logs.info("Navigating to the web page...");
        driver.get("https://www.saucedemo.com/");
        loginPage.writeCredentials("standard_user", "secret_sauce");
    }

    @Test
    public void verifyShoppingPageTest() {
        shoppingPage.verifyPage();
    }

    @Test
    public void verifyAddToCartTest() {
        shoppingPage.addToCart();
    }

}
