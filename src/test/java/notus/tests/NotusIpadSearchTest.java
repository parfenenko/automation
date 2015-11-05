package notus.tests;

import framework.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import notus.pages.CheckoutPage;
import notus.pages.NotusHomePage;
import notus.pages.PreviewCartPage;
import notus.pages.SubCategoryPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by payu on 9/24/2015.
 */
public class NotusIpadSearchTest extends BaseTest {

    private SubCategoryPage subCategoryPage;
    private CheckoutPage checkoutPage;
    private PreviewCartPage previewCartPage;

    //        Test data
    String categoryName = "iPad";
    String modelName = "iPad mini 4";
    String productName = "Apple iPad mini 4 Wi-Fi+LTE 64Gb Gold (MK8C2, MK722)";
    int priceToValue = 18500;

    @BeforeTest
    public void openLoginPage() {
        openBrowser();
        openPage("http://www.notus.com.ua/");
    }

    @AfterTest
    public void finishTest() {
        closeBrowser();
    }

    @Test(priority = 1)
    public void verifyModelFilter() {
        NotusHomePage notusHomePage = new NotusHomePage();
        subCategoryPage = notusHomePage.selectSubCatergoryByName(categoryName);
        subCategoryPage.selectModelFromFilterMenu(modelName);
        List<String> actualProductNames = subCategoryPage.getListOfProductNames();

        for (String item : actualProductNames) {
            assertTrue(item.toLowerCase().contains(modelName.toLowerCase()));
        }
    }

    @Test(priority = 2)
    public void verifyPriceFilter() {
        subCategoryPage.setPriceTo(priceToValue);
        List<Integer> actualPrices = subCategoryPage.getActualPrices();

        for (Integer item : actualPrices) {
            assertTrue(item <= priceToValue);
        }
    }

    @Test(priority = 3)
    public void verifyProductNameInTheCart() {
        previewCartPage = subCategoryPage.clickBuyProduct();

        assertEquals(previewCartPage.getProductName(), productName);

        checkoutPage = previewCartPage.submitOrderButton();

        assertEquals(checkoutPage.getProductName(), productName);
    }
}
