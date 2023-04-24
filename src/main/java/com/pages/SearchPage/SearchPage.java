package com.pages.SearchPage;

import com.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class SearchPage extends BasePage {

    public SearchPage() throws IOException {
        super();
    }

    @FindBy(xpath = "//*[@id=\"quick-search-expand\"]")
    public WebElement searchTxtLink;

    @FindBy(xpath = "//*[@id='nav-quick-search']")
    public WebElement searchBox;


    public void clickOnSearchLinkAndEnterProductNameOnSearchBox(String productName) {
        waitForWebElementAndClick(this.searchTxtLink);
        waitForWebElementAndClick(this.searchBox);
        sendKeys(this.searchBox, productName);
    }

    public void clickOnSearchBox() {
        waitFor(this.searchTxtLink);
        waitForWebElementAndClick(this.searchBox);
        waitFor(this.searchBox);
    }


}
