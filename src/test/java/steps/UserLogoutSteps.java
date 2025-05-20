package steps;

import components.Header;
import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserLogoutSteps {

    private final TestContext context;
    private final Header header;

    public UserLogoutSteps(TestContext context) {
        this.context = context;
        this.header = new Header(context);
    }

    @When("user logs out")
    public void userLogsout (){
        step("Click 'Options' then 'Sign Out' buttons");
        header
                .clickUserOptionsButton()
                .clickSignOutOption();
    }

    @Then("user is logged out")
    public void check () {
        step("Check that User is logged out");
        assertTrue(header.signInLink.isDisplayed());
    }




}
