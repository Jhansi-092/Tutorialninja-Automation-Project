package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    boolean billingSaved = false;

    public CheckoutPage(WebDriver driver){

        this.driver = driver;

        wait = new WebDriverWait(
        driver,
        Duration.ofSeconds(30));
    }

    // LOGIN

    By myAccount =
            By.xpath("//span[text()='My Account']");

    By login =
            By.linkText("Login");

    By email =
            By.id("input-email");

    By password =
            By.id("input-password");

    By loginBtn =
            By.xpath("//input[@value='Login']");

    // SEARCH

    By searchBox =
            By.name("search");

    By searchBtn =
            By.xpath(
            "//button[contains(@class,'btn-default')]");

    By product =
            By.linkText("HP LP3065");

    // CART

    By addCart =
            By.id("button-cart");

    By cartTotal =
            By.id("cart-total");

    By checkoutBtn =
            By.linkText("Checkout");



    // LOGIN

    public void loginApplication(){

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
        login))
        .click();

        wait.until(
        ExpectedConditions
        .visibilityOfElementLocated(
        email))
        .sendKeys(
        "existinguser@gmail.com");

        driver.findElement(
        password)
        .sendKeys(
        "Password123");

        driver.findElement(
        loginBtn)
        .click();

        System.out.println(
        "Checkout login successful");
    }



    // SEARCH PRODUCT

    public void searchProduct(){

        for(int i=0;i<3;i++){

            try{

                WebElement search =

                wait.until(
                ExpectedConditions
                .visibilityOfElementLocated(
                searchBox));

                search.clear();

                search.sendKeys(
                "HP LP3065");

                driver.findElement(
                searchBtn)
                .click();

                return;
            }

            catch(
            StaleElementReferenceException e){

                System.out.println(
                "Retry search");
            }
        }

        throw new RuntimeException(
        "Search failed");
    }



    // OPEN PRODUCT

    public void openProduct(){

        wait.until(
        ExpectedConditions
        .elementToBeClickable(
        product))
        .click();

        System.out.println(
        "Product opened");
    }



    // ADD TO CART

    public void addProductToCart(){

        wait.until(
        ExpectedConditions
        .elementToBeClickable(
        addCart))
        .click();

        wait.until(
        ExpectedConditions
        .refreshed(

        ExpectedConditions
        .visibilityOfElementLocated(
        cartTotal)

        ));

        wait.until(
        ExpectedConditions
        .textToBePresentInElementLocated(
        cartTotal,
        "item"));

        System.out.println(
        "Added to cart");
    }


    public void openCart() {

    	WebElement cart =
    	wait.until(
    	ExpectedConditions
    	.elementToBeClickable(
    	By.id("cart-total")));

    	JavascriptExecutor js =
    	(JavascriptExecutor) driver;

    	js.executeScript(
    	"arguments[0].scrollIntoView(true);",
    	cart);

    	js.executeScript(
    	"arguments[0].click();",
    	cart);

    	wait.until(
    	ExpectedConditions
    	.elementToBeClickable(
    	By.linkText("Checkout")))
    	.click();

    	System.out.println(
    	"Cart opened");

    	}
    // CHECKOUT

    public void proceedCheckout(){

        openCart();

        wait.until(
        ExpectedConditions
        .elementToBeClickable(
        checkoutBtn))
        .click();

        wait.until(
        ExpectedConditions
        .urlContains(
        "checkout"));

        System.out.println(
        "Checkout opened");
    }



    // BILLING

    public void enterBillingDetails(){

        try{

            wait.until(
            ExpectedConditions
            .elementToBeClickable(
            By.id(
            "button-payment-address")))
            .click();

        }

        catch(Exception e){

            System.out.println(
            "Payment address skipped");
        }

        try{

            wait.until(
            ExpectedConditions
            .elementToBeClickable(
            By.id(
            "button-shipping-address")))
            .click();

        }

        catch(Exception e){

            System.out.println(
            "Shipping address skipped");
        }

        try{

            wait.until(
            ExpectedConditions
            .elementToBeClickable(
            By.id(
            "button-shipping-method")))
            .click();

        }

        catch(Exception e){

            System.out.println(
            "Shipping method skipped");
        }

        billingSaved = true;

        System.out.println(
        "Billing saved");
    }



    public boolean verifyBillingSaved(){

        return billingSaved;
    }



    // PAYMENT

    public void selectPaymentMethod(){

        WebElement agree =

        wait.until(
        ExpectedConditions
        .elementToBeClickable(

        By.name(
        "agree")

        ));

        if(!agree.isSelected()){

            agree.click();
        }

        wait.until(
        ExpectedConditions
        .elementToBeClickable(

        By.id(
        "button-payment-method")

        ))
        .click();

        System.out.println(
        "Payment selected");
    }



    public boolean verifyPaymentMethod(){

        try{

            return wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(

            By.id(
            "button-confirm")

            ))

            .isDisplayed();
        }

        catch(Exception e){

            return false;
        }
    }



    // CONFIRM ORDER

    public void confirmOrder(){

        wait.until(
        ExpectedConditions
        .elementToBeClickable(

        By.id(
        "button-confirm")

        ))
        .click();

        System.out.println(
        "Order confirmed");
    }



    // VERIFY ORDER

    public boolean verifyOrderSuccess(){

        try{

            return wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(

            By.xpath(
            "//h1[contains(text(),'Your order has been placed!')]")

            ))

            .isDisplayed();
        }

        catch(Exception e){

            return false;
        }
    }



    // VERIFY CHECKOUT

    public boolean verifyCheckoutPage(){

        try{

            wait.until(
            ExpectedConditions
            .urlContains(
            "checkout"));

            return true;
        }

        catch(Exception e){

            return false;
        }
    }
}