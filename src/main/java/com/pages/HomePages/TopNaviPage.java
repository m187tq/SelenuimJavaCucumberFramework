package com.pages.HomePages;

import com.pages.AccountPages.AccountLoginPage;
import com.pages.BasePage;
import com.pages.SearchResultPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.data;

import java.io.IOException;


public class TopNaviPage extends BasePage {

    public TopNaviPage() throws IOException {
        super();
    }

    public final String URL = data.BASE_URL;

    @FindBy(css = ".navbar-header.header-logo")
    public WebElement logoImage;

    @FindBy(xpath = "//a[contains(text(),'Login or register')]")
    public WebElement loginOrRegisterLink;

    @FindBy(xpath = "//*[@id='main_menu_top']/li[1]/a/span")
    public WebElement specialsLink;

    @FindBy(xpath = "//*[@id='main_menu_top']/li[2]/a/span")
    public WebElement accountLink;
    @FindBy(xpath = "//header/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]")
    public WebElement accountCheckYourOrderLink;
    @FindBy(xpath = "//header/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]/span[1]")
    public WebElement accountLogoutLink;
    @FindBy(xpath = "//header/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/ul[1]/li[3]/a[1]/span[1]")
    public WebElement cartLink;
    @FindBy(xpath = "//header/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/ul[1]/li[4]/a[1]/span[1]")
    public WebElement checkoutLink;

    @FindBy(css = "#filter_keyword")
    public WebElement searchBox;
    @FindBy(css = ".button-in-search")
    public WebElement searchBtn;

    @FindBy(xpath = "//div[contains(text(),'Welcome back')]")
    public WebElement welcomeBackTxt;
    @FindBy(xpath = "//body[1]/div[1]/header[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]/span[1]")
    public WebElement currencyDropdown;
    @FindBy(xpath = "/html/body/div/header/div[2]/div/div[3]/ul/li")
    public WebElement itemsCartDropdown;
    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/a[1]/img[1]")
    public WebElement accountIconImage;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]")
    public WebElement accountStatusTxt;

    public void navigateToUrl(String string){
        navigateToIndexPage(string);
    }

    public String currentPageUrl() {
        return getDriver().getCurrentUrl();
    }
    public String currentPageTitle() {
        return getDriver().getTitle();
    }
    public boolean loginOrRegisterBtnEnabled() {
        return isEnabled(getDriver(), loginOrRegisterLink);
    }

    public boolean verifyLoginOrRegisterBtnIsDisplayed() {
        return verificationHelper.isDisplayed(loginOrRegisterLink);
    }
    public AccountLoginPage clickOnLoginRegisterBtn() throws IOException {
        captureScreen("HomePage", getDriver());
        waitForWebElementAndClick(loginOrRegisterLink);
        return new AccountLoginPage();
    }

    //************************************************//

    public void clickOnSearchBox() {
        waitForWebElementAndClick(searchBox);
    }
    public void entersKeywordOnSearchBox(String keyword) throws Exception {
        sendKeysToWebElement(searchBox, keyword);
    }

    public SearchResultPage clickOnSearchBtn() throws IOException {
         waitForWebElementAndClick(searchBtn);
        return new SearchResultPage();
    }


}