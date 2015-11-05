package rabota;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by payu on 9/24/2015.
 */
public class SubCategoryPage extends BasePage{

    public SubCategoryPage() {waitPageLoaded(Locators.PAGE_LOCATOR, 10, "SubCategoryPage");}

    public void selectModelFromFilterMenu(String linkText) {
        By LINK = (By.xpath(String.format(Locators.SUBCATEGORY_NAME, linkText)));
        clickOn(LINK);
    }

    public List<String> getListOfProductNames() {
        List<String> listOfProductTitles = new ArrayList<String>();
        List<WebElement> productList= $$(Locators.PRODUCT_TITLE);
        for (WebElement product : productList) {
            listOfProductTitles.add(product.getText());
        }
        return listOfProductTitles;
    }

    public void setPriceTo(int priceTo) {
        inputText(Locators.PRICE_TO_FILTER, String.valueOf(priceTo));
        $(Locators.PRICE_FILTER_OK_BUTTON).click();
        waitUntilElementLoaded(Locators.PRODUCT_TITLE, 5, "PRODUCT_TITLE");
    }

    public List<Integer> getActualPrices() {
        List<Integer> listOfPrices = new ArrayList<Integer>();
        List<WebElement> priceList = $$(Locators.PRODUCT_PRICE);
        for (WebElement price : priceList) {
            String priceString = price.getText();
            listOfPrices.add(Integer.valueOf(price.getText().replace(" грн", "")));
        }
        return listOfPrices;
    }

    public PreviewCartPage addProductToCart(String productName) {
    }


    public interface Locators{
        String SUBCATEGORY_NAME = "//ul[@class='subcategories']//a[contains(text(), '%s')]";
        By PRODUCT_TITLE = By.xpath("//div[@class='title_product']/a");
        By PAGE_LOCATOR = By.className("product_preview_filter");
        By PRICE_TO_FILTER = By.xpath(".//*[@id='search_price_to']");
        By PRODUCT_PRICE = By.xpath("//table[@class='price_active']//tr[1]//span[@class='priceUAH']");
        By PRICE_FILTER_OK_BUTTON = By.xpath("//a[contains(.,'Оk')]");
    }
}
