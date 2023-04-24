package com.pages.CartPages;

import com.pages.BasePage;
import helper.javaScript.JavaScriptHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;


public class ItemsTopMenuCartComponents extends BasePage {

    @FindBy(css = ".nav.pull-left.topcart > .dropdown")
    private WebElement itemsBasket;
    @FindBy(xpath = "//*[@id=\"top_cart_product_list\"]/div/table/tbody/tr/td/a")
    private WebElement itemsBasketList;
    @FindBy(css = "[title] .fa-money")
    private WebElement itemsBasketCheckoutBtn;
    @FindBy(css = "[title='View Cart'] .fa-shopping-cart")
    private WebElement itemsBasketViewCartBtn;

    public WebElement itemsDisplayedInBasket() {
        return noOfItemsDisplayedInBasket;
    }
    public String getNoOfItemsDisplayedInBasket() {
        return noOfItemsDisplayedInBasket.getText();
    }

    public boolean verifyNoOfItemsDisplayedInBasket() {
        return noOfItemsDisplayedInBasket.isDisplayed();
    }

    public void clickOnItemsDisplayedInBasket() {
        JavaScriptHelper.scrollIntoView(noOfItemsDisplayedInBasket);
        noOfItemsDisplayedInBasket.click();
    }

    @FindBy(css = ".topcart .label-orange")
    private WebElement noOfItemsDisplayedInBasket;



    public ItemsTopMenuCartComponents() throws IOException {
        super();
    }

    public WebElement getItemsBasket() {
        return itemsBasket;
    }

    public WebElement getItemsBasketList() {
        return itemsBasketList;
    }

    public WebElement getItemsBasketCheckoutBtn() {
        return itemsBasketCheckoutBtn;
    }

    public WebElement getItemsBasketViewCartBtn() {
        return itemsBasketViewCartBtn;
    }

    public void clickOnItemsBasketIcon() {
        waitForWebElementAndClick(itemsBasket);
    }

    public void clickOnBasketCheckoutBtn() {
        waitForWebElementAndClick(itemsBasketCheckoutBtn);
    }

    public void clickOnBasketViewCartBtn() {
        waitForWebElementAndClick(itemsBasketViewCartBtn);
    }


}
