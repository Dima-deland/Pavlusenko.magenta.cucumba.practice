package components;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class CookiesModal extends BasePage {
    public CookiesModal(TestContext context) {
        super(context);
        context.wait.until(ExpectedConditions.elementToBeClickable(acceptButton));
    }


    //elements---------------------------------------------------------

    @FindBy(xpath = "//button[@id='accept-btn']")
    private WebElement acceptButton;

    //actions---------------------------------------------------------

    public void clickAcceptCookiesButton() {
        acceptButton.click();
    }
}
