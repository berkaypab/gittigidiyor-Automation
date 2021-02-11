package methods;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class Methods {

    public static Logger logger = LogManager.getLogger(Methods.class);
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    private RequiredMethods requiredMethods;

    public Methods() {
        this.driver = Driver.driver;
        wait = new WebDriverWait(this.driver, 15);
        action = new Actions(this.driver);
        requiredMethods = new RequiredMethods();
    }

    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElements(by);
    }

    public void checkBroken() {
        requiredMethods.checkBroken(driver);
    }

    public void sendKeys(By by, String value) {
        findElement(by).sendKeys(value);
    }

    public void click(By by) {
        findElement(by).click();
    }

    public JavascriptExecutor javascriptExecutor() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        return jse;
    }

    public void moveActions(By by) {
        action.moveToElement(findElement(by)).perform();
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public boolean getTextContains(By by, String value) {
        return getText(by).contains(value);
    }

    public void sendKeysPressEnter(By by, String value) {
        findElement(by).sendKeys(value, Keys.ENTER);
    }

    public void selectRandomProduct(By locator) {
        List<WebElement> allProducts = findElements(locator);
        Random rand = new Random();
        int randomProduct = rand.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
    }

    public boolean isExist(By by) {
        List<WebElement> elements = findElements(by);
        return elements.size() > 0 ? true : false;
    }

    public Select select(By by) {
        Select select = new Select(findElement(by));
        return select;
    }

    public void selectByValue(By by, String value) {
        select(by).selectByValue(value);
    }

    public boolean titleControlContains(String value) {
        return driver.getTitle().toLowerCase().contains(value);
    }
}
