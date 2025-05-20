package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccountPage extends BasePage {
    public CreateAccountPage(TestContext context) {
        super(context);
        context.wait.until(ExpectedConditions.titleIs("Create New Customer Account"));
    }

    //elements---------------------------------------------------------

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameInputField;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@class='action submit primary']")
    private WebElement createAnAccountButton;


    //actions----------------------------------------------------------

    public CreateAccountPage fillFirstNameField(String value) {
        context.wait.until(ExpectedConditions.elementToBeClickable(firstNameInputField));
        firstNameInputField.sendKeys(value);
        return this;
    }

    public CreateAccountPage fillLastNameField(String value) {
        context.wait.until(ExpectedConditions.elementToBeClickable(lastNameInputField));
        lastNameInputField.sendKeys(value);
        return this;
    }

    public CreateAccountPage fillEmailInputField(String value) {
        context.wait.until(ExpectedConditions.elementToBeClickable(emailInputField));
        emailInputField.sendKeys(value);
        return this;
    }

    public CreateAccountPage fillPasswordField(String value) {
        context.wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(value);
        return this;
    }

    public CreateAccountPage fillConfirmPasswordField(String value) {
        context.wait.until(ExpectedConditions.elementToBeClickable(confirmPasswordField));
        confirmPasswordField.sendKeys(value);
        return this;
    }

    public void clickCreateAnAccountButton() {
        createAnAccountButton.click();
    }
}
