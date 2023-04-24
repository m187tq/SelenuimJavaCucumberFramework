package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductCategoryNaviMenuComponent extends BasePage {

    public ProductCategoryNaviMenuComponent() throws IOException {
        super();
    }

    @FindBy(css = ".prdocutname")
    protected List<WebElement> productNameList;
    @FindBy(xpath = "//*[@id=\"categorymenu\"]/nav/ul/li/a")
    private List<WebElement> catMenuList;
    @FindBy(xpath = "//*[@id=\"categorymenu\"]/nav/ul/li/div/ul/li/a")
    private List<WebElement> catAndSubMenuList;
    @FindBy(linkText = "Apparel & accessories")
    private WebElement apparelAccessories;
    @FindBy(linkText = "Makeup")
    private WebElement makeup;
    @FindBy(linkText = "Skincare")
    private WebElement skincare;
    @FindBy(linkText = "Fragrance")
    private WebElement fragrance;
    @FindBy(linkText = "Men")
    private WebElement men;
    @FindBy(linkText = "Hair Care")
    private WebElement hairCare;
    @FindBy(linkText = "Books")
    private WebElement books;


    @FindBy(linkText = "Featured")
    private WebElement featured;

    @FindBy(css = ".product-product")
    private WebElement latestProducts;


    @FindBy(xpath = "//span[normalize-space()='Bestsellers']")
    private WebElement bestsellers;

    public List<WebElement> getProductNameList() {
        return productNameList;
    }

    public List<WebElement> getCatMenuList() {
        return catMenuList;
    }

    public List<WebElement> getCatAndSubMenuList() {
        return catAndSubMenuList;
    }

    public WebElement getApparelAccessories() {
        return apparelAccessories;
    }

    public WebElement getMakeup() {
        return makeup;
    }

    public WebElement getSkincare() {
        return skincare;
    }

    public WebElement getFragrance() {
        return fragrance;
    }

    public WebElement getMen() {
        return men;
    }

    public WebElement getHairCare() {
        return hairCare;
    }

    public WebElement getBooks() {
        return books;
    }

    public ProductCategoryPathPage waitForWebElementAndClickOnProductCatMenu(WebElement element) throws IOException {
        log.info("waitForWebElementAndClicking on : " + element.getText());
        waitForWebElementAndClick(element);
        return new ProductCategoryPathPage();
    }

    public ProductCategoryPathPage waitForWebElementAndClickOnItem(String data) throws IOException {
        log.info("waitForWebElementAndClicking on :" + data);
        WebElement item = getDriver().findElement(By.xpath("//*[contains(text(),'" + data + "')]"));
        waitForWebElementAndClick(item);
        return new ProductCategoryPathPage();
    }

    public ProductCategoryPathPage waitAndClickOnProductCatMenu(String data) throws IOException {
        WebElement item = getDriver().findElement(By.xpath("//*[contains(text(),'" + data + "')]"));
        waitForWebElementAndClick(item);
        return new ProductCategoryPathPage();
    }

    public ProductCategoryPathPage hoverOverAndClickOnProductCatMenu(WebElement element, WebElement data) throws IOException {
        log.info("waitForWebElementAndClicking on : " + element.getText());
        WebElement item = getDriver().findElement(By.xpath("//*[contains(text(),'" + data + "')]"));
        mouseover(getDriver(), data);
        waitForWebElementAndClick(element);
        return new ProductCategoryPathPage();
    }

    public ProductCategoryPathPage getProductNameList(WebElement element, WebElement data) throws IOException {
        String itemsNeeded [] = {"BODY CREAM BY BULGARI", "CREME PRECIEUSE NUIT 50ML","JASMIN NOIR BODY LOTION 6.8 FL OZ"};
        List<WebElement> itemNames = this.productNameList;
        for(int i = 0; i<itemNames.size(); i++)
        {
            String listOfProducts = itemNames.get(i).getText();
            List itemsNeededList = Arrays.asList(itemsNeeded);
            if(itemsNeededList.contains(listOfProducts))
            {
                System.out.println("list of items displayed: "+i+ " " + listOfProducts);
                System.out.println("==================================");
            }
        }
        return new ProductCategoryPathPage();
    }

}