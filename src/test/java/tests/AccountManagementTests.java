package tests;

import components.ChangePassword;
import components.CookiesModal;
import components.Header;
import components.Notification;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import pages.CreateAccountPage;
import pages.MyAccountPage;
import utils.ConfigurationReader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Account management tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountManagementTests extends BaseTest {
    public AccountManagementTests() {
    }

    @Test
    @Order(1)
    @DisplayName("Create an Account Test")
    public void createAnAccountTest() {
        Allure.description("Test is checking creating of new Account");

        Allure.step("1. Open Home page");
        context.driver.get(ConfigurationReader.get("url"));

        Allure.step("2. Accept cookies");
        CookiesModal cookies = new CookiesModal(context);
        cookies
                .clickAcceptCookiesButton();

        Allure.step("3. Click Create an Account link");
        Header header = new Header(context);
        header
                .createAnAccountLinkClick();

        Allure.step("4. Fill in all required fields and click Create an Account button");
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
        Allure.step("5. Check that account is created and user is redirected to My account page");
        MyAccountPage myAccountPage = new MyAccountPage(context);
        assertTrue(context.driver.getTitle().equals("My Account"));
    }

    @Test
    @Order(2)
    @DisplayName("Change Information Test")
    public void changeInformationTest() {
        Allure.description("Test is checking changing of Contact information");

        Allure.step("1. CLick Edit Link ");
        MyAccountPage myAccountPage = new MyAccountPage(context);
        myAccountPage
                .clickEditLink();

        Allure.step("2. Fill in fields and click Save button");
        MyAccountPage myAccountPage1 = new MyAccountPage(context);
        myAccountPage
                .fillField("firstName", "New")
                .fillField("lastName", "New")
                .clickSaveButton();

        Allure.step("3. Check that notification is shown");
        Notification notification = new Notification(context);
        assertEquals(notification.getNotificationText(), "You saved the account information.");

    }

    @Test
    @Order(3)
    @DisplayName("Change password Test")
    public void changePasswordTest() {
        Allure.description("Test is checking password changing");

        Allure.step("1. CLick Change Password Link ");
        MyAccountPage myAccountPage = new MyAccountPage(context);
        myAccountPage
                .clickChangePasswordLink();

        Allure.step("2. Fill in fields and click Save button");
        ChangePassword changePassword = new ChangePassword(context);
        changePassword
                .fillField("currentPassword", ConfigurationReader.get("password"))
                .fillField("newPassword", ConfigurationReader.get("password") + "New")
                .fillField("confirmNewPassword", ConfigurationReader.get("password") + "New")
                .clickSaveButton();


        Allure.step("3. Check that notification is shown");
        Notification notification = new Notification(context);

        assertEquals(notification.getNotificationText(), "You saved the account information.");
    }
}

