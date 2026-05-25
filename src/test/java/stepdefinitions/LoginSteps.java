package stepdefinitions;

import org.testng.Assert;

import base.DriverFactory;

import io.cucumber.java.en.*;

import pages.LoginPage;

public class LoginSteps {

    LoginPage login;

    // LOGIN PAGE

    @Given("user opens login page")
    public void openLogin() {

        login =
        new LoginPage(
        DriverFactory.getDriver());

        login.openLoginPage();
    }


    @When("user enters valid login credentials")
    public void enterLogin() {

        login.loginUser();
    }


    @When("clicks login button")
    public void clickLogin() {

        // already handled inside LoginPage
    }


    @Then("user should login successfully")
    public void verifyLogin() {

        String actual =
        login.verifyLogin();

        Assert.assertEquals(
        actual,
        "My Account");
    }


    // INVALID LOGIN

    @When(
    "user enters invalid login credentials")
    public void invalidCredentials() {

        login.invalidLogin();
    }


    @Then(
    "warning message for invalid login should display")
    public void verifyInvalidLogin() {

        String actual =
        login.getLoginWarning();

        Assert.assertTrue(
        actual.contains(
        "Warning"));
    }


    // FORGOT PASSWORD

    @Given(
    "user opens forgot password page")
    public void openForgotPassword() {

        login =
        new LoginPage(
        DriverFactory.getDriver());

        login.openLoginPage();
    }


    @When(
    "user enters registered email")
    public void enterRegisteredMail() {

        login.forgotPasswordFlow();
    }


    @When(
    "clicks continue for password reset")
    public void clickReset() {

        // already handled
    }


    @Then(
    "password reset confirmation should display")
    public void verifyReset() {

        String actual =
        login.getResetMessage();

        System.out.println(
        "Reset Message = "
        + actual);

        Assert.assertTrue(
        actual.contains(
        "confirmation link"));
    }


    // LOGOUT

    @Given(
    "user logs into application")
    public void loginBeforeLogout() {

        login =
        new LoginPage(
        DriverFactory.getDriver());

        login.openLoginPage();

        login.loginUser();
    }


    @When(
    "user clicks logout")
    public void performLogout() {

        login.logoutUser();
    }


    @Then(
    "logout should be successful")
    public void verifyLogout() {

        String actual =
        login.verifyLogout();

        Assert.assertEquals(
        actual,
        "Account Logout");
    }

}