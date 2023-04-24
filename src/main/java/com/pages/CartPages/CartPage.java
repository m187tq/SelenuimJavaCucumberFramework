package com.pages.CartPages;

import com.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;


public class CartPage extends BasePage {

    public CartPage() throws IOException {
        super();
    }

	@FindBy(css=".nav.pull-left.topcart > .dropdown")
	private WebElement itemsBasket;

	@FindBy(xpath="//*[@id=\"top_cart_product_list\"]/div/table/tbody/tr/td/a")
	private WebElement itemsBasketList;

	@FindBy(css="[title] .fa-money")
	private WebElement itemsBasketCheckoutBtn;

	@FindBy(css="[title='View Cart'] .fa-shopping-cart")
	private WebElement itemsBasketViewCartBtn;


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




}
