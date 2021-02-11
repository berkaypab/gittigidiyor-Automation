package step;

import Constants.BaseData;

import ObjectRepo.ObjectRepo;
import methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ChooseItemFunc {

    private static Logger logger = LogManager.getLogger(ChooseItemFunc.class);
    private Methods methods;
    private ObjectRepo obj;


    public ChooseItemFunc() {
        methods = new Methods();
        obj = new ObjectRepo();
    }

    public void checkBroken() {
        methods.checkBroken();
    }

    public void LogIn() {
        logger.info("Test is started");
        logger.info("Checking page landing");
        Assert.assertTrue(methods.titleControlContains("gittigidiyor"));
        methods.moveActions(obj.goToLoginSection);
        methods.click(obj.signInButton);
        logger.info("Entering Username " + BaseData.email);
        methods.sendKeys(obj.usernameLabel, BaseData.email);
        logger.info("Entering Password " + BaseData.pass);
        methods.sendKeys(obj.passwordLabel, BaseData.pass);
        logger.info("Login button click");
        methods.click(obj.loginButton);
        logger.info("Logged In");
        Assert.assertFalse(methods.getTextContains(obj.userNameInHeader, "veya Üye Ol")); //Verify Login Process
    }

    public void Search() {
        logger.info("Sending keys to search box");
        methods.sendKeysPressEnter(obj.searchProduct, BaseData.searchFor);
    }

    public void Pagination() {
        logger.info("Pagination started");
        int cPageValue = 1;
        do {
            methods.javascriptExecutor().executeScript("scroll(0, 7000)");
            methods.click(obj.nextPage);
            cPageValue = Integer.parseInt(methods.getText(obj.currentPage));
            logger.info("Page : " + cPageValue);
        }
        while (cPageValue != BaseData.requiredPageNumber);
        Assert.assertTrue("Page number is : " + cPageValue, true);
    }

    public void AddWishList() throws InterruptedException {
        logger.info("Selecting random product");
        methods.selectRandomProduct(obj.productsList);
        String productFirstPrice = methods.getText(obj.price);
        methods.javascriptExecutor().executeScript("scroll(0, 300)");
        methods.click(obj.addToCartButton);
        Thread.sleep(1000);
        methods.moveActions(obj.cart);
        methods.click(obj.cart);
        String productSecondPrice = methods.getText(obj.totalPrice);
        logger.info("Verifying prices");
        Assert.assertTrue(productFirstPrice.contains(productSecondPrice));
        logger.info("Increasing item count ");
        methods.selectByValue(obj.drpDown,"2");
        Thread.sleep(1200);
        logger.info("Product deleting");
        methods.click(obj.deleteProductFromCart);
        logger.info("Verify product delete process");
        methods.isExist(obj.check);

    }
}
