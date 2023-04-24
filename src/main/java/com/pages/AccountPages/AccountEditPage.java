package com.pages.AccountPages;

import com.pages.BasePage;
import helper.javaScript.JavaScriptHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class AccountEditPage extends BasePage {
    public AccountEditPage() throws IOException {
        super();
    }

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]/span[1]")
    public WebElement myAccountInformationHeadingText;

    @FindBy(name = "firstname")
    public WebElement firstNameBox;
    @FindBy(xpath = "//*[@id=\"AccountFrm_lastname\"]")
    public WebElement lastNameBox;

    @FindBy(id = "AccountFrm_email")
    public WebElement emailBox;
    @FindBy(css = "#AccountFrm_telephone")
    public WebElement telephoneBox;
    @FindBy(css = "#AccountFrm_fax")
    public WebElement faxBox;
    @FindBy(xpath = "//*[@id=\"AccountFrm\"]/div[2]/div/button")
    public static WebElement continueEditBtn;


    public boolean validateUserOnAccountEditPage() throws InterruptedException {
        Thread.sleep(2000);
        return isDisplayed(getDriver(), myAccountInformationHeadingText);
    }
    public void enterFirstNameBox(String FirstName) throws Exception {
        sendKeysToWebElement(firstNameBox, FirstName);
    }

    public void enterLastNameBox(String Lastname) throws Exception {
        sendKeysToWebElement(lastNameBox, Lastname);

    }
    public void enterFreshEmailBox() throws Exception {
        //emailBox.clear();
        String email = System.currentTimeMillis() + "@gmail.com";
        sendKeysToWebElement(emailBox, email);

    }

    public void enterTelephoneBox(String Telephone) throws Exception {
        sendKeysToWebElement(telephoneBox, Telephone);

    }

    public void enterFaxBox(String Fax) throws Exception {
        sendKeysToWebElement(faxBox, Fax);

    }

    public AccountPage clickOnContinueEditBtn() throws IOException, InterruptedException {
        new JavaScriptHelper(getDriver()).scrollToElement(continueEditBtn);
        continueEditBtn.click();
        return new AccountPage();

    }

    public void updatingProfileDetails(String firstname, String lastname, String telephone, String fax) throws Exception {
        log.info("editing Profile Details....");
        enterFirstNameBox(firstname);
        enterLastNameBox(lastname);
        enterFreshEmailBox();
        enterTelephoneBox(telephone);
        enterFaxBox(fax);
        log.info("edited Profile Details....");

    }

        /*public void userUpdateProfile(DataTable dataTable) throws Exception {
        sendKeysToWebElement(firstNameBox, dataTable.cell(1, 0));
        log.info("Sent data to the element: " + dataTable.cell(1, 0));
        sendKeysToWebElement(lastNameBox, dataTable.cell(1, 1));
        log.info("Sent data to the element: " + dataTable.cell(1, 1));
        enterFreshEmailBox();
        log.info("Sent generated Email to the element...");
        sendKeysToWebElement(telephoneBox, dataTable.cell(1, 2));
        log.info("Sent data to the element: " + dataTable.cell(1, 2));
        sendKeysToWebElement(faxBox, dataTable.cell(1, 3));
        log.info("Sent data to the element: " + dataTable.cell(1, 3));
    }
*/

}
