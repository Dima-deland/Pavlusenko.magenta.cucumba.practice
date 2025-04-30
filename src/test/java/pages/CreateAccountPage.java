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

    public CreateAccountPage fillField(String fieldName, String value) {
        switch (fieldName) {
            case "firstName":
                firstNameInputField.sendKeys(value);
                break;
            case "lastName":
                lastNameInputField.sendKeys(value);
                break;
            case "email":
                emailInputField.sendKeys(value);
                break;
            case "password":
                passwordField.sendKeys(value);
                break;
            case "confirmPassword":
                confirmPasswordField.sendKeys(value);
                break;
            default:
                throw new IllegalArgumentException("Unknown field: " + fieldName);
        }
        return new CreateAccountPage(context);
    }

    public MyAccountPage clickCreateAnAccountButton() {
        createAnAccountButton.click();
        return new MyAccountPage(context);
    }
}
