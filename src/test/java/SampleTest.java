import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class SampleTest extends BaseTest {


    @Test(groups = {"searchAndProductToCard"}, dataProvider = "getData")
    public void searchAndProductToCard(String brandCheckBoxXpath) throws InterruptedException {
        String searchText = "smartwatches";
        driver.manage().window().maximize();

        //driver.get() method has implicit wait and it will wait for all elements to load before going to next step
        driver.get(testUri);

        //Asserting if title is correct.
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title did not match");

        //click on search bar and enter text
        helper.actionEnterTextById(searchBarId, searchText);

        //Click on Search button
        helper.actionClickById(searchButtonId);

        String searchedText = helper.findElement(searchedTextXpath,2).getText();

        //Asserting if searched text is same as we entered
        Assert.assertTrue(searchedText.contains(searchText));

        //Click on Noise checkbox
        helper.actionClickBXPath(brandCheckBoxXpath);

        //Find element where we want to scroll and scroll there
        element = helper.findElement(lowPriceTextBoxId, 1);
        helper.scrollToElement(element);


        //Enter low and high price
        helper.actionEnterTextById(lowPriceTextBoxId,"1000");
        helper.actionEnterTextById(highPriceTextBoxId,"5000");

        //Click on Go button
        helper.actionClickBXPath(goButtonXpath);

        //Click on dropdown
        helper.actionClickBXPath(sortDropDownButtonXpath);

        Thread.sleep(1000);

        //Select Price High to low option
        helper.actionClickBXPath(highToLowOptionXpath);

        Thread.sleep((1000));

        //Get first product from the list of products
        WebElement product = helper.findElements(allProductsXpath,2).get(0);


        //Get first product detail
        String productDetails = product.getText();
        product.click();
        Thread.sleep(1000);

        //Switch tab to new tab
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));


        //Get product details from product page
        String productDetailsFromProductPage = helper.findElement(productTitleXpath, 2).getText();

        //Asserting if 1st product in results page after sorting is same a one opened in new tab
        Assert.assertTrue(productDetailsFromProductPage.equals(productDetails));

        //Add to Cart
        helper.actionClickById(addToCartId);
        Thread.sleep(2000);

        //Click close button after adding product to cart
        helper.actionClickById(sideSheetCrossButtonId);

        //Click on Cart
        helper.actionClickById(cartId);

        //Get product details from cart
        String productDetailsFromCart = helper.findElement(firstProductDetailInCartXpath,2).getText();
        productDetailsFromCart = productDetailsFromCart.substring(0, productDetailsFromCart.indexOf('…'));

        //Asserting if the product we added to cart is same as the one present on top of the cart.
        Assert.assertTrue(productDetailsFromProductPage.contains(productDetailsFromCart));

        driver.close();

        //Switch tab to main tab
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));

    }

    @AfterTest
    public void cleanUp(){
        driver.quit();
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[3][1];
        data[0][0] = fireBoltCheckBoxXpath;
        data[1][0] = boatCheckBoxXpath;
        data[2][0] = noiseCheckBoxXpath;

        return data;
    }


}
