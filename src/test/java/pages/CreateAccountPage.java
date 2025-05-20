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
        firstNameInputField.clear();
        firstNameInputField.sendKeys(value);
        return this;
    }

    public CreateAccountPage fillLastNameField(String value) {
        context.wait.until(ExpectedConditions.elementToBeClickable(lastNameInputField));
        lastNameInputField.clear();
        lastNameInputField.sendKeys(value);
        return this;
    }

    public CreateAccountPage fillEmailInputField(String value) {
        context.wait.until(ExpectedConditions.elementToBeClickable(emailInputField));
        emailInputField.clear();
        emailInputField.sendKeys(value);
        return this;
    }

    public CreateAccountPage fillPasswordField(String value) {
        context.wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.clear();
        passwordField.sendKeys(value);
        return this;
    }

    public CreateAccountPage fillConfirmPasswordField(String value) {
        context.wait.until(ExpectedConditions.elementToBeClickable(confirmPasswordField));
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(value);
        return this;
    }

    public void clickCreateAnAccountButton() {
        createAnAccountButton.click();
    }
}
