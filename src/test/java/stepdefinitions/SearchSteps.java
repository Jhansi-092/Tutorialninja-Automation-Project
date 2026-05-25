package stepdefinitions;

import org.testng.Assert;

import base.DriverFactory;

import io.cucumber.java.en.*;

import pages.SearchPage;

public class SearchSteps {

    SearchPage search;

    @Given(
    "user opens search page")

    public void openSearch(){

        search =
        new SearchPage(
        DriverFactory.getDriver());

        search.openSearchPage();
    }


    @When(
    "user searches for valid product")

    public void searchProduct(){

        search.searchValidProduct();
    }


    @When(
    "clicks search button")

    public void clickSearch(){

        // already handled inside SearchPage
    }


    @Then(
    "product should display successfully")

    public void verifyProduct(){

        String actual =
        search.verifyProduct();

        Assert.assertEquals(
        actual,
        "iPhone");
    }


    @When(
    "user searches invalid product")

    public void invalidSearch(){

        search.searchInvalidProduct();
    }


    @Then(
    "no product warning should display")

    public void verifyNoProduct(){

        String actual =
        search.verifyNoResult();

        System.out.println(
        "No Product Message = "
        + actual);

        Assert.assertTrue(
        actual.contains(
        "There is no product"));
    }

}