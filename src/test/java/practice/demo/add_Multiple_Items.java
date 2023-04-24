package practice.demo;

import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class add_Multiple_Items extends BasePage {

    public add_Multiple_Items() throws IOException {
        super();
    }

    @Test
    public void AddItemsToCart() {

        getDriver().get("https://automationteststore.com/index.php?rt=product/category&path=43_46");
        wait.until(ExpectedConditions.titleIs("Face"));

        List<WebElement> itemNames = getDriver().findElements(By.cssSelector(".prdocutname"));

        List<WebElement> addToCartProduct = getDriver().findElements(By.cssSelector("a.productcart"));
        List<String> items = Arrays.asList("BODY CREAM BY BULGARI", "CREME PRECIEUSE NUIT 50ML", "JASMIN NOIR BODY LOTION 6.8 FL OZ","TOTAL MOISTURE FACIAL CREAM");

        String itemsNeeded[] = {"BODY CREAM BY BULGARI", "CREME PRECIEUSE NUIT 50ML", "JASMIN NOIR BODY LOTION 6.8 FL OZ","TOTAL MOISTURE FACIAL CREAM"};

        for (int i = 0; i < itemNames.size(); i++) {
            String name = itemNames.get(i).getText();
            List itemsNeededList = Arrays.asList(itemsNeeded);
            if (itemsNeededList.contains(name) && !itemNames.get(i).getText().isEmpty()) {
                System.out.println("Items "+"Index " +i+ ": "+name);
                System.out.println("================================================");
                addToCartProduct.get(i).click();
            }
        }
            getDriver().quit();
    }


}
