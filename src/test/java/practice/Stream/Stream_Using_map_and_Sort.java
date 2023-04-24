package practice.Stream;

import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_Using_map_and_Sort extends BasePage {

    public Stream_Using_map_and_Sort() throws IOException {
        super();
    }

    @Test
    public void using_map_and_sort() {

        getDriver().get("https://automationteststore.com/index.php?rt=product/category&path=43_46");
        wait.until(ExpectedConditions.titleIs("Face"));

        List<WebElement> itemNames = getDriver().findElements(By.cssSelector(".prdocutname"));

        List<WebElement> addToCartProduct = getDriver().findElements(By.cssSelector("a.productcart"));

        String itemsNeeded[] = {"BODY CREAM BY BULGARI", "CREME PRECIEUSE NUIT 50ML", "JASMIN NOIR BODY LOTION 6.8 FL OZ","TOTAL MOISTURE FACIAL CREAM"};
        List<String> originalList = itemNames.stream().map((i)->i.getText()).collect(Collectors.toList());

        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        System.out.println("Original List: " + originalList);
        System.out.println("Sorted List: " + sortedList);

            getDriver().quit();
    }


}
