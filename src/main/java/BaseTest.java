import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public WebElement element;

    public String testUri;
    public String searchBarId;
    public String searchButtonId;
    public String noiseCheckBoxXpath;
    public String boatCheckBoxXpath;
    public String fireBoltCheckBoxXpath;
    public String lowPriceTextBoxId;
    public String highPriceTextBoxId;
    public String goButtonXpath;
    public String sortDropDownButtonXpath;
    public String highToLowOptionXpath;
    public String allProductsXpath;
    public String productTitleXpath;
    public String addToCartId;
    public String sideSheetCrossButtonId;
    public String cartId;
    public String firstProductDetailInCartXpath;


    public String searchedTextXpath;
    public String chromeDriver;


    //Validations
    public String expectedTitle;


    protected Helper helper;

    public BaseTest(){
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {


        FileInputStream file = new FileInputStream("src/test/resources/testFlow.properties");
        Properties dictionary = new Properties();
        dictionary.load(file);

        testUri = dictionary.get("testUri").toString();
        searchBarId = dictionary.get("searchBarId").toString();
        searchButtonId = dictionary.get("searchButtonId").toString();
        noiseCheckBoxXpath = dictionary.get("noiseCheckBoxXpath") .toString();
        boatCheckBoxXpath = dictionary.get("boatCheckBoxXpath") .toString();
        fireBoltCheckBoxXpath = dictionary.get("fireBoltCheckBoxXpath") .toString();
        lowPriceTextBoxId = dictionary.get("lowPriceTextBoxId").toString();
        highPriceTextBoxId = dictionary.get("highPriceTextBoxId").toString();
        goButtonXpath = dictionary.get("goButtonXpath").toString();
        sortDropDownButtonXpath = dictionary.get("sortDropDownButtonXpath").toString();
        highToLowOptionXpath = dictionary.get("highToLowOptionXpath").toString();
        allProductsXpath = dictionary.get("allProductsXpath").toString();
        productTitleXpath = dictionary.get("productTitleXpath").toString();
        addToCartId = dictionary.get("addToCartId").toString();
        sideSheetCrossButtonId = dictionary.get("sideSheetCrossButtonId").toString();
        cartId = dictionary.get("cartId").toString();
        firstProductDetailInCartXpath = dictionary.get("firstProductDetailInCartXpath").toString();


        searchedTextXpath = dictionary.get("searchedTextXpath").toString();
        chromeDriver = dictionary.get("chromeDriver").toString();

        //Validation
        expectedTitle = dictionary.get("expectedTitle").toString();


        System.setProperty("webdriver.chrome.driver",chromeDriver);
        driver = new ChromeDriver();
        helper = new Helper(driver);
    }

}
