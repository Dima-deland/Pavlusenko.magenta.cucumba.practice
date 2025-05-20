package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(TestContext context) {
        super(context);
    }

    //elements---------------------------------------------------------
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@name='login[password]']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//button[@class='action login primary']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='pass-error']")
    public WebElement passwordFieldIsRequiredMessage;

    @FindBy(xpath = "//div[@id='email-error']")
    public WebElement emailFieldIsRequiredMessage;

    //actions---------------------------------------------------------

    public LoginPage fillEmailField(String email){
        emailInputField.sendKeys(email);
        return this;
    }

    public LoginPage fillPasswordField(String password){
        passwordInputField.sendKeys(password);
        return this;
    }

    public void clickSignInButton(){
        signInButton.click();
    }

}
