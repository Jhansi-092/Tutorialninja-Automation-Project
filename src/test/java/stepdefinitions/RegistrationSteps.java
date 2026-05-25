package stepdefinitions;

import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.RegisterPage;

public class RegistrationSteps {

    RegisterPage register;

    @Given("user opens registration page")
    public void openPage() {

        register = new RegisterPage(
                DriverFactory.getDriver());

        // OPEN PAGE
        register.openRegisterPage();
    }

    @When("user enters valid details")
    public void enterDetails() {

        register.registerUser();
    }

    @When("user enters existing email details")
    public void existingEmail() {

        register.registerExistingUser();
    }

    @When("clicks continue")
    public void continueButton() {

        // already handled inside page
    }

    @Then("registration should succeed")
    public void verifySuccess() {

        String actual =
                register.getSuccessMessage();

        Assert.assertEquals(
                actual,
                "Your Account Has Been Created!");
    }

    @Then("warning message should display")
    public void verifyWarning() {

        String actual =
                register.getWarningMessage();

        Assert.assertTrue(
                actual.contains(
                        "Warning"));
    }

    @When("user clicks continue without entering details")
    public void emptyRegistration() {

        register.submitEmptyRegistration();
    }

    @Then("mandatory field warning should display")
    public void verifyMandatoryFields() {

        String privacyMsg =
                register.getPrivacyWarning();

        String firstNameMsg =
                register.getFirstNameWarning();

        Assert.assertTrue(
                privacyMsg.contains(
                        "Warning"));

        Assert.assertTrue(
                firstNameMsg.contains(
                        "First Name"));
    }

    @Then("account creation message should display")
    public void verifyAccountCreated() {

        String actual =
                register.getSuccessMessage();

        Assert.assertEquals(
                actual,
                "Your Account Has Been Created!");
    }
}