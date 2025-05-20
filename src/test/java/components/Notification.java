package components;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class Notification extends BasePage {

    public Notification(TestContext context) {
        super(context);
    }

    //elements---------------------------------------------------------

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement notification;

    //actions---------------------------------------------------------

    public String getNotificationText() {
        // In project all notifications end with ".", so in this way program wait that message has text
        context.wait.until(ExpectedConditions.textToBePresentInElement(notification,"."));
        return notification.getText();
    }

}


