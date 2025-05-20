package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    public ProductPage(TestContext context) {
        super(context);
    }

    //elements---------------------------------------------------------

    @FindBy(xpath = "//*[@id='product-addtocart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[contains(@id, 'option-label-size')]")
    private WebElement chooseSizeButton;

    @FindBy(xpath = "//div[contains(@id, 'option-label-color')]")
    private WebElement chooseColorButton;

    //actions---------------------------------------------------------

    public ProductPage clickAddToCartButton() {
        context.wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
        return this;
    }

    public ProductPage clickChooseSizeButton() {
        context.wait.until(ExpectedConditions.elementToBeClickable(chooseSizeButton));
        chooseSizeButton.click();
        return this;
    }

    public ProductPage clickChooseColorButton() {
        context.wait.until(ExpectedConditions.elementToBeClickable(chooseColorButton));
        chooseColorButton.click();
        return this;
    }
}
