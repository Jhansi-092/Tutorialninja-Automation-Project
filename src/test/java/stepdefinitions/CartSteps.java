package stepdefinitions;

import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;

public class CartSteps {

    private CartPage cartPage;

    // GET CART OBJECT

    private CartPage getCart() {

        if (cartPage == null) {

            cartPage = new CartPage(
                    DriverFactory.getDriver());
        }

        return cartPage;
    }


    // LOGIN + CLEAR CART

    @Given(
    "user logs into application for cart")
    public void loginCart() {

        CartPage cart = getCart();

        cart.loginApplication();

        cart.clearCart();

        System.out.println(
        "Login successful");

    }


    // SEARCH PRODUCT

    @When(
    "user searches product for cart")
    public void searchProduct() {

        getCart()
        .searchProduct();

        System.out.println(
        "Product searched");

    }


    // OPEN PRODUCT

    @And(
    "user opens cart product")
    public void openProduct() {

        getCart()
        .openProduct();

        System.out.println(
        "Product opened");

    }


    // ADD PRODUCT TO CART

    @And(
    "user adds product to cart")
    public void addCart() {

        getCart()
        .addProductCart();

        System.out.println(
        "Product added to cart");

    }


    // VERIFY PRODUCT EXISTS

    @Then(
    "product should appear in cart")
    public void verifyCart() {

        boolean result =

        getCart()
        .verifyCart();

        Assert.assertTrue(
        result,
        "Cart product not found");

        System.out.println(
        "Cart verification passed");

    }


    // UPDATE QUANTITY

    @And(
    "user updates cart quantity")
    public void updateCartQuantity() {

        getCart()
        .updateQuantity();

        System.out.println(
        "Quantity updated");

    }


    // VERIFY QUANTITY

    @Then(
    "cart quantity should be updated")
    public void verifyUpdatedCart() {

        boolean result =

        getCart()
        .verifyUpdatedQuantity();

        Assert.assertTrue(
        result,
        "Quantity update failed");

        System.out.println(
        "Quantity verification passed");

    }


    // REMOVE PRODUCT

    @And(
    "user removes product from cart")
    public void removeCart() {

        getCart()
        .removeCartItem();

        System.out.println(
        "Cart item removed");

    }


    // VERIFY EMPTY CART

    @Then(
    "cart should be empty")
    public void verifyRemovedCart() {

        boolean result =

        getCart()
        .verifyRemovedCart();

        Assert.assertTrue(
        result,
        "Cart is not empty");

        System.out.println(
        "Empty cart verified");

    }


    // VERIFY TOTAL

    @Then(
    "cart total should display correctly")
    public void verifyCartTotal() {

        boolean result =

        getCart()
        .verifyCartTotal();

        Assert.assertTrue(
        result,
        "Cart total verification failed");

        System.out.println(
        "Cart total verified");
    }

}