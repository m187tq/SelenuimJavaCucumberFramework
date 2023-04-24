package com.pages.AccountPages;

import com.pages.BasePage;
import com.pages.HomePages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class AccountLogoutPage extends BasePage {
    public AccountLogoutPage() throws IOException {
        super();
    }

    @FindBy(xpath = "//p[contains(text(),'You have been logged off your account. It is now s')]")
    public WebElement saveToLogoutTxt;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/section[1]/a[1]")
    public WebElement logoutAccountContinueBtn;

    @FindBy(css = ".heading1")
    public WebElement accountLogoutTxt;


    public boolean validateSuccessfulLogOffProcess() throws InterruptedException {
        return isDisplayed(getDriver(), saveToLogoutTxt);
    }

    public boolean validateAccountLogoutTxtDisplayed() {
        return isDisplayed(getDriver(), accountLogoutTxt);
    }

    public String getCurrentUrl() throws InterruptedException {
        return getDriver().getCurrentUrl();
    }

    public HomePage clickOnLogoutContinueButton() throws InterruptedException, IOException {
        HomePage homePage = new HomePage();
        waitFor(this.logoutAccountContinueBtn);
        this.logoutAccountContinueBtn.click();
        return new HomePage();

    }

    public boolean validateLogoutContinueBtnIsDisplayed() throws InterruptedException {
        waitFor(logoutAccountContinueBtn);
        return isDisplayed(getDriver(), logoutAccountContinueBtn);
    }


}