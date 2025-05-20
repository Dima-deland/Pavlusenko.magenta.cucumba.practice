package pages;

import context.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(TestContext context) {
        super(context);
        context.wait.until(ExpectedConditions.titleIs("Shopping Cart"));
    }

    //elements---------------------------------------------------------

    @FindBy(xpath = "//div[@class='cart-empty']")
    private WebElement cartEmptyInfoText;

    @FindBy(xpath = "//*[@data-ui-id='page-title-wrapper']")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[@class='item-info']")
    private WebElement productItem;

    @FindBy(xpath = "//*[@class='item-info']")
    private List<WebElement> productItems;

    @FindBy(xpath = "//input[contains(@name, '[qty]')]")
    private WebElement productQuantityField;

    @FindBy(xpath = "//button[@class='action update']")
    private WebElement updateShoppingCartButton;

    @FindBy(xpath = "//a[@class='action action-delete']")
    private WebElement removeItemButton;

    //actions---------------------------------------------------------

    public int countProductItems() {
        List<WebElement> elements = context.driver.findElements(By.xpath("//*[@class='item-info']"));
        return elements.size();
    }

    public CartPage setProductQuantityField(int quantity) {
        context.wait.until(ExpectedConditions.elementToBeClickable(productQuantityField));
        productQuantityField.clear();
        productQuantityField.sendKeys(String.valueOf(quantity));
        return this;
    }

    public int getProductQuantityField() {
        context.wait.until(ExpectedConditions.attributeToBeNotEmpty(productQuantityField,"value"));
        String value = productQuantityField.getCssValue("value");
        if (!value.isEmpty()) return Integer.parseInt(value);
        else return 0;
    }

    public CartPage clickUpdateShoppingCartButton() {
        updateShoppingCartButton.click();
        context.wait.until(ExpectedConditions.visibilityOf(updateShoppingCartButton));
        return this;
    }

    public CartPage clickRemoveItemButton() {
        context.wait.until(ExpectedConditions.elementToBeClickable(removeItemButton));
        removeItemButton.click();
        return this;
    }

    public String getCartEmptyInfoText() {
        context.wait.until(ExpectedConditions.visibilityOf(cartEmptyInfoText));
        return cartEmptyInfoText.getText();
    }

}

