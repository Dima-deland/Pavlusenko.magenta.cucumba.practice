package steps;

import components.CookiesModal;
import components.Header;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.ProductItemPage;
import utils.ConfigurationReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProductToCart {

    private final TestContext context;

    public AddProductToCart(TestContext context) {
        this.context = context;
    }

    @Given("I open Product page")
    public void openProductPage() {


        context.driver.get(ConfigurationReader.get("url") + ConfigurationReader.get("itempage"));

        CookiesModal cookies = new CookiesModal(context);
        cookies
                .clickAcceptCookiesButton();
    }

    @When("I add Product to Cart")
    public void addProductToCart() {
        ProductItemPage productItemPage = new ProductItemPage(context);
        productItemPage
                .clickChooseSizeButton()
                .clickChooseColorButton()
                .clickAddToCartButton();
    }

    @Then("I open Cart Page and check amount of added Products")
    public void checkAmountOfProducts() {
        context.driver.get(ConfigurationReader.get("url") + "/checkout/cart/");
        CartPage cartPage = new CartPage(context);
        assertEquals(1, cartPage.countProductItems());

        Header header = new Header(context);
        context.wait.until(driver -> header.getCartCounterValue() > 0);

        assertEquals(1, header.getCartCounterValue());
    }
}

