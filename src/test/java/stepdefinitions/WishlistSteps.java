package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

import pages.WishlistPage;

public class WishlistSteps {

    WishlistPage wishlist;



    // LOGIN BEFORE WISHLIST TESTS

    @Given(
    "user logs into application for wishlist")

    public void loginWishlist() {

        wishlist = new WishlistPage(

        DriverFactory.getDriver());

        wishlist.loginApplication();
    }



    // SEARCH PRODUCT

    @When(
    "user searches product for wishlist")

    public void searchProduct() {

        wishlist.searchProduct();
    }



    // OPEN PRODUCT PAGE

    @And(
    "user opens searched product")

    public void openProduct() {

        wishlist.openProduct();
    }



    // ADD PRODUCT TO WISHLIST

    @And(
    "user adds product to wishlist")

    public void addWishlist() {

        wishlist.addToWishlist();
    }



    // VERIFY PRODUCT PRESENT

    @Then(
    "product should appear in wishlist")

    public void verifyWishlist() {

        Assert.assertTrue(

        wishlist.verifyWishlist(),

        "Wishlist product not found");
    }



    // OPEN WISHLIST PAGE

    @And(
    "user opens wishlist page")

    public void openWishlistPage() {

        wishlist.openWishlist();
    }



    // REMOVE PRODUCT

    @And(
    "user removes product from wishlist")

    public void removeWishlist() {

        wishlist.removeWishlistProduct();
    }



    // VERIFY EMPTY WISHLIST

    @Then(
    "wishlist should be empty")

    public void verifyRemovedWishlist() {

        Assert.assertTrue(

        wishlist.verifyRemoved(),

        "Wishlist is not empty");
    }



    // VERIFY WISHLIST PAGE

    @Then(
    "wishlist page should display")

    public void verifyWishlistPage() {

        Assert.assertTrue(

        wishlist.verifyWishlistPage(),

        "Wishlist page not displayed");
    }
}