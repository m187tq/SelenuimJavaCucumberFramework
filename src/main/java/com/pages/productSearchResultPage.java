package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class productSearchResultPage extends BasePage {

    public productSearchResultPage() throws IOException {
        super();
    }

    @FindBy(xpath="//*[@id='layered_block_left']/p")
    public WebElement catalogTextObj;

    @FindBy(xpath="//*[@id='layer_cart']/div[1]/div[1]/h2")
    public WebElement productAddedSuccessfully;

}
