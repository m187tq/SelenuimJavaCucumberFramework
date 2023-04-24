package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;


public class Search {

    @Test
    public void SearchAutoSuggestionsTest() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://automationteststore.com/");
        WebElement searchBox = driver.findElement(By.cssSelector("input#filter_keyword"));
        WebElement searchButton = driver.findElement(By.cssSelector("form#search_form .fa.fa-search"));
        searchBox.click();

        //List<WebElement> product = driver.findElements(By.cssSelector("li.search-category"));
        List<WebElement> productsSuggestions = new WebDriverWait(driver, 15).
                until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li.search-category")));
        for (WebElement product : productsSuggestions) {
            System.out.println(product.getText());
        }

        searchBox.sendKeys("Makeup");
        searchButton.click();

        driver.quit();

    }

}


