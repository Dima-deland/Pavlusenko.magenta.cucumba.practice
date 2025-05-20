package steps;

import context.TestContext;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CreateAccountPage;
import utils.ConfigurationReader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateAccountSteps {

    private final TestContext context;
    private final CreateAccountPage createAccountPage;

    public CreateAccountSteps(TestContext context) {
        this.context = context;
        this.createAccountPage = new CreateAccountPage(context);
    }

    @When("user fill necessary fields and click Create account button")
    public void fillFieldsAccountPage() {

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String datecode = date.format(formatter);

        step("Fill fields with data");
        createAccountPage
                .fillFirstNameField(ConfigurationReader.get("firstName"))
                .fillLastNameField(ConfigurationReader.get("lastName"))
                .fillEmailInputField(datecode + "@gmail.com")
                .fillPasswordField( ConfigurationReader.get("password"))
                .fillConfirmPasswordField(ConfigurationReader.get("password"));

        step("Clicks 'Create an Account' button");
        createAccountPage
                .clickCreateAnAccountButton();
    }

    @Then("new account is created")
    public void checkCreationOfAccount() {
        context.wait.until(ExpectedConditions.urlToBe(ConfigurationReader.get("url") + "/customer/account/"));

        step("Check that 'My account' page is opened");
        assertEquals("My Account", context.driver.getTitle());
    }
}