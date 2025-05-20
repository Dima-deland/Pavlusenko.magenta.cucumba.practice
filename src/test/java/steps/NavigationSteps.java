package steps;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import utils.ConfigurationReader;

import static io.qameta.allure.Allure.step;

public class NavigationSteps {

    private final TestContext context;

    public NavigationSteps(TestContext context) {
        this.context = context;
    }

    @Given("New account page is opened")
    public void openNewAccountPage() {
        step("Open New account page");
        context.driver.get(ConfigurationReader.get("url") + "/customer/account/create");
    }

    @Given("Login page is opened")
    public void openLoginPage() {
        step("Open Login page");
        context.driver.get(ConfigurationReader.get("url") + "/customer/account/login/");
    }

    @Given("My Account page is opened")
    public void myAccountPage() {
        step("Open My account page");
        context.driver.get(ConfigurationReader.get("url") + "/customer/account");
    }

    @Given("Product page is opened")
    public void openProductPage() {
        step("Open Product page");
        context.driver.get(ConfigurationReader.get("url") + ConfigurationReader.get("itempage"));
    }

    @Given("Cart page is opened")
    public void openCartPage() {
        step("Open Cart page");
        context.driver.get(ConfigurationReader.get("url") + "/checkout/cart/");
    }

    @Then("user is on Login page")
    public void userIsOnLoginPage() {
        step("Check that Login page is opened");
        Assertions.assertEquals(ConfigurationReader.get("url") + "/customer/account/login/", context.driver.getCurrentUrl());
    }
}
