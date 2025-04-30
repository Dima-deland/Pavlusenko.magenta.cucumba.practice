package pages;

import components.Header;
import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigurationReader;

public class ProductItemPage extends BasePage {
    public ProductItemPage(TestContext context) {
        super(context);

        context.wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        context.wait.until(ExpectedConditions.visibilityOf(chooseColorButton));
        context.wait.until(ExpectedConditions.visibilityOf(chooseSizeButton));
    }
    Header header;

    // Page elements
    @FindBy(xpath = "//*[@id='product-addtocart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[contains(@id, 'option-label-size')]")
    private WebElement chooseSizeButton;

    @FindBy(xpath = "//div[contains(@id, 'option-label-color')]")
    private WebElement chooseColorButton;

    // Page actions

    public ProductItemPage clickAddToCartButton() {
        addToCartButton.click();
        return new ProductItemPage(context);
    }

    public ProductItemPage clickChooseSizeButton() {
        chooseSizeButton.click();
        return new ProductItemPage(context);
    }

    public ProductItemPage clickChooseColorButton() {
        chooseColorButton.click();
        return new ProductItemPage(context);
    }
}
