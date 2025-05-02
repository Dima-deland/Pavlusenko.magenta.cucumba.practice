package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(TestContext context) {
        super(context);
        context.wait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com"));
        context.wait.until(ExpectedConditions.visibilityOf(homePageTitle));
    }

    //elements---------------------------------------------------------

    @FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
    private WebElement homePageTitle;

    //actions---------------------------------------------------------

    public String getPageTitleText() {
        return homePageTitle.getText();
    }
}

