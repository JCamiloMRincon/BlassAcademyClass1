package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.Logs;

public class ShoppingPage extends BasePage {

    private final By productsTitle = By.xpath("//span[text()='Products']");
    private final By sortElement = By.cssSelector("select[data-test='product_sort_container']");
    private final By inventoryItem = By.className("inventory_item");
    private final By btnAddToCart = By.className("btn_inventory");
    private final By shoppingCartCounter = By.className("shopping_cart_badge");

    @Override
    public void verifyPage() {
        final var softAssert = new SoftAssert();
        Logs.info("Verifying the shopping page UI...");
        softAssert.assertTrue(find(productsTitle).isDisplayed());
        softAssert.assertTrue(find(sortElement).isDisplayed());
        softAssert.assertEquals(findAll(inventoryItem).size(), 6);
        softAssert.assertAll();
    }

    public void addToCart() {
        final var btnAddToCartList = findAll(btnAddToCart);
        Logs.info("Click on the 6 Add to cart buttons");
        for (var btn : btnAddToCartList) {
            btn.click();
        }
        //--- Get the number of items as string. Then it will be parsed as integer
        final var currentNumberOfItems = find(shoppingCartCounter).getText();
        Logs.info("Verifying that the shopping cart contains 6 elements...");
        Assert.assertEquals(Integer.parseInt(currentNumberOfItems), 6);
    }

}
