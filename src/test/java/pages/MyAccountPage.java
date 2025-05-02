package pages;

import components.ChangePassword;
import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    public MyAccountPage(TestContext context) {
        super(context);
    }

    //elements---------------------------------------------------------

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameInputField;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//a[@class='action change-password']")
    WebElement chnagePasswordLink;

    @FindBy(xpath = "//a[@class='action edit']")
    WebElement editLink;

    @FindBy(xpath = "//button[@class='action save primary']")
    private WebElement saveButton;

    //actions---------------------------------------------------------

    public MyAccountPage clickSaveButton() {
        saveButton.click();
        return new MyAccountPage(context);
    }

    public MyAccountPage clickEditLink() {
        editLink.click();
        return new MyAccountPage(context);
    }

    public ChangePassword clickChangePasswordLink() {
        chnagePasswordLink.click();
        return new ChangePassword(context);

    }

    public MyAccountPage fillField(String fieldName, String value) {
        switch (fieldName) {
            case "firstName":
                firstNameInputField.sendKeys(value);
                break;
            case "lastName":
                lastNameInputField.sendKeys(value);
                break;
            default:
                throw new IllegalArgumentException("Unknown field: " + fieldName);
        }
        return new MyAccountPage(context);
    }
}
