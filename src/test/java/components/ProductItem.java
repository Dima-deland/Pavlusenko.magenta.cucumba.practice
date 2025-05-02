package components;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.ProductItemPage;

public class ProductItem extends BasePage {


    public ProductItem(TestContext context) {
        super(context);
    }

    //elements---------------------------------------------------------

    @FindBy(xpath = "//div[@class='product-item-info']")
    private WebElement productItemCard;

    //actions---------------------------------------------------------

    public ProductItemPage clickProductItemCard() {
        productItemCard.click();
        return new ProductItemPage(context);
    }

}
