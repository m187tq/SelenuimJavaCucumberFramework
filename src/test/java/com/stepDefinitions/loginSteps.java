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
import org.testng.annotations.Listeners;
import utilities.data;

import java.io.IOException;

import static com.utils.ExtentManager.log;
import static com.utils.ExtentManager.pass;
public class loginSteps extends BasePage {
    private WebDriver driver = this.driver;
    private TopNaviPage topNaviPage;
    private AccountPage accountPage;
    private AccountLoginPage accountLoginPage;
    private AccountCreatePage accountCreatePage;
    private AccountEditPage accountEditPage;
    private AccountLogoutPage accountLogoutPage;
    private AccountSuccessPage accountSuccessPage;
    private HomePage homePage;


    public loginSteps(TopNaviPage topNaviPage,
                      AccountLoginPage accountLoginPage,
                      HomePage homePage,
                      AccountSuccessPage accountSuccessPage,
                      AccountEditPage accountEditPage,
                      AccountLogoutPage accountLogoutPage,
                      AccountCreatePage accountCreatePage,
                      AccountPage accountPage)
            throws IOException {
                                this.topNaviPage = topNaviPage;
                                this.accountLoginPage = accountLoginPage;
                                this.homePage = homePage;
                                this.accountSuccessPage = accountSuccessPage;
                                this.accountEditPage = accountEditPage;
                                this.accountLogoutPage = accountLogoutPage;
                                this.accountCreatePage = accountCreatePage;
                                this.accountPage = accountPage;
    }
    @Given("user is on index page as {string}")
    public void user_is_on_index_page_as(String string) throws InterruptedException {
        topNaviPage.navigateToUrl(string);
        Assert.assertEquals(topNaviPage.currentPageUrl(), data.expectedURL);
        Assert.assertEquals(topNaviPage.currentPageTitle(), data.getExpectedTitle());
    }
    @When("user clicks on LoginOrRegister button")
    public void user_clicks_on_loginorregister_button() throws IOException {
        Assert.assertTrue(topNaviPage.verifyLoginOrRegisterBtnIsDisplayed());
        Assert.assertTrue(topNaviPage.loginOrRegisterBtnEnabled());
        topNaviPage.clickOnLoginRegisterBtn();
    }
    @When("user enters login Name as {string} and password as {string} and clicks on Login button")
    public void user_enters_login_name_as_and_password_as_and_clicks_on_login_button(String string, String string2) throws Exception {
        accountLoginPage.enterLoginName(string);
        accountLoginPage.enterPassword(string2);
        Assert.assertTrue(accountLoginPage.verifyLoginBtnDisplayed());
        accountLoginPage.clickOnLoginBtn();
    }
    @Then("user should be presented with the following validation message as {string}")
    public void user_should_be_presented_with_the_following_validation_message_as(String arg1) throws InterruptedException {
        Assert.assertTrue(accountPage.getHomePageWelcomeMsg().contains(arg1));
    }
    @Then("user clicks on edit profile button")
    public void user_clicks_on_edit_profile_button() throws IOException {
        Assert.assertTrue(accountPage.verifyEditAccountDetailsLinkIsDisplayed());
        accountPage.clickOnEditAccountDetailsLink();
    }
    @Then("user enters {string} {string} and EmailAddress telephone as {string} and fax as {string} in their respective box")
    public void user_enters_and_email_address_telephone_as_and_fax_as_in_their_respective_box(String string, String string2, String string3, String string4) throws Exception {
        Assert.assertTrue(accountEditPage.validateUserOnAccountEditPage());
        accountEditPage.enterFirstNameBox(string);
        accountEditPage.enterLastNameBox(string2);
        accountEditPage.enterFreshEmailBox();
        accountEditPage.enterTelephoneBox(string3);
        accountEditPage.enterFaxBox(string4);
    }
    @And("user clicks on Continue button to confirms profile successful update message as {string}")
    public void userClicksOnContinueButtonToConfirmsProfileSuccessfulUpdateMessageAs(String arg0) throws InterruptedException, IOException {
        accountEditPage.clickOnContinueEditBtn();
        Assert.assertTrue(accountPage.accountProfileSuccessfulUpdateMessage().contains(arg0));
    }
    @When("user clicks on logoff button and logout Continue Button")
    public void user_clicks_on_logoff_button_and_logout_continue_button() throws IOException, InterruptedException {
        Assert.assertTrue(accountPage.isLogoffBtnDisplayed());
        accountPage.clickOnLogoffBtn();
        Assert.assertTrue(accountLogoutPage.validateLogoutContinueBtnIsDisplayed());
        accountLogoutPage.clickOnLogoutContinueButton();
    }
    @Then("user is back to index page as {string}")
    public void user_is_back_to_index_page_as(String string) throws InterruptedException {
        Assert.assertEquals(homePage.getCurrentPageUrl(), string);
    }
    @Then("User gets error message as {string} and still on Home page title as {string}")
    public void userGetsErrorMessageAsAndStillOnHomePageTitleAs(String loginValidationMessage, String pageTitle) {
        Assert.assertTrue(accountLoginPage.errorIncorrectLoginPasswordProvidedConfirmationMessage(loginValidationMessage).contains(loginValidationMessage));
        Assert.assertTrue(accountLoginPage.currentPageTitle(pageTitle).contains(pageTitle));
    }

}
