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
        context.wait.until(ExpectedConditions.visibilityOf(notification));
        return notification.getText();
    }
}


