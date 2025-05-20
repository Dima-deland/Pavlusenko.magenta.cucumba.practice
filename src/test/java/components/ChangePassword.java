package components;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class ChangePassword extends BasePage {
    public ChangePassword(TestContext context) {
        super(context);

        context.wait.until(ExpectedConditions.visibilityOf(title));
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

    public ChangePassword fillCurrentPasswordField(String value) {
        context.wait.until(ExpectedConditions.elementToBeClickable(currentPasswordField));
        currentPasswordField.sendKeys(value);
        return this;
    }

    public ChangePassword fillNewPasswordField(String value) {
        context.wait.until(ExpectedConditions.elementToBeClickable(newPasswordField));
        newPasswordField.sendKeys(value);
        return this;
    }

    public ChangePassword fillConfirmationPasswordField(String value) {
        context.wait.until(ExpectedConditions.elementToBeClickable(confirmationPasswordField));
        confirmationPasswordField.sendKeys(value);
        return this;
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}