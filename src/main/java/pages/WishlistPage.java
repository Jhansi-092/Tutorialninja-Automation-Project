package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage {

    WebDriver driver;
    WebDriverWait wait;

    public WishlistPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20));
    }


    // LOGIN LOCATORS

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


    // SEARCH LOCATORS

    By searchBox =
            By.name("search");

    By searchBtn =
            By.xpath(
            "//button[contains(@class,'btn-default')]");

    By product =
            By.linkText(
            "HP LP3065");


    // WISHLIST LOCATORS

    By addWishlist =
            By.xpath(
            "//button[@data-original-title='Add to Wish List']");

    By wishlistLink =
            By.id("wishlist-total");


    // MUST MATCH SEARCHED PRODUCT

    By wishlistProduct =
            By.linkText(
            "HP LP3065");


    By removeBtn =
            By.xpath(
            "//a[contains(@data-original-title,'Remove')]");

    By emptyWishlist =
            By.xpath(
            "//div[@id='content']/p");

    By wishlistHeading =
            By.xpath(
            "//div[@id='content']/h2");


    // LOGIN

    public void loginApplication() {

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
        "Wishlist login successful");
    }



    // SEARCH PRODUCT

    public void searchProduct() {

        int retry = 5;

        while(retry > 0) {

            try {

                WebElement searchField =

                wait.until(
                ExpectedConditions
                .visibilityOfElementLocated(
                searchBox));

                searchField.click();

                // remove old text safely

                searchField.sendKeys(
                Keys.CONTROL + "a");

                searchField.sendKeys(
                Keys.DELETE);

                searchField.sendKeys(
                "HP LP3065");

                wait.until(
                ExpectedConditions
                .elementToBeClickable(
                searchBtn))
                .click();

                wait.until(
                ExpectedConditions
                .visibilityOfElementLocated(
                product));

                System.out.println(
                "Wishlist product searched");

                return;
            }

            catch(
            StaleElementReferenceException e) {

                retry--;

                System.out.println(
                "Retry wishlist search");
            }

            catch(Exception e) {

                retry--;

                System.out.println(
                "Retry search");
            }
        }

        throw new RuntimeException(
        "Wishlist search failed");
    }



    // OPEN PRODUCT

    public void openProduct() {

        wait.until(
        ExpectedConditions
        .elementToBeClickable(
        product))
        .click();

        System.out.println(
        "Wishlist product opened");
    }



    // ADD PRODUCT TO WISHLIST

    public void addToWishlist() {

        wait.until(
        ExpectedConditions
        .elementToBeClickable(
        addWishlist))
        .click();

        wait.until(
        ExpectedConditions
        .visibilityOfElementLocated(

        By.xpath(
        "//div[contains(@class,'alert-success')]")));

        System.out.println(
        "Added to wishlist");
    }



    // OPEN WISHLIST
    public void openWishlist() {

        try {

            Thread.sleep(2000);

            WebElement wishlistBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.id("wishlist-total")));

            ((JavascriptExecutor) driver)
                    .executeScript(
                            "arguments[0].click();",
                            wishlistBtn);

            System.out.println("Wishlist opened");

        }

        catch (Exception e) {

            System.out.println(
                    "Retry wishlist click");

            driver.navigate().refresh();

            WebElement retryBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.id("wishlist-total")));

            ((JavascriptExecutor) driver)
                    .executeScript(
                            "arguments[0].click();",
                            retryBtn);

        }
    }
    // VERIFY PRODUCT PRESENT

    public boolean verifyWishlist() {

        try {

            openWishlist();

            return wait.until(

            ExpectedConditions
            .visibilityOfElementLocated(
            wishlistProduct))
            .isDisplayed();

        }

        catch(Exception e) {

            return false;
        }
    }



    // REMOVE PRODUCT

    public void removeWishlistProduct() {

        wait.until(
        ExpectedConditions
        .elementToBeClickable(
        removeBtn))
        .click();

        System.out.println(
        "Wishlist item removed");
    }



    // VERIFY EMPTY WISHLIST

    public boolean verifyRemoved() {

        try {

            String msg =

            wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(
            emptyWishlist))
            .getText();

            return msg.contains(
            "Your wish list is empty");
        }

        catch(Exception e) {

            return false;
        }
    }



    // VERIFY PAGE

    public boolean verifyWishlistPage() {

        try {

            String heading =

            wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(
            wishlistHeading))
            .getText();

            System.out.println(
            "Wishlist Heading = "
            + heading);

            return heading.contains(
            "My Wish List");
        }

        catch(Exception e) {

            return false;
        }
    }
}