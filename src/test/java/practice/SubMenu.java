package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


import java.util.List;

public class SubMenu {

    @Test
    public void click_On_SubMenu_Item() throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://automationteststore.com/");

        List<WebElement> subcategories = driver.findElements(By.cssSelector(".subcategories"));
        for (WebElement subcategory : subcategories)
        {
            System.out.println("List Of SubMenu: " +subcategory.getText());
            if(subcategory.getText().contains("  Men"))
            {
                subcategory.click();
            }
        }

        //driver.quit();

    }

}


