package practice.Stream;

import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_Using_collect_distinct extends BasePage {

    public Stream_Using_collect_distinct() throws IOException {
        super();
    }

    @Test
    public void using_map_and_collect() {

        getDriver().get("https://automationteststore.com/index.php?rt=product/category&path=43_46");
        wait.until(ExpectedConditions.titleIs("Face"));

        List<WebElement> itemNames = getDriver().findElements(By.cssSelector(".prdocutname"));
        List<String> originalList = itemNames.stream().map((itemName)->itemName.getText()).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        System.out.println("item: " + originalList.get(2));
        System.out.println("=======================================");

        System.out.println("Original List: " + originalList);
        System.out.println("=======================================");
        System.out.println("Sorted List: " + sortedList);
        System.out.println("=======================================");
        sortedList.stream().forEach(i->System.out.println(i));
        System.out.println("=======================================");
        sortedList.stream().distinct().forEach(i->System.out.println(i));

        getDriver().quit();
    }


}
