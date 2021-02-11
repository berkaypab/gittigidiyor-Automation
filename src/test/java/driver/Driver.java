package driver;

import Constants.BaseData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class Driver {

    public static Logger logger = LogManager.getLogger(Driver.class);


    public static WebDriver driver;

    @Before
    public void onStart() {
        logger.info("test started");
        driver = WebDriverExec.getChromeDriver();
        driver.get(BaseData.baseURL);
    }


    @After
    public void onFinish() {
        logger.info("test completed");
        driver.quit();
    }


}
