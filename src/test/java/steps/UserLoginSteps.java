package steps;

import components.Header;
import components.Notification;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pages.LoginPage;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;

public class UserLoginSteps {
    private final TestContext context;
    private final LoginPage loginPage;

    public UserLoginSteps(TestContext context) {
        this.context = context;
        loginPage = new LoginPage(context);
    }

    @Given("user is logged in with email {string} and password {string}")
    @When("user logins with email {string} and password {string}")
    public void userLoginWithEmailAndPassword(String email, String password) {
        step("Enter login and password");
        loginPage
                .fillEmailField(email)
                .fillPasswordField(password);
        step("Click Sign In button");
        loginPage
                .clickSignInButton();
    }

    @Then("user is logged in")
    public void checkUserIsLoggedIn() {
        Header header = new Header(context);
        step("Check that user is logged in");
        assertTrue(header.userOptionsButton.isDisplayed());
    }

    @Then("{string} is shown")
    public void isShown(String expectedMessage) {
        Notification notification = new Notification(context);
        step("Check that notification is shown");
        Allure.addAttachment("Expected message",expectedMessage);
        assertEquals(expectedMessage, notification.getNotificationText().trim());
    }

    @Then("{string} that  {string} field is required or incorrect is shown")
    public void thatFieldIsRequiredIsShown(String expectedErrorMessage, String fieldName) {
        step("Check that error message is shown");

        if (fieldName == "Email") {
            assertTrue(loginPage.emailFieldIsRequiredMessage.isDisplayed());
            assertFalse(loginPage.passwordFieldIsRequiredMessage.isDisplayed());
            assertEquals(expectedErrorMessage, loginPage.emailFieldIsRequiredMessage.getText());
        } else if (fieldName == "Password") {
            assertTrue(loginPage.passwordFieldIsRequiredMessage.isDisplayed());
            assertFalse(loginPage.emailFieldIsRequiredMessage.isDisplayed());
            assertEquals(expectedErrorMessage, loginPage.passwordFieldIsRequiredMessage.getText());
        }
    }
}
