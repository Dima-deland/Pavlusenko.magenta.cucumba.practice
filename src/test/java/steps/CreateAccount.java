package steps;

import components.CookiesModal;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAccountPage;
import pages.MyAccountPage;
import utils.ConfigurationReader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CreateAccount {

    private final TestContext context;

    public CreateAccount(TestContext context) {
        this.context = context;
    }


    @Given("I opened New account page")
    public void openNewAccountPage() throws InterruptedException {
        context.driver.get("https://magento.softwaretestingboard.com/customer/account/create/");


        CookiesModal cookies = new CookiesModal(context);
        cookies
                .clickAcceptCookiesButton();


    }

    @When("I fill all fields and click Create account button")
    public void fillFieldsAccountPage() {

        CreateAccountPage createAccountPage = new CreateAccountPage(context);

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String datecode = date.format(formatter);

        createAccountPage
                .fillField("firstName", ConfigurationReader.get("firstName"))
                .fillField("lastName", ConfigurationReader.get("lastName"))
                .fillField("email", datecode + "@gmail.com")
                .fillField("password", ConfigurationReader.get("password"))
                .fillField("confirmPassword", ConfigurationReader.get("password"))
                .clickCreateAnAccountButton();
    }

    @Then("I check that account is created")
    public void checkCrationofAccount() {

        MyAccountPage myAccountPage = new MyAccountPage(context);
        assertTrue(context.driver.getTitle().equals("My Account"));
    }

}
