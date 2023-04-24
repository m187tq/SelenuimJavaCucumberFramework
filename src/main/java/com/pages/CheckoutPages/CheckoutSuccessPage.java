package com.pages.CheckoutPages;

import com.pages.BasePage;
import com.pages.HomePages.HomePage;
import com.pages.InvoiceOrderPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class CheckoutSuccessPage extends BasePage {

    public CheckoutSuccessPage() throws IOException {
        super();
    }

    public String orderSuccessPageUrl = "https://automationteststore.com/index.php?rt=checkout/success";

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/h1/span[1]")
    private WebElement yourOrderHasBeenProcessedHeadingTxt;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/p[2]")
    private WebElement OrderNumberText;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/p[3]")
    private WebElement viewInvoiceText;

    @FindBy(xpath = "//p[contains(text(),'Thank you for shopping with us!')]")
    private WebElement thankYouForShoppingWithUsText;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/p[3]")
    private WebElement invoicePageLink;

    @FindBy(css = ".btn.btn-default.mr10")
    private WebElement continueCheckoutSuccessBtn;

    public String getOrderSuccessPageUrl() {
        return orderSuccessPageUrl;
    }

    public boolean validateYourOrderHasBeenProcessedHeadingTxt() {
        return yourOrderHasBeenProcessedHeadingTxt.isDisplayed();
    }

    public boolean validateOrderNumberText() {
        return OrderNumberText.isDisplayed();
    }

    public boolean validateViewInvoiceText() {
        return viewInvoiceText.isDisplayed();
    }

    public boolean validateThankYouForShoppingWithUsText() {
        return thankYouForShoppingWithUsText.isDisplayed();
    }

    public InvoiceOrderPage clickOnInvoicePageLink() throws IOException {
        invoicePageLink.click();
        return new InvoiceOrderPage();
    }

    public HomePage clickOnContinueCheckoutSuccessBtn() throws IOException {
        continueCheckoutSuccessBtn.click();
        return new HomePage();
    }

}
