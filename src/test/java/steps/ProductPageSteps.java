package steps;

import context.TestContext;
import io.cucumber.java.en.When;
import pages.ProductPage;

import static io.qameta.allure.Allure.step;

public class ProductPageSteps {
    private final TestContext context;
    private final ProductPage productPage;

    public ProductPageSteps(TestContext context) {
        this.context = context;
        productPage = new ProductPage(context);
    }

    @When("user adds Product to Cart")
    public void addProductToCart() {
        step("Add Product to Cart");
        productPage
                .clickAddToCartButton();
    }
}

