package rabota.tests;

import framework.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rabota.NotusHomePage;
import rabota.SubCategoryPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by payu on 9/24/2015.
 */
public class NotusIpadSearchTest extends BaseTest {

    private SubCategoryPage subCategoryPage;

    //        Test data
    String categoryName = "iPad";
    String modelName = "iPad Mini 3";
    String productName = "Apple iPad Air Wi-Fi 16GB Space Gray (MD785, MD781) NEW";
    int priceToValue = 10000;

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
    public void verifyPriceFilter(){
        subCategoryPage.setPriceTo(priceToValue);
        List<Integer> actualPrices = subCategoryPage.getActualPrices();

        for (Integer item : actualPrices){
            assertTrue(item <= priceToValue);
        }
    }

//    @Test(priority = 3)
//    public void verifyProductNameInTheCart(){
//        PreviewCartPage previewCartPage = subCategory.addProductToCart(productName);
//
//        assertEquals(previewCartPage.getProductName(), productName);
//
//        CheckoutPage checkoutPage = previewCartPage.submitOrderButton();
//
//        assertEquals(checkoutPage.getProductName(), productName);
//
//    }
}
