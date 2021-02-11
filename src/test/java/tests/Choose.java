package tests;
import driver.Driver;
import org.junit.BeforeClass;
import org.junit.Test;
import methods.RequiredMethods;
import step.ChooseItemFunc;
public class Choose extends Driver {
    @Test
    public void ChooseItemTestCase() throws InterruptedException {

        ChooseItemFunc chooseItemFunc = new ChooseItemFunc();
        chooseItemFunc.LogIn();
        chooseItemFunc.Search();
        chooseItemFunc.Pagination();
        chooseItemFunc.AddWishList();
    }

    @Test
    public void checkBroken() {
        ChooseItemFunc chooseItemFunc = new ChooseItemFunc();
        chooseItemFunc.LogIn();
        chooseItemFunc.checkBroken();
    }

}