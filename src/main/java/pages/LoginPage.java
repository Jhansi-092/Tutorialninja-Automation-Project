package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20));
    }

    // LOCATORS

    By myAccount =
    		By.xpath("//span[contains(text(),'My Account')]");
    By login =
            By.linkText("Login");

    By email =
            By.id("input-email");

    By password =
            By.id("input-password");

    By loginBtn =
            By.xpath("//input[@value='Login']");

    By accountHeader =
            By.xpath("//div[@id='content']//h2");

    By loginWarning =
            By.xpath("//div[contains(@class,'alert-danger')]");

    // Forgot Password

    By forgotPassword =
            By.linkText("Forgotten Password");

    By continueBtn =
            By.xpath("//input[@value='Continue']");

    By successReset =
            By.xpath("//div[contains(@class,'alert-success')]");

    // Logout

    By logoutLink =
            By.linkText("Logout");

    By logoutHeader =
            By.xpath("//div[@id='content']/h1");


    // COMMON METHOD

    public void openLoginPage() {

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
    }

    // VALID LOGIN
    public void loginUser() {

        openLoginPage();

        driver.findElement(email)
              .sendKeys(
              "existinguser@gmail.com");

        driver.findElement(password)
              .sendKeys(
              "Password123");

        driver.findElement(loginBtn)
              .click();
    }
    // VERIFY LOGIN

    public String verifyLogin() {

        return wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                accountHeader))
                .getText();
    }


    // INVALID LOGIN

    public void invalidLogin() {

        openLoginPage();

        driver.findElement(email)
                .sendKeys(
                        "wronguser@gmail.com");

        driver.findElement(password)
                .sendKeys(
                        "WrongPassword");

        driver.findElement(loginBtn)
                .click();
    }


    // LOGIN WARNING

    public String getLoginWarning() {

        return wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                loginWarning))
                .getText();
    }


    // FORGOT PASSWORD

    public void forgotPasswordFlow() {

        openLoginPage();

        wait.until(
                ExpectedConditions
                        .elementToBeClickable(
                                forgotPassword))
                .click();

        wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                email))
                .sendKeys(
                        "existinguser@gmail.com");

        driver.findElement(
                continueBtn)
                .click();
    }


    // RESET MESSAGE

    public String getResetMessage() {

        return wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                successReset))
                .getText();
    }


    // LOGOUT

    public void logoutUser() {

        for (int i = 0; i < 3; i++) {

            try {

                WebElement account =
                        wait.until(
                                ExpectedConditions
                                        .visibilityOfElementLocated(
                                                myAccount));

                ((JavascriptExecutor) driver)
                        .executeScript(
                                "arguments[0].click();",
                                account);

                break;

            }

            catch (StaleElementReferenceException e) {

                System.out.println(
                        "Retry My Account");
            }
        }

        wait.until(
                ExpectedConditions
                        .elementToBeClickable(
                                logoutLink))
                .click();

        wait.until(
                ExpectedConditions
                        .urlContains(
                                "logout"));
    }


    // VERIFY LOGOUT

    public String verifyLogout() {

        return wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                logoutHeader))
                .getText();
    }
}