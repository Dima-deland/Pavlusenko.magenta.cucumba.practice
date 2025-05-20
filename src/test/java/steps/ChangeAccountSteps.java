package steps;

import components.ChangePassword;
import components.Notification;
import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MyAccountPage;
import utils.ConfigurationReader;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeAccountSteps {
    private final TestContext context;
    private final MyAccountPage myAccountPage;

    public ChangeAccountSteps(TestContext context) {
        this.context = context;
        this.myAccountPage = new MyAccountPage(context);
    }

    @When("user change First name and Last name on My Account page")
    public void changeInformationTest() {
        step("Click 'Edit' link");
        myAccountPage.clickEditLink();

        step("Enter new data");
        myAccountPage.fillFirstNameInputField("Newname").fillLastNameInputField("Newlastname");

        step("Click 'Save' button");
        myAccountPage.clickSaveButton();
    }

    @Then("Notification that user changed account information is shown")
    public void checkNotificationIsShown() {
        Notification notification = new Notification(context);
        step("Check that notification is shown");
        assertEquals("You saved the account information.", notification.getNotificationText());
    }

    @Then("User's First and Last names are changed")
    public void checkNameIsChanged() {
        step("Check that information is changed");
        assertEquals("Newname Newlastname", myAccountPage.getContactInformation().substring(0, 19));
    }

    @When("user changes Password")
    public void userChangesPassword() {
        step("Click 'Change password' link");
        myAccountPage.clickChangePasswordLink();

        step("Fill fields with new data");
        ChangePassword changePassword = new ChangePassword(context);
        changePassword.fillCurrentPasswordField(ConfigurationReader.get("password")).fillNewPasswordField("New" + ConfigurationReader.get("password")).fillConfirmationPasswordField("New" + ConfigurationReader.get("password"));

        step("Click 'Save' button");
        myAccountPage.clickSaveButton();
    }
}
