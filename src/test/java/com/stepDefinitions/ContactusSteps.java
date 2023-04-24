package com.stepDefinitions;

import com.pages.BasePage;
import com.pages.ContactusPages.ContactUsPage;
import com.pages.ContactusPages.ContactUsSuccessPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class ContactusSteps extends BasePage {

    public ContactusSteps() throws IOException {
        super();
    }

    private WebDriver driver;
    private ContactUsPage contactUsPage;
    private ContactUsSuccessPage contactUsSuccessPage;

    public ContactusSteps(ContactUsPage contactUsPage, ContactUsSuccessPage contactUsSuccessPage
    )
            throws IOException {
        this.contactUsSuccessPage = contactUsSuccessPage;
        this.contactUsPage = contactUsPage;
    }


    @Given("^user on contactus page as \"([^\"]*)\" and title as \"([^\"]*)\"$")
    public void userOnContactusPageAsAndTitleAs(String arg0, String arg1) throws Throwable {

    }

    @And("^user confirms company contact details are displayed as \"([^\"]*)\"$")
    public void userConfirmsCompanyContactDetailsAreDisplayedAs(String arg0) throws Throwable {

    }

    @When("^user enters first name as \"([^\"]*)\" email Address as \"([^\"]*)\" and inquiry as \"([^\"]*)\"$")
    public void userEntersFirstNameAsEmailAddressAsAndInquiryAs(String arg0, String arg1, String arg2) throws Throwable {

    }

    @Then("^user should get warning firstname confirmation message as \"([^\"]*)\"$")
    public void userShouldGetWarningFirstnameConfirmationMessageAs(String arg0) throws Throwable {

    }

    @Then("^user should get warning email confirmation message as \"([^\"]*)\"$")
    public void userShouldGetWarningEmailConfirmationMessageAs(String arg0) throws Throwable {

    }

    @Then("^user should get warning inquiry confirmation message as \"([^\"]*)\"$")
    public void userShouldGetWarningInquiryConfirmationMessageAs(String arg0) throws Throwable {

    }

    @Then("^user should gets invalid email warning  message as \"([^\"]*)\"$")
    public void userShouldGetsInvalidEmailWarningMessageAs(String arg0) throws Throwable {

    }

    @And("^user clicks on the submit button$")
    public void userClicksOnTheSubmitButton() {
    }

    @Then("^user should get confirmation message as \"([^\"]*)\"$")
    public void userShouldGetConfirmationMessageAs(String arg0) throws Throwable {

    }

    @And("^user confirms the current url as \"([^\"]*)\"$")
    public void userConfirmsTheCurrentUrlAs(String arg0) throws Throwable {

    }

    @When("^user clicks on Continue button on contact page$")
    public void userClicksOnContinueButtonOnContactPage() {
    }

    @Then("^user should be on home page title as \"([^\"]*)\"$")
    public void userShouldBeOnHomePageTitleAs(String arg0) throws Throwable {

    }
}
