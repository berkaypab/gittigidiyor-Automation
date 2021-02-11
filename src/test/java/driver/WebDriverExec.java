package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverExec {

    private static WebDriver driver;

    public static Logger logger = LogManager.getLogger(WebDriverExec.class);
    private static String sourceDirectory = System.getProperty("user.dir");

    public static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty(sourceDirectory + "/gittigidiyor-automation/", "chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies(); //delete all cookies
        driver.manage().window().maximize();
        return driver;
    }


}
