package practice;

import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;

public class addProductToCart extends BasePage {

    public addProductToCart() throws IOException {
        super();
    }

    @Test
    public void AddToCartTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://automationteststore.com/");
        // List<WebElement> subMenuList = driver.findElements(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li"));
        WebElement makeup_SubMenuName = driver.findElement(By.cssSelector("section#categorymenu nav > ul > li:nth-child(3) > a"));
        Actions action = new Actions(driver);
        action.moveToElement(makeup_SubMenuName).build().perform();

        // List<WebElement> productsElements = driver.findElements(By.cssSelector("li:nth-of-type(3) div:first-of-type ul:first-of-type li"));
        String itemName = "Lips";
        driver.findElement(By.linkText(itemName)).click();

        // List<WebElement> productName = driver.findElements(By.cssSelector("[class='col-md-3 col-sm-6 col-xs-12']"));
       String prdocutname = "Lancome Hypnose Doll Lashes Mascara 4-Piece Gift Set";
        WebElement productName = driver.findElement(By.cssSelector("a[title='"+prdocutname+"']"));
        productName.click();

    }

}


