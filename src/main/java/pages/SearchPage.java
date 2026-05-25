package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver){

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20));
    }

    // Locators

    By searchBox =
            By.name("search");

    By searchBtn =
            By.xpath(
            "//button[contains(@class,'btn-default')]");

    By productResult =
            By.linkText("iPhone");

    By noResult =
            By.xpath(
            "//p[contains(text(),'There is no product')]");


    // Open search page

    public void openSearchPage(){

        driver.get(
        "https://tutorialsninja.com/demo/");
    }


    // Valid product search

    public void searchValidProduct(){

        openSearchPage();

        wait.until(
        ExpectedConditions
        .visibilityOfElementLocated(
        searchBox))
        .clear();

        driver.findElement(
        searchBox)
        .sendKeys(
        "iPhone");

        wait.until(
        ExpectedConditions
        .elementToBeClickable(
        searchBtn))
        .click();
    }


    // Invalid product search

    public void searchInvalidProduct(){

        openSearchPage();

        wait.until(
        ExpectedConditions
        .visibilityOfElementLocated(
        searchBox))
        .clear();

        driver.findElement(
        searchBox)
        .sendKeys(
        "XYZ123");

        wait.until(
        ExpectedConditions
        .elementToBeClickable(
        searchBtn))
        .click();
    }


    // Verify valid product

    public String verifyProduct(){

        return wait.until(
        ExpectedConditions
        .visibilityOfElementLocated(
        productResult))
        .getText();
    }


    // Verify no product result

    public String verifyNoResult(){

        return wait.until(
        ExpectedConditions
        .visibilityOfElementLocated(
        noResult))
        .getText();
    }

}