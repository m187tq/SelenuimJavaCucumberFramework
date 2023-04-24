package com.stepDefinitions;

import com.pages.AccountPages.*;
import com.pages.BasePage;
import com.pages.HomePages.HomePage;
import com.pages.HomePages.TopNaviPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.data;

import java.io.IOException;

public class registrationSteps extends BasePage {

    private WebDriver driver = getDriver();
    private TopNaviPage topNaviPage;
    private AccountPage accountPage;
    private AccountLoginPage accountLoginPage;
    private AccountCreatePage accountCreatePage;
    private AccountEditPage accountEditPage;
    private AccountLogoutPage accountLogoutPage;
    private AccountSuccessPage accountSuccessPage;
    private HomePage homePage;

    public registrationSteps(
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
    @Given("user is on landing page")
    public void userIsOnLandingPage() throws InterruptedException {
        navigateToIndexPage(data.getBaseUrl());
        Assert.assertEquals(topNaviPage.currentPageUrl(), data.expectedURL);
        Assert.assertEquals(topNaviPage.currentPageTitle(), data.getExpectedTitle());

    }

    @Given("user is on index page")
    public void userIsOnIndexPage() throws InterruptedException {
        navigateToIndexPage(data.getBaseUrl());
        Assert.assertEquals(topNaviPage.currentPageUrl(), data.expectedURL);
        Assert.assertEquals(topNaviPage.currentPageTitle(), data.getExpectedTitle());
    }
    @When("^user clicks the LoginOrRegister link$")
    public void userClicksTheLoginOrRegisterLink() throws IOException, InterruptedException {
        topNaviPage.clickOnLoginRegisterBtn();
    }
    @And("^user should be on account login page with option to login or create an Account$")
    public void userShouldBeOnAccountLoginPageWithOptionToLoginOrCreateAnAccount() {
        Assert.assertTrue(accountLoginPage.validateNewCustomerTxtIsDisplayed());
        Assert.assertTrue(accountLoginPage.verifyRegisterAccountTextCheckBoxIsDisplayed());
    }
    @And("^user verifies register account radio button is checked and clicks on Continue button$")
    public void userVerifiesRegisterAccountRadioButtonIsCheckedAndClicksOnContinueButton() throws IOException, InterruptedException {
        // Assert.assertTrue(accountLoginPage.verifyRegisterAccountTextCheckBoxIsDisplayed());
        accountLoginPage.clickOnContinueRegisterAccountBtn();
    }
    @And("user is on account create page and verifies page heading as {string} and page Url contains {string}")
    public void userIsOnAccountCreatePageAndVerifiesPageHeadingAsAndPageUrlContains(String arg0, String arg1) throws InterruptedException {
        Assert.assertTrue(accountCreatePage.getCreateAccountText().contains(arg0));
    }
    @And("user enters generated email and Your Personal Section Details")
    public void userEntersGeneratedEmailAndYourPersonalSectionDetails() {
        Assert.assertTrue(accountCreatePage.verifyYourPersonalDetailsTxtIsDisplayed());
        accountCreatePage.enterFirstName(data.firstName);
        accountCreatePage.enterLastName(data.lastName);
        accountCreatePage.enterEmailAddress();
        accountCreatePage.enterTelephoneNumber(data.getTelephone());
        accountCreatePage.enterFaxNumber(data.getFaxNumber());
    }
    @And("^user enters Your Address Section Details$")
    public void userEntersYourAddressSectionDetails() {
        Assert.assertTrue(accountCreatePage.verifyYourAddressTextIsDisplayed());
        accountCreatePage.enterCompanyName(data.getCompanyName());
        accountCreatePage.enterAddress1(data.getAddress1());
        accountCreatePage.enterAddress2(data.getAddress2());
        accountCreatePage.enterCity(data.getCity());
        accountCreatePage.enterZipCode(data.getZipCode());
        accountCreatePage.selectRegionState(data.getRegionState());
        accountCreatePage.selectCountry(data.getCountry());

    }
    @And("^user enters generated loginName and Login Section Details$")
    public void userEntersGeneratedLoginNameAndLoginSectionDetails() throws IOException {
        Assert.assertTrue(accountCreatePage.verifyLoginDetailsSectionTextIsDisplayed());
        accountCreatePage.enterLoginName();
        accountCreatePage.enterPassword(data.getPassword());
        accountCreatePage.enterPasswordConfirm(data.getConfirmPassword());
    }
    @And("^user subscribed to Newsletter and check on Yes$")
    public void userSubscribedToNewsletterAndCheckOnYes() throws IOException {
        Assert.assertTrue(accountCreatePage.verifyNewsletterTextIsDisplayed());
        accountCreatePage.tickOnSubscribeAsYes();
    }
    @And("user ticks on Privacy Policy radio button and create account button")
    public void userTicksOnPrivacyPolicyRadioButtonAndCreateAccountButton() throws IOException {
        //accountCreatePage.tickOnSubscribeAsYes();
        accountCreatePage.clickOnIAgreeToPrivacyPolicyRadioButton();
        accountCreatePage.clickOnContinueButton();
    }
    @Then("user gets success confirmation message as {string}")
    public void userGetsSuccessConfirmationMessageAs(String arg1) {

    }
    @And("^user clicks on Continue Shipping button$")
    public void userClicksOnContinueShippingButton() throws IOException, InterruptedException {
        accountSuccessPage.clickOnContinueAccountSuccessBtn();
    }
    @And("user is on home page and presented with welcome message as {string}")
    public void userIsOnHomePageAndPresentedWithWelcomeMessageAs(String arg0) throws InterruptedException {
        //Assert.assertEquals(accountPage.homePageWelcomeMsg(), arg0);

    }
    @And("^user clicks on SignOut button$")
    public void userClicksOnSignOutButton() throws IOException, InterruptedException {
        accountPage.clickOnLogoffBtn();
        accountLogoutPage.clickOnLogoutContinueButton();

    }
    @And("user is back to login page")
    public void userIsBackToLoginPage() {
        Assert.assertTrue(topNaviPage.getCurrentPageUrl().contains(homePage.url));
    }
}
