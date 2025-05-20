package components;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class Header extends BasePage {
    public Header(TestContext context) {
        super(context);
    }

    //elements---------------------------------------------------------

    @FindBy(xpath = "//*[@class='counter-number']")
    private WebElement cartCounter;

    @FindBy(xpath = "//div[@class='panel header']/ul[@class='header links']//a[contains(@href, 'create')]")
    private WebElement createAnAccountLink;

    @FindBy(xpath = "//span[@class='customer-name']//button[@class='action switch']")
    public WebElement userOptionsButton;

    @FindBy(xpath = "//div[@class='panel header']//ul[@class='header links']//li[@class='authorization-link']")
    public WebElement signInLink;

    @FindBy(xpath = "//li[@class='customer-welcome active']//li[@class='authorization-link']")
    private WebElement signOutOption;

    //actions---------------------------------------------------------

    public int getCartCounterValue() {
        context.wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(cartCounter)));
        String counterText = cartCounter.getText();
        return Integer.parseInt(counterText);
    }

    public Header createAnAccountLinkClick() {
        createAnAccountLink.click();
        return this;
    }

    public Header clickUserOptionsButton (){
        userOptionsButton.click();
        return this;
    }

    public Header clickSignOutOption (){
        signOutOption.click();
        return this;
    }
}