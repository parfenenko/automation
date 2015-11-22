package notus.pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by payu on 9/24/2015.
 */
public class SubCategoryPage extends BasePage{

    public SubCategoryPage() {waitPageLoaded(Locators.PAGE_LOCATOR, 5, "SubCategoryPage");}

    @Step
    public void selectModelFromFilterMenu(String linkText) {
        By LINK = (By.xpath(String.format(Locators.SUBCATEGORY_NAME, linkText)));
        clickOn(LINK);
    }

    @Step
    public List<String> getListOfProductNames() {
        List<String> listOfProductTitles = new ArrayList();
        List<WebElement> productList= $$(Locators.PRODUCT_TITLE);
        for (WebElement product : productList) {
            listOfProductTitles.add(product.getText());
        }
        return listOfProductTitles;
    }

    @Step
    public void setPriceTo(int priceTo) {
        inputText(Locators.PRICE_TO_FILTER, String.valueOf(priceTo));
        $(Locators.SET_PRICE_FILTER_OK_BUTTON).click();
    }

    @Step
    public List<Integer> getActualPrices() {
        List<Integer> listOfPrices = new ArrayList();
        List<WebElement> priceList = $$(Locators.PRODUCT_PRICE);
        for (WebElement price : priceList) {
            listOfPrices.add(Integer.valueOf(price.getText().replace(" грн", "")));
        }
        return listOfPrices;
    }

    @Step
    public PreviewCartPage clickBuyProductByName(String linkText) { // method is substituted by the clickBuyProduct because of problems with cyrillic symbols
        By LINK = (By.xpath(Locators.BUY_PRODUCT_BUTTON_BY_NAME));
        clickOn(LINK);
        return new PreviewCartPage();
    }

    @Step
    public PreviewCartPage clickBuyProduct() {
        $(Locators.BUY_PRODUCT).click();
        return new PreviewCartPage();
    }


    public interface Locators{
        By PAGE_LOCATOR = By.className("product_preview_filter");
        String SUBCATEGORY_NAME = "//ul[@class='subcategories']//a[contains(text(), '%s')]";
        By PRODUCT_TITLE = By.xpath("//div[@class='title_product']/a");
        By PRICE_TO_FILTER = By.xpath(".//*[@id='search_price_to']");
        By PRODUCT_PRICE = By.xpath("//table[@class='price_active']//tr[1]//span[@class='priceUAH']");
        By SET_PRICE_FILTER_OK_BUTTON = By.xpath("//a[contains(.,'Оk')]");
        String BUY_PRODUCT_BUTTON_BY_NAME = "(//div[@class=\"title_product\" and a[contains(text(), \"%s\")]]/..//span[text()=\"Купить\"])[1]"; //problems with cyrillic symbols
        By BUY_PRODUCT = By.cssSelector(".btn_oformit_zakaz>span");

    }
}
