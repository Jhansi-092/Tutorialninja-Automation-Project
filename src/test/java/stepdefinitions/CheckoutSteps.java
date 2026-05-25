package stepdefinitions;

import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;

public class CheckoutSteps {

    private final CheckoutPage checkout =
            new CheckoutPage(
                    DriverFactory.getDriver());

    // LOGIN

    @Given(
    "user logs into application for checkout")

    public void loginCheckout() {

        checkout.loginApplication();

        System.out.println(
        "Checkout login success");
    }

    // SEARCH PRODUCT

    @When(
    "user searches product for checkout")

    public void searchProduct() {

        checkout.searchProduct();

        System.out.println(
        "Product searched for checkout");
    }

    // OPEN PRODUCT

    @And(
    "user opens checkout product")

    public void openProduct() {

        checkout.openProduct();

        System.out.println(
        "Checkout product opened");
    }

    // ADD PRODUCT TO CART

    @And(
    "user adds product to cart for checkout")

    public void addCart() {

        checkout.addProductToCart();

        System.out.println(
        "Product added to cart");
    }

    // PROCEED CHECKOUT

    @And(
    "user proceeds to checkout")

    public void proceedCheckout() {

        checkout.proceedCheckout();

        System.out.println(
        "Checkout opened");
    }

    // VERIFY CHECKOUT PAGE

    @Then(
    "checkout page should open")

    public void verifyCheckout() {

        boolean result =
                checkout.verifyCheckoutPage();

        Assert.assertTrue(
        result,
        "Checkout page not opened");

        System.out.println(
        "Checkout verification passed");
    }

    // BILLING

    @And(
    "user enters billing details")

    public void enterBilling() {

        checkout.enterBillingDetails();

        System.out.println(
        "Billing details entered");
    }

    @Then(
    "billing details should save successfully")

    public void verifyBilling() {

        boolean result =
                checkout.verifyBillingSaved();

        Assert.assertTrue(
        result,
        "Billing save failed");

        System.out.println(
        "Billing verification passed");
    }

    // PAYMENT

    @And(
    "user selects payment method")

    public void selectPayment() {

        checkout.selectPaymentMethod();

        System.out.println(
        "Payment selected");
    }

    @Then(
    "payment method should be selected successfully")

    public void verifyPayment() {

        boolean result =
                checkout.verifyPaymentMethod();

        Assert.assertTrue(
        result,
        "Payment selection failed");

        System.out.println(
        "Payment verification passed");
    }

    // CONFIRM ORDER

    @And(
    "user confirms order")

    public void confirmOrder() {

        checkout.confirmOrder();

        System.out.println(
        "Order confirmed");
    }

    // VERIFY ORDER SUCCESS

    @Then(
    "order should be placed successfully")

    public void verifyOrderSuccess() {

        boolean result =
                checkout.verifyOrderSuccess();

        Assert.assertTrue(
        result,
        "Order placement failed");

        System.out.println(
        "Order success verified");
    }
}