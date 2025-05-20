package steps;

import components.Header;
import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import utils.ConfigurationReader;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartSteps {
    private final TestContext context;
    private final CartPage cartPage;
    private final Header header;

    public CartSteps(TestContext context) {
        this.context = context;
        cartPage = new CartPage(context);
        header = new Header(context);
    }

    @When("user changes quantity of product to {int}")
    public void userChangesQuantityOfProductTo(int quantity) {
        step("Change amount of items and clicks 'Update shopping cart' button");
        cartPage
                .setProductQuantityField(quantity)
                .clickUpdateShoppingCartButton();
    }

    @When("user delete product from Cart")
    public void userDeleteProductFromCart() {
        step("Click 'Remove' button, to remove product from Cart");
        cartPage
                .clickRemoveItemButton();
    }

    @Then("quantity of products in Cart is changed to {int}")
    public void quantityOfProductsInCartIsChangedTo(int quantity) {
        step("Check that number of products is changed in Cart");
        assertEquals(quantity, cartPage.getProductQuantityField());
    }

    @Then("Cart counter number is changed to {int}")
    public void cartCounterNumberIsChangedTo(int quantity) {
        context.wait.until(driver -> header.getCartCounterValue() > 0);
        step("Check that cart counter has new value");
        assertEquals(quantity, header.getCartCounterValue());
    }

    @Then("amount of products in cart equals {int}")
    public void checkAmountOfProducts(int expectedAmount) {
        context.driver.get(ConfigurationReader.get("url") + "/checkout/cart/");
        step("Check amount of products in Cart");
        assertEquals(expectedAmount, cartPage.countProductItems());
    }

    @Then("{string} text is displayed")
    public void textIsDisplayed(String emptyCartMsg) {
        step("Check that Message that Cart is empty is displayed");
        assertEquals(emptyCartMsg, cartPage.getCartEmptyInfoText().split("\\.")[0]);
    }
}