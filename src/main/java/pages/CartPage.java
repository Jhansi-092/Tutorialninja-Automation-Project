package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20));

        PageFactory.initElements(
                driver,
                this);
    }

    // ================= LOGIN ELEMENTS =================

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccount;

    @FindBy(linkText = "Login")
    WebElement loginBtn;

    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginSubmit;


    // ================= LOCATORS =================

    By searchBox =
            By.name("search");

    By searchBtn =
            By.xpath(
            "//button[contains(@class,'btn-default')]");

    By productLocator =
            By.linkText(
            "HP LP3065");

    By addCartLocator =
            By.id(
            "button-cart");

    By cartMenu =
            By.id(
            "cart-total");

    By viewCart =
            By.linkText(
            "View Cart");

    By quantityField =
            By.xpath(
            "//input[contains(@name,'quantity')]");

    By updateButton =
            By.xpath(
            "//button[@data-original-title='Update']");

    By removeButton =
            By.xpath(
            "//button[@data-original-title='Remove']");

    By emptyCart =
            By.xpath(
            "//div[@id='content']//p[contains(text(),'Your shopping cart is empty')]");

    By totalLocator =
            By.xpath(
            "//td[contains(text(),'Total') or contains(text(),'Sub-Total')]");


    // ================= LOGIN =================

    public void loginApplication() {

        driver.get(
        "https://tutorialsninja.com/demo/");

        wait.until(
        ExpectedConditions
        .elementToBeClickable(
        myAccount))
        .click();

        wait.until(
        ExpectedConditions
        .elementToBeClickable(
        loginBtn))
        .click();

        wait.until(
        ExpectedConditions
        .visibilityOf(
        email))
        .sendKeys(
        "existinguser@gmail.com");

        password.sendKeys(
        "Password123");

        loginSubmit.click();

        System.out.println(
        "Login successful");
    }


    // ================= SEARCH PRODUCT =================

    public void searchProduct() {

        int retry = 3;

        while(retry > 0) {

            try {

                WebElement search =

                wait.until(

                ExpectedConditions.refreshed(

                ExpectedConditions
                .elementToBeClickable(
                searchBox)

                )

                );

                search.click();

                search.sendKeys(
                Keys.CONTROL + "a");

                search.sendKeys(
                Keys.DELETE);

                search.sendKeys(
                "HP LP3065");

                wait.until(

                ExpectedConditions
                .elementToBeClickable(
                searchBtn)

                ).click();

                System.out.println(
                "Product searched");

                return;

            }

            catch(
            StaleElementReferenceException e) {

                retry--;

                System.out.println(
                "Retry search");

            }

        }

        throw new RuntimeException(
        "Search failed");
    }


    // ================= OPEN PRODUCT =================

    public void openProduct() {

        wait.until(
        ExpectedConditions
        .elementToBeClickable(
        productLocator))
        .click();

        System.out.println(
        "Product opened");
    }


    // ================= ADD PRODUCT =================

    public void addProductCart() {

        wait.until(
        ExpectedConditions
        .elementToBeClickable(
        addCartLocator))
        .click();

        wait.until(
        ExpectedConditions
        .visibilityOfElementLocated(
        cartMenu));

        System.out.println(
        "Product added");
    }


    // ================= OPEN CART =================

    public void openCart() {

        int retry = 3;

        while(retry > 0) {

            try {

                WebElement cart =

                wait.until(
                ExpectedConditions
                .elementToBeClickable(
                cartMenu));

                ((JavascriptExecutor)driver)
                .executeScript(
                "arguments[0].click();",
                cart);

                WebElement view =

                wait.until(
                ExpectedConditions
                .visibilityOfElementLocated(
                viewCart));

                view.click();

                System.out.println(
                "Cart opened");

                return;

            }

            catch(Exception e) {

                retry--;

                System.out.println(
                "Retry cart click");
            }

        }

        throw new RuntimeException(
        "Unable to open cart");
    }
    public void updateQuantity() {

        try {

            driver.get(
            "https://tutorialsninja.com/demo/index.php?route=checkout/cart");

            WebElement quantity =

            wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(

            By.xpath(
            "(//input[contains(@name,'quantity')])[1]")

            ));

            quantity.clear();

            quantity.sendKeys("2");

            WebElement updateBtn =

            wait.until(
            ExpectedConditions
            .elementToBeClickable(

            By.xpath(
            "(//button[@data-original-title='Update'])[1]")

            ));

            ((JavascriptExecutor)driver)

            .executeScript(
            "arguments[0].click();",
            updateBtn);

            wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(

            By.cssSelector(
            ".alert-success")

            ));

            System.out.println(
            "Quantity updated");

        }

        catch(Exception e) {

            throw new RuntimeException(
            "Cart quantity update failed : "
            + e.getMessage());
        }
    }
    // ================= VERIFY QUANTITY =================

    public boolean verifyUpdatedQuantity() {

        try {

            openCart();

            String qty =

            wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(
            quantityField))
            .getAttribute(
            "value");

            return qty.equals(
            "2");

        }

        catch(Exception e) {

            return false;
        }
    }


    // ================= REMOVE ITEM =================

    public void removeCartItem() {

        openCart();

        wait.until(
        ExpectedConditions
        .elementToBeClickable(
        removeButton))
        .click();

        wait.until(
        ExpectedConditions
        .visibilityOfElementLocated(
        emptyCart));

        System.out.println(
        "Cart removed");
    }


    // ================= VERIFY PRODUCT =================

    public boolean verifyCart() {

        try {

            openCart();

            WebElement product =

            wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(

            By.linkText(
            "HP LP3065")

            ));

            return product.isDisplayed();

        }

        catch(Exception e) {

            return false;
        }
    }


    // ================= VERIFY EMPTY CART =================

    public boolean verifyRemovedCart() {

        try {

            return wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(
            emptyCart))
            .isDisplayed();

        }

        catch(Exception e) {

            return false;
        }
    }


    // ================= VERIFY TOTAL =================

    public boolean verifyCartTotal() {

        try {

            openCart();

            WebElement total =

            wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(
            totalLocator));

            return total.isDisplayed();

        }

        catch(Exception e) {

            return false;
        }
    }
    public void clearCart() {

        try {

            driver.get(
            "https://tutorialsninja.com/demo/index.php?route=checkout/cart");

            List<WebElement> removeButtons =

            driver.findElements(
            By.xpath(
            "//button[contains(@data-original-title,'Remove')]"));

            while(removeButtons.size() > 0) {

                removeButtons.get(0).click();

                wait.until(
                ExpectedConditions.stalenessOf(
                removeButtons.get(0)));

                removeButtons = driver.findElements(
                By.xpath(
                "//button[contains(@data-original-title,'Remove')]"));
            }

            System.out.println(
            "Cart cleared");

        }

        catch(Exception e) {

            System.out.println(
            "Cart already empty");
        }
    }
}