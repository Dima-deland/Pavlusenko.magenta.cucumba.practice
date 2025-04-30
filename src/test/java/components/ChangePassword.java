package components;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.CreateAccountPage;
import pages.LoginPage;
import pages.MyAccountPage;

public class ChangePassword extends BasePage {
    public ChangePassword(TestContext context) {
        super(context);
    }

    //elements---------------------------------------------------------

    @FindBy(xpath = "//span[@data-title='change-email-password']")
    private WebElement title;

    @FindBy(xpath = "//input[@id='current-password']")
    private WebElement currentPasswordField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    private WebElement confirmationPasswordField;

    @FindBy(xpath = "//button[@class='action save primary']")
    private WebElement saveButton;

    //actions---------------------------------------------------------

    public ChangePassword fillField(String fieldName, String value) {
        switch (fieldName) {
            case "currentPassword":
                currentPasswordField.sendKeys(value);
                break;
            case "newPassword":
                newPasswordField.sendKeys(value);
                break;
            case "confirmNewPassword":
                confirmationPasswordField.sendKeys(value);
                break;
            default:
                throw new IllegalArgumentException("Unknown field: " + fieldName);
        }
        return new ChangePassword(context);
    }

    public LoginPage clickSaveButton() {
        saveButton.click();
        return new LoginPage(context);
    }
}
