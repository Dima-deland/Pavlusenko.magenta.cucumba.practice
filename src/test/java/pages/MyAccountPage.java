package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy(xpath = "//div[@class='box box-information']//p")
    private WebElement contactInformation;

    //actions---------------------------------------------------------

    public MyAccountPage clickSaveButton() {
        saveButton.click();
        return this;
    }

    public MyAccountPage clickEditLink() {
        context.wait.until(ExpectedConditions.elementToBeClickable(editLink));
        editLink.click();
        return this;
    }

    public MyAccountPage clickChangePasswordLink() {
        chnagePasswordLink.click();
        return this;
    }

    public String getContactInformation (){
       return contactInformation.getText();
    }

    public MyAccountPage fillFirstNameInputField(String value) {
        context.wait.until(ExpectedConditions.elementToBeClickable(firstNameInputField));
        firstNameInputField.clear();
        firstNameInputField.sendKeys(value);
        return this;
    }

    public MyAccountPage fillLastNameInputField(String value) {
        context.wait.until(ExpectedConditions.elementToBeClickable(lastNameInputField));
        lastNameInputField.clear();
        lastNameInputField.sendKeys(value);
        return this;
    }
    }



