import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Helper{

    private WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Click an element with unique id
     * @param elementId
     */
    public void actionClickById(String elementId){
        driver.findElement(By.id(elementId)).click();
        System.out.println("Clicked element with ID " + elementId);
    }

    /**
     * Click and Element with XPath
     * @param xpath
     */
    public void actionClickBXPath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
        System.out.println("Clicked element with XPath " + xpath);
    }

    /**
     * Enter text into a text box by identifying it with ID
     * @param elementId
     * @param textToEnter
     */
    public void actionEnterTextById(String elementId, String textToEnter){
        driver.findElement(By.id(elementId)).clear();
        driver.findElement(By.id(elementId)).sendKeys(textToEnter);
        System.out.println("Entered Text " + textToEnter +  " in element with ID " + elementId);
    }

    /**
     * findElement takes 2 argument
     * 1st one if the element we are looking for
     * 2nd one is how are we going to find the element.
     * Pass 1 if you are passing ID and pass 2 if you are passing XPath
     *
     * Exapmpe:
     * 1. To search with ID: findElement("textBoxId", 1)
     * 2. To search with XPath: findElement("//div[@class='a-size-mini']", 2)
     *
     * @param elementFinder
     * @param type
     * @return WebElement
     */
    public WebElement findElement(String elementFinder, int type){
        switch (type){
            case 1:
                return driver.findElement(By.id(elementFinder));
            case 2:
                return driver.findElement(By.xpath(elementFinder));
            default:
                System.out.println("Wrong Choice.");
                return null;
        }
    }

    /**
     *
     * findElements takes 2 argument
     *      * 1st one if the element we are looking for
     *      * 2nd one is how are we going to find the element.
     *      * Pass 1 if you are passing ID and pass 2 if you are passing XPath
     *      *
     *      * Exapmpe:
     *      * 1. To search with ID: findElements("textBoxId", 1)
     *      * 2. To search with XPath: findElements("//div[@class='a-size-mini']", 2)
     *
     *
     * @param elementFinder
     * @param type
     * @return List<WebElement>
     */
    public List<WebElement> findElements(String elementFinder, int type){
        switch (type){
            case 1:
                return driver.findElements(By.id(elementFinder));
            case 2:
                return driver.findElements(By.xpath(elementFinder));
            default:
                System.out.println("Wrong Choice.");
                return null;
        }
    }

    /**
     *
     * When an element is not visible in the screen, this mehtod helps us to scrol to that element.
     *
     * @param element
     */
    public void scrollToElement(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
