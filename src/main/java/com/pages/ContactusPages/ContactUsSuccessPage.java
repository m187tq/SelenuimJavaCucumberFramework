package com.pages.ContactusPages;

import com.pages.BasePage;
import helper.axe.actiondriver.Action;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class ContactUsSuccessPage extends BasePage {

    public static final Logger log = LoggerHelper.getLogger(ContactUsSuccessPage.class);
    Action act = new Action();

    public ContactUsSuccessPage() throws IOException {
        super();
    }
    @FindBy(css = ".mb40 > p:nth-of-type(2)")
    WebElement successfullySentMsg;

    @FindBy(css= ".mb40 > a[title='Continue']")
    WebElement continueBtn;
    public String successfullySentMsg() {
        return this.successfullySentMsg.getText();
    }
    public WebElement continueBtn() {
        return this.continueBtn;
    }

}



