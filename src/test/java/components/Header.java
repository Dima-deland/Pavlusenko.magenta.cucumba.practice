package components;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.CreateAccountPage;

public class Header extends BasePage {
    public Header(TestContext context) {
        super(context);
    }

    //elements---------------------------------------------------------

    @FindBy(xpath = "//*[@class='counter-number']")
    private WebElement cartCounter;

    @FindBy(xpath = "//div[@class='panel header']/ul[@class='header links']//a[contains(@href, 'create')]")
    private WebElement createAnAccountLink;

    //actions---------------------------------------------------------

    public int getCartCounterValue() {
        if (!cartCounter.isDisplayed()) return 0;
        context.wait.until(ExpectedConditions.visibilityOf(cartCounter));
        String counterText = cartCounter.getText();
        return Integer.parseInt(counterText);
    }

    public CreateAccountPage createAnAccountLinkClick() {
        createAnAccountLink.click();
        return new CreateAccountPage(context);
    }
}



