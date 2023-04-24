package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class NoOfProductsDisplayedAndAddToCart {

    @Test
    public void HoverOverAnItemTest() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://automationteststore.com/");
        String productName = "MAKEUP";
        WebElement subMenuName = driver.findElement(By.linkText(productName));
        Actions action = new Actions(driver);
        action.moveToElement(subMenuName).build().perform();
        Thread.sleep(3000);
        WebElement ItemElement = driver.findElement(By.cssSelector("section#categorymenu li:nth-child(3) > div > ul:nth-child(1) > li:nth-child(3) > a"));
        ItemElement.click();
        driver.quit();

    }

    @Test
    public void HoverOverAnItemAndClickProductTest() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://automationteststore.com/");
        String productName = "MAKEUP";
        WebElement subMenuName = driver.findElement(By.linkText(productName));
        Actions action = new Actions(driver);
        action.moveToElement(subMenuName).build().perform();
        Thread.sleep(3000);
        String ItemName = "Lips";
        List<WebElement> productsElementS = driver.findElements(By.cssSelector("li:nth-of-type(3) div:first-of-type ul:first-of-type li"));
        for(WebElement productsElement: productsElementS){
            if(productsElement.getText().contains(ItemName)){
                System.out.println(productsElement.getText());
                productsElement.click();
            }
        }
        //List<WebElement> products = driver.findElements(By.xpath("#maincontainer > div > div > div > div > div:nth-of-type(3) > div"));
        List<WebElement> products = driver.findElements(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div"));
        for(WebElement product : products){
            if(product.getText().contains("Product with stock locations") ){
                product.click();
            }
        }
        Thread.sleep(10000);
        //driver.quit();

    }

}


