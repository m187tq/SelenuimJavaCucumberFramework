package com.pages.CheckoutPages;


import com.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class PaymentModeEditPage extends BasePage {

    public PaymentModeEditPage() throws IOException {
        super();
    }

    @FindBy(css = ".paymentProviderHeader-name")
    private WebElement testGatewayTxt;

    @FindBy(css = "#ccNumber")
    private WebElement ccNumberBox;





}
