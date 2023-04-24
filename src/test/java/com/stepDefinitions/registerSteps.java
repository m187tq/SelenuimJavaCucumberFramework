package com.stepDefinitions;

import com.pages.AccountPages.*;
import com.pages.BasePage;
import com.pages.HomePages.HomePage;
import com.pages.HomePages.TopNaviPage;
import helper.assertion.AssertionHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class registerSteps extends BasePage {

    private WebDriver driver = getDriver();
    private TopNaviPage topNaviPage;
    private AccountPage accountPage;
    private AccountLoginPage accountLoginPage;
    private AccountCreatePage accountCreatePage;
    private AccountEditPage accountEditPage;
    private AccountLogoutPage accountLogoutPage;
    private AccountSuccessPage accountSuccessPage;
    private HomePage homePage;

    public registerSteps(
            TopNaviPage topNaviPage,
            AccountLoginPage accountLoginPage,
            HomePage homePage,
            AccountSuccessPage accountSuccessPage,
            AccountEditPage accountEditPage,
            AccountLogoutPage accountLogoutPage,
            AccountCreatePage accountCreatePage,
            AccountPage accountPage

    ) throws IOException {
        this.topNaviPage = topNaviPage;
        this.accountLoginPage = accountLoginPage;
        this.homePage = homePage;
        this.accountSuccessPage = accountSuccessPage;
        this.accountEditPage = accountEditPage;
        this.accountLogoutPage = accountLogoutPage;
        this.accountCreatePage = accountCreatePage;
        this.accountPage = accountPage;
    }

    @Given("user is on index page url as {string} and page title as {string}")
    public void user_is_on_index_page_url_as_something_and_page_title_as_something(String arg0, String arg1) throws Throwable {
        navigateToIndexPage(arg0);
        Assert.assertEquals(getCurrentPageUrl(), arg0);
        Assert.assertEquals(getCurrentPageTitle(), arg1);

    }

    @When("user clicks on Login Or Register link")
    public void user_clicks_on_login_or_register_link() throws Throwable {
        topNaviPage.clickOnLoginRegisterBtn();
    }

    @When("user clicks on logoff button on Account page")
    public void user_clicks_on_logoff_button_on_account_page() throws Throwable {

    }

    @Then("user gets success confirmation msg as {string}")
    public void user_gets_success_confirmation_message_as_something(String string) throws Throwable {

    }
    @And("user is on account create page and verifies pageheading as {string} and page Url contains {string}")
    public void user_is_on_account_create_page_and_verifies_pageheading_as_something_and_page_url_contains_something(String arg0, String arg1) throws Throwable {
        Assert.assertEquals(accountCreatePage.getCreateAccountText(),arg0);
        Assert.assertTrue(accountCreatePage.getCurrentPageUrl().contains(arg1));
    }

    @And("user is in personal details in {string}")
    public void user_is_in_personal_details_in_something(String string) throws Throwable {
        AssertionHelper.updateTestStatus(accountCreatePage.verifyYourPersonalDetailsTxtIsDisplayed());
        Assert.assertEquals(accountCreatePage.getYourPersonalDetailsTxt(),string);

    }
    @And("user enters First Name box as {word}")
    public void user_enters_first_name_box_as_firstname(String string) throws Throwable {
        accountCreatePage.enterFirstName(string);
    }
    @And("user enters Last Name box as {word}")
    public void user_enters_last_name_box_as_lastname(String string) throws Throwable {
        accountCreatePage.enterLastName(string);
    }

    @And("user enters fresh email in EMail box")
    public void user_enters_fresh_email_in_email_box() throws Throwable {
        accountCreatePage.enterEmailAddress();
    }

    @And("user enters Telephone box as {word}")
    public void user_enters_telephone_box_as_07400000000(String string) throws Throwable {
        accountCreatePage.enterTelephoneNumber(string);
    }

    @And("user enters Fax box as {word}")
    public void user_enters_fax_box_as_07400000001(String string) throws Throwable {
        accountCreatePage.enterFaxNumber(string);
    }


    @And("user on Address Section as {string}")
    public void userOnAddressSectionAs(String arg0) {
        accountCreatePage.verifyYourAddressTextIsDisplayed();
        AssertionHelper.updateTestStatus(accountCreatePage.getYourAddressText().contains(arg0));
    }

    @And("user enters Company name as {word}")
    public void user_enters_company_name_as_yourcompanyname(String string) throws Throwable {
        accountCreatePage.enterCompanyName(string);
    }

    @And("user enters Address One box as {word}")
    public void user_enters_address_one_box_as_youraddress1(String string) throws Throwable {
        accountCreatePage.enterAddress1(string);
    }

    @And("user enters Address Two box as {word}")
    public void user_enters_address_two_box_as_youraddress2(String string) throws Throwable {
        accountCreatePage.enterAddress2(string);
    }

    @And("user enters City box as {word}")
    public void user_enters_city_box_as_yourcity(String string) throws Throwable {
        accountCreatePage.enterCity(string);
    }

    @And("user selects Region or State as {word}")
    public void user_selects_region_or_state_as_something(String string) throws Throwable {
        accountCreatePage.selectRegionState(string);
    }

    @And("user enters ZIP Code box as {string}")
    public void user_enters_zip_code_box_as_something(String string) throws Throwable {
        accountCreatePage.enterZipCode(string);

    }

    @And("user enters Country box as {string}")
    public void user_enters_country_box_as_something(String string) throws Throwable {
        accountCreatePage.selectCountry(string);
    }

    @And("user on login section as {string}")
    public void user_on_login_section_as_something(String string) throws Throwable {
        AssertionHelper.updateTestStatus(accountCreatePage.getLoginDetailsSectionText().contains(string));

    }

    @And("^user enters loginName in Login name box$")
    public void user_enters_loginname_in_login_name_box() throws Throwable {
        accountCreatePage.enterLoginName();
    }

    @And("user enters password in Password box as {string}")
    public void user_enters_password_in_password_box_as_something(String string) throws Throwable {
        accountCreatePage.enterPassword(string);
    }

    @And("user enters Confirm password in Password Confirm box as {string}")
    public void user_enters_confirm_password_in_password_confirm_box_as_something(String string) throws Throwable {
        accountCreatePage.enterPasswordConfirm(string);
    }

    @And("user subscribed to Newsletter by checking on Yes")
    public void user_subscribed_to_newsletter_by_checking_on_yes() throws Throwable {
        accountCreatePage.tickOnSubscribeAsYes();
    }

    @And("user ticks on read and agree to the Privacy Policy radio button")
    public void user_ticks_on_read_and_agree_to_the_privacy_policy_radio_button() throws Throwable {
        accountCreatePage.clickOnIAgreeToPrivacyPolicyRadioButton();
    }

    @And("user clicks on Continue button")
    public void user_clicks_on_continue_button() throws Throwable {
        accountSuccessPage.clickOnContinueAccountSuccessBtn();
    }

    @And("user gets congratulatory msg as {string}")
    public void user_gets_congratulatory_msg_as_something(String string) throws Throwable {


    }

    @And("user clicks on ContinueAccountSuccess button")
    public void user_clicks_on_continueaccountsuccess_button() throws Throwable {
            this.accountSuccessPage.clickOnContinueAccountSuccessBtn();
    }

    @And("user is on home page and presented with welcome msg as {string}")
    public void user_is_on_home_page_and_presented_with_welcome_msg_as_something(String string) throws Throwable {
        accountPage.validateUserAccountTextIsDisplayed();
        accountPage.getHomePageWelcomeMsg().contains(string);

    }

    @And("user verifies account logout page url contains {string} and clicks on logout Continue Button")
    public void user_verifies_account_logout_page_url_contains_something_and_clicks_on_logout_continue_button(String string) throws Throwable {
        accountLogoutPage.getCurrentPageUrl().contains(string);
        accountLogoutPage.clickOnLogoutContinueButton();
    }

    @And("user is on account create page and verifies page-heading as {string} and page Url contains {string}")
    public void userIsOnAccountCreatePageAndVerifiesPageHeadingAsAndPageUrlContains(String arg0, String arg1) throws InterruptedException {
        Assert.assertTrue(accountCreatePage.getCreateAccountText().contains(arg0));
    }


}

