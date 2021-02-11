package ObjectRepo;

import org.openqa.selenium.By;

public class ObjectRepo {

    public By goToLoginSection = By.cssSelector("div[class*='gekhq4-4 hwMdSM']");
    public By signInButton = By.cssSelector("a[class*='qjixn8-0 sc-1bydi5r-0']");
    public By usernameLabel = By.name("kullanici");
    public By passwordLabel = By.name("sifre");
    public By loginButton = By.id("gg-login-enter");
    public By userNameInHeader = By.cssSelector("div[class*='gekhq4-3 icMLoL']+span");
    public By searchProduct = By.name("k");
    public By currentPage = By.cssSelector("a[class*='current']");
    public By nextPage = By.cssSelector("li[class*='next-link'] a");
    public By productsList = By.cssSelector("li[id*='product_id_']");
    public By addToCartButton = By.cssSelector("button[id='add-to-basket']");
    public By price = By.cssSelector("div[class$='lastPrice']");
    public By cart = By.cssSelector("a[class*='gg-ui-btn-default padding-none']");
    public By totalPrice = By.xpath("//strong[contains(text(),'TL')][2]");
    public By drpDown = By.cssSelector("select[class='amount']");
    public By check= By.cssSelector("div[class*='product-item-box product']");
    public By deleteProductFromCart= By.cssSelector("a[class*='btn-delete btn-update-item hidden-m']");
    public By elements= By.cssSelector("div[class*='product-item-box product']");

}
