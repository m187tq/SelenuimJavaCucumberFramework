package com.stepDefinitions;

import com.pages.AccountPages.*;
import com.pages.BasePage;
import com.pages.CartPages.ItemsTopMenuCartComponents;
import com.pages.CheckoutPages.CheckoutCartPage;
import com.pages.CheckoutPages.CheckoutConfirmationPage;
import com.pages.CheckoutPages.CheckoutSuccessPage;
import com.pages.HomePages.HomePage;
import com.pages.HomePages.MiddleMenuNaviPage;
import com.pages.HomePages.TopNaviPage;
import com.pages.ProductCategoryNaviMenuComponent;
import helper.javaScript.JavaScriptHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.data;
import utils.Global_Vars;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static helper.assertion.AssertionHelper.updateTestStatus;

public class e2eSteps extends BasePage {

    public e2eSteps() throws IOException {
        super();
    }
    private TopNaviPage topNaviPage;
    private AccountPage accountPage;
    private AccountLoginPage accountLoginPage;
    private AccountCreatePage accountCreatePage;
    private AccountEditPage accountEditPage;
    private AccountLogoutPage accountLogoutPage;
    private AccountSuccessPage accountSuccessPage;
    private HomePage homePage;
    private ProductCategoryNaviMenuComponent productCategoryNaviMenuComponent;
    private MiddleMenuNaviPage middleMenuNaviPage;
    private ItemsTopMenuCartComponents itemsTopMenuCartComponents;
    private CheckoutCartPage checkoutCartPage;
    private CheckoutConfirmationPage checkoutConfirmationPage;
    private CheckoutSuccessPage checkoutSuccessPage;

    public e2eSteps(
            TopNaviPage topNaviPage,
            AccountLoginPage accountLoginPage,
            HomePage homePage,
            AccountSuccessPage accountSuccessPage,
            AccountLogoutPage accountLogoutPage,
            AccountCreatePage accountCreatePage,
            AccountPage accountPage,
            ProductCategoryNaviMenuComponent productCategoryNaviMenuComponent,
            MiddleMenuNaviPage middleMenuNaviPage,
            ItemsTopMenuCartComponents itemsTopMenuCartComponents,
            CheckoutCartPage checkoutCartPage,
            CheckoutConfirmationPage checkoutConfirmationPage,
            CheckoutSuccessPage checkoutSuccessPage

    ) throws IOException {
        this.homePage = homePage;
        this.topNaviPage = topNaviPage;
        this.accountLoginPage = accountLoginPage;
        this.accountCreatePage = accountCreatePage;
        this.accountSuccessPage = accountSuccessPage;
        this.accountPage = accountPage;
        this.accountLogoutPage = accountLogoutPage;
        this.productCategoryNaviMenuComponent = productCategoryNaviMenuComponent;
        this.middleMenuNaviPage = middleMenuNaviPage;
        this.itemsTopMenuCartComponents = itemsTopMenuCartComponents;
        this.checkoutCartPage = checkoutCartPage;
        this.checkoutConfirmationPage = checkoutConfirmationPage;
        this.checkoutSuccessPage = checkoutSuccessPage;
    }
    @Given("user is on landing Page as {string}")
    public void userIsOnLandingPage(String string) {
        topNaviPage.navigateToUrl(string);
        Assert.assertEquals(topNaviPage.currentPageUrl(), data.expectedURL);
        Assert.assertEquals(topNaviPage.currentPageTitle(), data.getExpectedTitle());
    }

    @When("user clicks on search box")
    public void userClicksOnSearchBox() throws Exception {
        topNaviPage.clickOnSearchBox();
    }

    @And("user enters product name as {string} and clicks on search button")
    public void userEntersProductNameAndClicksOnSearchBtn(String makeup) throws Exception {
        topNaviPage.entersKeywordOnSearchBox(makeup);
        topNaviPage.clickOnSearchBtn();
        Thread.sleep(12000);
    }
    @And("user should be able to see search result items")
    public void userShouldBeAbleToSeeSearchResultItems() throws InterruptedException {
        String itemsNeeded [] = {"Skinsheen Bronzer Stick"};
        List<WebElement> productList = productCategoryNaviMenuComponent.getCatAndSubMenuList();
        List listOfProducts = Arrays.asList(itemsNeeded);
        for(int i = 0; i<=productList.size()-1; i++)
        {
            String productName = productList.get(i).getText();
            if(!productName.isEmpty())
                Thread.sleep(1000);
            {
                System.out.println(productName);
            }
        }
    }

    @And("user adds products to the cart")
    public void userAddsProductsToTheCart() throws InterruptedException {

        List<WebElement> itemNames = getDriver().findElements(By.cssSelector(".prdocutname"));
        List<WebElement> addToCartProduct = getDriver().findElements(By.cssSelector("a.productcart"));
        String itemsNeeded [] = {"BODY CREAM BY BULGARI", "CREME PRECIEUSE NUIT 50ML","JASMIN NOIR BODY LOTION 6.8 FL OZ"};
        for(int i = 0; i<itemNames.size(); i++)
        {
            String name = itemNames.get(i).getText();
            List itemsNeededList = Arrays.asList(itemsNeeded);
            if(itemsNeededList.contains(name))
            {
                addToCartProduct.get(i).click();


            }
            Thread.sleep(10000);
        }
    }



        /*String itemName = "Lips";
        getDriver().findElement(By.linkText(itemName)).click();

        String prdocutname = "Lancome Hypnose Doll Lashes Mascara 4-Piece Gift Set";
        WebElement productName = getDriver().findElement(By.cssSelector("a[title='"+prdocutname+"']"));
        productName.click();

        List<WebElement> itemNames = getDriver().findElements(By.cssSelector(".prdocutname"));
        List<WebElement> addToCartProduct = getDriver().findElements(By.cssSelector("a.productcart"));
        String itemsNeeded [] = {"BODY CREAM BY BULGARI",
                                 "CREME PRECIEUSE NUIT 50ML","JASMIN NOIR BODY LOTION 6.8 FL OZ"
                                };
        for(int i = 0; i<itemNames.size(); i++)
        {
            String name = itemNames.get(i).getText();
            List itemsNeededList = Arrays.asList(itemsNeeded);
            if(itemsNeededList.contains(name))
            {
                addToCartProduct.get(i).click();
            }
        }
    }*/
    @And("user verifies the product item by item image, unit price, quantity and grand total")
    public void userVerifiesTheProductItemByItemImageUnitPriceQuantityAndGrandTotal() {
    }

    @And("user should be able to increase and remove item from cart")
    public void userShouldBeAbleToIncreaseAndRemoveItemFromCart() {
    }

    @And("user clicks on the Check out button")
    public void userClicksOnTheCheckOutButton() throws IOException, InterruptedException {
        checkoutCartPage.clickOnCheckoutBtn();
    }

    @And("user is on checks Customer Shipping Address, Method,Order Summary, Coupon and Total")
    public void userIsOnChecksCustomerShippingAddressMethodOrderSummaryCouponAndTotal() {
    }

    @And("user should be able to edit the cart")
    public void userShouldBeAbleToEditTheCart() {
    }

    @And("user clicks on continue button")
    public void userClicksOnContinueButton() {
    }

    @And("user confirms email, Shipping Address, Method, Billing and total")
    public void userConfirmsEmailShippingAddressMethodBillingAndTotal() {
    }

    @And("user should be able to edit the cart, Shipping,Method and Billing Address")
    public void userShouldBeAbleToEditTheCartShippingMethodAndBillingAddress() {
    }

    @And("user log in as a returning customer")
    public void userRegistersAndLoginAsANewUser() throws Exception {
        accountLoginPage.goToLoginPageEnterLoginNameAndPasswordThenClickOnLoginBtn(Global_Vars.getUserName(), Global_Vars.getPassword());
    }

    @And("user enters payment details and clicks on place order button")
    public void userEntersPaymentDetailsAndClicksOnPlaceOrderButton() {
    }

    @And("user is presented with a purchase confirmation page")
    public void userIsPresentedWithAPurchaseConfirmationPage() {
        checkoutSuccessPage.validateYourOrderHasBeenProcessedHeadingTxt();

    }

    @Then("user gets an order number and thank message with first name displayed")
    public void userGetsAnOrderNumberAndThankMessageWithFirstNameDisplayed() {
        checkoutSuccessPage.validateOrderNumberText();
        checkoutSuccessPage.validateThankYouForShoppingWithUsText();
    }

    @And("user order confirmation page is populate with print icon, item image total price and continue shipping button")
    public void userOrderConfirmationPageIsPopulateWithPrintIconItemImageTotalPriceAndContinueShippingButton() throws IOException {
        checkoutSuccessPage.clickOnInvoicePageLink();
        checkoutSuccessPage.validateViewInvoiceText();

    }

    @And("user clicks on continue and logout button")
    public void userClicksOnContinueAndLogoutButton() throws IOException {
        checkoutSuccessPage.clickOnContinueCheckoutSuccessBtn();
    }

    @Then("user is back to home page")
    public void userIsBackToHomePage() {
        Assert.assertEquals(topNaviPage.currentPageUrl(), data.expectedURL);
        Assert.assertEquals(topNaviPage.currentPageTitle(), data.getExpectedTitle());
    }

    @And("user should be able to see displayed items")
    public void userShouldBeAbleToSeeDisplayedItems() throws InterruptedException {
        List<WebElement> itemNames = getDriver().findElements(By.cssSelector(".prdocutname"));
        for(int i = 0; i<itemNames.size(); i++)
            {
            String name = itemNames.get(i).getText();
                System.out.println("ListOfProductDisplayed: "+i+ "  " +name);
                System.out.println("=========================================================");

        }

    }

    @When("user scroll down to the middle page to view items")
    public void userScrollDownToTheMiddlePageToViewItems() {
        JavaScriptHelper.scrollIntoView(middleMenuNaviPage.getFeatured());
    }

    @And("user adds items to the cart and verifies number of items in the cart")
    public void userAddsItemsToTheCartAndVerifyNumberOfItemsInTheCart() throws InterruptedException {
        List<WebElement> itemNames = getDriver().findElements(By.cssSelector(".prdocutname"));
        List<WebElement> addProductToCart = getDriver().findElements(By.cssSelector("a.productcart"));
        String itemsNeeded [] = {
                "ABSOLUTE ANTI-AGE SPOT REPLENISHING UNIFYING TREATMENTSPF 15",
                "ABSOLUE EYE PRECIOUS CELLS",
                "TOTAL MOISTURE FACIAL CREAM",
                "SKINSHEEN BRONZER STICK"};

            for(int i = 0; i<itemNames.size(); i++) {
            String name = itemNames.get(i).getText();
            List itemsNeededList = Arrays.asList(itemsNeeded);
            if(itemsNeededList.contains(name)) {
                Thread.sleep(2000);
                addProductToCart.get(i).click();
                Thread.sleep(3000);
                break;
            }
        }

        updateTestStatus(itemsTopMenuCartComponents.verifyNoOfItemsDisplayedInBasket());
        Assert.assertTrue(itemsTopMenuCartComponents.getNoOfItemsDisplayedInBasket().contains("3"));

    }
    @And("user clicks on ItemsCartIcon at the left top sub menu bar")
    public void userClicksOnItemsCartIconAtTheLeftTopSubMenuBar() {
        //action.mouseover(getDriver(),itemsTopMenuCartComponents.itemsDisplayedInBasket());
        itemsTopMenuCartComponents.clickOnItemsBasketIcon();
    }
    @And("user lands on checkout cart page")
    public void userLandsOnCheckoutCartPage() {
        Assert.assertTrue(getCurrentPageTitle().contains("Shopping Cart"));
        

    }

    @And("user clicks remove icon to remove an item and update")
    public void userClicksRemoveIconToRemoveAnItemAndUpdate() {
        checkoutCartPage.clickOnRemoveIconBtn();
        checkoutCartPage.clickOnUpdateBtn();

    }

    @And("user adds quantity of an item as {string} and update")
    public void userAddsQuantityOfAnItemAndUpdate(String string) throws Exception {
        checkoutCartPage.clear_enter_QuantityBox(string);
        checkoutCartPage.clickOnUpdateBtn();
    }

    @And("user click on checkout confirmation order button")
    public void userClickOnCheckoutConfirmationOrderButton() throws IOException, InterruptedException {
        checkoutConfirmationPage.validateOrderSummaryTxt();
        updateTestStatus(checkoutConfirmationPage.validateCheckoutConfirmationTxt());
        checkoutConfirmationPage.clickOnConfirmOrderBtn();
    }

}
