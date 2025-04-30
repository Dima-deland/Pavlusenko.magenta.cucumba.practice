package tests;

import components.CookiesModal;
import components.Header;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import pages.CartPage;
import pages.ProductItemPage;
import utils.ConfigurationReader;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Change number of items in Cart")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChangeProductInCartTests extends BaseTest {
    public ChangeProductInCartTests() {
    }

    @Test
    @DisplayName("Adding product to cart test")
    @Order(1)
    public void addToCartTest() {
        Allure.description("Test is checking adding product to Cart");

        Allure.step("1. Open Product page");
        context.driver.get(ConfigurationReader.get("url") + "/argus-all-weather-tank.html");

        Allure.step("2. Accept cookies");
        CookiesModal cookies = new CookiesModal(context);
        cookies
                .clickAcceptCookiesButton();

        Allure.step("3. Add product to Cart");
        ProductItemPage productItemPage = new ProductItemPage(context);
        productItemPage
                .clickChooseSizeButton()
                .clickChooseColorButton()
                .clickAddToCartButton();

        Allure.step("4. Open Cart page");
        context.driver.get(ConfigurationReader.get("url") + "/checkout/cart/");
        CartPage cartPage = new CartPage(context);

        Allure.step("5. Check number of products in Cart");
        assertEquals(1,cartPage.countProductItems());

        Allure.step("6. Check value of Cart counter in header");
        Header header = new Header(context);
        context.wait.until(driver -> header.getCartCounterValue()>0);
        assertEquals(1, header.getCartCounterValue());

    }

    @Test
    @DisplayName("Update product quantity in cart test")
    @Order(2)
    public void updateQuantityInCart() throws InterruptedException {
        CartPage cartPage = new CartPage(context);

        Allure.step("1. Update quantity of products in Cart");
        cartPage
                .setProductQuantityField(2);
                Thread.sleep(300);
                cartPage.clickUpdateShoppingCartButton();

        Allure.step("2. Check number of products in Cart");
        assertEquals(2,cartPage.getProductQuantityField());

        Allure.step("3. Check value of Cart counter in header");
        Header header = new Header(context);
        context.wait.until(driver -> header.getCartCounterValue()>1);
        assertEquals(2, header.getCartCounterValue());

    }

    @Test
    @DisplayName("Remove product from cart test")
    @Order(3)
    public void removeProductFromCart() throws InterruptedException {
        CartPage cartPage = new CartPage(context);

        Allure.step("1. Remove product from Cart");
        cartPage
                .clickRemoveItemButton();
        Thread.sleep(600);

        Allure.step("2. Check that Cart is empty");
        assertTrue(cartPage.getCartEmptyInfoText().isDisplayed());

        Allure.step("3. Check value of Cart counter in header");
        Header header = new Header(context);
        assertEquals(0, header.getCartCounterValue());

    }
}
