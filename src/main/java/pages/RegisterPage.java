package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20));

    }

    // Updated locator
    By myAccount =
    		By.xpath("//span[contains(text(),'My Account')]");

    By register =
            By.linkText("Register");

    By firstName =
            By.id("input-firstname");

    By lastName =
            By.id("input-lastname");

    By email =
            By.id("input-email");

    By phone =
            By.id("input-telephone");

    By password =
            By.id("input-password");

    By confirmPassword =
            By.id("input-confirm");

    By agree =
            By.name("agree");

    By continueBtn =
            By.xpath("//input[@value='Continue']");

    By warningMessage =
            By.xpath("//div[contains(@class,'alert-danger')]");

    By privacyWarning =
            By.xpath("//div[contains(@class,'alert-danger')]");

    By firstNameWarning =
            By.xpath("//input[@id='input-firstname']/following::div[1]");

    By successMessage =
            By.xpath("//div[@id='content']/h1");


    // OPEN REGISTER PAGE
    public void openRegisterPage() {

        wait.until(
        ExpectedConditions
        .elementToBeClickable(
        myAccount))
        .click();

        wait.until(
        ExpectedConditions
        .elementToBeClickable(
        register))
        .click();
    }

    // VALID REGISTRATION

    public void registerUser() {

        openRegisterPage();

        driver.findElement(firstName)
                .sendKeys("Ballapuram");

        driver.findElement(lastName)
                .sendKeys("Jhansi Bai");

        driver.findElement(email)
                .sendKeys(
                        "test"
                                + System.currentTimeMillis()
                                + "@gmail.com");

        driver.findElement(phone)
                .sendKeys("8978870749");

        driver.findElement(password)
                .sendKeys("Password123");

        driver.findElement(confirmPassword)
                .sendKeys("Password123");

        driver.findElement(agree)
                .click();

        driver.findElement(continueBtn)
                .click();
    }


    // EXISTING USER

    public void registerExistingUser() {

        openRegisterPage();

        driver.findElement(firstName)
                .sendKeys("Ballapuram");

        driver.findElement(lastName)
                .sendKeys("Jhansi Bai");

        driver.findElement(email)
                .sendKeys(
                        "existinguser@gmail.com");

        driver.findElement(phone)
                .sendKeys("8978870749");

        driver.findElement(password)
                .sendKeys("Password123");

        driver.findElement(confirmPassword)
                .sendKeys("Password123");

        driver.findElement(agree)
                .click();

        driver.findElement(continueBtn)
                .click();
    }


    // EMPTY FORM

    public void submitEmptyRegistration() {

        openRegisterPage();

        driver.findElement(
                continueBtn)
                .click();
    }


    // VALIDATIONS

    public String getWarningMessage() {

        return wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                warningMessage))
                .getText();
    }

    public String getPrivacyWarning() {

        return wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                privacyWarning))
                .getText();
    }

    public String getFirstNameWarning() {

        return wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                firstNameWarning))
                .getText();
    }

    public String getSuccessMessage() {

        return wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                successMessage))
                .getText();
    }
}